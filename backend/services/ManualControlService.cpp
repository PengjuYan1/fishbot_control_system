#include "backend/services/ManualControlService.h"

namespace {
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

bool ManualControlService::out_of_charge() {
    return adapter_.out_of_charge();
}

bool ManualControlService::exit_navigation_mode() {
    const bool released = release_navigation_control();
    control_session_active_ = false;
    return released;
}

bool ManualControlService::move(double linear_speed, double angular_speed) {
    const bool wants_motion = linear_speed != 0.0 || angular_speed != 0.0;
    const auto robot_status = adapter_.get_robot_status();

    if (wants_motion && charging_still_blocks_manual_control(robot_status)) {
        control_session_active_ = false;
        return adapter_.out_of_charge();
    }

    const bool must_reacquire_control =
        wants_motion && (!control_session_active_ || navigation_still_owns_chassis(robot_status));

    if (must_reacquire_control) {
        if (!release_navigation_control()) {
            return false;
        }
        control_session_active_ = true;
    }

    return adapter_.manual_move(linear_speed, angular_speed);
}

bool ManualControlService::stop() {
    const bool released = release_navigation_control();
    const bool stopped = adapter_.manual_move(0.0, 0.0);
    control_session_active_ = false;
    return released && stopped;
}

bool ManualControlService::release_navigation_control() {
    return adapter_.stop_navigation();
}
