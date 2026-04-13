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
    return snapshot;
}
