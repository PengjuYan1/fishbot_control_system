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
        navigation_status_code = 83;
        return true;
    }
    bool set_initial_pose(const Pose&) override { return true; }
    ManualControlAcquireResult acquire_manual_control() override {
        ++acquire_manual_control_count;
        stop_navigation();
        if (charging) {
            if (!out_of_charge_succeeds) {
                return ManualControlAcquireResult{false, ManualControlAcquireState::kFailed};
            }

            ++out_of_charge_count;
            if (out_of_charge_count >= out_of_charge_calls_to_release) {
                charging = false;
                charge_status_code = 41;
                return ManualControlAcquireResult{true, ManualControlAcquireState::kReady};
            }

            charge_status_code = 47;
            return ManualControlAcquireResult{true, ManualControlAcquireState::kUndockingRequested};
        }

        return ManualControlAcquireResult{true, ManualControlAcquireState::kReady};
    }
    bool out_of_charge() override {
        out_of_charge_requested = true;
        ++out_of_charge_count;
        if (out_of_charge_succeeds && out_of_charge_count >= out_of_charge_calls_to_release) {
            charging = false;
            charge_status_code = 41;
        }
        return out_of_charge_succeeds;
    }
    bool manual_move(double linear_speed, double angular_speed) override {
        move_requested = true;
        ++move_count;
        last_linear = linear_speed;
        last_angular = angular_speed;
        return manual_move_succeeds;
    }
    Pose get_robot_pose() const override { return {}; }
    int get_battery() const override { return 100; }
    RobotStatus get_robot_status() const override {
        RobotStatus status{100, charging, true, true};
        status.navigation_status_code = navigation_status_code;
        status.charge_status_code = charge_status_code;
        return status;
    }
    MapSnapshot get_map_snapshot() const override { return {}; }
    bool is_charging() const override { return charging; }

    bool out_of_charge_requested = false;
    bool out_of_charge_succeeds = true;
    bool move_requested = false;
    bool stop_navigation_requested = false;
    int stop_navigation_count = 0;
    int out_of_charge_count = 0;
    int out_of_charge_calls_to_release = 1;
    int acquire_manual_control_count = 0;
    int move_count = 0;
    bool manual_move_succeeds = true;
    double last_linear = 0.0;
    double last_angular = 0.0;
    int navigation_status_code = 83;
    bool charging = false;
    int charge_status_code = 41;
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

    const auto exit_navigation = server.handle_post("/api/control/exit-navigation-mode", "");
    if (exit_navigation.status != 200 || adapter.acquire_manual_control_count != 1 ||
        !adapter.stop_navigation_requested ||
        exit_navigation.body.find("\"phase\":\"ready_for_drive\"") == std::string::npos) {
        std::cerr << "expected explicit exit-navigation request to prepare manual drive once\n";
        return EXIT_FAILURE;
    }

    adapter.stop_navigation_requested = false;
    adapter.charging = true;
    adapter.charge_status_code = 47;
    adapter.out_of_charge_calls_to_release = 2;
    adapter.out_of_charge_count = 0;
    adapter.move_requested = false;
    adapter.move_count = 0;
    adapter.acquire_manual_control_count = 0;

    const auto first_drag = server.handle_post("/api/control/move", "linear=0.12&angular=0.0");
    if (first_drag.status != 200 ||
        adapter.acquire_manual_control_count != 1 ||
        adapter.move_requested ||
        first_drag.body.find("\"phase\":\"undocking_requested\"") == std::string::npos) {
        std::cerr << "expected first joystick heartbeat to trigger takeover and stay in undocking\n";
        return EXIT_FAILURE;
    }

    const auto second_drag = server.handle_post("/api/control/move", "linear=0.12&angular=0.0");
    if (second_drag.status != 200 ||
        adapter.acquire_manual_control_count != 2 ||
        !adapter.move_requested ||
        adapter.last_linear != 0.12 ||
        adapter.last_angular != 0.0 ||
        second_drag.body.find("\"phase\":\"driving\"") == std::string::npos) {
        std::cerr << "expected later joystick heartbeat to drive immediately after undock is ready\n";
        return EXIT_FAILURE;
    }

    adapter.move_requested = false;
    const auto move = server.handle_post("/api/control/move", "linear=0.15&angular=0.6");
    if (move.status != 200 || !adapter.move_requested ||
        adapter.last_linear != 0.15 || adapter.last_angular != 0.6 ||
        move.body.find("\"phase\":\"driving\"") == std::string::npos) {
        std::cerr << "expected direct joystick heartbeat to publish cmd_vel without backend drive loop\n";
        return EXIT_FAILURE;
    }

    adapter.move_requested = false;
    adapter.charging = true;
    adapter.charge_status_code = 47;
    adapter.out_of_charge_succeeds = false;
    const auto failed_move = server.handle_post("/api/control/move", "linear=0.05&angular=0.0");
    if (failed_move.status != 500 || adapter.move_requested) {
        std::cerr << "expected move to fail when adapter cannot acquire manual control\n";
        return EXIT_FAILURE;
    }
    adapter.out_of_charge_succeeds = true;
    adapter.charging = false;
    adapter.charge_status_code = 41;

    const auto stop = server.handle_post("/api/control/stop", "");
    if (stop.status != 200 || adapter.last_linear != 0.0 || adapter.last_angular != 0.0 ||
        stop.body.find("\"phase\":\"idle\"") == std::string::npos) {
        std::cerr << "expected manual stop to send zero velocity and reset state immediately\n";
        return EXIT_FAILURE;
    }

    return EXIT_SUCCESS;
}
