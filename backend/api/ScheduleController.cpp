#include "backend/api/ScheduleController.h"

#include <string>

namespace {
std::string schedule_list_json(const std::vector<ScheduleRecord>& schedules) {
    std::string body = "[";
    for (std::size_t index = 0; index < schedules.size(); ++index) {
        const auto& schedule = schedules[index];
        body += std::string("{\"id\":") + std::to_string(schedule.id) +
            ",\"name\":\"" + schedule.name +
            "\",\"enabled\":" + (schedule.enabled ? "true" : "false") +
            ",\"cron\":\"" + schedule.cron_expr + "\"}";
        if (index + 1 < schedules.size()) {
            body += ",";
        }
    }
    body += "]";
    return body;
}
}  // namespace

void register_schedule_routes(AppServer& server, ScheduleService& schedule_service) {
    server.register_post("/api/schedules", [&schedule_service](const std::string& body) {
        const auto id = schedule_service.create_schedule(body);
        return HttpResponse{200, std::string("{\"id\":") + std::to_string(id) + "}", "application/json"};
    });

    server.register_get("/api/schedules", [&schedule_service]() {
        return HttpResponse{200, schedule_list_json(schedule_service.list_schedules()), "application/json"};
    });
}
