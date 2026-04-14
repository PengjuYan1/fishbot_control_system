#include <cstdlib>
#include <iostream>

#include "backend/api/TaskController.h"
#include "backend/app/AppServer.h"
#include "backend/services/TaskService.h"
#include "ros_adapter/IRobotAdapter.h"
#include "storage/Database.h"
#include "storage/repositories/PointRepository.h"

class FakeTaskAdapter : public IRobotAdapter {
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
    bool list_native_points(std::vector<PointRecord>* points) override {
        if (points == nullptr) {
            return false;
        }
        *points = native_points;
        return true;
    }

    Pose last_goal;
    bool navigation_requested = false;
    std::vector<PointRecord> native_points;
};

int main() {
    auto db = open_test_database();
    run_migrations(db);
    PointRepository point_repository(db);
    point_repository.insert_point(PointRecord{0, "F1", "feed", 3.0, 4.0, 1.0, 2, 12, 22});

    FakeTaskAdapter adapter;
    adapter.native_points.push_back(PointRecord{0, "C1", "charge", 1.0, 2.0, 0.0, 1, 11, 21});
    TaskService service(adapter, point_repository);
    AppServer server;
    register_task_routes(server, service);

    const auto response = server.handle_post("/api/tasks/start", "");
    if (response.status != 200) {
        std::cerr << "expected successful task start response\n";
        return EXIT_FAILURE;
    }

    if (response.body.find("\"status\":\"running\"") == std::string::npos) {
        std::cerr << "expected running task status\n";
        return EXIT_FAILURE;
    }

    if (response.body.find("\"current_target_name\":\"F1\"") == std::string::npos) {
        std::cerr << "expected first feed point to be selected\n";
        return EXIT_FAILURE;
    }

    if (!adapter.navigation_requested || adapter.last_goal.x != 3.0 || adapter.last_goal.y != 4.0) {
        std::cerr << "expected navigation request to first feed point\n";
        return EXIT_FAILURE;
    }

    if (adapter.last_goal.floor_id != 2 || adapter.last_goal.map_id != 12 || adapter.last_goal.point_id != 22) {
        std::cerr << "expected task flow to forward robot-native point identifiers\n";
        return EXIT_FAILURE;
    }

    const auto charge_response = server.handle_post("/api/tasks/go-charge", "");
    if (charge_response.status != 200) {
        std::cerr << "expected successful go-charge response\n";
        return EXIT_FAILURE;
    }

    if (charge_response.body.find("\"status\":\"charging\"") == std::string::npos ||
        charge_response.body.find("\"current_target_name\":\"C1\"") == std::string::npos) {
        std::cerr << "expected charge point to become current target\n";
        return EXIT_FAILURE;
    }

    if (adapter.last_goal.x != 1.0 || adapter.last_goal.y != 2.0 ||
        adapter.last_goal.floor_id != 1 || adapter.last_goal.map_id != 11 || adapter.last_goal.point_id != 21) {
        std::cerr << "expected go-charge to navigate to configured charge point\n";
        return EXIT_FAILURE;
    }

    return EXIT_SUCCESS;
}
