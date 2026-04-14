#include "ros_adapter/bridge_client/RosbridgeAdapter.h"

#include <chrono>
#include <cctype>
#include <cmath>
#include <regex>
#include <sstream>
#include <utility>
#include <string>
#include <thread>
#include <vector>

namespace {
constexpr int kChargeReady = 41;
constexpr const char* kGetMapsServiceType = "std_srvs/Trigger";
constexpr const char* kListNaviPointsService = "list_navi_points";

bool charging_blocks_manual_control(const RobotStatus& status) {
    if (status.charging) {
        return true;
    }

    switch (status.charge_status_code) {
        case 45:
        case 46:
        case 47:
        case 48:
            return true;
        default:
            return false;
    }
}

long long steady_clock_millis() {
    return std::chrono::duration_cast<std::chrono::milliseconds>(
        std::chrono::steady_clock::now().time_since_epoch()).count();
}

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

long extract_long_value(const std::string& payload, const std::string& key, long default_value = 0) {
    const auto start = find_value_start(payload, key);
    if (start == std::string::npos) {
        return default_value;
    }

    if (start < payload.size() && payload[start] == '"') {
        auto end_quote = payload.find('"', start + 1);
        if (end_quote == std::string::npos || end_quote <= start + 1) {
            return default_value;
        }
        try {
            return std::stol(payload.substr(start + 1, end_quote - start - 1));
        } catch (const std::exception&) {
            return default_value;
        }
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
        return std::stol(payload.substr(start, end - start));
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

std::string extract_string_value(const std::string& payload, const std::string& key) {
    const auto start = find_value_start(payload, key);
    if (start == std::string::npos || start >= payload.size() || payload[start] != '"') {
        return "";
    }

    std::string value;
    bool escaped = false;
    for (std::size_t pos = start + 1; pos < payload.size(); ++pos) {
        const char ch = payload[pos];
        if (escaped) {
            switch (ch) {
                case 'n':
                    value += '\n';
                    break;
                case 'r':
                    value += '\r';
                    break;
                case 't':
                    value += '\t';
                    break;
                default:
                    value += ch;
                    break;
            }
            escaped = false;
            continue;
        }
        if (ch == '\\') {
            escaped = true;
            continue;
        }
        if (ch == '"') {
            return value;
        }
        value += ch;
    }
    return "";
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

std::vector<std::string> extract_object_array(const std::string& payload, const std::string& key) {
    auto pos = find_value_start(payload, key);
    if (pos == std::string::npos || pos >= payload.size() || payload[pos] != '[') {
        return {};
    }
    ++pos;

    std::vector<std::string> values;
    while (pos < payload.size()) {
        while (pos < payload.size() &&
               (std::isspace(static_cast<unsigned char>(payload[pos])) != 0 || payload[pos] == ',')) {
            ++pos;
        }
        if (pos >= payload.size() || payload[pos] == ']') {
            break;
        }
        if (payload[pos] != '{') {
            ++pos;
            continue;
        }

        const auto start = pos;
        int depth = 0;
        bool in_string = false;
        bool escaped = false;
        for (; pos < payload.size(); ++pos) {
            const char ch = payload[pos];
            if (in_string) {
                if (escaped) {
                    escaped = false;
                } else if (ch == '\\') {
                    escaped = true;
                } else if (ch == '"') {
                    in_string = false;
                }
                continue;
            }

            if (ch == '"') {
                in_string = true;
                continue;
            }
            if (ch == '{') {
                ++depth;
            } else if (ch == '}') {
                --depth;
                if (depth == 0) {
                    values.push_back(payload.substr(start, pos - start + 1));
                    ++pos;
                    break;
                }
            }
        }
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

bool is_effectively_zero(double value) {
    return std::abs(value) < 1e-6;
}

std::string json_escape(const std::string& value) {
    std::string escaped;
    escaped.reserve(value.size());
    for (const char ch : value) {
        switch (ch) {
            case '\\':
                escaped += "\\\\";
                break;
            case '"':
                escaped += "\\\"";
                break;
            case '\n':
                escaped += "\\n";
                break;
            case '\r':
                escaped += "\\r";
                break;
            case '\t':
                escaped += "\\t";
                break;
            default:
                escaped += ch;
                break;
        }
    }
    return escaped;
}

bool parse_default_map_context(const std::string& payload, long* floor_id, long* map_id) {
    if (floor_id == nullptr || map_id == nullptr) {
        return false;
    }

    std::string maps_json = extract_string_value(payload, "message");
    if (maps_json.empty()) {
        maps_json = payload;
    }

    const long default_floor = extract_long_value(maps_json, "defaultFloor", 0);
    const auto floors = extract_object_array(maps_json, "floors");
    if (floors.empty()) {
        return false;
    }

    for (const auto& floor_payload : floors) {
        const long candidate_floor = extract_long_value(floor_payload, "floorId", 0);
        if (default_floor > 0 && candidate_floor != default_floor) {
            continue;
        }

        const long candidate_map = extract_long_value(floor_payload, "defaultmap", 0);
        if (candidate_floor > 0 && candidate_map > 0) {
            *floor_id = candidate_floor;
            *map_id = candidate_map;
            return true;
        }
    }

    const long fallback_floor = extract_long_value(floors.front(), "floorId", 0);
    const long fallback_map = extract_long_value(floors.front(), "defaultmap", 0);
    if (fallback_floor > 0 && fallback_map > 0) {
        *floor_id = fallback_floor;
        *map_id = fallback_map;
        return true;
    }

    return false;
}

bool parse_current_map_metadata(const std::string& payload, long* floor_id, long* map_id,
                                long* charge_id, long* initial_id) {
    if (floor_id == nullptr || map_id == nullptr || charge_id == nullptr || initial_id == nullptr) {
        return false;
    }

    *charge_id = 0;
    *initial_id = 0;

    std::string maps_json = extract_string_value(payload, "message");
    if (maps_json.empty()) {
        maps_json = payload;
    }

    const long default_floor = extract_long_value(maps_json, "defaultFloor", 0);
    const auto floors = extract_object_array(maps_json, "floors");
    if (floors.empty()) {
        return false;
    }

    for (const auto& floor_payload : floors) {
        const long candidate_floor = extract_long_value(floor_payload, "floorId", 0);
        if (default_floor > 0 && candidate_floor != default_floor) {
            continue;
        }

        const long default_map = extract_long_value(floor_payload, "defaultmap", 0);
        const auto maps = extract_object_array(floor_payload, "maps");
        if (!maps.empty()) {
            for (const auto& map_payload : maps) {
                const long candidate_map = extract_long_value(map_payload, "mapId", 0);
                if (default_map > 0 && candidate_map != default_map) {
                    continue;
                }
                if (candidate_floor > 0 && candidate_map > 0) {
                    *floor_id = candidate_floor;
                    *map_id = candidate_map;
                    *charge_id = extract_long_value(map_payload, "chargeId", 0);
                    *initial_id = extract_long_value(map_payload, "initialId", 0);
                    return true;
                }
            }
        }

        if (candidate_floor > 0 && default_map > 0) {
            *floor_id = candidate_floor;
            *map_id = default_map;
            return true;
        }
    }

    return parse_default_map_context(payload, floor_id, map_id);
}

PointRecord build_native_point_record(const std::string& payload, long floor_id, long map_id,
                                      long charge_id, long initial_id) {
    PointRecord point;
    point.name = extract_string_value(payload, "point_name");
    point.type = "feed";
    point.x = extract_double_value(payload, "x");
    point.y = extract_double_value(payload, "y");
    point.theta = extract_double_value(payload, "z");
    point.floor_id = floor_id;
    point.map_id = map_id;
    point.point_id = extract_long_value(payload, "point_id", 0);

    if (point.point_id == charge_id) {
        point.type = "charge";
    } else if (point.point_id == initial_id) {
        point.type = "initial";
    }

    return point;
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
    std::string response;
    bool ok = call_service("/set_mode", "map_msgs/SetMode", "{\"mode\":0}", &response);
    ok = publish_topic("/navi_stop", "std_msgs/Int16", "{\"data\":5}") && ok;

    std::ostringstream payload;
    payload << "{\"linear\":{\"x\":0,\"y\":0,\"z\":0},\"angular\":{\"x\":0,\"y\":0,\"z\":0}}";
    return publish_topic("/cmd_vel", "geometry_msgs/Twist", payload.str()) && ok;
}

bool RosbridgeAdapter::set_initial_pose(const Pose& pose) {
    std::ostringstream payload;
    payload << "{\"x\":" << pose.x << ",\"y\":" << pose.y << ",\"theta\":" << pose.theta << "}";
    return publish_topic("/initialpose", "geometry_msgs/PoseWithCovarianceStamped", payload.str());
}

ManualControlAcquireResult RosbridgeAdapter::acquire_manual_control() {
    if (!is_connected()) {
        return ManualControlAcquireResult{false, ManualControlAcquireState::kFailed};
    }

    std::string response;
    bool ok = call_service("/set_mode", "map_msgs/SetMode", "{\"mode\":0}", &response);
    ok = publish_topic("/navi_stop", "std_msgs/Int16", "{\"data\":5}") && ok;
    ok = publish_topic("/cmd_vel", "geometry_msgs/Twist",
                       "{\"linear\":{\"x\":0,\"y\":0,\"z\":0},\"angular\":{\"x\":0,\"y\":0,\"z\":0}}") && ok;

    const auto status = get_robot_status();
    if (!ok) {
        return ManualControlAcquireResult{false, ManualControlAcquireState::kFailed};
    }

    if (charging_blocks_manual_control(status)) {
        const auto now_ms = steady_clock_millis();
        if (last_manual_takeover_command_ms_ == 0 ||
            (now_ms - last_manual_takeover_command_ms_) >= 250) {
            ok = publish_topic("outofcharge", "std_msgs/Int16", "{\"data\":1}") && ok;
            last_manual_takeover_command_ms_ = now_ms;
        }

        return ManualControlAcquireResult{
            ok,
            ok ? ManualControlAcquireState::kUndockingRequested : ManualControlAcquireState::kFailed,
        };
    }

    if (status.charge_status_code == kChargeReady || !status.charging) {
        return ManualControlAcquireResult{true, ManualControlAcquireState::kReady};
    }

    return ManualControlAcquireResult{false, ManualControlAcquireState::kFailed};
}

bool RosbridgeAdapter::out_of_charge() {
    return acquire_manual_control().ok;
}

bool RosbridgeAdapter::manual_move(double linear_speed, double angular_speed) {
    std::ostringstream payload;
    payload << "{\"linear\":{\"x\":" << linear_speed
            << ",\"y\":0,\"z\":0},\"angular\":{\"x\":0,\"y\":0,\"z\":"
            << angular_speed << "}}";
    return publish_topic("/cmd_vel", "geometry_msgs/Twist", payload.str());
}

bool RosbridgeAdapter::create_current_pose_point(const std::string& name, long point_mode, PointRecord* point) {
    if (point == nullptr || name.empty() || !is_connected()) {
        return false;
    }

    const Pose pose = get_robot_pose();
    const double half_theta = pose.theta / 2.0;
    const double orientation_z = std::sin(half_theta);
    const double orientation_w = std::cos(half_theta);

    std::ostringstream request;
    request << "{\"point_name\":\"" << json_escape(name)
            << "\",\"point_mode\":" << point_mode
            << ",\"point\":{\"header\":{\"frame_id\":\"map\"},\"pose\":{\"pose\":{\"position\":{\"x\":"
            << pose.x << ",\"y\":" << pose.y << ",\"z\":0},\"orientation\":{\"x\":0,\"y\":0,\"z\":"
            << orientation_z << ",\"w\":" << orientation_w
            << "}},\"covariance\":[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]}}}";

    std::string point_response;
    if (!call_service("pointmanu_set", "", request.str(), &point_response)) {
        return false;
    }

    const long point_id = extract_long_value(point_response, "result", 0);
    if (point_id <= 0) {
        return false;
    }

    std::string maps_response;
    long floor_id = 0;
    long map_id = 0;
    if (!call_service("get_maps", "", "{}", &maps_response) ||
        !parse_default_map_context(maps_response, &floor_id, &map_id)) {
        return false;
    }

    point->name = name;
    point->x = pose.x;
    point->y = pose.y;
    point->theta = pose.theta;
    point->floor_id = floor_id;
    point->map_id = map_id;
    point->point_id = point_id;
    return true;
}

bool RosbridgeAdapter::list_native_points(std::vector<PointRecord>* points) {
    if (!is_connected() || points == nullptr) {
        return false;
    }

    std::string maps_response;
    long floor_id = 0;
    long map_id = 0;
    long charge_id = 0;
    long initial_id = 0;
    if (!call_service("get_maps", kGetMapsServiceType, "{}", &maps_response) ||
        !parse_current_map_metadata(maps_response, &floor_id, &map_id, &charge_id, &initial_id)) {
        return false;
    }

    std::string points_response;
    if (!call_service(kListNaviPointsService, "", "{}", &points_response)) {
        return false;
    }

    points->clear();
    for (const auto& payload : extract_object_array(points_response, "list_system_points")) {
        points->push_back(build_native_point_record(payload, floor_id, map_id, charge_id, initial_id));
    }
    for (const auto& payload : extract_object_array(points_response, "list_navi_points")) {
        points->push_back(build_native_point_record(payload, floor_id, map_id, charge_id, initial_id));
    }

    return true;
}

bool RosbridgeAdapter::delete_saved_point(const PointRecord& point) {
    if (!is_connected() || point.floor_id <= 0 || point.map_id <= 0 || point.point_id <= 0) {
        return false;
    }

    std::ostringstream request;
    request << "{\"floor_id\":" << point.floor_id
            << ",\"map_id\":" << point.map_id
            << ",\"point_id\":" << point.point_id << "}";
    std::string response;
    return call_service("delete_test_point", "", request.str(), &response);
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
    status.navigation_status_code = navigation_status_;
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
