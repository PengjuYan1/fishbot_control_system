#include "backend/api/MapController.h"

#include <stdexcept>
#include <string>
#include <unordered_map>

namespace {
std::unordered_map<std::string, std::string> parse_form_encoded(const std::string& body) {
    std::unordered_map<std::string, std::string> values;
    std::size_t start = 0;
    while (start < body.size()) {
        const auto equal = body.find('=', start);
        if (equal == std::string::npos) {
            break;
        }
        const auto end = body.find('&', equal + 1);
        values[body.substr(start, equal - start)] =
            body.substr(equal + 1, end == std::string::npos ? std::string::npos : end - equal - 1);
        if (end == std::string::npos) {
            break;
        }
        start = end + 1;
    }
    return values;
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

std::string map_list_json(const std::vector<MapDescriptor>& maps) {
    std::string body = "{\"maps\":[";
    for (std::size_t index = 0; index < maps.size(); ++index) {
        const auto& map = maps[index];
        body += std::string("{\"floor_id\":") + std::to_string(map.floor_id) +
            ",\"floor_name\":\"" + json_escape(map.floor_name) +
            "\",\"map_id\":" + std::to_string(map.map_id) +
            ",\"map_name\":\"" + json_escape(map.map_name) +
            "\",\"default_floor_id\":" + std::to_string(map.default_floor_id) +
            ",\"default_map_id\":" + std::to_string(map.default_map_id) +
            ",\"charge_id\":" + std::to_string(map.charge_id) +
            ",\"initial_id\":" + std::to_string(map.initial_id) +
            ",\"is_default_floor\":" + std::string(map.is_default_floor ? "true" : "false") +
            ",\"is_default_map\":" + std::string(map.is_default_map ? "true" : "false") +
            "}";
        if (index + 1 < maps.size()) {
            body += ",";
        }
    }
    body += "]}";
    return body;
}
}  // namespace

void register_map_routes(AppServer& server, MapService& map_service) {
    server.register_get("/api/map/snapshot", [&map_service]() {
        return HttpResponse{200, to_json(map_service.get_snapshot()), "application/json"};
    });

    server.register_post("/api/map/start-mapping", [&map_service](const std::string&) {
        return HttpResponse{map_service.start_mapping() ? 200 : 500, "{\"status\":\"started\"}", "application/json"};
    });

    server.register_post("/api/map/stop-mapping", [&map_service](const std::string&) {
        return HttpResponse{map_service.stop_mapping() ? 200 : 500, "{\"status\":\"stopped\"}", "application/json"};
    });

    server.register_post("/api/map/save", [&map_service](const std::string& body) {
        return HttpResponse{map_service.save_map(body) ? 200 : 500, "{\"status\":\"saved\"}", "application/json"};
    });

    server.register_post("/api/map/load", [&map_service](const std::string& body) {
        try {
            const auto values = parse_form_encoded(body);
            const auto floor_it = values.find("floor_id");
            const auto map_it = values.find("map_id");
            if (floor_it == values.end() || map_it == values.end()) {
                return HttpResponse{400, "{\"error\":\"missing_floor_or_map_id\"}", "application/json"};
            }

            const long floor_id = std::stol(floor_it->second);
            const long map_id = std::stol(map_it->second);
            if (!map_service.load_map(floor_id, map_id)) {
                return HttpResponse{500, "{\"error\":\"load_map_failed\"}", "application/json"};
            }
            return HttpResponse{
                200,
                std::string("{\"status\":\"loaded\",\"floor_id\":") + std::to_string(floor_id) +
                    ",\"map_id\":" + std::to_string(map_id) + "}",
                "application/json"
            };
        } catch (const std::exception& error) {
            return HttpResponse{500, std::string("{\"error\":\"") + error.what() + "\"}", "application/json"};
        }
    });

    server.register_get("/api/maps", [&map_service]() {
        return HttpResponse{200, map_list_json(map_service.list_maps()), "application/json"};
    });

    server.register_post("/api/maps/delete", [&map_service](const std::string& body) {
        try {
            const auto values = parse_form_encoded(body);
            const auto floor_it = values.find("floor_id");
            const auto map_it = values.find("map_id");
            if (floor_it == values.end() || map_it == values.end()) {
                return HttpResponse{400, "{\"error\":\"missing_floor_or_map_id\"}", "application/json"};
            }

            const long floor_id = std::stol(floor_it->second);
            const long map_id = std::stol(map_it->second);
            if (floor_id <= 0 || map_id <= 0) {
                return HttpResponse{400, "{\"error\":\"invalid_floor_or_map_id\"}", "application/json"};
            }

            if (!map_service.delete_map(floor_id, map_id)) {
                return HttpResponse{500, "{\"error\":\"delete_map_failed\"}", "application/json"};
            }

            const auto response = std::string("{\"status\":\"deleted\",\"floor_id\":") +
                std::to_string(floor_id) + ",\"map_id\":" + std::to_string(map_id) + "}";
            return HttpResponse{200, response, "application/json"};
        } catch (const std::exception& error) {
            return HttpResponse{500, std::string("{\"error\":\"") + error.what() + "\"}", "application/json"};
        }
    });
}
