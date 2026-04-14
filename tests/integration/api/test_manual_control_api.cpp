#include <chrono>
#include <cstdlib>
#include <iostream>
#include <thread>

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
    bool is_charging() const override { return false; }

    bool out_of_charge_requested = false;
    bool out_of_charge_succeeds = true;
    bool move_requested = false;
    bool stop_navigation_requested = false;
    int stop_navigation_count = 0;
    int out_of_charge_count = 0;
    int out_of_charge_calls_to_release = 1;
    int move_count = 0;
    bool manual_move_succeeds = true;
    double last_linear = 0.0;
    double last_angular = 0.0;
    int navigation_status_code = 0;
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
    if (exit_navigation.status != 200 || !adapter.stop_navigation_requested ||
        adapter.stop_navigation_count != 1) {
        std::cerr << "expected explicit exit-navigation request to release adapter control\n";
        return EXIT_FAILURE;
    }

    adapter.stop_navigation_requested = false;

    adapter.charging = true;
    adapter.charge_status_code = 47;
    adapter.out_of_charge_calls_to_release = 2;
    adapter.move_count = 0;
    const auto auto_takeover = service.move(0.18, 0.12);
    if (!auto_takeover.ok ||
        auto_takeover.state.desired_linear != 0.18 ||
        auto_takeover.state.desired_angular != 0.12 ||
        !auto_takeover.state.session_active ||
        !auto_takeover.state.pending_motion ||
        auto_takeover.state.phase == ManualControlPhase::kIdle ||
        adapter.out_of_charge_count < 1) {
        std::cerr << "expected first joystick move to enter undocking state and retain desired velocity\n";
        return EXIT_FAILURE;
    }

    const auto takeover_deadline = std::chrono::steady_clock::now() + std::chrono::milliseconds(800);
    auto takeover_state = service.get_state();
    while (std::chrono::steady_clock::now() < takeover_deadline &&
           takeover_state.phase != ManualControlPhase::kDriving) {
        std::this_thread::sleep_for(std::chrono::milliseconds(50));
        takeover_state = service.get_state();
    }

    if (takeover_state.phase != ManualControlPhase::kDriving ||
        !takeover_state.session_active ||
        !takeover_state.pending_motion ||
        adapter.out_of_charge_count < 2 ||
        adapter.move_count == 0 ||
        adapter.last_linear != 0.18 ||
        adapter.last_angular != 0.12) {
        std::cerr << "expected backend control loop to finish undocking and promote joystick session to driving\n";
        return EXIT_FAILURE;
    }

    const auto reset_after_takeover = server.handle_post("/api/control/stop", "");
    if (reset_after_takeover.status != 200 ||
        reset_after_takeover.body.find("\"phase\":\"idle\"") == std::string::npos) {
        std::cerr << "expected stop to reset the strong manual-control session after automatic takeover\n";
        return EXIT_FAILURE;
    }

    adapter.stop_navigation_requested = false;
    adapter.charging = true;
    adapter.charge_status_code = 47;
    adapter.out_of_charge_calls_to_release = 1;
    adapter.out_of_charge_count = 0;
    adapter.move_requested = false;
    adapter.move_count = 0;
    const auto charging_move = server.handle_post("/api/control/move", "linear=0.12&angular=0.0");
    if (charging_move.status != 200 || !adapter.out_of_charge_requested ||
        charging_move.body.find("\"phase\":\"idle\"") != std::string::npos) {
        std::cerr << "expected charging-state move to accept joystick takeover and start automatic undocking\n";
        return EXIT_FAILURE;
    }

    const auto charging_deadline = std::chrono::steady_clock::now() + std::chrono::milliseconds(500);
    auto charging_state = service.get_state();
    while (std::chrono::steady_clock::now() < charging_deadline &&
           charging_state.phase != ManualControlPhase::kDriving) {
        std::this_thread::sleep_for(std::chrono::milliseconds(50));
        charging_state = service.get_state();
    }

    if (charging_state.phase != ManualControlPhase::kDriving ||
        adapter.out_of_charge_count < 1 ||
        adapter.move_count == 0 ||
        adapter.last_linear != 0.12 || adapter.last_angular != 0.0) {
        std::cerr << "expected charging-state joystick move to auto-undock and reach driving\n";
        return EXIT_FAILURE;
    }

    const auto move = server.handle_post("/api/control/move", "linear=0.15&angular=0.6");
    if (move.status != 200 || !adapter.move_requested ||
        !adapter.stop_navigation_requested ||
        adapter.last_linear != 0.15 || adapter.last_angular != 0.6 ||
        move.body.find("\"phase\":\"driving\"") == std::string::npos) {
        std::cerr << "expected manual move request to report driving only after cmd_vel is sent\n";
        return EXIT_FAILURE;
    }

    adapter.move_requested = false;
    adapter.navigation_status_code = 1;
    const auto second_move = server.handle_post("/api/control/move", "linear=0.10&angular=0.0");
    const auto second_move_deadline = std::chrono::steady_clock::now() + std::chrono::milliseconds(400);
    auto second_move_state = service.get_state();
    while (std::chrono::steady_clock::now() < second_move_deadline &&
           second_move_state.phase != ManualControlPhase::kDriving) {
        std::this_thread::sleep_for(std::chrono::milliseconds(50));
        second_move_state = service.get_state();
    }
    if (second_move.status != 200 || !adapter.move_requested ||
        adapter.stop_navigation_count < 2 ||
        adapter.last_linear != 0.10 || adapter.last_angular != 0.0 ||
        second_move_state.phase != ManualControlPhase::kDriving) {
        std::cerr << "expected repeated move to re-release control when navigation becomes active again\n";
        return EXIT_FAILURE;
    }

    adapter.move_requested = false;
    adapter.navigation_status_code = 83;
    const auto terminal_nav_move = server.handle_post("/api/control/move", "linear=0.08&angular=0.0");
    const auto terminal_deadline = std::chrono::steady_clock::now() + std::chrono::milliseconds(400);
    auto terminal_state = service.get_state();
    while (std::chrono::steady_clock::now() < terminal_deadline &&
           terminal_state.phase != ManualControlPhase::kDriving) {
        std::this_thread::sleep_for(std::chrono::milliseconds(50));
        terminal_state = service.get_state();
    }
    if (terminal_nav_move.status != 200 || !adapter.move_requested ||
        adapter.last_linear != 0.08 || adapter.last_angular != 0.0 ||
        terminal_state.phase != ManualControlPhase::kDriving) {
        std::cerr << "expected terminal navigation status to avoid redundant release loop\n";
        return EXIT_FAILURE;
    }

    adapter.move_requested = false;
    adapter.move_count = 0;
    adapter.last_linear = 0.0;
    adapter.last_angular = 0.0;
    adapter.navigation_status_code = 83;
    const auto leased_move = service.move(0.22, 0.01);
    if (!leased_move.ok || leased_move.state.phase == ManualControlPhase::kIdle) {
        std::cerr << "expected leased joystick move to start a manual-drive session\n";
        return EXIT_FAILURE;
    }

    std::this_thread::sleep_for(std::chrono::milliseconds(350));
    const auto expired_state = service.get_state();
    if (expired_state.phase != ManualControlPhase::kIdle ||
        expired_state.session_active ||
        expired_state.pending_motion ||
        adapter.last_linear != 0.0 ||
        adapter.last_angular != 0.0) {
        std::cerr << "expected joystick session to self-expire and send zero velocity when heartbeats stop\n";
        return EXIT_FAILURE;
    }

    adapter.charging = true;
    adapter.charge_status_code = 47;
    adapter.out_of_charge_succeeds = false;
    const auto failed_out_of_charge = server.handle_post("/api/control/move", "linear=0.05&angular=0.0");
    if (failed_out_of_charge.status != 200 ||
        failed_out_of_charge.body.find("\"phase\":\"idle\"") != std::string::npos) {
        std::cerr << "expected charging-state move to keep joystick session alive even when an undock attempt fails\n";
        return EXIT_FAILURE;
    }
    adapter.out_of_charge_succeeds = true;
    adapter.charging = false;
    adapter.charge_status_code = 41;

    const auto stop = server.handle_post("/api/control/stop", "");
    if (stop.status != 200 || adapter.stop_navigation_count < 4 ||
        adapter.last_linear != 0.0 || adapter.last_angular != 0.0 ||
        stop.body.find("\"phase\":\"idle\"") == std::string::npos) {
        std::cerr << "expected manual stop to clear the control session and send zero velocity\n";
        return EXIT_FAILURE;
    }

    return EXIT_SUCCESS;
}
