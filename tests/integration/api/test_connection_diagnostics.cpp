#include <cstdlib>
#include <iostream>
#include <string>

#include "backend/api/SystemController.h"
#include "backend/app/AppServer.h"
#include "backend/services/SystemService.h"
#include "ros_adapter/IRobotAdapter.h"

class BrokenConnectionAdapter : public IRobotAdapter {
  public:
    std::string mode_name() const override { return "rosbridge"; }
    bool connect() override { return false; }
    void disconnect() override {}
    bool is_connected() const override { return false; }
    bool start_mapping() override { return false; }
    bool stop_mapping() override { return false; }
    bool save_map(const std::string&) override { return false; }
    bool load_map(const std::string&) override { return false; }
    bool navigate_to_pose(const Pose&) override { return false; }
    bool stop_navigation() override { return true; }
    bool set_initial_pose(const Pose&) override { return false; }
    bool out_of_charge() override { return true; }
    bool manual_move(double, double) override { return true; }
    Pose get_robot_pose() const override { return {}; }
    int get_battery() const override { return 41; }
    RobotStatus get_robot_status() const override { return RobotStatus{41, false, false, false}; }
    MapSnapshot get_map_snapshot() const override { return {}; }
    bool is_charging() const override { return false; }
};

int main() {
    BrokenConnectionAdapter adapter;
    SystemService system_service(adapter);
    system_service.record_connection_error("rosbridge timeout");
    system_service.set_reconnect_attempts(3);

    AppServer server;
    register_system_routes(server, system_service);

    const auto response = server.handle_get("/api/system/status");
    if (response.status != 200) {
        std::cerr << "expected successful system status response\n";
        return EXIT_FAILURE;
    }

    if (response.body.find("\"healthy\":false") == std::string::npos) {
        std::cerr << "expected unhealthy connection field\n";
        return EXIT_FAILURE;
    }

    if (response.body.find("\"last_error\":\"rosbridge timeout\"") == std::string::npos) {
        std::cerr << "expected last_error field in response\n";
        return EXIT_FAILURE;
    }

    if (response.body.find("\"reconnect_attempts\":3") == std::string::npos) {
        std::cerr << "expected reconnect attempts in response\n";
        return EXIT_FAILURE;
    }

    return EXIT_SUCCESS;
}
