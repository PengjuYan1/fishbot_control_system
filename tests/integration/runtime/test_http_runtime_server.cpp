#include <cstdlib>
#include <iostream>
#include <string>
#include <thread>

#include <boost/asio/connect.hpp>
#include <boost/asio/ip/tcp.hpp>
#include <boost/beast/core/flat_buffer.hpp>
#include <boost/beast/http.hpp>

#include "backend/api/HealthController.h"
#include "backend/app/AppServer.h"

namespace {
namespace asio = boost::asio;
namespace http = boost::beast::http;
using tcp = asio::ip::tcp;

std::string http_get(const std::string& host, unsigned short port, const std::string& target) {
    asio::io_context ioc;
    tcp::resolver resolver(ioc);
    tcp::socket socket(ioc);
    auto endpoints = resolver.resolve(host, std::to_string(port));
    asio::connect(socket, endpoints);

    http::request<http::string_body> request{http::verb::get, target, 11};
    request.set(http::field::host, host);
    request.set(http::field::user_agent, "fishbot-test");
    http::write(socket, request);

    boost::beast::flat_buffer buffer;
    http::response<http::string_body> response;
    http::read(socket, buffer, response);
    return response.body();
}
}  // namespace

int main() {
    constexpr unsigned short port = 18081;
    AppServer server;
    AppConfig config;
    config.adapter_mode = "fake";
    register_health_routes(server, config);
    server.set_static_root("frontend");

    if (!server.start(port)) {
        std::cerr << "expected runtime http server to start\n";
        return EXIT_FAILURE;
    }

    std::this_thread::sleep_for(std::chrono::milliseconds(50));

    const auto health = http_get("127.0.0.1", port, "/api/health");
    if (health.find("\"status\":\"ok\"") == std::string::npos) {
        std::cerr << "expected /api/health over real http server\n";
        return EXIT_FAILURE;
    }

    const auto index = http_get("127.0.0.1", port, "/");
    if (index.find("Fishbot Dashboard") == std::string::npos) {
        std::cerr << "expected static frontend index to be served over http\n";
        return EXIT_FAILURE;
    }

    server.stop();
    return EXIT_SUCCESS;
}
