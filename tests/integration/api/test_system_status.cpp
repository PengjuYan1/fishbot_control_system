#include <cstdlib>
#include <iostream>
#include <string>

#include "backend/api/SystemController.h"
#include "backend/app/AppServer.h"
#include "backend/services/ManualControlService.h"
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
    bool out_of_charge() override {
        out_of_charge_requested = true;
        return true;
    }
    bool manual_move(double, double) override { return true; }
    Pose get_robot_pose() const override { return Pose{1.0, 2.0, 0.5}; }
    int get_battery() const override { return 78; }
    RobotStatus get_robot_status() const override {
        RobotStatus status{78, false, true, true};
        status.emergency_stopped = true;
        status.emergency_status_code = 31;
        status.motor_locked = true;
        status.motor_status_code = 33;
        status.charge_status_code = 47;
        status.stm32_status_code = 17;
        status.odom_status_code = 19;
        status.navigation_status_code = 1;
        return status;
    }
    MapSnapshot get_map_snapshot() const override { return MapSnapshot{10, 20, 0.05, {0, 100}}; }
    bool is_charging() const override { return false; }

    bool out_of_charge_requested = false;
};

int main() {
    FakeRobotAdapter adapter;
    ManualControlService control_service(adapter);
    control_service.out_of_charge();
    SystemService system_service(adapter, []() {
        return TaskSummary{"running", "F1"};
    }, [&control_service]() {
        return control_service.get_state();
    });
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

    if (response.body.find("\"status\":\"running\"") == std::string::npos ||
        response.body.find("\"current_target\":\"F1\"") == std::string::npos) {
        std::cerr << "expected task summary from task supplier\n";
        return EXIT_FAILURE;
    }

    if (response.body.find("\"control\":{") == std::string::npos ||
        response.body.find("\"motor_locked\":true") == std::string::npos) {
        std::cerr << "expected control diagnostics in response body\n";
        return EXIT_FAILURE;
    }

    if (response.body.find("\"emergency_status_code\":31") == std::string::npos ||
        response.body.find("\"motor_status_code\":33") == std::string::npos ||
        response.body.find("\"charge_status_code\":47") == std::string::npos ||
        response.body.find("\"stm32_status_code\":17") == std::string::npos ||
        response.body.find("\"odom_status_code\":19") == std::string::npos ||
        response.body.find("\"navigation_status_code\":1") == std::string::npos) {
        std::cerr << "expected extended drivetrain diagnostics in response body\n";
        return EXIT_FAILURE;
    }

    if (response.body.find("\"manual_control\":{") == std::string::npos ||
        response.body.find("\"phase\":\"undocking_requested\"") == std::string::npos ||
        response.body.find("\"session_active\":true") == std::string::npos) {
        std::cerr << "expected manual control session state in response body\n";
        return EXIT_FAILURE;
    }

    return EXIT_SUCCESS;
}
