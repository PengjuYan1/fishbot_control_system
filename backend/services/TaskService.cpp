#include "backend/services/TaskService.h"

#include <chrono>
#include <optional>
#include <sstream>
#include <stdexcept>
#include <thread>

#include "backend/services/NativePointSync.h"

namespace {
bool has_native_identity(const PointRecord& point) {
    return point.floor_id > 0 && point.map_id > 0 && point.point_id > 0;
}

void try_load_map_for_point(IRobotAdapter& adapter, const std::optional<PointRecord>& point,
                            bool allow_switch_map) {
    if (!allow_switch_map) {
        return;
    }
    if (!point.has_value() || point->floor_id <= 0 || point->map_id <= 0) {
        return;
    }
    (void) adapter.load_map(std::to_string(point->floor_id) + ":" + std::to_string(point->map_id));
}

std::optional<PointRecord> find_point_by_type(const std::vector<PointRecord>& points,
                                              const std::string& type) {
    std::optional<PointRecord> fallback;
    for (const auto& point : points) {
        if (point.type != type) {
            continue;
        }

        if (has_native_identity(point)) {
            return point;
        }

        if (!fallback.has_value()) {
            fallback = point;
        }
    }
    return fallback;
}
}  // namespace

TaskService::TaskService(IRobotAdapter& adapter, PointRepository& point_repository)
    : TaskService(adapter, point_repository, nullptr) {}

TaskService::TaskService(IRobotAdapter& adapter, PointRepository& point_repository,
                         TaskRunRepository* task_run_repository)
    : adapter_(adapter),
      point_repository_(point_repository),
      task_run_repository_(task_run_repository) {}

TaskStartResult TaskService::start_manual_run() {
    return start_run("manual");
}

TaskStartResult TaskService::start_scheduled_run(const std::string&) {
    return start_run("schedule");
}

TaskStartResult TaskService::start_charge_return() {
    sync_native_points_if_supported(adapter_, point_repository_);

    const auto all_points = point_repository_.list_points();
    std::optional<PointRecord> charge_point;
    try { charge_point = find_charge_point(); } catch (const std::runtime_error&) {}

    const auto initial_point = find_point_by_type(all_points, "initial");

    // APK "立即回充" path sends autocharge first instead of target-goal navigation.
    auto status_before_return = adapter_.get_robot_status();

    if (!status_before_return.localized) {
        std::optional<PointRecord> relocalization_point;
        if (status_before_return.charging && charge_point.has_value()) {
            relocalization_point = charge_point;
        } else if (initial_point.has_value()) {
            relocalization_point = initial_point;
        } else if (charge_point.has_value()) {
            relocalization_point = charge_point;
        }

        if (relocalization_point.has_value()) {
            try_load_map_for_point(adapter_, relocalization_point, true);
            Pose initial_pose;
            initial_pose.x = relocalization_point->x;
            initial_pose.y = relocalization_point->y;
            initial_pose.theta = relocalization_point->theta;
            initial_pose.floor_id = relocalization_point->floor_id;
            initial_pose.map_id = relocalization_point->map_id;
            initial_pose.point_id = relocalization_point->point_id;

            bool relocation_sent = adapter_.set_relocation(initial_pose);
            if (!relocation_sent) {
                relocation_sent = adapter_.set_initial_pose(initial_pose);
            }

            if (relocation_sent) {
                for (int attempt = 0; attempt < 8; ++attempt) {
                    std::this_thread::sleep_for(std::chrono::milliseconds(80));
                    status_before_return = adapter_.get_robot_status();
                    if (status_before_return.localized) {
                        break;
                    }
                }
            } else {
                status_before_return = adapter_.get_robot_status();
            }
        }

        if (!status_before_return.localized) {
            throw std::runtime_error("not_localized_for_charge_return");
        }
    }

    if (adapter_.go_charge()) {
        current_task_.status = "charging";
        current_task_.current_target_name = charge_point.has_value() ? charge_point->name : "autocharge";
        last_trigger_type_ = "charge_return";
        return current_task_;
    }

    // Fallback: use native charge point navigation when autocharge publish fails.
    // Avoid switching maps while already localized; force-load can drop localization and block motion.
    try_load_map_for_point(adapter_, charge_point, !status_before_return.localized);

    if (charge_point.has_value()) {
        try {
            navigate_to_point(*charge_point);
            current_task_.status = "charging";
            current_task_.current_target_name = charge_point->name;
            last_trigger_type_ = "charge_return";
            return current_task_;
        } catch (const std::runtime_error&) {
        }
    }

    throw std::runtime_error("charge_return_failed");
}

TaskStartResult TaskService::current_task() const {
    return current_task_;
}

std::string TaskService::last_trigger_type() const {
    return last_trigger_type_;
}

TaskStartResult TaskService::start_run(const std::string& trigger_type) {
    feed_points_ = list_feed_points();
    current_feed_index_ = 0;
    const auto& target_point = feed_points_.at(current_feed_index_);
    if (!state_machine_.start_run()) {
        throw std::runtime_error("task_already_running");
    }

    navigate_to_point(target_point);

    if (!state_machine_.on_navigation_started()) {
        throw std::runtime_error("task_transition_failed");
    }

    current_task_.status = "running";
    current_task_.current_target_name = target_point.name;
    last_trigger_type_ = trigger_type;
    if (task_run_repository_ != nullptr) {
        active_run_id_ = task_run_repository_->insert_run(trigger_type, "running");
    }
    return current_task_;
}

void TaskService::complete_current_feed_point() {
    if (feed_points_.empty()) {
        return;
    }

    if (current_feed_index_ + 1 >= feed_points_.size()) {
        current_task_.status = "completed";
        current_task_.current_target_name.clear();
        if (task_run_repository_ != nullptr && active_run_id_ != 0) {
            task_run_repository_->update_status(active_run_id_, "completed");
            task_run_repository_->update_resume_context(active_run_id_, "");
        }
        return;
    }

    ++current_feed_index_;
    navigate_to_point(feed_points_.at(current_feed_index_));
    current_task_.status = "running";
    current_task_.current_target_name = feed_points_.at(current_feed_index_).name;
}

void TaskService::interrupt_for_low_battery() {
    current_task_.status = "charging";
    adapter_.stop_navigation();

    if (task_run_repository_ != nullptr && active_run_id_ != 0) {
        task_run_repository_->update_status(active_run_id_, "charging");
        task_run_repository_->update_resume_context(active_run_id_, serialize_remaining_points());
    }
}

void TaskService::on_charge_completed(bool resume_after_charge) {
    if (!resume_after_charge || task_run_repository_ == nullptr || active_run_id_ == 0) {
        current_task_.status = "waiting_manual_start";
        current_task_.current_target_name.clear();
        return;
    }

    const auto latest_run = task_run_repository_->latest_run();
    const auto remaining_names = parse_remaining_point_names(latest_run.resume_context_json);
    if (remaining_names.empty()) {
        current_task_.status = "waiting_manual_start";
        current_task_.current_target_name.clear();
        return;
    }

    current_feed_index_ = static_cast<std::size_t>(index_of_point_name(remaining_names.front()));
    navigate_to_point(feed_points_.at(current_feed_index_));
    current_task_.status = "running";
    current_task_.current_target_name = feed_points_.at(current_feed_index_).name;
    task_run_repository_->update_status(active_run_id_, "running");
}

std::vector<PointRecord> TaskService::list_feed_points() const {
    const auto points = point_repository_.list_points();
    std::vector<PointRecord> feed_points;
    for (const auto& point : points) {
        if (point.type == "feed") {
            feed_points.push_back(point);
        }
    }

    if (feed_points.empty()) {
        throw std::runtime_error("no_feed_point_configured");
    }

    return feed_points;
}

PointRecord TaskService::find_charge_point() const {
    const auto points = point_repository_.list_points();
    std::optional<PointRecord> fallback_charge;
    for (const auto& point : points) {
        if (point.type != "charge") {
            continue;
        }

        if (has_native_identity(point)) {
            return point;
        }

        if (!fallback_charge.has_value()) {
            fallback_charge = point;
        }
    }

    if (fallback_charge.has_value()) {
        return *fallback_charge;
    }

    throw std::runtime_error("no_charge_point_configured");
}

void TaskService::navigate_to_point(const PointRecord& point) {
    Pose target_pose;
    target_pose.x = point.x;
    target_pose.y = point.y;
    target_pose.theta = point.theta;
    target_pose.floor_id = point.floor_id;
    target_pose.map_id = point.map_id;
    target_pose.point_id = point.point_id;

    if (!adapter_.navigate_to_pose(target_pose)) {
        throw std::runtime_error("navigation_start_failed");
    }
}

std::string TaskService::serialize_remaining_points() const {
    std::string value;
    for (std::size_t index = current_feed_index_; index < feed_points_.size(); ++index) {
        if (!value.empty()) {
            value += ",";
        }
        value += feed_points_.at(index).name;
    }
    return value;
}

std::vector<std::string> TaskService::parse_remaining_point_names(const std::string& value) const {
    std::vector<std::string> point_names;
    std::stringstream stream(value);
    std::string item;
    while (std::getline(stream, item, ',')) {
        if (!item.empty()) {
            point_names.push_back(item);
        }
    }
    return point_names;
}

int TaskService::index_of_point_name(const std::string& point_name) const {
    for (std::size_t index = 0; index < feed_points_.size(); ++index) {
        if (feed_points_.at(index).name == point_name) {
            return static_cast<int>(index);
        }
    }

    throw std::runtime_error("resume_point_not_found");
}
