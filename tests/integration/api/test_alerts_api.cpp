#include <cstdlib>
#include <iostream>
#include <string>

#include "backend/api/AlertController.h"
#include "backend/app/AppServer.h"
#include "backend/services/AlertService.h"
#include "storage/Database.h"
#include "storage/repositories/EventLogRepository.h"

int main() {
    auto db = open_test_database();
    run_migrations(db);

    EventLogRepository repository(db);
    repository.insert_log("warning", "battery_low", "Battery below return threshold");
    repository.insert_log("error", "adapter_disconnect", "rosbridge timeout");

    AlertService service(repository);
    AppServer server;
    register_alert_routes(server, service);

    const auto response = server.handle_get("/api/alerts");
    if (response.status != 200) {
        std::cerr << "expected successful alerts response\n";
        return EXIT_FAILURE;
    }

    if (response.body.find("\"category\":\"battery_low\"") == std::string::npos) {
        std::cerr << "expected battery_low alert in response\n";
        return EXIT_FAILURE;
    }

    if (response.body.find("\"category\":\"adapter_disconnect\"") == std::string::npos) {
        std::cerr << "expected adapter_disconnect alert in response\n";
        return EXIT_FAILURE;
    }

    return EXIT_SUCCESS;
}
