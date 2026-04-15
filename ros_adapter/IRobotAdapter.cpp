#include "ros_adapter/IRobotAdapter.h"

std::vector<std::string> describe_adapter_contract() {
    return {
        "connect",
        "disconnect",
        "is_connected",
        "start_mapping",
        "stop_mapping",
        "save_map",
        "load_map",
        "navigate_to_pose",
        "stop_navigation",
        "set_initial_pose",
        "set_relocation",
        "acquire_manual_control",
        "out_of_charge",
        "go_charge",
        "manual_move",
        "get_robot_pose",
        "get_battery",
        "get_robot_status",
        "get_map_snapshot",
        "is_charging",
        "get_latest_laser_scan",
        "create_current_pose_point",
        "list_native_points",
        "list_maps",
        "delete_map",
        "delete_saved_point",
    };
}
