#ifndef FISHBOT_ROS_ADAPTER_MODEL_MAPDESCRIPTOR_H_
#define FISHBOT_ROS_ADAPTER_MODEL_MAPDESCRIPTOR_H_

#include <string>

struct MapDescriptor {
    long floor_id = 0;
    std::string floor_name;
    long map_id = 0;
    std::string map_name;
    long default_floor_id = 0;
    long default_map_id = 0;
    long charge_id = 0;
    long initial_id = 0;
    bool is_default_floor = false;
    bool is_default_map = false;
};

inline std::string to_json(const MapDescriptor& map) {
    return std::string("{\"floor_id\":") + std::to_string(map.floor_id) +
        ",\"floor_name\":\"" + map.floor_name +
        "\",\"map_id\":" + std::to_string(map.map_id) +
        ",\"map_name\":\"" + map.map_name +
        "\",\"default_floor_id\":" + std::to_string(map.default_floor_id) +
        ",\"default_map_id\":" + std::to_string(map.default_map_id) +
        ",\"charge_id\":" + std::to_string(map.charge_id) +
        ",\"initial_id\":" + std::to_string(map.initial_id) +
        ",\"is_default_floor\":" + std::string(map.is_default_floor ? "true" : "false") +
        ",\"is_default_map\":" + std::string(map.is_default_map ? "true" : "false") +
        "}";
}

#endif
