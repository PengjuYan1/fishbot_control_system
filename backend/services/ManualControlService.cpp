#include "backend/services/ManualControlService.h"

namespace {
bool navigation_still_owns_chassis(const RobotStatus& status) {
    return status.navigation_status_code != 0 && status.navigation_status_code != 7;
}
}  // namespace

ManualControlService::ManualControlService(IRobotAdapter& adapter) : adapter_(adapter) {}

bool ManualControlService::out_of_charge() {
    return adapter_.out_of_charge();
}

bool ManualControlService::move(double linear_speed, double angular_speed) {
    const bool wants_motion = linear_speed != 0.0 || angular_speed != 0.0;
    const auto robot_status = adapter_.get_robot_status();
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
