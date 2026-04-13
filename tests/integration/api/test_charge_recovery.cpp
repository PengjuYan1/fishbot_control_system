#include <cstdlib>
#include <iostream>

#include "backend/services/TaskService.h"
#include "ros_adapter/IRobotAdapter.h"
#include "storage/Database.h"
#include "storage/repositories/PointRepository.h"
#include "storage/repositories/TaskRunRepository.h"

class FakeRecoveryAdapter : public IRobotAdapter {
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
        ++navigation_count;
        return true;
    }
    bool stop_navigation() override { return true; }
    bool set_initial_pose(const Pose&) override { return true; }
    bool out_of_charge() override { return true; }
    bool manual_move(double, double) override { return true; }
    Pose get_robot_pose() const override { return {}; }
    int get_battery() const override { return 80; }
    RobotStatus get_robot_status() const override { return RobotStatus{80, false, true, true}; }
    MapSnapshot get_map_snapshot() const override { return {}; }
    bool is_charging() const override { return false; }

    Pose last_goal;
    int navigation_count = 0;
};

int main() {
    auto db = open_test_database();
    run_migrations(db);

    PointRepository point_repository(db);
    point_repository.insert_point(PointRecord{0, "F1", "feed", 1.0, 1.0, 0.0});
    point_repository.insert_point(PointRecord{0, "F2", "feed", 2.0, 2.0, 0.2});
    point_repository.insert_point(PointRecord{0, "F3", "feed", 3.0, 3.0, 0.3});

    TaskRunRepository task_run_repository(db);
    FakeRecoveryAdapter adapter;
    TaskService service(adapter, point_repository, &task_run_repository);

    service.start_manual_run();
    service.complete_current_feed_point();
    service.interrupt_for_low_battery();

    const auto stored_run = task_run_repository.latest_run();
    if (stored_run.resume_context_json.find("F2") == std::string::npos ||
        stored_run.resume_context_json.find("F3") == std::string::npos) {
        std::cerr << "expected resume context to persist remaining feed points\n";
        return EXIT_FAILURE;
    }

    service.on_charge_completed(true);

    const auto current_task = service.current_task();
    if (current_task.current_target_name != "F2") {
        std::cerr << "expected charge completion to resume at F2\n";
        return EXIT_FAILURE;
    }

    if (current_task.status != "running") {
        std::cerr << "expected resumed task to be running\n";
        return EXIT_FAILURE;
    }

    if (adapter.last_goal.x != 2.0 || adapter.last_goal.y != 2.0) {
        std::cerr << "expected resumed navigation goal to match F2\n";
        return EXIT_FAILURE;
    }

    return EXIT_SUCCESS;
}
