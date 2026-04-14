#include "backend/api/SystemController.h"

void register_system_routes(AppServer& server, const SystemService& system_service) {
    server.register_get("/api/system/status", [&system_service]() {
        return HttpResponse{200, to_json(system_service.get_snapshot()), "application/json"};
    });
    server.register_get("/api/system/status/trace", [&system_service]() {
        return HttpResponse{200, system_service.get_trace_json(), "application/json"};
    });
}
