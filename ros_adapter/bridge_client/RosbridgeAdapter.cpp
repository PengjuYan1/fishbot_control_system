#include "ros_adapter/bridge_client/RosbridgeAdapter.h"

#include <cctype>
#include <cmath>
#include <regex>
#include <sstream>
#include <string>
#include <vector>

namespace {
std::size_t find_value_start(const std::string& payload, const std::string& key) {
    const auto token = std::string("\"") + key + "\"";
    const auto key_pos = payload.find(token);
    if (key_pos == std::string::npos) {
        return std::string::npos;
    }

    auto pos = payload.find(':', key_pos + token.size());
    if (pos == std::string::npos) {
        return std::string::npos;
    }
    ++pos;

    while (pos < payload.size() && std::isspace(static_cast<unsigned char>(payload[pos])) != 0) {
        ++pos;
    }
    return pos;
}

int extract_int_value(const std::string& payload, const std::string& key, int default_value = 0) {
    const auto start = find_value_start(payload, key);
    if (start == std::string::npos) {
        return default_value;
    }

    auto end = start;
    if (end < payload.size() && (payload[end] == '-' || payload[end] == '+')) {
        ++end;
    }
    while (end < payload.size() && std::isdigit(static_cast<unsigned char>(payload[end])) != 0) {
        ++end;
    }
    if (end == start || (end == start + 1 && (payload[start] == '-' || payload[start] == '+'))) {
        return default_value;
    }

    try {
        return std::stoi(payload.substr(start, end - start));
    } catch (const std::exception&) {
        return default_value;
    }
}

double extract_double_value(const std::string& payload, const std::string& key, double default_value = 0.0) {
    const auto start = find_value_start(payload, key);
    if (start == std::string::npos) {
        return default_value;
    }

    auto end = start;
    if (end < payload.size() && (payload[end] == '-' || payload[end] == '+')) {
        ++end;
    }
    bool saw_digit = false;
    while (end < payload.size()) {
        const char ch = payload[end];
        if (std::isdigit(static_cast<unsigned char>(ch)) != 0) {
            saw_digit = true;
            ++end;
            continue;
        }
        if (ch == '.' || ch == 'e' || ch == 'E' || ch == '-' || ch == '+') {
            ++end;
            continue;
        }
        break;
    }
    if (!saw_digit) {
        return default_value;
    }

    try {
        return std::stod(payload.substr(start, end - start));
    } catch (const std::exception&) {
        return default_value;
    }
}

std::vector<int> extract_int_array(const std::string& payload, const std::string& key) {
    auto pos = find_value_start(payload, key);
    if (pos == std::string::npos || pos >= payload.size() || payload[pos] != '[') {
        return {};
    }
    ++pos;

    std::vector<int> values;
    while (pos < payload.size()) {
        while (pos < payload.size() &&
               (std::isspace(static_cast<unsigned char>(payload[pos])) != 0 || payload[pos] == ',')) {
            ++pos;
        }
        if (pos >= payload.size() || payload[pos] == ']') {
            break;
        }

        auto end = pos;
        if (payload[end] == '-' || payload[end] == '+') {
            ++end;
        }
        while (end < payload.size() && std::isdigit(static_cast<unsigned char>(payload[end])) != 0) {
            ++end;
        }
        if (end == pos || (end == pos + 1 && (payload[pos] == '-' || payload[pos] == '+'))) {
            break;
        }

        try {
            values.push_back(std::stoi(payload.substr(pos, end - pos)));
        } catch (const std::exception&) {
            break;
        }
        pos = end;
    }
    return values;
}

double quaternion_to_theta(double z, double w) {
    return std::atan2(2.0 * w * z, 1.0 - 2.0 * z * z);
}

bool parse_map_selector(const std::string& selector, long* floor_id, long* map_id) {
    if (floor_id == nullptr || map_id == nullptr || selector.empty()) {
        return false;
    }

    std::size_t delimiter = selector.find(':');
    if (delimiter == std::string::npos) {
        delimiter = selector.find('/');
    }
    if (delimiter == std::string::npos) {
        delimiter = selector.find(',');
    }

    try {
        if (delimiter == std::string::npos) {
            *floor_id = 0;
            *map_id = std::stol(selector);
            return true;
        }

        *floor_id = std::stol(selector.substr(0, delimiter));
        *map_id = std::stol(selector.substr(delimiter + 1));
        return true;
    } catch (const std::exception&) {
        return false;
    }
}
}  // namespace

RosbridgeAdapter::RosbridgeAdapter(IRosbridgeTransport* transport) : transport_(transport) {}

std::string RosbridgeAdapter::mode_name() const { return "rosbridge"; }

bool RosbridgeAdapter::connect() {
    if (transport_ == nullptr) {
        return false;
    }

    connected_ = transport_->connect();
    if (!connected_) {
        return false;
    }

    if (!subscribe_status_topics()) {
        transport_->disconnect();
        connected_ = false;
        return false;
    }

    return true;
}

void RosbridgeAdapter::disconnect() {
    if (transport_ != nullptr) {
        transport_->disconnect();
    }
    connected_ = false;
}

bool RosbridgeAdapter::is_connected() const {
    return transport_ != nullptr && connected_ && transport_->is_connected();
}

bool RosbridgeAdapter::start_mapping() {
    std::string response;
    return call_service("clear_map", "map_msgs/ClearMap", "{}", &response) &&
        call_service("/set_mode", "map_msgs/SetMode", "{\"mode\":1}", &response);
}

bool RosbridgeAdapter::stop_mapping() {
    return call_service("/set_mode", "map_msgs/SetMode", "{\"mode\":0}");
}

bool RosbridgeAdapter::save_map(const std::string& map_name) {
    return !map_name.empty();
}

bool RosbridgeAdapter::load_map(const std::string& map_id) {
    long floor_id_value = 0;
    long map_id_value = 0;
    if (!parse_map_selector(map_id, &floor_id_value, &map_id_value)) {
        return false;
    }

    std::ostringstream request;
    request << "{\"type\":0,\"floor_id\":" << floor_id_value
            << ",\"map_id\":" << map_id_value << "}";
    return call_service("/publish_map", "map_msgs/PublishMap", request.str());
}

bool RosbridgeAdapter::navigate_to_pose(const Pose& pose) {
    if (pose.point_id <= 0) {
        return false;
    }

    std::ostringstream request;
    request << "{\"type\":0,\"floor_id\":" << pose.floor_id
            << ",\"map_id\":" << pose.map_id
            << ",\"point_id\":" << pose.point_id << "}";
    return call_service("navi_targegoalplan", "map_msgs/TargetGoalPlan", request.str());
}

bool RosbridgeAdapter::stop_navigation() {
    return publish_topic("/navi_stop", "std_msgs/Int16", "{\"data\":5}");
}

bool RosbridgeAdapter::set_initial_pose(const Pose& pose) {
    std::ostringstream payload;
    payload << "{\"x\":" << pose.x << ",\"y\":" << pose.y << ",\"theta\":" << pose.theta << "}";
    return publish_topic("/initialpose", "geometry_msgs/PoseWithCovarianceStamped", payload.str());
}

bool RosbridgeAdapter::out_of_charge() {
    return publish_topic("outofcharge", "std_msgs/Int16", "{\"data\":1}");
}

bool RosbridgeAdapter::manual_move(double linear_speed, double angular_speed) {
    std::ostringstream payload;
    payload << "{\"linear\":{\"x\":" << linear_speed
            << ",\"y\":0,\"z\":0},\"angular\":{\"x\":0,\"y\":0,\"z\":"
            << (-angular_speed) << "}}";
    return publish_topic("cmd_vel", "geometry_msgs/Twist", payload.str());
}

Pose RosbridgeAdapter::get_robot_pose() const { return pose_; }

int RosbridgeAdapter::get_battery() const { return battery_; }

RobotStatus RosbridgeAdapter::get_robot_status() const {
    RobotStatus status;
    status.battery_percent = battery_;
    status.charging = charging_;
    status.connected = is_connected();
    status.localized = localized_;
    status.emergency_stopped = emergency_stopped_;
    status.emergency_status_code = emergency_status_code_;
    status.motor_locked = motor_locked_;
    status.motor_status_code = motor_status_code_;
    status.charge_status_code = charge_status_code_;
    status.stm32_status_code = stm32_status_code_;
    status.odom_status_code = odom_status_code_;
    status.motion_mode_code = motion_mode_code_;
    status.out_of_charge_status_code = out_of_charge_status_code_;
    status.out_machine_signal = out_machine_signal_;
    status.out_of_charge_result_code = out_of_charge_result_code_;
    return status;
}

MapSnapshot RosbridgeAdapter::get_map_snapshot() const { return map_snapshot_; }

bool RosbridgeAdapter::is_charging() const { return charging_; }

bool RosbridgeAdapter::subscribe_status_topics() {
    if (transport_ == nullptr) {
        return false;
    }

    return transport_->subscribe("power_report", "std_msgs/Int16",
               [this](const std::string& payload) { handle_battery_message(payload); }) &&
        transport_->subscribe("androidmsg_emergencystatus", "std_msgs/Int16",
               [this](const std::string& payload) { handle_emergency_message(payload); }) &&
        transport_->subscribe("androidmsg_motorenabledstatus", "std_msgs/Int16",
               [this](const std::string& payload) { handle_motor_lock_message(payload); }) &&
        transport_->subscribe("androidmsg_chargestatus", "std_msgs/Int16",
               [this](const std::string& payload) { handle_charge_message(payload); }) &&
        transport_->subscribe("androidmsg_stm32status", "std_msgs/Int16",
               [this](const std::string& payload) { handle_stm32_message(payload); }) &&
        transport_->subscribe("androidmsg_odomstatus", "std_msgs/Int16",
               [this](const std::string& payload) { handle_odom_message(payload); }) &&
        transport_->subscribe("motion_mode", "std_msgs/Int16",
               [this](const std::string& payload) { handle_motion_mode_message(payload); }) &&
        transport_->subscribe("outofcharge_status", "std_msgs/Int16",
               [this](const std::string& payload) { handle_out_of_charge_status_message(payload); }) &&
        transport_->subscribe("reviceOutMachineSignal", "std_msgs/Int16",
               [this](const std::string& payload) { handle_out_machine_signal_message(payload); }) &&
        transport_->subscribe("androidmsg_outofchargepoint", "std_msgs/Int16",
               [this](const std::string& payload) { handle_out_of_charge_result_message(payload); }) &&
        transport_->subscribe("androidmsg_locationstatus", "std_msgs/Int16",
               [this](const std::string& payload) { handle_location_message(payload); }) &&
        transport_->subscribe("androidmsg_navigationstatus", "std_msgs/Int16",
               [this](const std::string& payload) { handle_navigation_message(payload); }) &&
        transport_->subscribe("tracked_pose", "geometry_msgs/PoseStamped",
               [this](const std::string& payload) { handle_pose_message(payload); }) &&
        transport_->subscribe("/map", "nav_msgs/OccupancyGrid",
               [this](const std::string& payload) { handle_map_message(payload); }) &&
        transport_->subscribe("androidmsg_mapstatus", "std_msgs/Int16",
               [this](const std::string& payload) { handle_android_map_status_message(payload); }) &&
        transport_->subscribe("map_status", "std_msgs/Int16",
               [this](const std::string& payload) { handle_map_status_message(payload); });
}

bool RosbridgeAdapter::publish_topic(const std::string& topic, const std::string& type,
                                     const std::string& payload) {
    if (transport_ == nullptr) {
        return false;
    }
    return transport_->publish(topic, type, payload);
}

bool RosbridgeAdapter::call_service(const std::string& service, const std::string& type,
                                    const std::string& request, std::string* response) {
    if (transport_ == nullptr) {
        return false;
    }
    return transport_->call_service(service, type, request, response);
}

void RosbridgeAdapter::handle_battery_message(const std::string& payload) {
    battery_ = extract_int_value(payload, "data");
}

void RosbridgeAdapter::handle_charge_message(const std::string& payload) {
    charge_status_code_ = extract_int_value(payload, "data");
    charging_ = charge_status_code_ == 45 || charge_status_code_ == 46 ||
        charge_status_code_ == 47 || charge_status_code_ == 48;
}

void RosbridgeAdapter::handle_stm32_message(const std::string& payload) {
    stm32_status_code_ = extract_int_value(payload, "data");
}

void RosbridgeAdapter::handle_odom_message(const std::string& payload) {
    odom_status_code_ = extract_int_value(payload, "data");
}

void RosbridgeAdapter::handle_emergency_message(const std::string& payload) {
    emergency_status_code_ = extract_int_value(payload, "data");
    emergency_stopped_ = emergency_status_code_ == 31;
}

void RosbridgeAdapter::handle_motor_lock_message(const std::string& payload) {
    motor_status_code_ = extract_int_value(payload, "data");
    motor_locked_ = motor_status_code_ == 33;
}

void RosbridgeAdapter::handle_motion_mode_message(const std::string& payload) {
    motion_mode_code_ = extract_int_value(payload, "data");
}

void RosbridgeAdapter::handle_location_message(const std::string& payload) {
    localized_ = extract_int_value(payload, "data") == 10;
}

void RosbridgeAdapter::handle_navigation_message(const std::string& payload) {
    navigation_status_ = extract_int_value(payload, "data");
}

void RosbridgeAdapter::handle_out_of_charge_status_message(const std::string& payload) {
    out_of_charge_status_code_ = extract_int_value(payload, "data");
}

void RosbridgeAdapter::handle_out_machine_signal_message(const std::string& payload) {
    out_machine_signal_ = extract_int_value(payload, "data") == 1;
}

void RosbridgeAdapter::handle_out_of_charge_result_message(const std::string& payload) {
    out_of_charge_result_code_ = extract_int_value(payload, "data");
}

void RosbridgeAdapter::handle_pose_message(const std::string& payload) {
    const std::regex position_pattern(
        "\"position\"\\s*:\\s*\\{[^\\}]*\"x\"\\s*:\\s*(-?[0-9]+(?:\\.[0-9]+)?)\\s*,\\s*\"y\"\\s*:\\s*(-?[0-9]+(?:\\.[0-9]+)?)");
    const std::regex orientation_pattern(
        "\"orientation\"\\s*:\\s*\\{[^\\}]*\"z\"\\s*:\\s*(-?[0-9]+(?:\\.[0-9]+)?)\\s*,\\s*\"w\"\\s*:\\s*(-?[0-9]+(?:\\.[0-9]+)?)");
    std::smatch match;

    if (std::regex_search(payload, match, position_pattern)) {
        pose_.x = std::stod(match[1].str());
        pose_.y = std::stod(match[2].str());
    }

    if (std::regex_search(payload, match, orientation_pattern)) {
        pose_.theta = quaternion_to_theta(std::stod(match[1].str()), std::stod(match[2].str()));
    }
}

void RosbridgeAdapter::handle_map_message(const std::string& payload) {
    map_snapshot_.width = extract_int_value(payload, "width");
    map_snapshot_.height = extract_int_value(payload, "height");
    map_snapshot_.resolution = extract_double_value(payload, "resolution");
    map_snapshot_.occupancy_data = extract_int_array(payload, "data");
    map_snapshot_.origin_x = extract_double_value(payload, "x");
    map_snapshot_.origin_y = extract_double_value(payload, "y");
}

void RosbridgeAdapter::handle_map_status_message(const std::string& payload) {
    map_status_ = extract_int_value(payload, "data");
}

void RosbridgeAdapter::handle_android_map_status_message(const std::string& payload) {
    android_map_status_ = extract_int_value(payload, "data");
}
