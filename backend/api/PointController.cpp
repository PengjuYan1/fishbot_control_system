#include "backend/api/PointController.h"

#include <string>

namespace {
std::string form_value(const std::string& body, const std::string& key) {
    const auto token = key + "=";
    const auto start = body.find(token);
    if (start == std::string::npos) {
        return "";
    }

    const auto value_start = start + token.size();
    const auto value_end = body.find('&', value_start);
    return body.substr(value_start, value_end == std::string::npos ? std::string::npos : value_end - value_start);
}

std::string point_json(const PointRecord& point) {
    return std::string("{\"id\":") + std::to_string(point.id) +
        ",\"name\":\"" + point.name +
        "\",\"type\":\"" + point.type +
        "\",\"x\":" + std::to_string(point.x) +
        ",\"y\":" + std::to_string(point.y) +
        ",\"theta\":" + std::to_string(point.theta) +
        ",\"floor_id\":" + std::to_string(point.floor_id) +
        ",\"map_id\":" + std::to_string(point.map_id) +
        ",\"point_id\":" + std::to_string(point.point_id) +
        "}";
}

std::string point_list_json(const std::vector<PointRecord>& points) {
    std::string body = "[";
    for (std::size_t index = 0; index < points.size(); ++index) {
        body += point_json(points[index]);
        if (index + 1 < points.size()) {
            body += ",";
        }
    }
    body += "]";
    return body;
}
}  // namespace

void register_point_routes(AppServer& server, PointService& point_service) {
    server.register_post("/api/points/charge", [&point_service](const std::string& body) {
        const auto id = point_service.create_charge_point(body);
        return HttpResponse{200, std::string("{\"id\":") + std::to_string(id) + ",\"type\":\"charge\"}", "application/json"};
    });

    server.register_post("/api/points/nav", [&point_service](const std::string& body) {
        const auto id = point_service.create_nav_point(body);
        return HttpResponse{200, std::string("{\"id\":") + std::to_string(id) + ",\"type\":\"nav\"}", "application/json"};
    });

    server.register_post("/api/points/feed", [&point_service](const std::string& body) {
        const auto id = point_service.create_feed_point(body);
        return HttpResponse{200, std::string("{\"id\":") + std::to_string(id) + ",\"type\":\"feed\"}", "application/json"};
    });

    server.register_get("/api/points", [&point_service]() {
        return HttpResponse{200, point_list_json(point_service.list_points()), "application/json"};
    });

    server.register_post("/api/points/delete", [&point_service](const std::string& body) {
        try {
            const auto id = std::stoi(form_value(body, "id"));
            return HttpResponse{200, point_json(point_service.delete_point(id)), "application/json"};
        } catch (const std::exception& error) {
            return HttpResponse{500, std::string("{\"error\":\"") + error.what() + "\"}", "application/json"};
        }
    });

    server.register_post("/api/points/charge/current", [&point_service](const std::string&) {
        try {
            return HttpResponse{200, point_json(point_service.create_current_charge_point()), "application/json"};
        } catch (const std::exception& error) {
            return HttpResponse{500, std::string("{\"error\":\"") + error.what() + "\"}", "application/json"};
        }
    });

    server.register_post("/api/points/feed/current", [&point_service](const std::string&) {
        try {
            return HttpResponse{200, point_json(point_service.create_current_feed_point()), "application/json"};
        } catch (const std::exception& error) {
            return HttpResponse{500, std::string("{\"error\":\"") + error.what() + "\"}", "application/json"};
        }
    });

    server.register_post("/api/points/nav/current", [&point_service](const std::string&) {
        try {
            return HttpResponse{200, point_json(point_service.create_current_nav_point()), "application/json"};
        } catch (const std::exception& error) {
            return HttpResponse{500, std::string("{\"error\":\"") + error.what() + "\"}", "application/json"};
        }
    });
}
