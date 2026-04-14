#include <cstdlib>
#include <iostream>
#include <string>

#include "backend/api/PointController.h"
#include "backend/app/AppServer.h"
#include "backend/services/PointService.h"
#include "ros_adapter/IRobotAdapter.h"
#include "storage/Database.h"
#include "storage/repositories/PointRepository.h"

class FakeCurrentPointAdapter : public IRobotAdapter {
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
    bool out_of_charge() override { return true; }
    bool manual_move(double, double) override { return true; }
    Pose get_robot_pose() const override {
        Pose pose;
        pose.x = 4.2;
        pose.y = 8.4;
        pose.theta = 1.57;
        return pose;
    }
    int get_battery() const override { return 88; }
    RobotStatus get_robot_status() const override { return RobotStatus{88, false, true, true}; }
    MapSnapshot get_map_snapshot() const override { return {}; }
    bool is_charging() const override { return false; }

    bool create_current_pose_point(const std::string& name, long point_mode, PointRecord* point) override {
        requested_name = name;
        requested_mode = point_mode;
        if (!allow_create) {
            return false;
        }
        if (point == nullptr) {
            return false;
        }
        point->name = name;
        point->x = 4.2;
        point->y = 8.4;
        point->theta = 1.57;
        point->floor_id = 101;
        point->map_id = 202;
        point->point_id = point_mode == 1 ? 301 : 302;
        return true;
    }

    bool allow_create = true;
    std::string requested_name;
    long requested_mode = -1;
};

int main() {
    auto db = open_test_database();
    run_migrations(db);
    PointRepository repository(db);
    FakeCurrentPointAdapter adapter;
    PointService service(repository, adapter);
    AppServer server;
    register_point_routes(server, service);

    const auto charge = server.handle_post("/api/points/charge/current", "");
    if (charge.status != 200) {
        std::cerr << "expected successful current charge point creation\n";
        return EXIT_FAILURE;
    }
    if (adapter.requested_name != "C1" || adapter.requested_mode != 1) {
        std::cerr << "expected charge point to use automatic naming and charge mode\n";
        return EXIT_FAILURE;
    }

    const auto feed = server.handle_post("/api/points/feed/current", "");
    if (feed.status != 200) {
        std::cerr << "expected successful current feed point creation\n";
        return EXIT_FAILURE;
    }
    if (adapter.requested_name != "F1" || adapter.requested_mode != 0) {
        std::cerr << "expected feed point to use automatic naming and feed mode\n";
        return EXIT_FAILURE;
    }

    const auto points = repository.list_points();
    if (points.size() != 2) {
        std::cerr << "expected current pose routes to persist two points\n";
        return EXIT_FAILURE;
    }
    if (points[0].floor_id != 101 || points[0].map_id != 202 || points[0].point_id != 301) {
        std::cerr << "expected charge point to persist adapter returned ids\n";
        return EXIT_FAILURE;
    }
    if (points[1].floor_id != 101 || points[1].map_id != 202 || points[1].point_id != 302) {
        std::cerr << "expected feed point to persist adapter returned ids\n";
        return EXIT_FAILURE;
    }

    adapter.allow_create = false;
    const auto failure = server.handle_post("/api/points/feed/current", "");
    if (failure.status != 500) {
        std::cerr << "expected failed current pose point creation to return 500\n";
        return EXIT_FAILURE;
    }
    if (repository.list_points().size() != 2) {
        std::cerr << "expected failed current pose creation to avoid persisting partial point data\n";
        return EXIT_FAILURE;
    }

    return EXIT_SUCCESS;
}
