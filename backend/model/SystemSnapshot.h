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

struct SystemSnapshot {
    int battery = 0;
    Pose pose;
    bool charging = false;
    bool connected = false;
    bool localized = false;
    TaskSummary task;
    ConnectionDiagnostics connection;
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
        ",\"adapter_mode\":\"" + snapshot.connection.adapter_mode + "\"}}";
}

#endif
