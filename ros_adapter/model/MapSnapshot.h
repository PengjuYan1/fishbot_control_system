#ifndef FISHBOT_ROS_ADAPTER_MODEL_MAP_SNAPSHOT_H_
#define FISHBOT_ROS_ADAPTER_MODEL_MAP_SNAPSHOT_H_

#include <vector>

struct MapSnapshot {
    int width = 0;
    int height = 0;
    double resolution = 0.0;
    std::vector<int> occupancy_data;
};

#endif
