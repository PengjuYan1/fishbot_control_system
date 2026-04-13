#ifndef FISHBOT_BACKEND_MODEL_SYSTEMSNAPSHOT_H_
#define FISHBOT_BACKEND_MODEL_SYSTEMSNAPSHOT_H_

#include <string>

#include "ros_adapter/model/Pose.h"

struct TaskSummary {
    std::string status = "idle";
    std::string current_target = "";
};

struct ConnectionDiagnostics {
    bool healthy = true;
    std::string last_error = "";
    int reconnect_attempts = 0;
    std::string adapter_mode = "";
};

struct ControlDiagnostics {
    bool emergency_stopped = false;
    int emergency_status_code = 0;
    bool motor_locked = false;
    int motor_status_code = 0;
    int charge_status_code = 0;
    int stm32_status_code = 0;
    int odom_status_code = 0;
    int motion_mode_code = 0;
    int out_of_charge_status_code = 0;
    bool out_machine_signal = false;
    int out_of_charge_result_code = 0;
};

struct SystemSnapshot {
    int battery = 0;
    Pose pose;
    bool charging = false;
    bool connected = false;
    bool localized = false;
    TaskSummary task;
    ConnectionDiagnostics connection;
    ControlDiagnostics control;
};

inline std::string to_json(const SystemSnapshot& snapshot) {
    return std::string("{\"battery\":") + std::to_string(snapshot.battery) +
        ",\"pose\":{\"x\":" + std::to_string(snapshot.pose.x) +
        ",\"y\":" + std::to_string(snapshot.pose.y) +
        ",\"theta\":" + std::to_string(snapshot.pose.theta) +
        "},\"charging\":" + (snapshot.charging ? "true" : "false") +
        ",\"connected\":" + (snapshot.connected ? "true" : "false") +
        ",\"localized\":" + (snapshot.localized ? "true" : "false") +
        ",\"task\":{\"status\":\"" + snapshot.task.status +
        "\",\"current_target\":\"" + snapshot.task.current_target + "\"" +
        "},\"connection\":{\"healthy\":" + (snapshot.connection.healthy ? "true" : "false") +
        ",\"last_error\":\"" + snapshot.connection.last_error +
        "\",\"reconnect_attempts\":" + std::to_string(snapshot.connection.reconnect_attempts) +
        ",\"adapter_mode\":\"" + snapshot.connection.adapter_mode + "\"}" +
        ",\"control\":{\"emergency_stopped\":" + (snapshot.control.emergency_stopped ? "true" : "false") +
        ",\"emergency_status_code\":" + std::to_string(snapshot.control.emergency_status_code) +
        ",\"motor_locked\":" + (snapshot.control.motor_locked ? "true" : "false") +
        ",\"motor_status_code\":" + std::to_string(snapshot.control.motor_status_code) +
        ",\"charge_status_code\":" + std::to_string(snapshot.control.charge_status_code) +
        ",\"stm32_status_code\":" + std::to_string(snapshot.control.stm32_status_code) +
        ",\"odom_status_code\":" + std::to_string(snapshot.control.odom_status_code) +
        ",\"motion_mode_code\":" + std::to_string(snapshot.control.motion_mode_code) +
        ",\"out_of_charge_status_code\":" + std::to_string(snapshot.control.out_of_charge_status_code) +
        ",\"out_machine_signal\":" + (snapshot.control.out_machine_signal ? "true" : "false") +
        ",\"out_of_charge_result_code\":" + std::to_string(snapshot.control.out_of_charge_result_code) +
        "}}";
}

#endif
