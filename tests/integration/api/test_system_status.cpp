#include <cstdlib>
#include <iostream>
#include <string>

#include "backend/api/SystemController.h"
#include "backend/app/AppServer.h"
#include "backend/services/SystemService.h"
#include "ros_adapter/IRobotAdapter.h"

class FakeRobotAdapter : public IRobotAdapter {
  public:
    std::string mode_name() const override { return "fake"; }
    bool connect() override { return true; }
    void disconnect() override {}
    bool is_connected() const override { return true; }
    bool start_mapping() override { return true; }
    bool stop_mapping() override { return true; }
    bool save_map(const std::string&) override { return true; }
    bool load_map(const std::string&) override { return true; }
    bool navigate_to_pose(const Pose&) override { return true; }
    bool stop_navigation() override { return true; }
    bool set_initial_pose(const Pose&) override { return true; }
    Pose get_robot_pose() const override { return Pose{1.0, 2.0, 0.5}; }
    int get_battery() const override { return 78; }
    RobotStatus get_robot_status() const override { return RobotStatus{78, false, true, true}; }
    MapSnapshot get_map_snapshot() const override { return MapSnapshot{10, 20, 0.05, {0, 100}}; }
    bool is_charging() const override { return false; }
};

int main() {
    FakeRobotAdapter adapter;
    SystemService system_service(adapter);
    AppServer server;
    register_system_routes(server, system_service);

    const auto response = server.handle_get("/api/system/status");
    if (response.status != 200) {
        std::cerr << "expected HTTP 200 from /api/system/status\n";
        return EXIT_FAILURE;
    }

    if (response.body.find("\"battery\":78") == std::string::npos) {
        std::cerr << "expected battery field in response body\n";
        return EXIT_FAILURE;
    }

    if (response.body.find("\"pose\":{") == std::string::npos) {
        std::cerr << "expected pose field in response body\n";
        return EXIT_FAILURE;
    }

    if (response.body.find("\"task\":{") == std::string::npos) {
        std::cerr << "expected task field in response body\n";
        return EXIT_FAILURE;
    }

    return EXIT_SUCCESS;
}
