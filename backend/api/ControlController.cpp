#include "backend/api/ControlController.h"

#include <exception>
#include <sstream>
#include <string>
#include <unordered_map>

namespace {
std::unordered_map<std::string, std::string> parse_form_encoded(const std::string& body) {
    std::unordered_map<std::string, std::string> values;
    std::stringstream stream(body);
    std::string pair;
    while (std::getline(stream, pair, '&')) {
        const auto separator = pair.find('=');
        if (separator == std::string::npos) {
            continue;
        }
        values[pair.substr(0, separator)] = pair.substr(separator + 1);
    }
    return values;
}

std::string build_control_response(const ManualControlCommandResult& result) {
    return std::string("{\"status\":\"") + to_string(result.state.phase) +
        "\",\"phase\":\"" + to_string(result.state.phase) +
        "\",\"desired_linear\":" + std::to_string(result.state.desired_linear) +
        ",\"desired_angular\":" + std::to_string(result.state.desired_angular) +
        ",\"session_active\":" + (result.state.session_active ? "true" : "false") +
        ",\"pending_motion\":" + (result.state.pending_motion ? "true" : "false") + "}";
}
}  // namespace

void register_control_routes(AppServer& server, ManualControlService& control_service) {
    server.register_post("/api/control/out-of-charge", [&control_service](const std::string&) {
        const auto result = control_service.out_of_charge();
        return result.ok
            ? HttpResponse{200, build_control_response(result), "application/json"}
            : HttpResponse{500, "{\"error\":\"out_of_charge_failed\"}", "application/json"};
    });

    server.register_post("/api/control/exit-navigation-mode", [&control_service](const std::string&) {
        const auto result = control_service.exit_navigation_mode();
        return result.ok
            ? HttpResponse{200, build_control_response(result), "application/json"}
            : HttpResponse{500, "{\"error\":\"exit_navigation_mode_failed\"}", "application/json"};
    });

    server.register_post("/api/control/move", [&control_service](const std::string& body) {
        try {
            const auto values = parse_form_encoded(body);
            const auto linear = std::stod(values.at("linear"));
            const auto angular = std::stod(values.at("angular"));
            const auto result = control_service.move(linear, angular);
            return result.ok
                ? HttpResponse{200, build_control_response(result), "application/json"}
                : HttpResponse{500, "{\"error\":\"manual_move_failed\"}", "application/json"};
        } catch (const std::exception&) {
            return HttpResponse{400, "{\"error\":\"invalid_manual_move_request\"}", "application/json"};
        }
    });

    server.register_post("/api/control/stop", [&control_service](const std::string&) {
        const auto result = control_service.stop();
        return result.ok
            ? HttpResponse{200, build_control_response(result), "application/json"}
            : HttpResponse{500, "{\"error\":\"manual_stop_failed\"}", "application/json"};
    });
}
