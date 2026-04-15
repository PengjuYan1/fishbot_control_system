#include <chrono>
#include <cmath>
#include <cstdlib>
#include <iostream>
#include <thread>

#include "backend/services/TaskService.h"
#include "ros_adapter/IRobotAdapter.h"
#include "storage/Database.h"
#include "storage/repositories/PointRepository.h"

class FakeSelfChargeDockingAdapter : public IRobotAdapter {
  public:
    std::string mode_name() const override { return "fake"; }
    bool connect() override { return true; }
    void disconnect() override {}
    bool is_connected() const override { return true; }
    bool start_mapping() override { return true; }
    bool stop_mapping() override { return true; }
    bool save_map(const std::string&) override { return true; }
    bool load_map(const std::string&) override { return true; }
    bool navigate_to_pose(const Pose& pose) override {
        last_goal = pose;
        navigation_requested = true;
        navigation_status_code = 2;
        localized = true;
        return true;
    }
    bool stop_navigation() override {
        ++stop_navigation_count;
        return true;
    }
    bool set_initial_pose(const Pose&) override { return true; }
    bool set_relocation(const Pose&) override { return true; }
    ManualControlAcquireResult acquire_manual_control() override {
        return ManualControlAcquireResult{true, ManualControlAcquireState::kReady};
    }
    bool out_of_charge() override { return true; }
    bool manual_move(double linear, double angular) override {
        ++manual_move_count;
        if (std::abs(angular) > 0.01) {
            saw_scan_guided_turn = true;
        }
        pose.x += linear * 0.1;
        pose.theta += angular * 0.1;
        if (saw_scan_guided_turn) {
            left_distance = 0.34;
            right_distance = 0.35;
        }
        if (manual_move_count >= 3) {
            charging = true;
            charge_status_code = 45;
        }
        return true;
    }
    Pose get_robot_pose() const override { return pose; }
    int get_battery() const override { return 90; }
    RobotStatus get_robot_status() const override {
        RobotStatus status{90, charging, true, localized};
        status.charge_status_code = charge_status_code;
        status.navigation_status_code = navigation_status_code;
        status.location_status_code = localized ? 10 : 9;
        return status;
    }
    MapSnapshot get_map_snapshot() const override { return {}; }
    bool is_charging() const override { return charging; }
    bool get_latest_laser_scan(LaserScanSnapshot* scan) const override {
        if (scan == nullptr) {
            return false;
        }
        scan->angle_min = -0.4;
        scan->angle_increment = 0.2;
        scan->range_min = 0.05;
        scan->range_max = 8.0;
        scan->received_steady_time_ms = std::chrono::duration_cast<std::chrono::milliseconds>(
            std::chrono::steady_clock::now().time_since_epoch()).count();
        scan->ranges = {right_distance, right_distance, 0.32, left_distance, left_distance};
        return true;
    }
    bool list_native_points(std::vector<PointRecord>* points) override {
        if (points == nullptr) {
            return false;
        }
        *points = native_points;
        return true;
    }

    Pose pose{1.0, 1.7, 0.0, 1, 11, 21};
    Pose last_goal;
    bool navigation_requested = false;
    bool charging = false;
    bool localized = true;
    int charge_status_code = 41;
    int navigation_status_code = 0;
    int manual_move_count = 0;
    int stop_navigation_count = 0;
    bool saw_scan_guided_turn = false;
    double left_distance = 0.16;
    double right_distance = 0.42;
    std::vector<PointRecord> native_points;
};

int main() {
    auto db = open_test_database();
    run_migrations(db);
    PointRepository point_repository(db);

    FakeSelfChargeDockingAdapter adapter;
    adapter.native_points.push_back(PointRecord{0, "C1", "charge", 1.0, 2.0, 0.0, 1, 11, 21});
    TaskService service(adapter, point_repository);

    const auto result = service.start_self_charge();
    if (result.status != "self_charging_nav" || result.current_target_name != "C1") {
        std::cerr << "expected self-charge to start in navigation phase\n";
        return EXIT_FAILURE;
    }

    for (int retry = 0; retry < 40; ++retry) {
        if (service.current_task().status == "charging") {
            break;
        }
        std::this_thread::sleep_for(std::chrono::milliseconds(100));
    }

    if (service.current_task().status != "charging") {
        std::cerr << "expected self-charge to finish when charging status is detected\n";
        return EXIT_FAILURE;
    }

    if (!adapter.navigation_requested || adapter.stop_navigation_count == 0 || adapter.manual_move_count < 3) {
        std::cerr << "expected self-charge to navigate, stop navigation, and perform local docking moves\n";
        return EXIT_FAILURE;
    }

    if (!adapter.saw_scan_guided_turn) {
        std::cerr << "expected docking to use laser asymmetry to issue a centering turn\n";
        return EXIT_FAILURE;
    }

    return EXIT_SUCCESS;
}
