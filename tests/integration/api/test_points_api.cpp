#include <cstdlib>
#include <chrono>
#include <iostream>
#include <string>
#include <thread>

#include "backend/api/PointController.h"
#include "backend/app/AppServer.h"
#include "backend/services/PointService.h"
#include "ros_adapter/IRobotAdapter.h"
#include "storage/Database.h"
#include "storage/repositories/PointRepository.h"

class FakePointAdapter : public IRobotAdapter {
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
    bool list_native_points(std::vector<PointRecord>* points) override {
        if (points == nullptr) {
            return false;
        }
        *points = native_points;
        return true;
    }

    std::vector<PointRecord> native_points;
};

int main() {
    auto db = open_test_database();
    run_migrations(db);
    PointRepository repository(db);
    FakePointAdapter adapter;
    adapter.native_points.push_back(PointRecord{0, "C1", "charge", 1.0, 2.0, 0.0, 9, 19, 29});
    adapter.native_points.push_back(PointRecord{0, "I1", "initial", 1.1, 2.1, 0.1, 9, 19, 30});
    PointService service(repository, adapter);
    AppServer server;
    register_point_routes(server, service);

    const auto charge = server.handle_post(
        "/api/points/charge", "name=C1&x=1&y=2&theta=0&floor_id=9&map_id=19&point_id=29");
    const auto feed = server.handle_post(
        "/api/points/feed", "name=F1&x=3&y=4&theta=1&floor_id=10&map_id=20&point_id=30");

    if (charge.status != 200) {
        std::cerr << "expected successful charge point creation\n";
        return EXIT_FAILURE;
    }

    if (feed.status != 200) {
        std::cerr << "expected successful feed point creation\n";
        return EXIT_FAILURE;
    }

    auto list_response = server.handle_get("/api/points");
    std::vector<PointRecord> points;
    for (int retry = 0; retry < 50; ++retry) {
        points = repository.list_points();
        if (points.size() == 3) {
            break;
        }
        std::this_thread::sleep_for(std::chrono::milliseconds(10));
        list_response = server.handle_get("/api/points");
    }
    list_response = server.handle_get("/api/points");
    if (points.size() != 3) {
        std::cerr << "expected synced system points to merge into stored points\n";
        return EXIT_FAILURE;
    }

    bool saw_charge = false;
    bool saw_initial = false;
    bool saw_feed = false;
    for (const auto& point : points) {
        if (point.type == "charge") {
            saw_charge = true;
        } else if (point.type == "initial") {
            saw_initial = true;
        } else if (point.type == "feed") {
            saw_feed = true;
        }
    }
    if (!saw_charge || !saw_initial || !saw_feed) {
        std::cerr << "expected charge/initial/feed point types\n";
        return EXIT_FAILURE;
    }

    bool charge_ids_ok = false;
    bool feed_ids_ok = false;
    for (const auto& point : points) {
        if (point.type == "charge" && point.floor_id == 9 && point.map_id == 19 && point.point_id == 29) {
            charge_ids_ok = true;
        }
        if (point.type == "feed" && point.floor_id == 10 && point.map_id == 20 && point.point_id == 30) {
            feed_ids_ok = true;
        }
    }
    if (!charge_ids_ok) {
        std::cerr << "expected charge point robot ids to be stored\n";
        return EXIT_FAILURE;
    }

    if (!feed_ids_ok) {
        std::cerr << "expected feed point robot ids to be stored\n";
        return EXIT_FAILURE;
    }

    if (list_response.body.find("\"type\":\"initial\"") == std::string::npos ||
        list_response.body.find("\"floor_id\":10") == std::string::npos ||
        list_response.body.find("\"point_id\":30") == std::string::npos) {
        std::cerr << "expected point list api to expose robot ids\n";
        return EXIT_FAILURE;
    }

    return EXIT_SUCCESS;
}
