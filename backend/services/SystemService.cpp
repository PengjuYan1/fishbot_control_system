#include "backend/services/SystemService.h"

#include <chrono>

SystemService::SystemService(
    IRobotAdapter& adapter,
    TaskSummaryProvider task_summary_provider,
    ManualControlStateProvider manual_control_state_provider)
    : adapter_(adapter),
      task_summary_provider_(std::move(task_summary_provider)),
      manual_control_state_provider_(std::move(manual_control_state_provider)) {}

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
    snapshot.control.stm32_status_code = robot_status.stm32_status_code;
    snapshot.control.odom_status_code = robot_status.odom_status_code;
    snapshot.control.motion_mode_code = robot_status.motion_mode_code;
    snapshot.control.location_status_code = robot_status.location_status_code;
    snapshot.control.navigation_status_code = robot_status.navigation_status_code;
    snapshot.control.out_of_charge_status_code = robot_status.out_of_charge_status_code;
    snapshot.control.out_machine_signal = robot_status.out_machine_signal;
    snapshot.control.out_of_charge_result_code = robot_status.out_of_charge_result_code;
    snapshot.manual_control = manual_control_state_provider_
        ? manual_control_state_provider_()
        : ManualControlState{};
    return snapshot;
}

SystemSnapshot SystemService::capture_snapshot() {
    const auto snapshot = get_snapshot();
    append_trace_entry(snapshot);
    return snapshot;
}

std::string SystemService::get_trace_json(std::size_t limit) const {
    std::lock_guard<std::mutex> lock(trace_mutex_);

    const std::size_t clamped_limit = limit == 0 ? 1 : limit;
    const std::size_t count =
        trace_entries_.size() < clamped_limit ? trace_entries_.size() : clamped_limit;
    const std::size_t start_index = trace_entries_.size() > count ? trace_entries_.size() - count : 0;

    std::string body = "{\"entries\":[";
    for (std::size_t index = start_index; index < trace_entries_.size(); ++index) {
        if (index > start_index) {
            body += ",";
        }
        body += std::string("{\"timestamp_ms\":") + std::to_string(trace_entries_[index].timestamp_ms) +
            ",\"snapshot\":" + to_json(trace_entries_[index].snapshot) + "}";
    }
    body += "]}";
    return body;
}

void SystemService::record_connection_error(const std::string& message) {
    last_error_ = message;
}

void SystemService::set_reconnect_attempts(int attempts) {
    reconnect_attempts_ = attempts;
}

void SystemService::append_trace_entry(const SystemSnapshot& snapshot) {
    const auto now = std::chrono::time_point_cast<std::chrono::milliseconds>(
        std::chrono::system_clock::now());
    const auto timestamp_ms = now.time_since_epoch().count();

    std::lock_guard<std::mutex> lock(trace_mutex_);
    trace_entries_.push_back(TimedSystemSnapshot{timestamp_ms, snapshot});
    while (trace_entries_.size() > max_trace_entries_) {
        trace_entries_.pop_front();
    }
}
