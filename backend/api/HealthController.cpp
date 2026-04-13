#include "backend/api/HealthController.h"

void register_health_routes(AppServer& server, const AppConfig& config) {
    server.register_get("/api/health", [config]() {
        return HttpResponse{200,
                            std::string("{\"status\":\"ok\",\"adapter_mode\":\"") +
                                config.adapter_mode + "\"}",
                            "application/json"};
    });
}
