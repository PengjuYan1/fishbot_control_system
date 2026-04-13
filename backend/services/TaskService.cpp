#include "backend/services/TaskService.h"

#include <stdexcept>

TaskService::TaskService(IRobotAdapter& adapter, PointRepository& point_repository)
    : adapter_(adapter), point_repository_(point_repository) {}

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
    const auto target_point = first_feed_point();
    if (!state_machine_.start_run()) {
        throw std::runtime_error("task_already_running");
    }

    if (!adapter_.navigate_to_pose(Pose{target_point.x, target_point.y, target_point.theta})) {
        throw std::runtime_error("navigation_start_failed");
    }

    if (!state_machine_.on_navigation_started()) {
        throw std::runtime_error("task_transition_failed");
    }

    current_task_.status = "running";
    current_task_.current_target_name = target_point.name;
    last_trigger_type_ = trigger_type;
    return current_task_;
}

PointRecord TaskService::first_feed_point() const {
    const auto points = point_repository_.list_points();
    for (const auto& point : points) {
        if (point.type == "feed") {
            return point;
        }
    }

    throw std::runtime_error("no_feed_point_configured");
}
