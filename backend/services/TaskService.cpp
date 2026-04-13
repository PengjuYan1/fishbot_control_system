#include "backend/services/TaskService.h"

#include <sstream>
#include <stdexcept>

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
