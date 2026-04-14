#include "backend/services/PointService.h"

#include <cctype>
#include <sstream>
#include <stdexcept>
#include <unordered_map>
#include <vector>

#include "ros_adapter/IRobotAdapter.h"

namespace {
std::unordered_map<std::string, std::string> parse_form_encoded(const std::string& body) {
    std::unordered_map<std::string, std::string> values;
    std::stringstream stream(body);
    std::string pair;
    while (std::getline(stream, pair, '&')) {
        const auto separator = pair.find('=');
        if (separator == std::string::npos) {
            continue;
        }
        values[pair.substr(0, separator)] = pair.substr(separator + 1);
    }
    return values;
}

long optional_long_value(const std::unordered_map<std::string, std::string>& values,
                         const std::vector<std::string>& keys) {
    for (const auto& key : keys) {
        const auto it = values.find(key);
        if (it != values.end() && !it->second.empty()) {
            return std::stol(it->second);
        }
    }
    return 0;
}

std::string canonical_type_for(const std::string& point_kind, const std::string& biz_role) {
    if (point_kind == "charge") {
        return "charge";
    }
    if (point_kind == "initial") {
        return "initial";
    }
    if (biz_role == "feed") {
        return "feed";
    }
    return "navigation";
}
}  // namespace

PointService::PointService(PointRepository& repository) : repository_(repository) {}

PointService::PointService(PointRepository& repository, IRobotAdapter& adapter)
    : repository_(repository), adapter_(&adapter) {}

int PointService::create_charge_point(const std::string& body) {
    return repository_.insert_point(parse_point(body, "charge", ""));
}

int PointService::create_feed_point(const std::string& body) {
    return repository_.insert_point(parse_point(body, "navigation", "feed"));
}

PointRecord PointService::create_current_initial_point() {
    return create_current_point("initial", "", "I", 2);
}

PointRecord PointService::create_current_charge_point() {
    return create_current_point("charge", "", "C", 1);
}

PointRecord PointService::create_current_feed_point() {
    return create_current_point("navigation", "feed", "F", 0);
}

PointRecord PointService::delete_point(int id) {
    const auto point = repository_.find_point(id);
    if (!point.has_value()) {
        throw std::runtime_error("point_not_found");
    }

    const bool has_native_identity = point->floor_id > 0 && point->map_id > 0 && point->point_id > 0;
    if (has_native_identity) {
        if (adapter_ == nullptr) {
            throw std::runtime_error("robot_adapter_unavailable");
        }
        if (!adapter_->delete_saved_point(*point)) {
            throw std::runtime_error("delete_saved_point_failed");
        }
    }

    if (!repository_.delete_point(id)) {
        throw std::runtime_error("point_not_found");
    }
    return *point;
}

std::vector<PointRecord> PointService::list_points() const {
    return repository_.list_points();
}

std::string PointService::next_point_name(const std::string& prefix, const std::string& point_kind,
                                         const std::string& biz_role) const {
    const auto points = repository_.list_points();
    int max_index = 0;
    for (const auto& point : points) {
        if (point.point_kind != point_kind || point.biz_role != biz_role ||
            point.name.size() <= prefix.size() || point.name.rfind(prefix, 0) != 0) {
            continue;
        }

        bool numeric_suffix = true;
        for (std::size_t index = prefix.size(); index < point.name.size(); ++index) {
            if (std::isdigit(static_cast<unsigned char>(point.name[index])) == 0) {
                numeric_suffix = false;
                break;
            }
        }
        if (!numeric_suffix) {
            continue;
        }

        try {
            max_index = std::max(max_index, std::stoi(point.name.substr(prefix.size())));
        } catch (const std::exception&) {
        }
    }

    return prefix + std::to_string(max_index + 1);
}

PointRecord PointService::parse_point(const std::string& body, const std::string& point_kind,
                                      const std::string& biz_role) const {
    const auto values = parse_form_encoded(body);
    PointRecord point;
    point.name = values.at("name");
    point.point_kind = point_kind;
    point.biz_role = biz_role;
    point.type = canonical_type_for(point_kind, biz_role);
    point.x = std::stod(values.at("x"));
    point.y = std::stod(values.at("y"));
    point.theta = std::stod(values.at("theta"));
    point.floor_id = optional_long_value(values, {"floor_id", "floorId"});
    point.map_id = optional_long_value(values, {"map_id", "mapId"});
    point.point_id = optional_long_value(values, {"point_id", "pointId"});
    return point;
}

PointRecord PointService::create_current_point(const std::string& point_kind, const std::string& biz_role,
                                               const std::string& prefix, long point_mode) {
    if (adapter_ == nullptr) {
        throw std::runtime_error("robot_adapter_unavailable");
    }

    PointRecord point;
    point.name = next_point_name(prefix, point_kind, biz_role);
    point.point_kind = point_kind;
    point.biz_role = biz_role;
    point.type = canonical_type_for(point_kind, biz_role);
    if (!adapter_->create_current_pose_point(point.name, point_mode, &point)) {
        throw std::runtime_error("create_current_pose_point_failed");
    }

    point.name = point.name.empty() ? next_point_name(prefix, point_kind, biz_role) : point.name;
    point.point_kind = point_kind;
    point.biz_role = biz_role;
    point.type = canonical_type_for(point_kind, biz_role);
    point.id = repository_.insert_point(point);
    return point;
}
