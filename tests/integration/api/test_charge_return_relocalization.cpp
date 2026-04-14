#include <cstdlib>
#include <iostream>
#include <stdexcept>

#include "backend/services/TaskService.h"
#include "ros_adapter/IRobotAdapter.h"
#include "storage/Database.h"
#include "storage/repositories/PointRepository.h"

class FakeChargeReturnAdapter : public IRobotAdapter {
  public:
    std::string mode_name() const override { return "fake"; }
    bool connect() override { return true; }
    void disconnect() override {}
    bool is_connected() const override { return true; }
    bool start_mapping() override { return true; }
    bool stop_mapping() override { return true; }
    bool save_map(const std::string&) override { return true; }
    bool load_map(const std::string& map_id) override {
        ++load_map_count;
        last_map_id = map_id;
        return load_map_ok;
    }
    bool navigate_to_pose(const Pose&) override { return true; }
    bool stop_navigation() override { return true; }
    bool set_initial_pose(const Pose&) override {
        ++set_initial_pose_count;
        if (set_initial_pose_localizes) {
            localized = true;
            location_status_code = 10;
        }
        return set_initial_pose_ok;
    }
    bool set_relocation(const Pose&) override {
        ++set_relocation_count;
        if (set_relocation_localizes) {
            localized = true;
            location_status_code = 10;
        }
        return set_relocation_ok;
    }
    ManualControlAcquireResult acquire_manual_control() override {
        return ManualControlAcquireResult{true, ManualControlAcquireState::kReady};
    }
    bool out_of_charge() override { return true; }
    bool go_charge() override {
        ++go_charge_count;
        return go_charge_ok;
    }
    bool manual_move(double, double) override { return true; }
    Pose get_robot_pose() const override { return {}; }
    int get_battery() const override { return 90; }
    RobotStatus get_robot_status() const override {
        RobotStatus status{90, charging, true, localized};
        status.location_status_code = location_status_code;
        return status;
    }
    MapSnapshot get_map_snapshot() const override { return {}; }
    bool is_charging() const override { return charging; }

    bool localized = false;
    int location_status_code = 9;
    bool charging = false;
    bool go_charge_ok = true;
    bool load_map_ok = true;
    bool set_relocation_ok = true;
    bool set_relocation_localizes = true;
    bool set_initial_pose_ok = true;
    bool set_initial_pose_localizes = true;
    int load_map_count = 0;
    int set_relocation_count = 0;
    int set_initial_pose_count = 0;
    int go_charge_count = 0;
    std::string last_map_id;
};

int main() {
    {
        auto db = open_test_database();
        run_migrations(db);
        PointRepository repo(db);
        repo.insert_point(PointRecord{0, "C1", "charge", 1.0, 2.0, 0.3, 1, 11, 111});
        repo.insert_point(PointRecord{0, "I1", "initial", 0.8, 1.8, 0.2, 1, 11, 112});

        FakeChargeReturnAdapter adapter;
        adapter.localized = false;
        adapter.location_status_code = 9;
        adapter.set_relocation_ok = true;
        adapter.set_relocation_localizes = true;
        adapter.set_initial_pose_ok = true;
        adapter.set_initial_pose_localizes = true;
        TaskService service(adapter, repo);

        const auto result = service.start_charge_return();
        if (result.status != "charging" || result.current_target_name != "C1") {
            std::cerr << "expected charge return to start after successful relocation\n";
            return EXIT_FAILURE;
        }
        if (adapter.set_relocation_count != 1 || adapter.set_initial_pose_count != 0) {
            std::cerr << "expected set_relocation primary path without fallback\n";
            return EXIT_FAILURE;
        }
        if (adapter.go_charge_count != 1) {
            std::cerr << "expected go_charge to run once after relocalization\n";
            return EXIT_FAILURE;
        }
    }

    {
        auto db = open_test_database();
        run_migrations(db);
        PointRepository repo(db);
        repo.insert_point(PointRecord{0, "C1", "charge", 1.0, 2.0, 0.3, 1, 11, 111});
        repo.insert_point(PointRecord{0, "I1", "initial", 0.8, 1.8, 0.2, 1, 11, 112});

        FakeChargeReturnAdapter adapter;
        adapter.localized = false;
        adapter.location_status_code = 9;
        adapter.set_relocation_ok = false;
        adapter.set_relocation_localizes = false;
        adapter.set_initial_pose_ok = false;
        adapter.set_initial_pose_localizes = false;
        TaskService service(adapter, repo);

        bool threw = false;
        try {
            (void) service.start_charge_return();
        } catch (const std::runtime_error& error) {
            threw = std::string(error.what()) == "not_localized_for_charge_return";
        }

        if (!threw) {
            std::cerr << "expected explicit not_localized_for_charge_return failure\n";
            return EXIT_FAILURE;
        }
        if (adapter.set_relocation_count != 1 || adapter.set_initial_pose_count != 1 || adapter.go_charge_count != 0) {
            std::cerr << "expected relocation attempt and fallback before failing\n";
            return EXIT_FAILURE;
        }
    }

    return EXIT_SUCCESS;
}
