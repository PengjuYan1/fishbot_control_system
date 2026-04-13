#include "backend/api/MapController.h"

void register_map_routes(AppServer& server, const MapService& map_service) {
    server.register_post("/api/map/start-mapping", [&map_service](const std::string&) {
        return HttpResponse{map_service.start_mapping() ? 200 : 500, "{\"status\":\"started\"}", "application/json"};
    });

    server.register_post("/api/map/stop-mapping", [&map_service](const std::string&) {
        return HttpResponse{map_service.stop_mapping() ? 200 : 500, "{\"status\":\"stopped\"}", "application/json"};
    });

    server.register_post("/api/map/save", [&map_service](const std::string& body) {
        return HttpResponse{map_service.save_map(body) ? 200 : 500, "{\"status\":\"saved\"}", "application/json"};
    });
}
