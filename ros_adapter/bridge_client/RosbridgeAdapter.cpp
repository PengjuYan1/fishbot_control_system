#include "ros_adapter/bridge_client/RosbridgeAdapter.h"

#include <chrono>
#include <cctype>
#include <cmath>
#include <initializer_list>
#include <regex>
#include <sstream>
#include <utility>
#include <string>
#include <thread>
#include <vector>

namespace {
constexpr int kChargeReady = 41;
constexpr const char* kGetMapsServiceType = "std_srvs/Trigger";
constexpr const char* kPointSetServiceType = "map_msgs/PointSet";
constexpr const char* kPointManuSetServiceType = "map_msgs/PointManuSet";
constexpr const char* kDeleteTestPointServiceType = "map_msgs/DeleteTestPoint";
constexpr const char* kSaveMapServiceType = "map_msgs/SaveMap";
constexpr const char* kDeleteMapServiceType = "map_msgs/DeleteMap";
constexpr const char* kListNaviPointsService = "list_navi_points";
constexpr const char* kListNaviPointsServiceType = "map_msgs/ListNaviPoints";

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

bool has_key(const std::string& payload, const std::string& key) {
    return payload.find(std::string("\"") + key + "\"") != std::string::npos;
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

long extract_long_value_any(const std::string& payload, std::initializer_list<const char*> keys,
                            long default_value = 0) {
    for (const auto* key : keys) {
        if (key != nullptr && has_key(payload, key)) {
            return extract_long_value(payload, key, default_value);
        }
    }
    return default_value;
}

double extract_double_value_any(const std::string& payload, std::initializer_list<const char*> keys,
                                double default_value = 0.0) {
    for (const auto* key : keys) {
        if (key != nullptr && has_key(payload, key)) {
            return extract_double_value(payload, key, default_value);
        }
    }
    return default_value;
}

std::string extract_string_value_any(const std::string& payload, std::initializer_list<const char*> keys) {
    for (const auto* key : keys) {
        if (key == nullptr || !has_key(payload, key)) {
            continue;
        }
        const auto value = extract_string_value(payload, key);
        if (!value.empty()) {
            return value;
        }
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

std::vector<std::string> extract_object_array_any(const std::string& payload,
                                                  std::initializer_list<const char*> keys) {
    for (const auto* key : keys) {
        if (key == nullptr || !has_key(payload, key)) {
            continue;
        }
        const auto values = extract_object_array(payload, key);
        if (!values.empty()) {
            return values;
        }
    }
    return {};
}

double quaternion_to_theta(double z, double w) {
    return std::atan2(2.0 * w * z, 1.0 - 2.0 * z * z);
}

double theta_to_quaternion_z(double theta) {
    return std::sin(theta * 0.5);
}

double theta_to_quaternion_w(double theta) {
    return std::cos(theta * 0.5);
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

std::string unwrap_maps_payload(const std::string& payload) {
    std::string maps_json = extract_string_value_any(payload, {"message", "data"});
    if (maps_json.empty()) {
        maps_json = payload;
    }
    return maps_json;
}

std::vector<MapDescriptor> parse_map_descriptors(const std::string& payload) {
    const std::string maps_json = unwrap_maps_payload(payload);
    const long default_floor = extract_long_value_any(maps_json, {"defaultFloor", "default_floor"}, 0);
    const auto floors = extract_object_array_any(maps_json, {"floors", "floor_list", "floorList"});

    std::vector<MapDescriptor> maps;
    for (std::size_t floor_index = 0; floor_index < floors.size(); ++floor_index) {
        const auto& floor_payload = floors[floor_index];
        const long floor_id = extract_long_value_any(floor_payload, {"floorId", "floor_id", "id"}, 0);
        if (floor_id <= 0) {
            continue;
        }

        const std::string floor_name = extract_string_value_any(
            floor_payload, {"floorName", "floor_name", "name"});
        long default_map = extract_long_value_any(
            floor_payload, {"defaultmap", "defaultMap", "default_map"}, 0);
        const auto map_payloads = extract_object_array_any(
            floor_payload, {"maps", "map_list", "mapList"});
        if (!map_payloads.empty() && default_map <= 0) {
            default_map = extract_long_value_any(map_payloads.front(), {"mapId", "map_id", "id"}, 0);
        }

        for (std::size_t map_index = 0; map_index < map_payloads.size(); ++map_index) {
            const auto& map_payload = map_payloads[map_index];
            const long map_id = extract_long_value_any(map_payload, {"mapId", "map_id", "id"}, 0);
            if (map_id <= 0) {
                continue;
            }

            MapDescriptor descriptor;
            descriptor.floor_id = floor_id;
            descriptor.floor_name = floor_name;
            descriptor.map_id = map_id;
            descriptor.map_name = extract_string_value_any(map_payload, {"mapName", "map_name", "name"});
            descriptor.default_floor_id = default_floor;
            descriptor.default_map_id = default_map;
            descriptor.charge_id = extract_long_value_any(map_payload, {"chargeId", "charge_id"}, 0);
            descriptor.initial_id = extract_long_value_any(map_payload, {"initialId", "initial_id"}, 0);
            descriptor.is_default_floor = default_floor > 0 ? floor_id == default_floor : floor_index == 0;
            descriptor.is_default_map = default_map > 0 ? map_id == default_map : map_index == 0;
            maps.push_back(descriptor);
        }

        if (map_payloads.empty() && default_map > 0) {
            MapDescriptor descriptor;
            descriptor.floor_id = floor_id;
            descriptor.floor_name = floor_name;
            descriptor.map_id = default_map;
            descriptor.default_floor_id = default_floor;
            descriptor.default_map_id = default_map;
            descriptor.is_default_floor = default_floor > 0 ? floor_id == default_floor : floor_index == 0;
            descriptor.is_default_map = true;
            maps.push_back(descriptor);
        }
    }

    return maps;
}

bool parse_default_map_context(const std::string& payload, long* floor_id, long* map_id) {
    if (floor_id == nullptr || map_id == nullptr) {
        return false;
    }

    const auto maps = parse_map_descriptors(payload);
    if (maps.empty()) {
        return false;
    }

    for (const auto& map : maps) {
        if (map.is_default_floor && map.is_default_map) {
            *floor_id = map.floor_id;
            *map_id = map.map_id;
            return true;
        }
    }

    for (const auto& map : maps) {
        if (map.is_default_floor) {
            *floor_id = map.floor_id;
            *map_id = map.map_id;
            return true;
        }
    }

    *floor_id = maps.front().floor_id;
    *map_id = maps.front().map_id;
    return true;
}

bool parse_current_map_metadata(const std::string& payload, long* floor_id, long* map_id,
                                long* charge_id, long* initial_id) {
    if (floor_id == nullptr || map_id == nullptr || charge_id == nullptr || initial_id == nullptr) {
        return false;
    }

    *charge_id = 0;
    *initial_id = 0;

    const auto maps = parse_map_descriptors(payload);
    if (maps.empty()) {
        return false;
    }

    for (const auto& map : maps) {
        if (map.is_default_floor && map.is_default_map) {
            *floor_id = map.floor_id;
            *map_id = map.map_id;
            *charge_id = map.charge_id;
            *initial_id = map.initial_id;
            return true;
        }
    }

    for (const auto& map : maps) {
        if (map.is_default_floor) {
            *floor_id = map.floor_id;
            *map_id = map.map_id;
            *charge_id = map.charge_id;
            *initial_id = map.initial_id;
            return true;
        }
    }

    *floor_id = maps.front().floor_id;
    *map_id = maps.front().map_id;
    *charge_id = maps.front().charge_id;
    *initial_id = maps.front().initial_id;
    return true;
}

PointRecord build_native_point_record(const std::string& payload, long floor_id, long map_id,
                                      long charge_id, long initial_id) {
    PointRecord point;
    point.name = extract_string_value_any(payload, {"point_name", "pointName", "name"});
    point.type = "feed";
    point.x = extract_double_value_any(payload, {"x", "position_x"}, 0.0);
    point.y = extract_double_value_any(payload, {"y", "position_y"}, 0.0);
    point.theta = extract_double_value_any(payload, {"z", "theta", "yaw"}, 0.0);
    point.floor_id = floor_id;
    point.map_id = map_id;
    point.point_id = extract_long_value_any(payload, {"point_id", "pointId", "id"}, 0);

    if (point.point_id == charge_id) {
        point.type = "charge";
    } else if (point.point_id == initial_id) {
        point.type = "initial";
    } else {
        if (point.name.find("充电") != std::string::npos || point.name.find("charge") != std::string::npos ||
            point.name.find("Charge") != std::string::npos) {
            point.type = "charge";
        } else if (point.name.find("初始") != std::string::npos || point.name.find("initial") != std::string::npos ||
                   point.name.find("Initial") != std::string::npos) {
            point.type = "initial";
        }
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
    if (!is_connected() || map_name.empty()) {
        return false;
    }

    long floor_id = 0;
    std::string floor_name = "F1";
    std::string maps_response;
    if (call_service("get_maps", kGetMapsServiceType, "{}", &maps_response)) {
        const auto maps = parse_map_descriptors(maps_response);
        for (const auto& map : maps) {
            if (map.is_default_floor && map.is_default_map) {
                floor_id = map.floor_id;
                if (!map.floor_name.empty()) {
                    floor_name = map.floor_name;
                }
                break;
            }
        }
    }

    const int save_type = floor_id > 0 ? 0 : 2;
    std::ostringstream request;
    request << "{\"type\":" << save_type
            << ",\"floor_id\":" << floor_id
            << ",\"floor_name\":\"" << json_escape(floor_name)
            << "\",\"map_name\":\"" << json_escape(map_name) << "\"}";

    std::string response;
    return call_service("save_map", kSaveMapServiceType, request.str(), &response);
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
    payload << "{\"header\":{\"frame_id\":\"map\"},\"pose\":{\"pose\":{\"position\":{\"x\":"
            << pose.x << ",\"y\":" << pose.y << ",\"z\":0},\"orientation\":{\"x\":0,\"y\":0,\"z\":"
            << theta_to_quaternion_z(pose.theta) << ",\"w\":" << theta_to_quaternion_w(pose.theta)
            << "}},\"covariance\":[";
    for (int index = 0; index < 36; ++index) {
        if (index > 0) {
            payload << ",";
        }
        payload << (index == 0 ? 1 : 0);
    }
    payload << "]}}";
    return publish_topic("/initialpose", "geometry_msgs/PoseWithCovarianceStamped", payload.str());
}

bool RosbridgeAdapter::set_relocation(const Pose& pose) {
    if (!is_connected()) {
        return false;
    }

    std::ostringstream request;
    request << "{\"point\":{\"header\":{\"frame_id\":\"map\"},\"pose\":{\"pose\":{\"position\":{\"x\":"
            << pose.x << ",\"y\":" << pose.y << ",\"z\":0},\"orientation\":{\"x\":0,\"y\":0,\"z\":"
            << theta_to_quaternion_z(pose.theta) << ",\"w\":" << theta_to_quaternion_w(pose.theta)
            << "}},\"covariance\":[";
    for (int index = 0; index < 36; ++index) {
        if (index > 0) {
            request << ",";
        }
        request << (index == 0 ? 1 : 0);
    }
    request << "]}}}";

    std::string response;
    bool ok = call_service("/set_relocation", "map_msgs/SetRelocation", request.str(), &response);
    if (!ok) {
        ok = call_service("set_relocation", "map_msgs/SetRelocation", request.str(), &response);
    }
    if (!ok) {
        return false;
    }

    return extract_long_value(response, "result", 1) > 0;
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

bool RosbridgeAdapter::go_charge() {
    if (!is_connected()) {
        return false;
    }
    return publish_topic("autocharge", "std_msgs/Int16", "{\"data\":1}");
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

    const Pose creation_pose = get_robot_pose();
    long point_id = 0;

    std::ostringstream request;
    request << "{\"point_name\":\"" << json_escape(name)
            << "\",\"point_mode\":" << point_mode << "}";

    std::string point_response;
    if (call_service("point_set", kPointSetServiceType, request.str(), &point_response)) {
        point_id = extract_long_value(point_response, "result", 0);
    }

    if (point_id <= 0) {
        std::ostringstream manual_request;
        manual_request << "{\"point_name\":\"" << json_escape(name)
                       << "\",\"point_mode\":" << point_mode
                       << ",\"point\":{\"header\":{\"frame_id\":\"map\"},\"pose\":{\"pose\":{\"position\":{\"x\":"
                       << creation_pose.x << ",\"y\":" << creation_pose.y
                       << ",\"z\":0},\"orientation\":{\"x\":0,\"y\":0,\"z\":"
                       << theta_to_quaternion_z(creation_pose.theta)
                       << ",\"w\":" << theta_to_quaternion_w(creation_pose.theta)
                       << "}},\"covariance\":[";
        for (int index = 0; index < 36; ++index) {
            if (index > 0) {
                manual_request << ",";
            }
            manual_request << (index == 0 ? 1 : 0);
        }
        manual_request << "]}}}";

        point_response.clear();
        if (!call_service("pointmanu_set", kPointManuSetServiceType, manual_request.str(), &point_response)) {
            return false;
        }

        point_id = extract_long_value(point_response, "result", 0);
        if (point_id <= 0) {
            return false;
        }
    }

    std::string maps_response;
    long floor_id = 0;
    long map_id = 0;
    if (!call_service("get_maps", kGetMapsServiceType, "{}", &maps_response) ||
        !parse_default_map_context(maps_response, &floor_id, &map_id)) {
        return false;
    }

    point->name = name;
    point->x = creation_pose.x;
    point->y = creation_pose.y;
    point->theta = creation_pose.theta;
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
    if (!call_service(kListNaviPointsService, kListNaviPointsServiceType, "{}", &points_response)) {
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

bool RosbridgeAdapter::list_maps(std::vector<MapDescriptor>* maps) {
    if (!is_connected() || maps == nullptr) {
        return false;
    }

    std::string maps_response;
    if (!call_service("get_maps", kGetMapsServiceType, "{}", &maps_response)) {
        return false;
    }

    *maps = parse_map_descriptors(maps_response);
    return true;
}

bool RosbridgeAdapter::delete_map(long floor_id, long map_id) {
    if (!is_connected() || floor_id <= 0 || map_id <= 0) {
        return false;
    }

    std::ostringstream request;
    request << "{\"floor_id\":" << floor_id
            << ",\"map_id\":" << map_id << "}";

    std::string response;
    if (call_service("delete_floor", kDeleteMapServiceType, request.str(), &response)) {
        return true;
    }
    return call_service("delete_map", kDeleteMapServiceType, request.str(), &response);
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
    return call_service("delete_test_point", kDeleteTestPointServiceType, request.str(), &response);
}

Pose RosbridgeAdapter::get_robot_pose() const { return pose_; }

int RosbridgeAdapter::get_battery() const { return battery_; }

RobotStatus RosbridgeAdapter::get_robot_status() const {
    RobotStatus status;
    status.battery_percent = battery_;
    status.charging = charging_;
    status.connected = is_connected();
    status.localized = localized_;
    status.location_status_code = location_status_code_;
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
    const int location_status = extract_int_value(payload, "data");
    location_status_code_ = location_status;
    if (location_status == 10) {
        localized_ = true;
    } else if (location_status == 9) {
        localized_ = false;
    }
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
