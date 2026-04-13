#include "backend/websocket/StatusHub.h"

#include <string>

std::string StatusHub::connect_and_get_initial_message(const SystemSnapshot& snapshot) {
    return std::string("{\"type\":\"system_snapshot\",\"payload\":") + to_json(snapshot) + "}";
}

std::string StatusHub::publish_map_snapshot(const MapSnapshot& snapshot) const {
    return std::string("{\"type\":\"map_snapshot\",\"payload\":") + to_json(snapshot) + "}";
}

std::string StatusHub::publish_robot_pose(const Pose& pose) const {
    return std::string("{\"type\":\"robot_pose\",\"payload\":{\"x\":") +
        std::to_string(pose.x) + ",\"y\":" + std::to_string(pose.y) +
        ",\"theta\":" + std::to_string(pose.theta) + "}}";
}
