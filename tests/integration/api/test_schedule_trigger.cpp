#include <cstdlib>
#include <iostream>

#include "backend/scheduler/TaskScheduler.h"
#include "backend/services/TaskService.h"
#include "ros_adapter/IRobotAdapter.h"
#include "storage/Database.h"
#include "storage/repositories/PointRepository.h"
#include "storage/repositories/ScheduleRepository.h"

class FakeScheduledTaskAdapter : public IRobotAdapter {
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
        return true;
    }
    bool stop_navigation() override { return true; }
    bool set_initial_pose(const Pose&) override { return true; }
    Pose get_robot_pose() const override { return {}; }
    int get_battery() const override { return 80; }
    RobotStatus get_robot_status() const override { return RobotStatus{80, false, true, true}; }
    MapSnapshot get_map_snapshot() const override { return {}; }
    bool is_charging() const override { return false; }

    Pose last_goal;
    bool navigation_requested = false;
};

int main() {
    auto db = open_test_database();
    run_migrations(db);

    PointRepository point_repository(db);
    point_repository.insert_point(PointRecord{0, "F1", "feed", 5.0, 6.0, 1.2});

    ScheduleRepository schedule_repository(db);
    schedule_repository.insert_schedule(ScheduleRecord{0, "Morning Feed", true, "0 8 * * *", "[]"});

    FakeScheduledTaskAdapter adapter;
    TaskService task_service(adapter, point_repository);
    TaskScheduler scheduler(schedule_repository, task_service);

    scheduler.tick("08:00");

    const auto current_task = task_service.current_task();
    if (current_task.status != "running") {
        std::cerr << "expected scheduler to start a running task\n";
        return EXIT_FAILURE;
    }

    if (current_task.current_target_name != "F1") {
        std::cerr << "expected scheduler to target first feed point\n";
        return EXIT_FAILURE;
    }

    if (task_service.last_trigger_type() != "schedule") {
        std::cerr << "expected scheduled trigger type\n";
        return EXIT_FAILURE;
    }

    if (!adapter.navigation_requested || adapter.last_goal.x != 5.0 || adapter.last_goal.y != 6.0) {
        std::cerr << "expected scheduled navigation to feed point\n";
        return EXIT_FAILURE;
    }

    return EXIT_SUCCESS;
}
