#include "backend/services/SystemService.h"

SystemService::SystemService(IRobotAdapter& adapter) : adapter_(adapter) {}

SystemSnapshot SystemService::get_snapshot() const {
    const auto robot_status = adapter_.get_robot_status();

    SystemSnapshot snapshot;
    snapshot.battery = adapter_.get_battery();
    snapshot.pose = adapter_.get_robot_pose();
    snapshot.charging = adapter_.is_charging();
    snapshot.connected = robot_status.connected;
    snapshot.localized = robot_status.localized;
    snapshot.task = TaskSummary{"idle", ""};
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
