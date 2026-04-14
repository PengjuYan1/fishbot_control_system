#include "ros_adapter/native_ros/NativeRosAdapter.h"

std::string NativeRosAdapter::mode_name() const { return "native_ros"; }

bool NativeRosAdapter::connect() {
    connected_ = true;
    return connected_;
}

void NativeRosAdapter::disconnect() { connected_ = false; }

bool NativeRosAdapter::is_connected() const { return connected_; }

bool NativeRosAdapter::start_mapping() { return connected_; }

bool NativeRosAdapter::stop_mapping() { return connected_; }

bool NativeRosAdapter::save_map(const std::string&) { return connected_; }

bool NativeRosAdapter::load_map(const std::string&) { return connected_; }

bool NativeRosAdapter::navigate_to_pose(const Pose&) { return connected_; }

bool NativeRosAdapter::stop_navigation() { return connected_; }

bool NativeRosAdapter::set_initial_pose(const Pose&) { return connected_; }

ManualControlAcquireResult NativeRosAdapter::acquire_manual_control() {
    return ManualControlAcquireResult{
        connected_,
        connected_ ? ManualControlAcquireState::kReady : ManualControlAcquireState::kFailed,
    };
}

bool NativeRosAdapter::out_of_charge() { return connected_; }

bool NativeRosAdapter::manual_move(double, double) { return connected_; }

Pose NativeRosAdapter::get_robot_pose() const { return {}; }

int NativeRosAdapter::get_battery() const { return 0; }

RobotStatus NativeRosAdapter::get_robot_status() const {
    return RobotStatus{0, false, connected_, false};
}

MapSnapshot NativeRosAdapter::get_map_snapshot() const { return {}; }

bool NativeRosAdapter::is_charging() const { return false; }
