#include "backend/api/TaskController.h"

#include <stdexcept>

namespace {
std::string form_value(const std::string& body, const std::string& key) {
    const auto token = key + "=";
    const auto start = body.find(token);
    if (start == std::string::npos) {
        return "";
    }

    const auto value_start = start + token.size();
    const auto value_end = body.find('&', value_start);
    return body.substr(value_start,
                       value_end == std::string::npos ? std::string::npos : value_end - value_start);
}
}  // namespace

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

    server.register_post("/api/tasks/go-charge", [&task_service](const std::string&) {
        try {
            const auto result = task_service.start_charge_return();
            const auto body = std::string("{\"status\":\"") + result.status +
                "\",\"current_target_name\":\"" + result.current_target_name + "\"}";
            return HttpResponse{200, body, "application/json"};
        } catch (const std::runtime_error& error) {
            const auto body = std::string("{\"error\":\"") + error.what() + "\"}";
            return HttpResponse{500, body, "application/json"};
        }
    });

    server.register_post("/api/tasks/navigate-point", [&task_service](const std::string& body) {
        try {
            const auto point_id = std::stoi(form_value(body, "id"));
            const auto result = task_service.start_navigation_to_point(point_id);
            const auto payload = std::string("{\"status\":\"") + result.status +
                "\",\"current_target_name\":\"" + result.current_target_name + "\"}";
            return HttpResponse{200, payload, "application/json"};
        } catch (const std::exception& error) {
            const auto payload = std::string("{\"error\":\"") + error.what() + "\"}";
            return HttpResponse{500, payload, "application/json"};
        }
    });

    server.register_post("/api/tasks/self-charge", [&task_service](const std::string&) {
        try {
            const auto result = task_service.start_self_charge();
            const auto payload = std::string("{\"status\":\"") + result.status +
                "\",\"current_target_name\":\"" + result.current_target_name + "\"}";
            return HttpResponse{200, payload, "application/json"};
        } catch (const std::exception& error) {
            const auto payload = std::string("{\"error\":\"") + error.what() + "\"}";
            return HttpResponse{500, payload, "application/json"};
        }
    });
}
