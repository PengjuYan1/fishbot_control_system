#include "backend/services/SystemService.h"

SystemService::SystemService(IRobotAdapter& adapter, TaskSummaryProvider task_summary_provider)
    : adapter_(adapter),
      task_summary_provider_(std::move(task_summary_provider)) {}

SystemSnapshot SystemService::get_snapshot() const {
    const auto robot_status = adapter_.get_robot_status();

    SystemSnapshot snapshot;
    snapshot.battery = adapter_.get_battery();
    snapshot.pose = adapter_.get_robot_pose();
    snapshot.charging = adapter_.is_charging();
    snapshot.connected = robot_status.connected;
    snapshot.localized = robot_status.localized;
    snapshot.task = task_summary_provider_ ? task_summary_provider_() : TaskSummary{"idle", ""};
    snapshot.connection.healthy = adapter_.is_connected() && robot_status.connected;
    snapshot.connection.last_error = last_error_;
    snapshot.connection.reconnect_attempts = reconnect_attempts_;
    snapshot.connection.adapter_mode = adapter_.mode_name();
    return snapshot;
}

void SystemService::record_connection_error(const std::string& message) {
    last_error_ = message;
}

void SystemService::set_reconnect_attempts(int attempts) {
    reconnect_attempts_ = attempts;
}
