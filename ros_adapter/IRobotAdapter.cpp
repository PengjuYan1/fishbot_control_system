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
        "acquire_manual_control",
        "out_of_charge",
        "manual_move",
        "get_robot_pose",
        "get_battery",
        "get_robot_status",
        "get_map_snapshot",
        "is_charging",
        "create_current_pose_point",
        "delete_saved_point",
    };
}
