#ifndef FISHBOT_ROS_ADAPTER_MODEL_MAP_SNAPSHOT_H_
#define FISHBOT_ROS_ADAPTER_MODEL_MAP_SNAPSHOT_H_

#include <string>
#include <vector>

struct MapSnapshot {
    int width = 0;
    int height = 0;
    double resolution = 0.0;
    std::vector<int> occupancy_data;
    double origin_x = 0.0;
    double origin_y = 0.0;
};

inline std::string to_json(const MapSnapshot& snapshot) {
    std::string occupancy = "[";
    for (std::size_t index = 0; index < snapshot.occupancy_data.size(); ++index) {
        occupancy += std::to_string(snapshot.occupancy_data[index]);
        if (index + 1 < snapshot.occupancy_data.size()) {
            occupancy += ",";
        }
    }
    occupancy += "]";

    return std::string("{\"width\":") + std::to_string(snapshot.width) +
        ",\"height\":" + std::to_string(snapshot.height) +
        ",\"resolution\":" + std::to_string(snapshot.resolution) +
        ",\"occupancy_data\":" + occupancy +
        ",\"origin_x\":" + std::to_string(snapshot.origin_x) +
        ",\"origin_y\":" + std::to_string(snapshot.origin_y) + "}";
}

#endif
