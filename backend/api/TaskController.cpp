#include "backend/api/TaskController.h"

#include <stdexcept>

void register_task_routes(AppServer& server, TaskService& task_service) {
    server.register_post("/api/tasks/start", [&task_service](const std::string&) {
        try {
            const auto result = task_service.start_manual_run();
            const auto body = std::string("{\"status\":\"") + result.status +
                "\",\"current_target_name\":\"" + result.current_target_name + "\"}";
            return HttpResponse{200, body, "application/json"};
        } catch (const std::runtime_error& error) {
            const auto body = std::string("{\"error\":\"") + error.what() + "\"}";
            return HttpResponse{500, body, "application/json"};
        }
    });
}
