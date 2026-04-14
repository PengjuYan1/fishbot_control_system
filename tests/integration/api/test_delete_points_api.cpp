#include <cstdlib>
#include <iostream>
#include <string>

#include "backend/api/PointController.h"
#include "backend/app/AppServer.h"
#include "backend/services/PointService.h"
#include "ros_adapter/IRobotAdapter.h"
#include "storage/Database.h"
#include "storage/repositories/PointRepository.h"

class FakeDeletePointAdapter : public IRobotAdapter {
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
    Pose get_robot_pose() const override { return {}; }
    int get_battery() const override { return 100; }
    RobotStatus get_robot_status() const override { return RobotStatus{100, false, true, true}; }
    MapSnapshot get_map_snapshot() const override { return {}; }
    bool is_charging() const override { return false; }

    bool delete_saved_point(const PointRecord& point) override {
        delete_calls += 1;
        last_floor_id = point.floor_id;
        last_map_id = point.map_id;
        last_point_id = point.point_id;
        return allow_delete;
    }

    bool allow_delete = true;
    int delete_calls = 0;
    long last_floor_id = 0;
    long last_map_id = 0;
    long last_point_id = 0;
};

int main() {
    auto db = open_test_database();
    run_migrations(db);
    PointRepository repository(db);
    FakeDeletePointAdapter adapter;
    PointService service(repository, adapter);
    AppServer server;
    register_point_routes(server, service);

    PointRecord charge;
    charge.name = "C1";
    charge.type = "charge";
    charge.point_kind = "charge";
    charge.x = 1.0;
    charge.y = 2.0;
    charge.theta = 0.3;
    charge.floor_id = 11;
    charge.map_id = 22;
    charge.point_id = 33;
    const int native_point_id = repository.insert_point(charge);

    PointRecord local_only;
    local_only.name = "legacy_local";
    local_only.type = "feed";
    local_only.point_kind = "navigation";
    local_only.biz_role = "feed";
    const int local_only_id = repository.insert_point(local_only);

    const auto first_delete = server.handle_post("/api/points/delete", "id=" + std::to_string(native_point_id));
    if (first_delete.status != 200) {
        std::cerr << "expected successful native point delete\n";
        return EXIT_FAILURE;
    }
    if (adapter.delete_calls != 1 || adapter.last_floor_id != 11 || adapter.last_map_id != 22 || adapter.last_point_id != 33) {
        std::cerr << "expected delete route to call adapter with stored robot ids\n";
        return EXIT_FAILURE;
    }
    if (repository.list_points().size() != 1) {
        std::cerr << "expected native point deletion to remove local record\n";
        return EXIT_FAILURE;
    }

    const auto second_delete = server.handle_post("/api/points/delete", "id=" + std::to_string(local_only_id));
    if (second_delete.status != 200) {
        std::cerr << "expected local-only point delete to succeed\n";
        return EXIT_FAILURE;
    }
    if (adapter.delete_calls != 1) {
        std::cerr << "expected local-only point delete to skip native adapter call\n";
        return EXIT_FAILURE;
    }
    if (!repository.list_points().empty()) {
        std::cerr << "expected local-only point delete to remove remaining local record\n";
        return EXIT_FAILURE;
    }

    PointRecord failure_point;
    failure_point.name = "F9";
    failure_point.type = "feed";
    failure_point.point_kind = "navigation";
    failure_point.biz_role = "feed";
    failure_point.floor_id = 101;
    failure_point.map_id = 202;
    failure_point.point_id = 303;
    const int failure_id = repository.insert_point(failure_point);

    adapter.allow_delete = false;
    const auto failed_delete = server.handle_post("/api/points/delete", "id=" + std::to_string(failure_id));
    if (failed_delete.status != 500) {
        std::cerr << "expected native delete failure to return 500\n";
        return EXIT_FAILURE;
    }
    if (repository.list_points().size() != 1) {
        std::cerr << "expected failed native delete to keep local record\n";
        return EXIT_FAILURE;
    }

    return EXIT_SUCCESS;
}
