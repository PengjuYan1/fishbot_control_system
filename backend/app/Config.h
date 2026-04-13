#ifndef FISHBOT_BACKEND_APP_CONFIG_H_
#define FISHBOT_BACKEND_APP_CONFIG_H_

#include <string>

struct AppConfig {
    std::string adapter_mode;
    std::string rosbridge_host;
    int rosbridge_port = 0;
    std::string listen_host = "0.0.0.0";
    int listen_port = 8080;
    std::string static_root = "frontend";
    std::string database_path = "data/fishbot.db";
    int battery_return_threshold = 0;
    int battery_start_threshold = 0;
    int feed_pause_seconds = 0;
    bool resume_after_charge = false;
    std::string finish_action;
};

AppConfig load_config(const std::string& config_path);

#endif
