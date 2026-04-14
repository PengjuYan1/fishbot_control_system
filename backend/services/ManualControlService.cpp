#include "backend/services/ManualControlService.h"

#include <thread>

namespace {
constexpr double kUndockLinearSpeed = 0.25;
constexpr double kUndockAngularSpeed = 0.0;
constexpr auto kUndockPulseDuration = std::chrono::milliseconds(400);
constexpr auto kUndockGraceDuration = std::chrono::milliseconds(1500);

bool wants_motion(double linear_speed, double angular_speed) {
    return linear_speed != 0.0 || angular_speed != 0.0;
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

bool undock_grace_active(const std::chrono::steady_clock::time_point& deadline) {
    return deadline != std::chrono::steady_clock::time_point{} &&
        std::chrono::steady_clock::now() < deadline;
}
}  // namespace

ManualControlService::ManualControlService(IRobotAdapter& adapter) : adapter_(adapter) {}

ManualControlCommandResult ManualControlService::out_of_charge() {
    const bool ok = adapter_.out_of_charge();
    const auto robot_status = adapter_.get_robot_status();

    {
        std::lock_guard<std::mutex> lock(mutex_);
        update_state_locked(
            charging_still_blocks_manual_control(robot_status)
                ? ManualControlPhase::kUndockingRequested
                : ManualControlPhase::kReadyForDrive,
            0.0,
            0.0,
            true,
            false);
        sync_session_from_status_locked(robot_status);
    }

    return ManualControlCommandResult{ok, get_state()};
}

ManualControlCommandResult ManualControlService::undock() {
    bool ok = adapter_.out_of_charge();
    if (ok) {
        ok = adapter_.manual_move(kUndockLinearSpeed, kUndockAngularSpeed);
    }
    if (ok) {
        std::this_thread::sleep_for(kUndockPulseDuration);
        ok = adapter_.manual_move(0.0, 0.0);
    }

    {
        std::lock_guard<std::mutex> lock(mutex_);
        if (ok) {
            undock_grace_deadline_ = std::chrono::steady_clock::now() + kUndockGraceDuration;
            update_state_locked(ManualControlPhase::kReadyForDrive, 0.0, 0.0, true, false);
        } else {
            undock_grace_deadline_ = std::chrono::steady_clock::time_point{};
            update_state_locked(ManualControlPhase::kUndockingRequested, 0.0, 0.0, true, false);
        }
        sync_session_from_status_locked(adapter_.get_robot_status());
    }

    return ManualControlCommandResult{ok, get_state()};
}

ManualControlCommandResult ManualControlService::exit_navigation_mode() {
    const auto acquire = adapter_.acquire_manual_control();

    {
        std::lock_guard<std::mutex> lock(mutex_);
        if (acquire.state == ManualControlAcquireState::kReady) {
            update_state_locked(ManualControlPhase::kReadyForDrive, 0.0, 0.0, true, false);
        } else if (acquire.state == ManualControlAcquireState::kUndockingRequested) {
            update_state_locked(ManualControlPhase::kUndockingRequested, 0.0, 0.0, true, false);
        } else {
            drive_command_active_ = false;
        }
        sync_session_from_status_locked(adapter_.get_robot_status());
    }

    return ManualControlCommandResult{acquire.ok, get_state()};
}

ManualControlCommandResult ManualControlService::move(double linear_speed, double angular_speed) {
    const bool motion_requested = wants_motion(linear_speed, angular_speed);

    if (!motion_requested) {
        return stop();
    }

    if (undock_grace_active(undock_grace_deadline_)) {
        if (!adapter_.manual_move(linear_speed, angular_speed)) {
            std::lock_guard<std::mutex> lock(mutex_);
            update_state_locked(ManualControlPhase::kReadyForDrive, linear_speed, angular_speed, true, true);
            sync_session_from_status_locked(adapter_.get_robot_status());
            return ManualControlCommandResult{false, snapshot_state_locked()};
        }

        std::lock_guard<std::mutex> lock(mutex_);
        update_state_locked(ManualControlPhase::kDriving, linear_speed, angular_speed, true, true);
        sync_session_from_status_locked(adapter_.get_robot_status());
        return ManualControlCommandResult{true, snapshot_state_locked()};
    }

    const auto acquire = adapter_.acquire_manual_control();
    if (!acquire.ok) {
        std::lock_guard<std::mutex> lock(mutex_);
        update_state_locked(ManualControlPhase::kReadyForDrive, linear_speed, angular_speed, true, true);
        sync_session_from_status_locked(adapter_.get_robot_status());
        return ManualControlCommandResult{false, snapshot_state_locked()};
    }

    if (acquire.state == ManualControlAcquireState::kUndockingRequested) {
        std::lock_guard<std::mutex> lock(mutex_);
        update_state_locked(
            ManualControlPhase::kUndockingRequested, linear_speed, angular_speed, true, true);
        sync_session_from_status_locked(adapter_.get_robot_status());
        return ManualControlCommandResult{true, snapshot_state_locked()};
    }

    if (!adapter_.manual_move(linear_speed, angular_speed)) {
        std::lock_guard<std::mutex> lock(mutex_);
        update_state_locked(ManualControlPhase::kReadyForDrive, linear_speed, angular_speed, true, true);
        sync_session_from_status_locked(adapter_.get_robot_status());
        return ManualControlCommandResult{false, snapshot_state_locked()};
    }

    std::lock_guard<std::mutex> lock(mutex_);
    update_state_locked(ManualControlPhase::kDriving, linear_speed, angular_speed, true, true);
    sync_session_from_status_locked(adapter_.get_robot_status());
    return ManualControlCommandResult{true, snapshot_state_locked()};
}

ManualControlCommandResult ManualControlService::stop() {
    const bool stopped = adapter_.manual_move(0.0, 0.0);

    {
        std::lock_guard<std::mutex> lock(mutex_);
        session_state_ = ManualControlState{};
        drive_command_active_ = false;
        undock_grace_deadline_ = std::chrono::steady_clock::time_point{};
    }

    return ManualControlCommandResult{stopped, get_state()};
}

ManualControlState ManualControlService::get_state() {
    const auto robot_status = adapter_.get_robot_status();
    std::lock_guard<std::mutex> lock(mutex_);
    sync_session_from_status_locked(robot_status);
    return snapshot_state_locked();
}

void ManualControlService::update_state_locked(ManualControlPhase phase, double linear_speed,
                                               double angular_speed, bool session_active,
                                               bool pending_motion) {
    session_state_.phase = phase;
    session_state_.desired_linear = linear_speed;
    session_state_.desired_angular = angular_speed;
    session_state_.session_active = session_active;
    session_state_.pending_motion = pending_motion;
    drive_command_active_ = phase == ManualControlPhase::kDriving;
}

ManualControlState ManualControlService::snapshot_state_locked() const {
    return session_state_;
}

void ManualControlService::sync_session_from_status_locked(const RobotStatus& status) {
    if (!session_state_.session_active) {
        session_state_ = ManualControlState{};
        drive_command_active_ = false;
        undock_grace_deadline_ = std::chrono::steady_clock::time_point{};
        return;
    }

    session_state_.pending_motion =
        wants_motion(session_state_.desired_linear, session_state_.desired_angular);

    if (charging_still_blocks_manual_control(status) && !undock_grace_active(undock_grace_deadline_)) {
        session_state_.phase = ManualControlPhase::kUndockingRequested;
        drive_command_active_ = false;
        return;
    }

    if (drive_command_active_ && session_state_.pending_motion) {
        session_state_.phase = ManualControlPhase::kDriving;
        return;
    }

    session_state_.phase = ManualControlPhase::kReadyForDrive;
}
