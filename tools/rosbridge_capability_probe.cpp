#include <chrono>
#include <atomic>
#include <cctype>
#include <cstdlib>
#include <iostream>
#include <memory>
#include <mutex>
#include <set>
#include <unordered_map>
#include <string>
#include <thread>
#include <vector>

#include "ros_adapter/bridge_client/RosbridgeAdapter.h"
#include "ros_adapter/bridge_client/RosbridgeWebsocketTransport.h"

namespace {
struct RequiredInterface {
    std::string name;
    std::vector<std::string> aliases;
};

struct CheckResult {
    std::string name;
    bool available = false;
    std::string matched;
};

struct PerceptionRequirement {
    std::string name;
    std::vector<std::string> aliases;
    std::vector<std::string> accepted_types;
};

struct PerceptionCheck {
    std::string name;
    bool topic_present = false;
    bool type_matches = false;
    bool message_seen = false;
    std::string matched_topic;
    std::string topic_type;
    int message_count = 0;
};

void print_usage() {
    std::cerr << "usage: fishbot_rosbridge_capability_probe <host> <port> [wait_ms]\n";
}

std::string bool_json(bool value) {
    return value ? "true" : "false";
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

std::vector<std::string> extract_string_array(const std::string& payload, const std::string& key) {
    const auto start = find_value_start(payload, key);
    if (start == std::string::npos || start >= payload.size() || payload[start] != '[') {
        return {};
    }

    std::vector<std::string> values;
    std::size_t pos = start + 1;
    while (pos < payload.size()) {
        while (pos < payload.size() &&
               (std::isspace(static_cast<unsigned char>(payload[pos])) != 0 || payload[pos] == ',')) {
            ++pos;
        }
        if (pos >= payload.size() || payload[pos] == ']') {
            break;
        }
        if (payload[pos] != '"') {
            while (pos < payload.size() && payload[pos] != ',' && payload[pos] != ']') {
                ++pos;
            }
            continue;
        }

        ++pos;
        std::string value;
        bool escaped = false;
        while (pos < payload.size()) {
            const char ch = payload[pos++];
            if (escaped) {
                value += ch;
                escaped = false;
                continue;
            }
            if (ch == '\\') {
                escaped = true;
                continue;
            }
            if (ch == '"') {
                break;
            }
            value += ch;
        }
        values.push_back(value);
    }
    return values;
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
            value += ch;
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

bool call_service_with_aliases(RosbridgeWebsocketTransport& transport,
                               const std::vector<std::string>& aliases,
                               const std::string& type,
                               const std::string& request,
                               std::string* response,
                               std::string* matched_alias) {
    std::string service_response;
    for (const auto& alias : aliases) {
        if (!transport.call_service(alias, type, request, &service_response)) {
            continue;
        }
        if (response != nullptr) {
            *response = service_response;
        }
        if (matched_alias != nullptr) {
            *matched_alias = alias;
        }
        return true;
    }
    return false;
}

bool contains_any_alias(const std::set<std::string>& available, const std::vector<std::string>& aliases,
                        std::string* matched_alias) {
    for (const auto& alias : aliases) {
        if (available.find(alias) != available.end()) {
            if (matched_alias != nullptr) {
                *matched_alias = alias;
            }
            return true;
        }

        if (!alias.empty() && alias.front() == '/') {
            const auto stripped = alias.substr(1);
            if (available.find(stripped) != available.end()) {
                if (matched_alias != nullptr) {
                    *matched_alias = stripped;
                }
                return true;
            }
        } else {
            const auto with_slash = std::string("/") + alias;
            if (available.find(with_slash) != available.end()) {
                if (matched_alias != nullptr) {
                    *matched_alias = with_slash;
                }
                return true;
            }
        }
    }
    return false;
}

std::vector<CheckResult> evaluate_interfaces(const std::set<std::string>& available,
                                             const std::vector<RequiredInterface>& required) {
    std::vector<CheckResult> checks;
    checks.reserve(required.size());
    for (const auto& item : required) {
        CheckResult check;
        check.name = item.name;
        check.available = contains_any_alias(available, item.aliases, &check.matched);
        checks.push_back(check);
    }
    return checks;
}

int count_available(const std::vector<CheckResult>& checks) {
    int count = 0;
    for (const auto& check : checks) {
        if (check.available) {
            ++count;
        }
    }
    return count;
}

void print_check_array(const std::vector<CheckResult>& checks) {
    for (std::size_t i = 0; i < checks.size(); ++i) {
        const auto& check = checks[i];
        if (i > 0) {
            std::cout << ",";
        }
        std::cout << "{"
                  << "\"name\":\"" << json_escape(check.name) << "\","
                  << "\"available\":" << bool_json(check.available) << ","
                  << "\"matched\":\"" << json_escape(check.matched) << "\""
                  << "}";
    }
}

std::string resolve_topic_alias(const std::set<std::string>& topics, const std::vector<std::string>& aliases) {
    std::string matched;
    if (contains_any_alias(topics, aliases, &matched)) {
        return matched;
    }
    return "";
}

bool contains_string(const std::vector<std::string>& values, const std::string& target) {
    for (const auto& value : values) {
        if (value == target) {
            return true;
        }
    }
    return false;
}

std::string lookup_topic_type(RosbridgeWebsocketTransport& transport, const std::string& topic) {
    if (topic.empty()) {
        return "";
    }

    std::string response;
    std::string matched_alias;
    const bool ok = call_service_with_aliases(
        transport,
        {"/rosapi/topic_type", "rosapi/topic_type"},
        "rosapi/Topic",
        std::string("{\"topic\":\"") + json_escape(topic) + "\"}",
        &response,
        &matched_alias);
    if (!ok) {
        return "";
    }
    return extract_string_value(response, "type");
}

void print_perception_array(const std::vector<PerceptionCheck>& checks) {
    for (std::size_t i = 0; i < checks.size(); ++i) {
        const auto& check = checks[i];
        if (i > 0) {
            std::cout << ",";
        }
        std::cout << "{"
                  << "\"name\":\"" << json_escape(check.name) << "\","
                  << "\"topic_present\":" << bool_json(check.topic_present) << ","
                  << "\"type_matches\":" << bool_json(check.type_matches) << ","
                  << "\"message_seen\":" << bool_json(check.message_seen) << ","
                  << "\"matched_topic\":\"" << json_escape(check.matched_topic) << "\","
                  << "\"topic_type\":\"" << json_escape(check.topic_type) << "\","
                  << "\"message_count\":" << check.message_count
                  << "}";
    }
}
}  // namespace

int main(int argc, char** argv) {
    if (argc < 3 || argc > 4) {
        print_usage();
        return EXIT_FAILURE;
    }

    const std::string host = argv[1];
    const int port = std::atoi(argv[2]);
    const int wait_ms = argc >= 4 ? std::atoi(argv[3]) : 1500;
    if (host.empty() || port <= 0 || wait_ms < 0) {
        print_usage();
        return EXIT_FAILURE;
    }

    RosbridgeWebsocketTransport transport(host, port);
    if (!transport.connect()) {
        std::cerr << "failed to connect rosbridge at " << host << ":" << port << "\n";
        return EXIT_FAILURE;
    }

    std::set<std::string> services;
    std::set<std::string> topics;

    std::string services_response;
    std::string topics_response;
    std::string services_endpoint;
    std::string topics_endpoint;
    const bool services_query_ok = call_service_with_aliases(
        transport,
        {"/rosapi/services", "rosapi/services"},
        "rosapi/Services",
        "{}",
        &services_response,
        &services_endpoint);
    const bool topics_query_ok = call_service_with_aliases(
        transport,
        {"/rosapi/topics", "rosapi/topics"},
        "rosapi/Topics",
        "{}",
        &topics_response,
        &topics_endpoint);

    if (services_query_ok) {
        for (const auto& name : extract_string_array(services_response, "services")) {
            services.insert(name);
        }
    }
    if (topics_query_ok) {
        for (const auto& name : extract_string_array(topics_response, "topics")) {
            topics.insert(name);
        }
    }

    const std::vector<PerceptionRequirement> perception_requirements = {
        {"laser_scan", {"/scan", "scan", "/laser_scan", "laser_scan"}, {"sensor_msgs/LaserScan"}},
        {"point_cloud", {"/points", "points", "/point_cloud", "point_cloud", "/cloud", "cloud",
                         "/velodyne_points", "velodyne_points", "/camera/depth/points",
                         "camera/depth/points"},
         {"sensor_msgs/PointCloud2"}},
        {"depth_image", {"/camera/depth/image_raw", "camera/depth/image_raw",
                         "/camera/aligned_depth_to_color/image_raw",
                         "camera/aligned_depth_to_color/image_raw",
                         "/depth/image_raw", "depth/image_raw"},
         {"sensor_msgs/Image"}},
        {"depth_camera_info", {"/camera/depth/camera_info", "camera/depth/camera_info",
                               "/camera/aligned_depth_to_color/camera_info",
                               "camera/aligned_depth_to_color/camera_info",
                               "/depth/camera_info", "depth/camera_info"},
         {"sensor_msgs/CameraInfo"}},
    };

    const std::vector<RequiredInterface> required_services = {
        {"set_mode", {"/set_mode", "set_mode"}},
        {"set_relocation", {"set_relocation", "/set_relocation"}},
        {"get_maps", {"get_maps", "/get_maps"}},
        {"publish_map", {"/publish_map", "publish_map"}},
        {"navi_targegoalplan", {"navi_targegoalplan", "/navi_targegoalplan"}},
        {"point_set", {"point_set", "/point_set"}},
        {"pointmanu_set", {"pointmanu_set", "/pointmanu_set"}},
        {"list_navi_points", {"list_navi_points", "/list_navi_points"}},
    };

    const std::vector<RequiredInterface> required_topics = {
        {"cmd_vel", {"/cmd_vel", "cmd_vel"}},
        {"navi_stop", {"/navi_stop", "navi_stop"}},
        {"autocharge", {"autocharge", "/autocharge"}},
        {"outofcharge", {"outofcharge", "/outofcharge"}},
        {"initialpose", {"/initialpose", "initialpose"}},
        {"androidmsg_locationstatus", {"androidmsg_locationstatus", "/androidmsg_locationstatus"}},
        {"androidmsg_navigationstatus", {"androidmsg_navigationstatus", "/androidmsg_navigationstatus"}},
        {"androidmsg_chargestatus", {"androidmsg_chargestatus", "/androidmsg_chargestatus"}},
        {"tracked_pose", {"tracked_pose", "/tracked_pose"}},
        {"map", {"/map", "map"}},
    };

    const auto service_checks = evaluate_interfaces(services, required_services);
    const auto topic_checks = evaluate_interfaces(topics, required_topics);

    std::vector<PerceptionCheck> perception_checks;
    perception_checks.reserve(perception_requirements.size());

    std::unordered_map<std::string, std::shared_ptr<std::atomic<int>>> topic_message_counters;
    for (const auto& requirement : perception_requirements) {
        PerceptionCheck check;
        check.name = requirement.name;
        check.matched_topic = resolve_topic_alias(topics, requirement.aliases);
        check.topic_present = !check.matched_topic.empty();
        if (check.topic_present) {
            check.topic_type = lookup_topic_type(transport, check.matched_topic);
            check.type_matches = contains_string(requirement.accepted_types, check.topic_type);
            if (check.type_matches) {
                auto counter = std::make_shared<std::atomic<int>>(0);
                if (transport.subscribe(check.matched_topic, check.topic_type,
                                        [counter](const std::string&) { ++(*counter); })) {
                    topic_message_counters[check.name] = counter;
                }
            }
        }
        perception_checks.push_back(check);
    }

    RosbridgeAdapter adapter(&transport);
    const bool adapter_connected = adapter.connect();
    std::this_thread::sleep_for(std::chrono::milliseconds(wait_ms));

    const auto status = adapter.get_robot_status();
    const auto pose = adapter.get_robot_pose();
    const auto map = adapter.get_map_snapshot();

    for (auto& check : perception_checks) {
        const auto counter_it = topic_message_counters.find(check.name);
        if (counter_it == topic_message_counters.end()) {
            continue;
        }
        check.message_count = counter_it->second->load();
        check.message_seen = check.message_count > 0;
    }

    std::cout << "{"
              << "\"host\":\"" << json_escape(host) << "\","
              << "\"port\":" << port << ","
              << "\"rosapi\":{"
              << "\"services_query_ok\":" << bool_json(services_query_ok) << ","
              << "\"services_endpoint\":\"" << json_escape(services_endpoint) << "\","
              << "\"topics_query_ok\":" << bool_json(topics_query_ok) << ","
              << "\"topics_endpoint\":\"" << json_escape(topics_endpoint) << "\""
              << "},"
              << "\"service_checks\":[";
    print_check_array(service_checks);
    std::cout << "],"
              << "\"topic_checks\":[";
    print_check_array(topic_checks);
    std::cout << "],"
              << "\"perception_checks\":[";
    print_perception_array(perception_checks);
    std::cout << "],"
              << "\"summary\":{"
              << "\"required_services_available\":" << count_available(service_checks) << ","
              << "\"required_services_total\":" << static_cast<int>(service_checks.size()) << ","
              << "\"required_topics_available\":" << count_available(topic_checks) << ","
              << "\"required_topics_total\":" << static_cast<int>(topic_checks.size()) << ","
              << "\"perception_topics_present\":" << count_available(std::vector<CheckResult>{
                    CheckResult{"laser_scan", perception_checks[0].topic_present, perception_checks[0].matched_topic},
                    CheckResult{"point_cloud", perception_checks[1].topic_present, perception_checks[1].matched_topic},
                    CheckResult{"depth_image", perception_checks[2].topic_present, perception_checks[2].matched_topic},
                    CheckResult{"depth_camera_info", perception_checks[3].topic_present, perception_checks[3].matched_topic}
                 }) << ","
              << "\"perception_types_matched\":"
              << (static_cast<int>(perception_checks[0].type_matches) +
                  static_cast<int>(perception_checks[1].type_matches) +
                  static_cast<int>(perception_checks[2].type_matches) +
                  static_cast<int>(perception_checks[3].type_matches)) << ","
              << "\"perception_streams_live\":"
              << (static_cast<int>(perception_checks[0].message_seen) +
                  static_cast<int>(perception_checks[1].message_seen) +
                  static_cast<int>(perception_checks[2].message_seen) +
                  static_cast<int>(perception_checks[3].message_seen))
              << "},"
              << "\"live_snapshot\":{"
              << "\"connected\":" << bool_json(adapter_connected && adapter.is_connected()) << ","
              << "\"battery\":" << adapter.get_battery() << ","
              << "\"localized\":" << bool_json(status.localized) << ","
              << "\"location_status_code\":" << status.location_status_code << ","
              << "\"charging\":" << bool_json(status.charging) << ","
              << "\"charge_status_code\":" << status.charge_status_code << ","
              << "\"navigation_status_code\":" << status.navigation_status_code << ","
              << "\"motion_mode_code\":" << status.motion_mode_code << ","
              << "\"pose\":{"
              << "\"x\":" << pose.x << ","
              << "\"y\":" << pose.y << ","
              << "\"theta\":" << pose.theta
              << "},"
              << "\"map\":{"
              << "\"width\":" << map.width << ","
              << "\"height\":" << map.height << ","
              << "\"resolution\":" << map.resolution << ","
              << "\"origin_x\":" << map.origin_x << ","
              << "\"origin_y\":" << map.origin_y
              << "}"
              << "}"
              << "}\n";

    adapter.disconnect();
    return EXIT_SUCCESS;
}
