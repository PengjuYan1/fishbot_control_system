#include <cstdlib>
#include <iostream>
#include <string>

#include "backend/api/MapController.h"
#include "backend/app/AppServer.h"
#include "backend/services/MapService.h"
#include "ros_adapter/IRobotAdapter.h"

class FakeMapAdapter : public IRobotAdapter {
  public:
    std::string mode_name() const override { return "fake"; }
    bool connect() override { return true; }
    void disconnect() override {}
    bool is_connected() const override { return true; }
    bool start_mapping() override { started = true; return true; }
    bool stop_mapping() override { stopped = true; return true; }
    bool save_map(const std::string& map_name) override { saved_name = map_name; return true; }
    bool load_map(const std::string&) override { return true; }
    bool navigate_to_pose(const Pose&) override { return true; }
    bool stop_navigation() override { return true; }
    bool set_initial_pose(const Pose&) override { return true; }
    Pose get_robot_pose() const override { return {}; }
    int get_battery() const override { return 80; }
    RobotStatus get_robot_status() const override { return RobotStatus{80, false, true, true}; }
    MapSnapshot get_map_snapshot() const override { return {}; }
    bool is_charging() const override { return false; }

    bool started = false;
    bool stopped = false;
    std::string saved_name;
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

    return EXIT_SUCCESS;
}
