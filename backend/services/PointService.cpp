#include "backend/services/PointService.h"

#include <sstream>
#include <stdexcept>
#include <unordered_map>
#include <vector>

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
}  // namespace

PointService::PointService(PointRepository& repository) : repository_(repository) {}

int PointService::create_charge_point(const std::string& body) {
    return repository_.insert_point(parse_point(body, "charge"));
}

int PointService::create_feed_point(const std::string& body) {
    return repository_.insert_point(parse_point(body, "feed"));
}

std::vector<PointRecord> PointService::list_points() const {
    return repository_.list_points();
}

PointRecord PointService::parse_point(const std::string& body, const std::string& type) const {
    const auto values = parse_form_encoded(body);
    PointRecord point;
    point.name = values.at("name");
    point.type = type;
    point.x = std::stod(values.at("x"));
    point.y = std::stod(values.at("y"));
    point.theta = std::stod(values.at("theta"));
    point.floor_id = optional_long_value(values, {"floor_id", "floorId"});
    point.map_id = optional_long_value(values, {"map_id", "mapId"});
    point.point_id = optional_long_value(values, {"point_id", "pointId"});
    return point;
}
