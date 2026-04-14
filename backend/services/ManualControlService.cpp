#include "backend/services/ManualControlService.h"

#include <chrono>

namespace {
using Clock = std::chrono::steady_clock;
using namespace std::chrono_literals;

constexpr auto kControlLoopInterval = 40ms;
constexpr auto kMotionLeaseTimeout = 180ms;

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

ManualControlService::ManualControlService(IRobotAdapter& adapter) : adapter_(adapter) {
    control_thread_ = std::thread([this]() { control_loop(); });
}

ManualControlService::~ManualControlService() {
    {
        std::lock_guard<std::mutex> lock(mutex_);
        shutting_down_ = true;
        session_state_ = ManualControlState{};
        drive_command_active_ = false;
        zero_command_pending_ = false;
        motion_deadline_ = Clock::time_point{};
        ++command_revision_;
    }
    control_cv_.notify_all();
    if (control_thread_.joinable()) {
        control_thread_.join();
    }
}

ManualControlCommandResult ManualControlService::out_of_charge() {
    const auto robot_status = adapter_.get_robot_status();
    {
        std::lock_guard<std::mutex> lock(mutex_);
        session_state_.session_active = true;
        session_state_.pending_motion = false;
        motion_deadline_ = Clock::time_point{};
        zero_command_pending_ = false;
        sync_session_from_status_locked(robot_status);
        ++command_revision_;

        if (charging_still_blocks_manual_control(robot_status)) {
            session_state_.phase = ManualControlPhase::kUndockingRequested;
        } else {
            session_state_.phase = ManualControlPhase::kReadyForDrive;
        }
    }

    control_cv_.notify_all();

    if (!adapter_.out_of_charge()) {
        return ManualControlCommandResult{false, get_state()};
    }

    return ManualControlCommandResult{true, get_state()};
}

ManualControlCommandResult ManualControlService::exit_navigation_mode() {
    {
        std::lock_guard<std::mutex> lock(mutex_);
        session_state_.session_active = true;
        session_state_.pending_motion = false;
        drive_command_active_ = false;
        motion_deadline_ = Clock::time_point{};
        zero_command_pending_ = false;
        ++command_revision_;
    }

    control_cv_.notify_all();

    if (!release_navigation_control()) {
        return ManualControlCommandResult{false, get_state()};
    }

    return ManualControlCommandResult{true, get_state()};
}

ManualControlCommandResult ManualControlService::move(double linear_speed, double angular_speed) {
    const bool motion_requested = wants_motion(linear_speed, angular_speed);
    const auto robot_status = adapter_.get_robot_status();
    const auto now = Clock::now();
    {
        std::lock_guard<std::mutex> lock(mutex_);
        session_state_.session_active = true;
        session_state_.desired_linear = linear_speed;
        session_state_.desired_angular = angular_speed;
        session_state_.pending_motion = motion_requested;
        motion_deadline_ = motion_requested ? now + kMotionLeaseTimeout : Clock::time_point{};
        zero_command_pending_ = false;
        ++command_revision_;
        sync_session_from_status_locked(robot_status);

        if (motion_requested && charging_still_blocks_manual_control(robot_status)) {
            session_state_.phase = ManualControlPhase::kUndockingRequested;
        } else if (motion_requested) {
            session_state_.phase = drive_command_active_
                ? ManualControlPhase::kDriving
                : ManualControlPhase::kReadyForDrive;
        } else if (!motion_requested) {
            drive_command_active_ = false;
            session_state_.phase = session_state_.session_active
                ? ManualControlPhase::kReadyForDrive
                : ManualControlPhase::kIdle;
        }
    }

    if (motion_requested) {
        execute_control_step();
    }
    control_cv_.notify_all();

    return ManualControlCommandResult{true, get_state()};
}

ManualControlCommandResult ManualControlService::stop() {
    {
        std::lock_guard<std::mutex> lock(mutex_);
        session_state_ = ManualControlState{};
        drive_command_active_ = false;
        zero_command_pending_ = false;
        motion_deadline_ = Clock::time_point{};
        ++command_revision_;
    }
    control_cv_.notify_all();

    const bool released = release_navigation_control();
    const bool stopped = adapter_.manual_move(0.0, 0.0);

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

void ManualControlService::control_loop() {
    std::unique_lock<std::mutex> lock(mutex_);
    while (!shutting_down_) {
        control_cv_.wait_for(lock, kControlLoopInterval, [this]() {
            return shutting_down_ || zero_command_pending_ ||
                (session_state_.session_active && session_state_.pending_motion);
        });

        if (shutting_down_) {
            break;
        }

        if (!zero_command_pending_ && !(session_state_.session_active && session_state_.pending_motion)) {
            continue;
        }

        lock.unlock();
        execute_control_step();
        lock.lock();
    }
}

bool ManualControlService::execute_control_step() {
    const auto robot_status = adapter_.get_robot_status();
    const auto now = Clock::now();
    double desired_linear = 0.0;
    double desired_angular = 0.0;
    bool should_request_undock = false;
    bool should_release_navigation = false;
    bool should_send_zero = false;
    std::uint64_t revision = 0;

    {
        std::lock_guard<std::mutex> lock(mutex_);
        sync_session_from_status_locked(robot_status);
        if (motion_deadline_ != Clock::time_point{} && now >= motion_deadline_ && session_state_.pending_motion) {
            session_state_.desired_linear = 0.0;
            session_state_.desired_angular = 0.0;
            session_state_.pending_motion = false;
            motion_deadline_ = Clock::time_point{};
            zero_command_pending_ = drive_command_active_;
            drive_command_active_ = false;
        }

        sync_session_from_status_locked(robot_status);
        if (shutting_down_) {
            return false;
        }

        revision = command_revision_;

        if (zero_command_pending_) {
            should_send_zero = true;
        }

        if (!should_send_zero && (!session_state_.session_active || !session_state_.pending_motion)) {
            return false;
        }

        desired_linear = session_state_.desired_linear;
        desired_angular = session_state_.desired_angular;

        if (!should_send_zero && charging_still_blocks_manual_control(robot_status)) {
            session_state_.phase = ManualControlPhase::kUndockingRequested;
            drive_command_active_ = false;
            should_request_undock = true;
        } else if (!should_send_zero) {
            const bool navigation_blocked = navigation_still_owns_chassis(robot_status);
            const bool initial_release_needed = !drive_command_active_;
            should_release_navigation = navigation_blocked || initial_release_needed;
            if (navigation_blocked) {
                session_state_.phase = ManualControlPhase::kReadyForDrive;
                drive_command_active_ = false;
            }
        }
    }

    if (should_request_undock) {
        return adapter_.out_of_charge();
    }

    if (should_send_zero) {
        if (!adapter_.manual_move(0.0, 0.0)) {
            return false;
        }

        std::lock_guard<std::mutex> lock(mutex_);
        if (revision == command_revision_ && zero_command_pending_) {
            zero_command_pending_ = false;
            session_state_ = ManualControlState{};
            drive_command_active_ = false;
            motion_deadline_ = Clock::time_point{};
        }
        return true;
    }

    if (should_release_navigation && !release_navigation_control()) {
        return false;
    }

    {
        std::lock_guard<std::mutex> lock(mutex_);
        if (shutting_down_ || revision != command_revision_ ||
            !session_state_.session_active || !session_state_.pending_motion) {
            return false;
        }
        desired_linear = session_state_.desired_linear;
        desired_angular = session_state_.desired_angular;
    }

    if (!adapter_.manual_move(desired_linear, desired_angular)) {
        std::lock_guard<std::mutex> lock(mutex_);
        if (revision == command_revision_ && session_state_.session_active && session_state_.pending_motion) {
            drive_command_active_ = false;
            session_state_.phase = ManualControlPhase::kReadyForDrive;
        }
        return false;
    }

    std::lock_guard<std::mutex> lock(mutex_);
    if (revision == command_revision_ && session_state_.session_active && session_state_.pending_motion) {
        drive_command_active_ = true;
        session_state_.phase = ManualControlPhase::kDriving;
    }
    return true;
}

ManualControlState ManualControlService::snapshot_state_locked() const {
    return session_state_;
}

void ManualControlService::sync_session_from_status_locked(const RobotStatus& status) {
    if (!session_state_.session_active && !zero_command_pending_) {
        session_state_ = ManualControlState{};
        drive_command_active_ = false;
        motion_deadline_ = Clock::time_point{};
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
