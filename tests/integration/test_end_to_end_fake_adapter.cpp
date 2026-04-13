#include <cstdlib>
#include <iostream>
#include <string>

#include "backend/api/TaskController.h"
#include "backend/app/AppServer.h"
#include "backend/app/Config.h"
#include "backend/bootstrap.h"
#include "backend/services/TaskService.h"
#include "backend/websocket/StatusHub.h"
#include "ros_adapter/IRobotAdapter.h"
#include "storage/Database.h"
#include "storage/repositories/PointRepository.h"
#include "storage/repositories/TaskRunRepository.h"

class FakeEndToEndAdapter : public IRobotAdapter {
  public:
    std::string mode_name() const override { return "fake"; }
    bool connect() override { connected = true; return true; }
    void disconnect() override { connected = false; }
    bool is_connected() const override { return connected; }
    bool start_mapping() override { return true; }
    bool stop_mapping() override { return true; }
    bool save_map(const std::string&) override { return true; }
    bool load_map(const std::string&) override { return true; }
    bool navigate_to_pose(const Pose& pose) override { last_goal = pose; return true; }
    bool stop_navigation() override { return true; }
    bool set_initial_pose(const Pose&) override { return true; }
    bool out_of_charge() override { return true; }
    bool manual_move(double, double) override { return true; }
    Pose get_robot_pose() const override { return last_goal; }
    int get_battery() const override { return 88; }
    RobotStatus get_robot_status() const override { return RobotStatus{88, false, connected, true}; }
    MapSnapshot get_map_snapshot() const override { return {}; }
    bool is_charging() const override { return false; }

    bool connected = false;
    Pose last_goal;
};

int main() {
    const auto config = load_config("config/app.example.yaml");
    if (config.adapter_mode != "rosbridge") {
        std::cerr << "expected example config to remain on rosbridge by default\n";
        return EXIT_FAILURE;
    }

    if (!start_app_with_config("config/app.example.yaml")) {
        std::cerr << "expected bootstrap to succeed before fake smoke wiring\n";
        return EXIT_FAILURE;
    }

    auto db = open_test_database();
    run_migrations(db);
    PointRepository point_repository(db);
    point_repository.insert_point(PointRecord{0, "C1", "charge", 0.0, 0.0, 0.0});
    point_repository.insert_point(PointRecord{0, "F1", "feed", 2.0, 3.0, 0.1});

    TaskRunRepository task_run_repository(db);
    FakeEndToEndAdapter adapter;
    adapter.connect();

    TaskService task_service(adapter, point_repository, &task_run_repository);
    AppServer server;
    register_task_routes(server, task_service);

    const auto response = server.handle_post("/api/tasks/start", "");
    if (response.status != 200) {
        std::cerr << "expected task start to succeed in fake mode\n";
        return EXIT_FAILURE;
    }

    task_service.complete_current_feed_point();
    const auto task = task_service.current_task();
    if (task.status != "completed") {
        std::cerr << "expected fake task run to complete\n";
        return EXIT_FAILURE;
    }

    StatusHub hub;
    const auto update = hub.publish_robot_pose(adapter.get_robot_pose());
    if (update.find("\"type\":\"robot_pose\"") == std::string::npos) {
        std::cerr << "expected websocket update payload\n";
        return EXIT_FAILURE;
    }

    return EXIT_SUCCESS;
}
