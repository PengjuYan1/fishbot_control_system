#include "backend/api/MapController.h"

#include <string>

namespace {
std::string workflow_json(const MapWorkflowStatus& workflow) {
    return std::string("{\"mapping_active\":") + (workflow.mapping_active ? "true" : "false") +
        ",\"has_charge_point\":" + (workflow.has_charge_point ? "true" : "false") +
        ",\"has_initial_point\":" + (workflow.has_initial_point ? "true" : "false") +
        ",\"can_save_map\":" + (workflow.can_save_map ? "true" : "false") +
        ",\"next_step\":\"" + workflow.next_step + "\"}";
}
}  // namespace

void register_map_routes(AppServer& server, MapService& map_service) {
    server.register_get("/api/map/snapshot", [&map_service]() {
        return HttpResponse{200, to_json(map_service.get_snapshot()), "application/json"};
    });

    server.register_get("/api/map/workflow", [&map_service]() {
        return HttpResponse{200, workflow_json(map_service.get_workflow_status()), "application/json"};
    });

    server.register_post("/api/map/start-mapping", [&map_service](const std::string&) {
        if (!map_service.start_mapping()) {
            return HttpResponse{500, "{\"error\":\"start_mapping_failed\"}", "application/json"};
        }
        return HttpResponse{200, std::string("{\"status\":\"started\",\"workflow\":") +
            workflow_json(map_service.get_workflow_status()) + "}", "application/json"};
    });

    server.register_post("/api/map/stop-mapping", [&map_service](const std::string&) {
        if (!map_service.stop_mapping()) {
            return HttpResponse{500, "{\"error\":\"stop_mapping_failed\"}", "application/json"};
        }
        return HttpResponse{200, std::string("{\"status\":\"stopped\",\"workflow\":") +
            workflow_json(map_service.get_workflow_status()) + "}", "application/json"};
    });

    server.register_post("/api/map/save", [&map_service](const std::string& body) {
        try {
            if (!map_service.save_map(body)) {
                return HttpResponse{500, "{\"error\":\"save_map_failed\"}", "application/json"};
            }
            return HttpResponse{200, std::string("{\"status\":\"saved\",\"workflow\":") +
                workflow_json(map_service.get_workflow_status()) + "}", "application/json"};
        } catch (const std::exception& error) {
            return HttpResponse{409, std::string("{\"error\":\"") + error.what() +
                "\",\"workflow\":" + workflow_json(map_service.get_workflow_status()) + "}", "application/json"};
        }
    });
}
