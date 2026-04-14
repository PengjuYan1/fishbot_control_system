#ifndef FISHBOT_ROS_ADAPTER_MODEL_ROBOT_STATUS_H_
#define FISHBOT_ROS_ADAPTER_MODEL_ROBOT_STATUS_H_

struct RobotStatus {
    int battery_percent = 0;
    bool charging = false;
    bool connected = false;
    bool localized = false;
    int location_status_code = 0;
    bool emergency_stopped = false;
    int emergency_status_code = 0;
    bool motor_locked = false;
    int motor_status_code = 0;
    int charge_status_code = 0;
    int stm32_status_code = 0;
    int odom_status_code = 0;
    int motion_mode_code = 0;
    int navigation_status_code = 0;
    int out_of_charge_status_code = 0;
    bool out_machine_signal = false;
    int out_of_charge_result_code = 0;
};

#endif
