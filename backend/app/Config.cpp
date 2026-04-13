#include "backend/app/Config.h"

#include <fstream>
#include <sstream>
#include <stdexcept>
#include <unordered_map>

namespace {
std::string trim(const std::string& value) {
    const auto first = value.find_first_not_of(" \t\r\n");
    if (first == std::string::npos) {
        return "";
    }

    const auto last = value.find_last_not_of(" \t\r\n");
    return value.substr(first, last - first + 1);
}

bool as_bool(const std::string& value) {
    return value == "true" || value == "1" || value == "yes";
}
}  // namespace

AppConfig load_config(const std::string& config_path) {
    std::ifstream input(config_path);
    if (!input.is_open()) {
        throw std::runtime_error("unable to open config: " + config_path);
    }

    std::unordered_map<std::string, std::string> values;
    std::string line;
    while (std::getline(input, line)) {
        const auto comment = line.find('#');
        if (comment != std::string::npos) {
            line = line.substr(0, comment);
        }

        line = trim(line);
        if (line.empty()) {
            continue;
        }

        const auto separator = line.find(':');
        if (separator == std::string::npos) {
            continue;
        }

        const auto key = trim(line.substr(0, separator));
        const auto value = trim(line.substr(separator + 1));
        values[key] = value;
    }

    AppConfig config;
    config.adapter_mode = values["adapter_mode"];
    config.rosbridge_host = values["rosbridge_host"];
    config.rosbridge_port = std::stoi(values["rosbridge_port"]);
    config.battery_return_threshold = std::stoi(values["battery_return_threshold"]);
    config.battery_start_threshold = std::stoi(values["battery_start_threshold"]);
    config.feed_pause_seconds = std::stoi(values["feed_pause_seconds"]);
    config.resume_after_charge = as_bool(values["resume_after_charge"]);
    config.finish_action = values["finish_action"];
    return config;
}
