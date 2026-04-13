#include <chrono>
#include <cstdlib>
#include <iostream>
#include <string>
#include <thread>
#include <vector>

#include <boost/asio/connect.hpp>
#include <boost/asio/ip/tcp.hpp>
#include <boost/beast/core/flat_buffer.hpp>
#include <boost/beast/core/buffers_to_string.hpp>
#include <boost/beast/websocket.hpp>

#include "backend/app/AppServer.h"
#include "backend/runtime/StatusStreamService.h"
#include "backend/services/MapService.h"
#include "backend/services/SystemService.h"
#include "backend/websocket/StatusHub.h"
#include "ros_adapter/IRobotAdapter.h"

namespace {
namespace asio = boost::asio;
namespace websocket = boost::beast::websocket;
using tcp = asio::ip::tcp;

class FakeAdapter final : public IRobotAdapter {
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
    int get_battery() const override { return 76; }
    RobotStatus get_robot_status() const override { return RobotStatus{76, false, true, true}; }
    bool is_charging() const override { return false; }
    Pose get_robot_pose() const override { return Pose{3.0, 4.0, 0.2}; }
    MapSnapshot get_map_snapshot() const override {
        return MapSnapshot{4, 3, 0.05, {0, 100, -1, 0}, -1.0, -2.0};
    }
};

std::string websocket_read(websocket::stream<tcp::socket>& client) {
    boost::beast::flat_buffer buffer;
    client.read(buffer);
    return boost::beast::buffers_to_string(buffer.data());
}
}  // namespace

int main() {
    constexpr unsigned short port = 18083;

    FakeAdapter adapter;
    SystemService system_service(adapter, []() { return TaskSummary{"idle", ""}; });
    MapService map_service(adapter);
    StatusHub status_hub;
    StatusStreamService status_stream_service(system_service, map_service, status_hub);

    AppServer server;
    server.register_websocket("/ws/status", [&status_stream_service, &status_hub](AppServer::WebsocketSend send) {
        const auto subscription_id = status_hub.subscribe(std::move(send));
        return AppServer::WebsocketSession{
            status_stream_service.connect_client(),
            [&status_hub, subscription_id]() { status_hub.unsubscribe(subscription_id); },
        };
    });

    if (!server.start(port)) {
        std::cerr << "expected runtime websocket server to start\n";
        return EXIT_FAILURE;
    }

    std::this_thread::sleep_for(std::chrono::milliseconds(50));

    asio::io_context ioc;
    tcp::resolver resolver(ioc);
    websocket::stream<tcp::socket> client(ioc);
    auto endpoints = resolver.resolve("127.0.0.1", std::to_string(port));
    auto endpoint = asio::connect(client.next_layer(), endpoints);
    client.handshake("127.0.0.1:" + std::to_string(endpoint.port()), "/ws/status");

    const std::string initial_system = websocket_read(client);
    const std::string initial_map = websocket_read(client);
    if (initial_system.find("\"type\":\"system_snapshot\"") == std::string::npos ||
        initial_map.find("\"type\":\"map_snapshot\"") == std::string::npos) {
        std::cerr << "expected initial websocket status messages\n";
        return EXIT_FAILURE;
    }

    status_stream_service.poll_once();

    std::vector<std::string> updates = {
        websocket_read(client),
        websocket_read(client),
        websocket_read(client),
    };

    bool saw_pose = false;
    for (const auto& update : updates) {
        if (update.find("\"type\":\"robot_pose\"") != std::string::npos) {
            saw_pose = true;
        }
    }

    if (!saw_pose) {
        std::cerr << "expected robot_pose over websocket runtime stream\n";
        return EXIT_FAILURE;
    }

    client.close(websocket::close_code::normal);
    server.stop();
    return EXIT_SUCCESS;
}
