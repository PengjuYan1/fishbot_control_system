#include "backend/services/ManualControlService.h"

namespace {
bool wants_motion(double linear_speed, double angular_speed) {
    return linear_speed != 0.0 || angular_speed != 0.0;
}

bool navigation_still_owns_chassis(const RobotStatus& status) {
    switch (status.navigation_status_code) {
        case 1:
        case 5:
            return true;
        default:
            return false;
    }
}

bool charging_still_blocks_manual_control(const RobotStatus& status) {
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
}  // namespace

ManualControlService::ManualControlService(IRobotAdapter& adapter) : adapter_(adapter) {}

ManualControlCommandResult ManualControlService::out_of_charge() {
    const auto robot_status = adapter_.get_robot_status();
    bool should_request_undock = true;
    {
        std::lock_guard<std::mutex> lock(mutex_);
        session_state_.session_active = true;
        sync_session_from_status_locked(robot_status);

        if (charging_still_blocks_manual_control(robot_status)) {
            session_state_.phase = ManualControlPhase::kUndockingRequested;
        } else {
            session_state_.phase = ManualControlPhase::kReadyForDrive;
        }
    }

    if (should_request_undock && !adapter_.out_of_charge()) {
        return ManualControlCommandResult{false, get_state()};
    }

    return ManualControlCommandResult{true, get_state()};
}

ManualControlCommandResult ManualControlService::exit_navigation_mode() {
    {
        std::lock_guard<std::mutex> lock(mutex_);
        session_state_.session_active = true;
        drive_command_active_ = false;
    }

    if (!release_navigation_control()) {
        return ManualControlCommandResult{false, get_state()};
    }

    return ManualControlCommandResult{true, get_state()};
}

ManualControlCommandResult ManualControlService::move(double linear_speed, double angular_speed) {
    const bool motion_requested = wants_motion(linear_speed, angular_speed);
    const auto robot_status = adapter_.get_robot_status();
    bool should_request_undock = false;
    bool should_release_navigation = false;
    {
        std::lock_guard<std::mutex> lock(mutex_);
        session_state_.session_active = true;
        session_state_.desired_linear = linear_speed;
        session_state_.desired_angular = angular_speed;
        session_state_.pending_motion = motion_requested;
        sync_session_from_status_locked(robot_status);

        if (motion_requested && charging_still_blocks_manual_control(robot_status)) {
            session_state_.phase = ManualControlPhase::kUndockingRequested;
            should_request_undock = true;
        } else if (motion_requested) {
            const bool navigation_blocked = navigation_still_owns_chassis(robot_status);
            const bool initial_release_needed = !drive_command_active_;
            should_release_navigation = navigation_blocked || initial_release_needed;
            if (navigation_blocked) {
                session_state_.phase = ManualControlPhase::kReadyForDrive;
            }
        } else if (!motion_requested) {
            drive_command_active_ = false;
            session_state_.phase = session_state_.session_active
                ? ManualControlPhase::kReadyForDrive
                : ManualControlPhase::kIdle;
        }
    }

    if (should_request_undock) {
        if (!adapter_.out_of_charge()) {
            return ManualControlCommandResult{false, get_state()};
        }
        std::lock_guard<std::mutex> lock(mutex_);
        return ManualControlCommandResult{true, snapshot_state_locked()};
    }

    if (should_release_navigation) {
        if (!release_navigation_control()) {
            return ManualControlCommandResult{false, get_state()};
        }
    }

    if (motion_requested && !adapter_.manual_move(linear_speed, angular_speed)) {
        return ManualControlCommandResult{false, get_state()};
    }

    {
        std::lock_guard<std::mutex> lock(mutex_);
        drive_command_active_ = motion_requested;
        if (motion_requested) {
            session_state_.phase = ManualControlPhase::kDriving;
        }
        return ManualControlCommandResult{true, snapshot_state_locked()};
    }
}

ManualControlCommandResult ManualControlService::stop() {
    const bool released = release_navigation_control();
    const bool stopped = adapter_.manual_move(0.0, 0.0);

    {
        std::lock_guard<std::mutex> lock(mutex_);
        session_state_ = ManualControlState{};
        drive_command_active_ = false;
    }

    return ManualControlCommandResult{released && stopped, get_state()};
}

ManualControlState ManualControlService::get_state() {
    const auto robot_status = adapter_.get_robot_status();
    std::lock_guard<std::mutex> lock(mutex_);
    sync_session_from_status_locked(robot_status);
    return snapshot_state_locked();
}

bool ManualControlService::release_navigation_control() {
    return adapter_.stop_navigation();
}

ManualControlState ManualControlService::snapshot_state_locked() const {
    return session_state_;
}

void ManualControlService::sync_session_from_status_locked(const RobotStatus& status) {
    if (!session_state_.session_active) {
        session_state_ = ManualControlState{};
        drive_command_active_ = false;
        return;
    }

    session_state_.pending_motion =
        wants_motion(session_state_.desired_linear, session_state_.desired_angular);

    if (charging_still_blocks_manual_control(status)) {
        session_state_.phase = ManualControlPhase::kUndockingRequested;
        drive_command_active_ = false;
        return;
    }

    if (navigation_still_owns_chassis(status)) {
        session_state_.phase = ManualControlPhase::kReadyForDrive;
        drive_command_active_ = false;
        return;
    }

    if (drive_command_active_ && session_state_.pending_motion) {
        session_state_.phase = ManualControlPhase::kDriving;
        return;
    }

    session_state_.phase = ManualControlPhase::kReadyForDrive;
}
