#include <cstdlib>
#include <iostream>

#include "backend/api/HealthController.h"
#include "backend/app/AppServer.h"
#include "backend/app/Config.h"

int main() {
    AppServer server;
    const auto config = load_config("config/app.example.yaml");
    register_health_routes(server, config);

    const auto response = server.handle_get("/api/health");
    if (response.status != 200) {
        std::cerr << "expected HTTP 200 from /api/health\n";
        return EXIT_FAILURE;
    }

    if (response.body.find("\"status\":\"ok\"") == std::string::npos) {
        std::cerr << "expected ok status in response body\n";
        return EXIT_FAILURE;
    }

    if (response.body.find("\"adapter_mode\":\"rosbridge\"") == std::string::npos) {
        std::cerr << "expected adapter_mode in response body\n";
        return EXIT_FAILURE;
    }

    return EXIT_SUCCESS;
}
