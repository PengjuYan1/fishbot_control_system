#include <cstdlib>
#include <chrono>
#include <iostream>
#include <string>
#include <thread>
#include <vector>

#include "backend/runtime/StatusStreamService.h"
#include "backend/services/MapService.h"
#include "backend/services/SystemService.h"
#include "ros_adapter/IRobotAdapter.h"

class FakeStreamAdapter : public IRobotAdapter {
  public:
    std::string mode_name() const override { return "rosbridge"; }
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
    Pose get_robot_pose() const override { return Pose{2.0, 3.0, 0.4}; }
    int get_battery() const override { return 76; }
    RobotStatus get_robot_status() const override { return RobotStatus{76, false, true, true}; }
    MapSnapshot get_map_snapshot() const override { return MapSnapshot{4, 3, 0.05, {0, 100, -1, 0}, -1.0, -2.0}; }
    bool is_charging() const override { return false; }
};

int main() {
    FakeStreamAdapter adapter;
    SystemService system_service(adapter, []() {
        return TaskSummary{"running", "F1"};
    });
    MapService map_service(adapter);
    StatusHub hub;
    StatusStreamService stream_service(system_service, map_service, hub);

    const auto initial_messages = stream_service.connect_client();
    if (initial_messages.size() != 2 ||
        initial_messages[0].find("\"type\":\"system_snapshot\"") == std::string::npos ||
        initial_messages[1].find("\"type\":\"map_snapshot\"") == std::string::npos) {
        std::cerr << "expected initial websocket connect payloads\n";
        return EXIT_FAILURE;
    }

    std::vector<std::string> published;
    stream_service.subscribe([&published](const std::string& message) {
        published.push_back(message);
    });

    stream_service.start(std::chrono::milliseconds(10));
    std::this_thread::sleep_for(std::chrono::milliseconds(35));
    stream_service.stop();

    if (published.size() < 3) {
        std::cerr << "expected background stream loop to publish status messages\n";
        return EXIT_FAILURE;
    }

    if (published[0].find("\"type\":\"system_snapshot\"") == std::string::npos ||
        published[1].find("\"type\":\"map_snapshot\"") == std::string::npos ||
        published[2].find("\"type\":\"robot_pose\"") == std::string::npos) {
        std::cerr << "expected system/map/pose push order\n";
        return EXIT_FAILURE;
    }

    return EXIT_SUCCESS;
}
