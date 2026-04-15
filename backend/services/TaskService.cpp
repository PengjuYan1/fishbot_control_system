#include "backend/services/TaskService.h"

#include <chrono>
#include <cmath>
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

double normalize_angle(double value) {
    constexpr double kPi = 3.14159265358979323846;
    while (value > kPi) {
        value -= 2.0 * kPi;
    }
    while (value < -kPi) {
        value += 2.0 * kPi;
    }
    return value;
}

double clamp(double value, double minimum, double maximum) {
    if (value < minimum) {
        return minimum;
    }
    if (value > maximum) {
        return maximum;
    }
    return value;
}

bool charge_detected(const RobotStatus& status) {
    if (status.charging) {
        return true;
    }

    switch (status.charge_status_code) {
        case 45:
        case 46:
        case 47:
        case 48:
            return true;
        default:
            return false;
    }
}

long long steady_clock_millis() {
    return std::chrono::duration_cast<std::chrono::milliseconds>(
        std::chrono::steady_clock::now().time_since_epoch()).count();
}

bool scan_range_is_valid(const LaserScanSnapshot& scan, double value) {
    if (!(value > 0.0) || !std::isfinite(value)) {
        return false;
    }
    if (scan.range_min > 0.0 && value < scan.range_min) {
        return false;
    }
    if (scan.range_max > 0.0 && value > scan.range_max) {
        return false;
    }
    return true;
}

double average_scan_window(const LaserScanSnapshot& scan, double min_angle, double max_angle) {
    if (scan.ranges.empty() || scan.angle_increment == 0.0) {
        return -1.0;
    }

    double sum = 0.0;
    int count = 0;
    for (std::size_t index = 0; index < scan.ranges.size(); ++index) {
        const double angle = scan.angle_min + scan.angle_increment * static_cast<double>(index);
        if (angle < min_angle || angle > max_angle) {
            continue;
        }

        const double range = scan.ranges[index];
        if (!scan_range_is_valid(scan, range)) {
            continue;
        }

        sum += range;
        ++count;
    }

    if (count == 0) {
        return -1.0;
    }
    return sum / static_cast<double>(count);
}

struct DockingScanAssist {
    bool valid = false;
    double front_distance = -1.0;
    double left_distance = -1.0;
    double right_distance = -1.0;
    double balance_error = 0.0;
};

DockingScanAssist analyze_docking_scan(const LaserScanSnapshot& scan) {
    DockingScanAssist assist;
    assist.front_distance = average_scan_window(scan, -0.10, 0.10);
    assist.right_distance = average_scan_window(scan, -0.45, -0.10);
    assist.left_distance = average_scan_window(scan, 0.10, 0.45);
    assist.valid = assist.front_distance > 0.0 &&
        assist.left_distance > 0.0 &&
        assist.right_distance > 0.0;
    if (assist.valid) {
        assist.balance_error = assist.left_distance - assist.right_distance;
    }
    return assist;
}
}  // namespace

TaskService::TaskService(IRobotAdapter& adapter, PointRepository& point_repository)
    : TaskService(adapter, point_repository, nullptr) {}

TaskService::TaskService(IRobotAdapter& adapter, PointRepository& point_repository,
                         TaskRunRepository* task_run_repository)
    : adapter_(adapter),
      point_repository_(point_repository),
      task_run_repository_(task_run_repository) {}

TaskService::~TaskService() {
    stop_self_charge_worker();
}

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

TaskStartResult TaskService::start_navigation_to_point(int point_id) {
    stop_self_charge_worker();
    sync_native_points_if_supported(adapter_, point_repository_);

    const auto point = point_repository_.find_point(point_id);
    if (!point.has_value()) {
        throw std::runtime_error("point_not_found");
    }

    navigate_to_point(*point);
    update_current_task("navigating", point->name);
    last_trigger_type_ = "navigate_point";
    return current_task_;
}

TaskStartResult TaskService::start_self_charge() {
    stop_self_charge_worker();
    const auto generation = self_charge_generation_.fetch_add(1) + 1;
    sync_native_points_if_supported(adapter_, point_repository_);

    const auto all_points = point_repository_.list_points();
    std::optional<PointRecord> charge_point;
    try { charge_point = find_charge_point(); } catch (const std::runtime_error&) {}

    const auto initial_point = find_point_by_type(all_points, "initial");
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

    if (!charge_point.has_value()) {
        throw std::runtime_error("no_charge_point_configured");
    }

    try_load_map_for_point(adapter_, charge_point, !status_before_return.localized);
    navigate_to_point(*charge_point);
    update_current_task("self_charging_nav", charge_point->name);
    last_trigger_type_ = "self_charge";
    self_charge_phase_ = SelfChargePhase::kNavigating;
    self_charge_thread_ = std::thread([this, charge_point = *charge_point, generation]() {
        run_self_charge_loop(charge_point, generation);
    });
    return current_task_;
}

void TaskService::observe_system_snapshot(const SystemSnapshot&) {}

TaskStartResult TaskService::current_task() const {
    std::lock_guard<std::mutex> lock(current_task_mutex_);
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

    update_current_task("running", target_point.name);
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
        update_current_task("completed", "");
        if (task_run_repository_ != nullptr && active_run_id_ != 0) {
            task_run_repository_->update_status(active_run_id_, "completed");
            task_run_repository_->update_resume_context(active_run_id_, "");
        }
        return;
    }

    ++current_feed_index_;
    navigate_to_point(feed_points_.at(current_feed_index_));
    update_current_task("running", feed_points_.at(current_feed_index_).name);
}

void TaskService::interrupt_for_low_battery() {
    update_current_task("charging", current_task().current_target_name);
    adapter_.stop_navigation();

    if (task_run_repository_ != nullptr && active_run_id_ != 0) {
        task_run_repository_->update_status(active_run_id_, "charging");
        task_run_repository_->update_resume_context(active_run_id_, serialize_remaining_points());
    }
}

void TaskService::on_charge_completed(bool resume_after_charge) {
    if (!resume_after_charge || task_run_repository_ == nullptr || active_run_id_ == 0) {
        update_current_task("waiting_manual_start", "");
        return;
    }

    const auto latest_run = task_run_repository_->latest_run();
    const auto remaining_names = parse_remaining_point_names(latest_run.resume_context_json);
    if (remaining_names.empty()) {
        update_current_task("waiting_manual_start", "");
        return;
    }

    current_feed_index_ = static_cast<std::size_t>(index_of_point_name(remaining_names.front()));
    navigate_to_point(feed_points_.at(current_feed_index_));
    update_current_task("running", feed_points_.at(current_feed_index_).name);
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

void TaskService::update_current_task(const std::string& status, const std::string& target_name) {
    std::lock_guard<std::mutex> lock(current_task_mutex_);
    current_task_.status = status;
    current_task_.current_target_name = target_name;
}

void TaskService::run_self_charge_loop(PointRecord charge_point, std::uint64_t generation) {
    constexpr int kNavigationPollMs = 150;
    constexpr int kDockingStepMs = 120;
    constexpr int kDockingStepsPerAttempt = 40;
    constexpr int kDockingAttempts = 2;
    constexpr double kLinearSpeed = 0.05;
    constexpr double kAngularGain = 0.8;
    constexpr double kScanAngularGain = 1.1;
    constexpr double kAngularLimit = 0.25;
    constexpr double kAngleOnlyThreshold = 0.14;
    constexpr long long kScanFreshnessMs = 1200;

    for (;;) {
        if (self_charge_generation_.load() != generation) {
            return;
        }

        const auto status = adapter_.get_robot_status();
        if (charge_detected(status)) {
            adapter_.stop_navigation();
            self_charge_phase_ = SelfChargePhase::kCharging;
            update_current_task("charging", charge_point.name);
            return;
        }

        if (status.navigation_status_code == 8 || status.navigation_status_code == 51 ||
            status.navigation_status_code == 84 || status.navigation_status_code == 87) {
            self_charge_phase_ = SelfChargePhase::kFailed;
            update_current_task("self_charge_failed", charge_point.name);
            return;
        }

        if (status.navigation_status_code == 2) {
            break;
        }

        std::this_thread::sleep_for(std::chrono::milliseconds(kNavigationPollMs));
    }

    adapter_.stop_navigation();
    self_charge_phase_ = SelfChargePhase::kDocking;
    update_current_task("self_charging_docking", charge_point.name);

    for (int attempt = 0; attempt < kDockingAttempts; ++attempt) {
        for (int step = 0; step < kDockingStepsPerAttempt; ++step) {
            if (self_charge_generation_.load() != generation) {
                return;
            }

            const auto status = adapter_.get_robot_status();
            if (charge_detected(status)) {
                self_charge_phase_ = SelfChargePhase::kCharging;
                update_current_task("charging", charge_point.name);
                (void) adapter_.manual_move(0.0, 0.0);
                return;
            }

            const auto pose = adapter_.get_robot_pose();
            double angle_error = normalize_angle(charge_point.theta - pose.theta);
            double angular_speed = clamp(angle_error * kAngularGain, -kAngularLimit, kAngularLimit);
            double linear_speed = std::abs(angle_error) > kAngleOnlyThreshold ? 0.0 : kLinearSpeed;

            LaserScanSnapshot scan;
            if (adapter_.get_latest_laser_scan(&scan) &&
                scan.received_steady_time_ms > 0 &&
                steady_clock_millis() - scan.received_steady_time_ms <= kScanFreshnessMs) {
                const auto assist = analyze_docking_scan(scan);
                if (assist.valid) {
                    angular_speed = clamp(
                        angle_error * kAngularGain + assist.balance_error * kScanAngularGain,
                        -kAngularLimit,
                        kAngularLimit);
                    if (assist.front_distance < 0.18) {
                        linear_speed = std::abs(angular_speed) > 0.08 ? 0.0 : 0.02;
                    } else if (assist.front_distance < 0.28) {
                        linear_speed = std::abs(angular_speed) > 0.10 ? 0.0 : 0.03;
                    } else {
                        linear_speed = std::abs(angular_speed) > kAngleOnlyThreshold ? 0.0 : 0.05;
                    }
                }
            }
            (void) adapter_.manual_move(linear_speed, angular_speed);
            std::this_thread::sleep_for(std::chrono::milliseconds(kDockingStepMs));
        }

        for (int reverse_step = 0; reverse_step < 6; ++reverse_step) {
            if (self_charge_generation_.load() != generation) {
                return;
            }
            (void) adapter_.manual_move(-0.04, 0.0);
            std::this_thread::sleep_for(std::chrono::milliseconds(kDockingStepMs));
        }
    }

    self_charge_phase_ = SelfChargePhase::kFailed;
    update_current_task("self_charge_failed", charge_point.name);
    (void) adapter_.manual_move(0.0, 0.0);
}

void TaskService::stop_self_charge_worker() {
    self_charge_generation_.fetch_add(1);
    self_charge_phase_ = SelfChargePhase::kIdle;
    if (self_charge_thread_.joinable()) {
        self_charge_thread_.join();
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
