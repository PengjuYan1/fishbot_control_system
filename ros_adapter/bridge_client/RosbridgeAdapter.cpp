#include "ros_adapter/bridge_client/RosbridgeAdapter.h"

#include <sstream>

RosbridgeAdapter::RosbridgeAdapter(IRosbridgeTransport* transport) : transport_(transport) {}

std::string RosbridgeAdapter::mode_name() const { return "rosbridge"; }

bool RosbridgeAdapter::connect() {
    connected_ = call_simple("connect", "{}");
    return connected_;
}

void RosbridgeAdapter::disconnect() { connected_ = false; }

bool RosbridgeAdapter::is_connected() const { return connected_; }

bool RosbridgeAdapter::start_mapping() { return call_simple("start_mapping", "{}"); }

bool RosbridgeAdapter::stop_mapping() { return call_simple("stop_mapping", "{}"); }

bool RosbridgeAdapter::save_map(const std::string& map_name) {
    return call_simple("save_map", std::string("{\"name\":\"") + map_name + "\"}");
}

bool RosbridgeAdapter::load_map(const std::string& map_id) {
    return call_simple("load_map", std::string("{\"id\":\"") + map_id + "\"}");
}

bool RosbridgeAdapter::navigate_to_pose(const Pose& pose) {
    std::ostringstream payload;
    payload << "{\"x\":" << pose.x << ",\"y\":" << pose.y << ",\"theta\":" << pose.theta << "}";
    return call_simple("navigate_to_pose", payload.str());
}

bool RosbridgeAdapter::stop_navigation() { return call_simple("stop_navigation", "{}"); }

bool RosbridgeAdapter::set_initial_pose(const Pose& pose) {
    std::ostringstream payload;
    payload << "{\"x\":" << pose.x << ",\"y\":" << pose.y << ",\"theta\":" << pose.theta << "}";
    return call_simple("set_initial_pose", payload.str());
}

Pose RosbridgeAdapter::get_robot_pose() const { return {}; }

int RosbridgeAdapter::get_battery() const { return 0; }

RobotStatus RosbridgeAdapter::get_robot_status() const {
    return RobotStatus{0, false, connected_, false};
}

MapSnapshot RosbridgeAdapter::get_map_snapshot() const { return {}; }

bool RosbridgeAdapter::is_charging() const { return false; }

bool RosbridgeAdapter::call_simple(const std::string& method, const std::string& payload) {
    if (transport_ == nullptr) {
        return false;
    }
    return transport_->call_method(method, payload);
}
