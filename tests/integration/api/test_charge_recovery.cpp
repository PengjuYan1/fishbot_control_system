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
    ManualControlAcquireResult acquire_manual_control() override {
        return ManualControlAcquireResult{true, ManualControlAcquireState::kReady};
    }
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
    PointRecord feed1;
    feed1.name = "F1";
    feed1.type = "feed";
    feed1.point_kind = "navigation";
    feed1.biz_role = "feed";
    feed1.x = 1.0;
    feed1.y = 1.0;
    point_repository.insert_point(feed1);

    PointRecord feed2;
    feed2.name = "F2";
    feed2.type = "feed";
    feed2.point_kind = "navigation";
    feed2.biz_role = "feed";
    feed2.x = 2.0;
    feed2.y = 2.0;
    feed2.theta = 0.2;
    point_repository.insert_point(feed2);

    PointRecord feed3;
    feed3.name = "F3";
    feed3.type = "feed";
    feed3.point_kind = "navigation";
    feed3.biz_role = "feed";
    feed3.x = 3.0;
    feed3.y = 3.0;
    feed3.theta = 0.3;
    point_repository.insert_point(feed3);

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
