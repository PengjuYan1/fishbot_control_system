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
    snapshot.control.emergency_stopped = robot_status.emergency_stopped;
    snapshot.control.emergency_status_code = robot_status.emergency_status_code;
    snapshot.control.motor_locked = robot_status.motor_locked;
    snapshot.control.motor_status_code = robot_status.motor_status_code;
    snapshot.control.charge_status_code = robot_status.charge_status_code;
    snapshot.control.motion_mode_code = robot_status.motion_mode_code;
    snapshot.control.out_of_charge_status_code = robot_status.out_of_charge_status_code;
    snapshot.control.out_machine_signal = robot_status.out_machine_signal;
    snapshot.control.out_of_charge_result_code = robot_status.out_of_charge_result_code;
    return snapshot;
}

void SystemService::record_connection_error(const std::string& message) {
    last_error_ = message;
}

void SystemService::set_reconnect_attempts(int attempts) {
    reconnect_attempts_ = attempts;
}
