#ifndef FISHBOT_ROS_ADAPTER_MODEL_ROBOT_STATUS_H_
#define FISHBOT_ROS_ADAPTER_MODEL_ROBOT_STATUS_H_

struct RobotStatus {
    int battery_percent = 0;
    bool charging = false;
    bool connected = false;
    bool localized = false;
};

#endif
