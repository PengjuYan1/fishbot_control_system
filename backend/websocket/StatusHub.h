#ifndef FISHBOT_BACKEND_WEBSOCKET_STATUSHUB_H_
#define FISHBOT_BACKEND_WEBSOCKET_STATUSHUB_H_

#include <string>

#include "backend/model/SystemSnapshot.h"
#include "ros_adapter/model/MapSnapshot.h"

class StatusHub {
  public:
    std::string connect_and_get_initial_message(const SystemSnapshot& snapshot);
    std::string publish_map_snapshot(const MapSnapshot& snapshot) const;
    std::string publish_robot_pose(const Pose& pose) const;
};

#endif
