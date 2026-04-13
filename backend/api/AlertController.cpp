#include "backend/api/AlertController.h"

#include <string>

namespace {
std::string alerts_to_json(const std::vector<EventLogRecord>& alerts) {
    std::string body = "[";
    for (std::size_t index = 0; index < alerts.size(); ++index) {
        const auto& alert = alerts[index];
        body += std::string("{\"id\":") + std::to_string(alert.id) +
            ",\"level\":\"" + alert.level +
            "\",\"category\":\"" + alert.category +
            "\",\"message\":\"" + alert.message + "\"}";
        if (index + 1 < alerts.size()) {
            body += ",";
        }
    }
    body += "]";
    return body;
}
}  // namespace

void register_alert_routes(AppServer& server, const AlertService& alert_service) {
    server.register_get("/api/alerts", [&alert_service]() {
        return HttpResponse{200, alerts_to_json(alert_service.list_alerts()), "application/json"};
    });
}
