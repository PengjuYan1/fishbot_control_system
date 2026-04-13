#include <atomic>
#include <chrono>
#include <cstdlib>
#include <fstream>
#include <iostream>
#include <mutex>
#include <string>
#include <thread>
#include <vector>

#include <boost/asio.hpp>
#include <boost/beast/core.hpp>
#include <boost/beast/websocket.hpp>

#include "backend/app/AppContext.h"

namespace {
namespace asio = boost::asio;
namespace websocket = boost::beast::websocket;
using tcp = asio::ip::tcp;

class FakeRosbridgeServer {
  public:
    explicit FakeRosbridgeServer(unsigned short port)
        : ioc_(), acceptor_(ioc_, tcp::endpoint(tcp::v4(), port)) {}

    unsigned short port() const {
        return acceptor_.local_endpoint().port();
    }

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

    ~FakeRosbridgeServer() { stop(); }

    bool saw_subscribe(const std::string& topic) const {
        std::lock_guard<std::mutex> lock(messages_mutex_);
        for (const auto& message : received_messages_) {
            if (message.find("\"op\":\"subscribe\"") != std::string::npos &&
                message.find("\"topic\":\"" + topic + "\"") != std::string::npos) {
                return true;
            }
        }
        return false;
    }

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
                {
                    std::lock_guard<std::mutex> lock(messages_mutex_);
                    received_messages_.push_back(message);
                }

                if (message.find("\"op\":\"subscribe\"") != std::string::npos) {
                    continue;
                }
            }
        } catch (const std::exception&) {
        }
    }

    asio::io_context ioc_;
    tcp::acceptor acceptor_;
    std::thread thread_;
    std::atomic<bool> stop_requested_{false};
    mutable std::mutex messages_mutex_;
    std::vector<std::string> received_messages_;
};
}  // namespace

int main() {
    const std::string config_path = "tests/tmp_app_context_rosbridge.yaml";
    FakeRosbridgeServer server(0);
    server.start();

    {
        std::ofstream output(config_path);
        output << "adapter_mode: rosbridge\n";
        output << "rosbridge_host: 127.0.0.1\n";
        output << "rosbridge_port: " << server.port() << "\n";
        output << "battery_return_threshold: 25\n";
        output << "battery_start_threshold: 35\n";
        output << "feed_pause_seconds: 20\n";
        output << "resume_after_charge: true\n";
        output << "finish_action: return_to_charge\n";
    }

    auto context = build_app_context(config_path);
    if (!context.adapter) {
        std::cerr << "expected build_app_context to create a robot adapter\n";
        return EXIT_FAILURE;
    }

    if (context.adapter->mode_name() != "rosbridge") {
        std::cerr << "expected rosbridge mode adapter to be wired into app context\n";
        return EXIT_FAILURE;
    }

    if (!context.adapter->connect()) {
        std::cerr << "expected app context adapter to connect through websocket transport\n";
        return EXIT_FAILURE;
    }

    for (int attempt = 0; attempt < 50 && !server.saw_subscribe("power_report"); ++attempt) {
        std::this_thread::sleep_for(std::chrono::milliseconds(20));
    }

    context.adapter->disconnect();
    server.stop();
    std::remove(config_path.c_str());

    if (!server.saw_subscribe("power_report")) {
        std::cerr << "expected rosbridge adapter from app context to subscribe status topics\n";
        return EXIT_FAILURE;
    }

    return EXIT_SUCCESS;
}
