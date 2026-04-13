#include "backend/api/HealthController.h"

void register_health_routes(AppServer& server, const AppConfig& config) {
    const auto adapter_mode = config.adapter_mode;
    server.register_get("/api/health", [adapter_mode]() {
        return HttpResponse{200,
                            std::string("{\"status\":\"ok\",\"adapter_mode\":\"") +
                                adapter_mode + "\"}",
                            "application/json"};
    });
}
