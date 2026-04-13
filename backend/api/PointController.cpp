#include "backend/api/PointController.h"

#include <string>

namespace {
std::string point_list_json(const std::vector<PointRecord>& points) {
    std::string body = "[";
    for (std::size_t index = 0; index < points.size(); ++index) {
        const auto& point = points[index];
        body += std::string("{\"id\":") + std::to_string(point.id) +
            ",\"name\":\"" + point.name +
            "\",\"type\":\"" + point.type +
            "\",\"x\":" + std::to_string(point.x) +
            ",\"y\":" + std::to_string(point.y) +
            ",\"theta\":" + std::to_string(point.theta) +
            ",\"floor_id\":" + std::to_string(point.floor_id) +
            ",\"map_id\":" + std::to_string(point.map_id) +
            ",\"point_id\":" + std::to_string(point.point_id) +
            "}";
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

    server.register_post("/api/points/feed", [&point_service](const std::string& body) {
        const auto id = point_service.create_feed_point(body);
        return HttpResponse{200, std::string("{\"id\":") + std::to_string(id) + ",\"type\":\"feed\"}", "application/json"};
    });

    server.register_get("/api/points", [&point_service]() {
        return HttpResponse{200, point_list_json(point_service.list_points()), "application/json"};
    });
}
