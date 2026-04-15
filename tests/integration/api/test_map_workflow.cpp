#include <cstdlib>
#include <chrono>
#include <iostream>
#include <string>
#include <thread>

#include "backend/api/MapController.h"
#include "backend/app/AppServer.h"
#include "backend/model/SystemSnapshot.h"
#include "backend/services/MapService.h"
#include "ros_adapter/IRobotAdapter.h"
#include "storage/Database.h"
#include "storage/repositories/PointRepository.h"

class FakeMapAdapter : public IRobotAdapter {
  public:
    std::string mode_name() const override { return "fake"; }
    bool connect() override { return true; }
    void disconnect() override {}
    bool is_connected() const override { return true; }
    bool start_mapping() override { started = true; return true; }
    bool stop_mapping() override { stopped = true; return true; }
    bool save_map(const std::string& map_name) override { saved_name = map_name; return true; }
    bool load_map(const std::string& selector) override {
        loaded_selector = selector;
        return true;
    }
    bool navigate_to_pose(const Pose&) override { return true; }
    bool stop_navigation() override { return true; }
    bool set_initial_pose(const Pose&) override { return true; }
    ManualControlAcquireResult acquire_manual_control() override {
        return ManualControlAcquireResult{true, ManualControlAcquireState::kReady};
    }
    bool out_of_charge() override { return true; }
    bool manual_move(double, double) override { return true; }
    Pose get_robot_pose() const override { return Pose{1.5, 2.5, 0.4}; }
    int get_battery() const override { return 80; }
    RobotStatus get_robot_status() const override { return RobotStatus{80, false, true, true}; }
    MapSnapshot get_map_snapshot() const override { return MapSnapshot{4, 3, 0.05, {0, 100, -1, 0}, -1.0, -2.0}; }
    bool is_charging() const override { return false; }
    bool create_current_pose_point(const std::string& name, long point_mode, PointRecord* point) override {
        ++create_current_pose_point_count;
        last_created_name = name;
        last_point_mode = point_mode;
        if (point != nullptr) {
            point->name = name;
            point->x = 1.5;
            point->y = 2.5;
            point->theta = 0.4;
            point->floor_id = 1;
            point->map_id = 11;
            point->point_id = point_mode == 1 ? 101 : 0;
        }
        return true;
    }
    bool list_native_points(std::vector<PointRecord>* points) override {
        if (points == nullptr) {
            return false;
        }
        *points = native_points;
        return true;
    }
    bool list_maps(std::vector<MapDescriptor>* maps) override {
        if (maps == nullptr) {
            return false;
        }
        *maps = {
            MapDescriptor{1, "F1", 11, "default_map", 1, 11, 101, 102, true, true},
        };
        return true;
    }
    bool delete_map(long floor_id, long map_id) override {
        deleted_floor = floor_id;
        deleted_map = map_id;
        return true;
    }

    bool started = false;
    bool stopped = false;
    std::string saved_name;
    long deleted_floor = 0;
    long deleted_map = 0;
    std::string loaded_selector;
    int create_current_pose_point_count = 0;
    long last_point_mode = -1;
    std::string last_created_name;
    std::vector<PointRecord> native_points;
};

int main() {
    FakeMapAdapter adapter;
    MapService service(adapter);
    AppServer server;
    register_map_routes(server, service);

    const auto start_response = server.handle_post("/api/map/start-mapping", "");
    if (start_response.status != 200 || !adapter.started) {
        std::cerr << "expected successful start-mapping response\n";
        return EXIT_FAILURE;
    }

    const auto stop_response = server.handle_post("/api/map/stop-mapping", "");
    if (stop_response.status != 200 || !adapter.stopped) {
        std::cerr << "expected successful stop-mapping response\n";
        return EXIT_FAILURE;
    }

    const auto save_response = server.handle_post("/api/map/save", "pond_a");
    if (save_response.status != 200 || adapter.saved_name != "pond_a") {
        std::cerr << "expected successful save-map response\n";
        return EXIT_FAILURE;
    }

    const auto load_response = server.handle_post("/api/map/load", "floor_id=1&map_id=11");
    if (load_response.status != 200 || adapter.loaded_selector != "1:11") {
        std::cerr << "expected successful map-load response\n";
        return EXIT_FAILURE;
    }

    const auto snapshot_response = server.handle_get("/api/map/snapshot");
    if (snapshot_response.status != 200) {
        std::cerr << "expected successful map-snapshot response\n";
        return EXIT_FAILURE;
    }

    if (snapshot_response.body.find("\"width\":4") == std::string::npos ||
        snapshot_response.body.find("\"origin_x\":-1.000000") == std::string::npos ||
        snapshot_response.body.find("\"occupancy_data\":[0,100,-1,0]") == std::string::npos) {
        std::cerr << "expected map snapshot payload from adapter\n";
        return EXIT_FAILURE;
    }

    const auto maps_response = server.handle_get("/api/maps");
    if (maps_response.status != 200 ||
        maps_response.body.find("\"map_name\":\"default_map\"") == std::string::npos ||
        maps_response.body.find("\"charge_id\":101") == std::string::npos) {
        std::cerr << "expected map list payload\n";
        return EXIT_FAILURE;
    }

    const auto delete_map_response = server.handle_post("/api/maps/delete", "floor_id=1&map_id=11");
    if (delete_map_response.status != 200 ||
        adapter.deleted_floor != 1 ||
        adapter.deleted_map != 11 ||
        delete_map_response.body.find("\"status\":\"deleted\"") == std::string::npos) {
        std::cerr << "expected successful delete-map response\n";
        return EXIT_FAILURE;
    }

    auto point_db = open_test_database();
    run_migrations(point_db);
    PointRepository point_repository(point_db);
    MapService seeded_service(adapter, &point_repository);

    if (!seeded_service.start_mapping()) {
        std::cerr << "expected mapping to start for auto-seed test\n";
        return EXIT_FAILURE;
    }

    SystemSnapshot snapshot;
    snapshot.charging = true;
    snapshot.control.charge_status_code = 47;
    seeded_service.observe_system_snapshot(snapshot);

    std::vector<PointRecord> points;
    for (int retry = 0; retry < 50; ++retry) {
        points = point_repository.list_points();
        if (points.size() >= 2) {
            break;
        }
        std::this_thread::sleep_for(std::chrono::milliseconds(20));
    }

    if (adapter.create_current_pose_point_count != 1 || adapter.last_point_mode != 1) {
        std::cerr << "expected charging during mapping to auto-create one charge point\n";
        return EXIT_FAILURE;
    }

    bool saw_charge = false;
    bool saw_initial = false;
    for (const auto& point : points) {
        if (point.type == "charge") {
            saw_charge = true;
        } else if (point.type == "initial") {
            saw_initial = true;
        }
    }
    if (!saw_charge || !saw_initial) {
        std::cerr << "expected auto-seed to create charge and initial points\n";
        return EXIT_FAILURE;
    }

    return EXIT_SUCCESS;
}
