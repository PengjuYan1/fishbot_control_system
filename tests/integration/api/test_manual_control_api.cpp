#include <cstdlib>
#include <iostream>

#include "backend/api/ControlController.h"
#include "backend/app/AppServer.h"
#include "backend/services/ManualControlService.h"
#include "ros_adapter/IRobotAdapter.h"

class FakeControlAdapter : public IRobotAdapter {
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
    bool stop_navigation() override {
        stop_navigation_requested = true;
        ++stop_navigation_count;
        return true;
    }
    bool set_initial_pose(const Pose&) override { return true; }
    bool out_of_charge() override {
        out_of_charge_requested = true;
        return true;
    }
    bool manual_move(double linear_speed, double angular_speed) override {
        move_requested = true;
        last_linear = linear_speed;
        last_angular = angular_speed;
        return true;
    }
    Pose get_robot_pose() const override { return {}; }
    int get_battery() const override { return 100; }
    RobotStatus get_robot_status() const override { return RobotStatus{100, false, true, true}; }
    MapSnapshot get_map_snapshot() const override { return {}; }
    bool is_charging() const override { return false; }

    bool out_of_charge_requested = false;
    bool move_requested = false;
    bool stop_navigation_requested = false;
    int stop_navigation_count = 0;
    double last_linear = 0.0;
    double last_angular = 0.0;
};

int main() {
    FakeControlAdapter adapter;
    ManualControlService service(adapter);
    AppServer server;
    register_control_routes(server, service);

    const auto out_of_charge = server.handle_post("/api/control/out-of-charge", "");
    if (out_of_charge.status != 200 || !adapter.out_of_charge_requested) {
        std::cerr << "expected out-of-charge request to reach adapter\n";
        return EXIT_FAILURE;
    }

    const auto move = server.handle_post("/api/control/move", "linear=0.15&angular=0.6");
    if (move.status != 200 || !adapter.move_requested ||
        !adapter.stop_navigation_requested ||
        adapter.stop_navigation_count != 1 ||
        adapter.last_linear != 0.15 || adapter.last_angular != 0.6) {
        std::cerr << "expected manual move request to reach adapter\n";
        return EXIT_FAILURE;
    }

    adapter.move_requested = false;
    const auto second_move = server.handle_post("/api/control/move", "linear=0.10&angular=0.0");
    if (second_move.status != 200 || !adapter.move_requested ||
        adapter.stop_navigation_count != 1 ||
        adapter.last_linear != 0.10 || adapter.last_angular != 0.0) {
        std::cerr << "expected repeated move to reuse released control session\n";
        return EXIT_FAILURE;
    }

    const auto stop = server.handle_post("/api/control/stop", "");
    if (stop.status != 200 || adapter.stop_navigation_count != 2 ||
        adapter.last_linear != 0.0 || adapter.last_angular != 0.0) {
        std::cerr << "expected manual stop to release control and send zero velocity\n";
        return EXIT_FAILURE;
    }

    return EXIT_SUCCESS;
}
