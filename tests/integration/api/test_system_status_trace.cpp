#include <cstdlib>
#include <iostream>
#include <string>

#include "backend/api/SystemController.h"
#include "backend/app/AppServer.h"
#include "backend/runtime/StatusStreamService.h"
#include "backend/services/MapService.h"
#include "backend/services/SystemService.h"
#include "backend/websocket/StatusHub.h"
#include "ros_adapter/IRobotAdapter.h"

class FakeTraceAdapter : public IRobotAdapter {
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
    ManualControlAcquireResult acquire_manual_control() override {
        return ManualControlAcquireResult{true, ManualControlAcquireState::kReady};
    }
    bool out_of_charge() override { return true; }
    bool manual_move(double, double) override { return true; }
    Pose get_robot_pose() const override { return pose_; }
    int get_battery() const override { return battery_; }
    RobotStatus get_robot_status() const override {
        RobotStatus status{battery_, charging_, true, true};
        status.charge_status_code = charge_status_code_;
        status.navigation_status_code = navigation_status_code_;
        return status;
    }
    MapSnapshot get_map_snapshot() const override { return {}; }
    bool is_charging() const override { return charging_; }

    int battery_ = 100;
    bool charging_ = false;
    int charge_status_code_ = 41;
    int navigation_status_code_ = 83;
    Pose pose_{};
};

int main() {
    FakeTraceAdapter adapter;
    SystemService system_service(adapter);
    MapService map_service(adapter);
    StatusHub hub;
    StatusStreamService stream_service(system_service, map_service, hub);
    AppServer server;
    register_system_routes(server, system_service);

    adapter.battery_ = 95;
    adapter.charging_ = true;
    adapter.charge_status_code_ = 47;
    stream_service.poll_once();

    adapter.battery_ = 88;
    adapter.charging_ = false;
    adapter.charge_status_code_ = 41;
    adapter.pose_ = Pose{1.2, 3.4, 0.5};
    stream_service.poll_once();

    const auto response = server.handle_get("/api/system/status/trace");
    if (response.status != 200) {
        std::cerr << "expected HTTP 200 from /api/system/status/trace\n";
        return EXIT_FAILURE;
    }

    if (response.body.find("\"entries\":[") == std::string::npos ||
        response.body.find("\"timestamp_ms\":") == std::string::npos ||
        response.body.find("\"battery\":95") == std::string::npos ||
        response.body.find("\"battery\":88") == std::string::npos ||
        response.body.find("\"charge_status_code\":47") == std::string::npos ||
        response.body.find("\"charge_status_code\":41") == std::string::npos) {
        std::cerr << "expected recent system trace entries in response body\n";
        return EXIT_FAILURE;
    }

    return EXIT_SUCCESS;
}
