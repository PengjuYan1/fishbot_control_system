#include <atomic>
#include <chrono>
#include <cstdlib>
#include <cstring>
#include <iostream>
#include <string>
#include <thread>
#include <vector>

#include <boost/asio.hpp>
#include <boost/beast/core.hpp>
#include <boost/beast/websocket.hpp>

#include "ros_adapter/bridge_client/RosbridgeWebsocketTransport.h"

namespace {
namespace asio = boost::asio;
namespace websocket = boost::beast::websocket;
using tcp = asio::ip::tcp;

class FakeRosbridgeServer {
  public:
    explicit FakeRosbridgeServer(unsigned short port)
        : ioc_(), acceptor_(ioc_, tcp::endpoint(tcp::v4(), port)) {}

    void start() {
        thread_ = std::thread([this]() { run(); });
    }

    void stop() {
        stop_requested_ = true;
        boost::system::error_code ignored;
        acceptor_.close(ignored);
        if (thread_.joinable()) {
            thread_.join();
        }
    }

    ~FakeRosbridgeServer() {
        stop();
    }

    const std::vector<std::string>& received_messages() const { return received_messages_; }

  private:
    void run() {
        try {
            tcp::socket socket(ioc_);
            acceptor_.accept(socket);
            websocket::stream<tcp::socket> ws(std::move(socket));
            ws.accept();

            while (!stop_requested_) {
                boost::beast::flat_buffer buffer;
                ws.read(buffer);
                const auto message = boost::beast::buffers_to_string(buffer.data());
                received_messages_.push_back(message);

                if (message.find("\"op\":\"subscribe\"") != std::string::npos &&
                    message.find("\"topic\":\"power_report\"") != std::string::npos) {
                    ws.write(asio::buffer(std::string(
                        "{\"op\":\"publish\",\"topic\":\"power_report\",\"msg\":{\"data\":67}}")));
                    continue;
                }

                if (message.find("\"op\":\"call_service\"") != std::string::npos &&
                    message.find("\"service\":\"navi_targegoalplan\"") != std::string::npos) {
                    const auto id_pos = message.find("\"id\":\"");
                    if (id_pos == std::string::npos) {
                        continue;
                    }
                    const auto id_begin = id_pos + std::strlen("\"id\":\"");
                    const auto id_end = message.find('"', id_begin);
                    const auto request_id = message.substr(id_begin, id_end - id_begin);
                    ws.write(asio::buffer(
                        std::string("{\"op\":\"service_response\",\"service\":\"navi_targegoalplan\",\"values\":{\"ok\":true,\"point_id\":12},\"result\":true,\"id\":\"") + request_id + "\"}"));
                    continue;
                }

                if (message.find("\"op\":\"publish\"") != std::string::npos &&
                    message.find("\"topic\":\"/navi_stop\"") != std::string::npos) {
                    stop_requested_ = true;
                }
            }
        } catch (const std::exception&) {
        }
    }

    asio::io_context ioc_;
    tcp::acceptor acceptor_;
    std::thread thread_;
    std::atomic<bool> stop_requested_{false};
    std::vector<std::string> received_messages_;
};

bool contains_message(const std::vector<std::string>& messages, const std::string& pattern) {
    for (const auto& message : messages) {
        if (message.find(pattern) != std::string::npos) {
            return true;
        }
    }
    return false;
}
}  // namespace

int main() {
    constexpr unsigned short port = 19090;
    FakeRosbridgeServer server(port);
    server.start();

    RosbridgeWebsocketTransport transport("127.0.0.1", port);
    if (!transport.connect()) {
        std::cerr << "expected websocket transport connect to succeed\n";
        return EXIT_FAILURE;
    }

    std::atomic<bool> callback_called{false};
    std::string battery_payload;
    if (!transport.subscribe("power_report", "std_msgs/Int16", [&](const std::string& payload) {
            callback_called = true;
            battery_payload = payload;
        })) {
        std::cerr << "expected subscribe to succeed\n";
        return EXIT_FAILURE;
    }

    for (int attempt = 0; attempt < 50 && !callback_called.load(); ++attempt) {
        std::this_thread::sleep_for(std::chrono::milliseconds(20));
    }

    if (!callback_called.load() || battery_payload.find("\"data\":67") == std::string::npos) {
        std::cerr << "expected subscribed publish frame to reach callback\n";
        return EXIT_FAILURE;
    }

    std::string service_response;
    if (!transport.call_service("navi_targegoalplan", "map_msgs/TargetGoalPlan", "{\"point_id\":12}", &service_response)) {
        std::cerr << "expected call_service to succeed\n";
        return EXIT_FAILURE;
    }

    if (service_response.find("\"point_id\":12") == std::string::npos) {
        std::cerr << "expected service response payload to be returned\n";
        return EXIT_FAILURE;
    }

    if (!transport.publish("/navi_stop", "std_msgs/Int16", "{\"data\":5}")) {
        std::cerr << "expected publish to succeed\n";
        return EXIT_FAILURE;
    }

    transport.disconnect();
    server.stop();

    const auto& messages = server.received_messages();
    if (!contains_message(messages, "\"op\":\"subscribe\"") ||
        !contains_message(messages, "\"topic\":\"power_report\"")) {
        std::cerr << "expected subscribe frame to be sent to rosbridge server\n";
        return EXIT_FAILURE;
    }

    if (!contains_message(messages, "\"op\":\"call_service\"") ||
        !contains_message(messages, "\"service\":\"navi_targegoalplan\"")) {
        std::cerr << "expected call_service frame to be sent to rosbridge server\n";
        return EXIT_FAILURE;
    }

    if (!contains_message(messages, "\"op\":\"publish\"") ||
        !contains_message(messages, "\"topic\":\"/navi_stop\"")) {
        std::cerr << "expected publish frame to be sent to rosbridge server\n";
        return EXIT_FAILURE;
    }

    return EXIT_SUCCESS;
}
