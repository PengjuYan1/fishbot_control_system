#include <chrono>
#include <cstdlib>
#include <iostream>
#include <string>
#include <thread>

#include "ros_adapter/bridge_client/RosbridgeAdapter.h"
#include "ros_adapter/bridge_client/RosbridgeWebsocketTransport.h"

namespace {
void print_usage() {
    std::cerr << "usage: fishbot_rosbridge_probe <host> <port> [wait_ms]\n";
}

std::string bool_json(bool value) {
    return value ? "true" : "false";
}
}  // namespace

int main(int argc, char** argv) {
    if (argc < 3 || argc > 4) {
        print_usage();
        return EXIT_FAILURE;
    }

    const std::string host = argv[1];
    const int port = std::atoi(argv[2]);
    const int wait_ms = argc >= 4 ? std::atoi(argv[3]) : 1500;
    if (host.empty() || port <= 0 || wait_ms < 0) {
        print_usage();
        return EXIT_FAILURE;
    }

    RosbridgeWebsocketTransport transport(host, port);
    RosbridgeAdapter adapter(&transport);
    if (!adapter.connect()) {
        std::cerr << "failed to connect rosbridge at " << host << ":" << port << "\n";
        return EXIT_FAILURE;
    }

    std::this_thread::sleep_for(std::chrono::milliseconds(wait_ms));

    const auto status = adapter.get_robot_status();
    const auto pose = adapter.get_robot_pose();
    const auto map = adapter.get_map_snapshot();

    std::cout << "{"
              << "\"host\":\"" << host << "\","
              << "\"port\":" << port << ","
              << "\"connected\":" << bool_json(adapter.is_connected()) << ","
              << "\"battery\":" << adapter.get_battery() << ","
              << "\"localized\":" << bool_json(status.localized) << ","
              << "\"charging\":" << bool_json(adapter.is_charging()) << ","
              << "\"pose\":{"
              << "\"x\":" << pose.x << ","
              << "\"y\":" << pose.y << ","
              << "\"theta\":" << pose.theta
              << "},"
              << "\"map\":{"
              << "\"width\":" << map.width << ","
              << "\"height\":" << map.height << ","
              << "\"resolution\":" << map.resolution << ","
              << "\"origin_x\":" << map.origin_x << ","
              << "\"origin_y\":" << map.origin_y
              << "}"
              << "}\n";

    adapter.disconnect();
    return EXIT_SUCCESS;
}
