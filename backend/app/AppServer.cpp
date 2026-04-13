#include "backend/app/AppServer.h"

#include <fstream>
#include <chrono>
#include <filesystem>
#include <mutex>
#include <thread>
#include <utility>

#include <boost/asio/ip/address.hpp>
#include <boost/beast/core/flat_buffer.hpp>
#include <boost/beast/http.hpp>
#include <boost/beast/websocket.hpp>

namespace {
namespace asio = boost::asio;
namespace http = boost::beast::http;
namespace websocket = boost::beast::websocket;
using tcp = asio::ip::tcp;

struct WebsocketConnectionState {
    explicit WebsocketConnectionState(tcp::socket socket) : stream(std::move(socket)) {}

    websocket::stream<tcp::socket> stream;
    std::mutex write_mutex;
    bool open = true;
};

std::string strip_query(const std::string& target) {
    const auto query = target.find('?');
    return query == std::string::npos ? target : target.substr(0, query);
}

std::string content_type_for(const std::string& path) {
    const auto extension = std::filesystem::path(path).extension().string();
    if (extension == ".html") {
        return "text/html; charset=utf-8";
    }
    if (extension == ".css") {
        return "text/css; charset=utf-8";
    }
    if (extension == ".js") {
        return "application/javascript; charset=utf-8";
    }
    if (extension == ".json") {
        return "application/json";
    }
    return "text/plain; charset=utf-8";
}

std::string read_file_or_empty(const std::filesystem::path& path) {
    std::ifstream input(path, std::ios::binary);
    if (!input.is_open()) {
        return "";
    }
    return std::string((std::istreambuf_iterator<char>(input)), std::istreambuf_iterator<char>());
}
}  // namespace

AppServer::~AppServer() {
    stop();
}

void AppServer::register_get(const std::string& path, GetHandler handler) {
    get_handlers_[path] = std::move(handler);
}

void AppServer::register_post(const std::string& path, PostHandler handler) {
    post_handlers_[path] = std::move(handler);
}

void AppServer::register_websocket(const std::string& path, WebsocketHandler handler) {
    websocket_handlers_[path] = std::move(handler);
}

void AppServer::set_static_root(const std::string& static_root) {
    static_root_ = static_root;
}

bool AppServer::start(unsigned short port) {
    if (running_) {
        return true;
    }

    try {
        io_context_ = std::make_unique<asio::io_context>();
        acceptor_ = std::make_unique<tcp::acceptor>(*io_context_, tcp::endpoint(tcp::v4(), port));
        acceptor_->non_blocking(true);
        listen_port_ = port;
        running_ = true;
        server_thread_ = std::thread([this, port]() { serve_loop(port); });
        return true;
    } catch (const std::exception&) {
        running_ = false;
        acceptor_.reset();
        io_context_.reset();
        return false;
    }
}

void AppServer::stop() {
    running_ = false;
    if (acceptor_ != nullptr) {
        boost::system::error_code ec;
        acceptor_->close(ec);
    }
    if (io_context_ != nullptr) {
        io_context_->stop();
    }
    if (server_thread_.joinable()) {
        server_thread_.join();
    }
    acceptor_.reset();
    io_context_.reset();
    listen_port_ = 0;
}

void AppServer::wait() {
    if (server_thread_.joinable()) {
        server_thread_.join();
    }
}

HttpResponse AppServer::handle_get(const std::string& path) const {
    const auto it = get_handlers_.find(path);
    if (it == get_handlers_.end()) {
        return HttpResponse{404, "{\"error\":\"not_found\"}", "application/json"};
    }

    return it->second();
}

HttpResponse AppServer::handle_post(const std::string& path, const std::string& body) const {
    const auto it = post_handlers_.find(path);
    if (it == post_handlers_.end()) {
        return HttpResponse{404, "{\"error\":\"not_found\"}", "application/json"};
    }

    return it->second(body);
}

void AppServer::serve_loop(unsigned short) {
    while (running_ && acceptor_ != nullptr) {
        boost::system::error_code accept_ec;
        tcp::socket socket(*io_context_);
        acceptor_->accept(socket, accept_ec);
        if (accept_ec) {
            if (accept_ec == asio::error::would_block || accept_ec == asio::error::try_again) {
                std::this_thread::sleep_for(std::chrono::milliseconds(20));
                continue;
            }
            if (!running_) {
                break;
            }
            continue;
        }

        boost::beast::flat_buffer buffer;
        http::request<http::string_body> request;
        boost::system::error_code read_ec;
        http::read(socket, buffer, request, read_ec);
        if (read_ec) {
            continue;
        }

        const auto target = strip_query(request.target().to_string());
        if (websocket::is_upgrade(request)) {
            const auto it = websocket_handlers_.find(target);
            if (it == websocket_handlers_.end()) {
                continue;
            }

            auto handler = it->second;
            std::thread([handler = std::move(handler),
                         request = std::move(request),
                         socket = std::move(socket)]() mutable {
                auto connection = std::make_shared<WebsocketConnectionState>(std::move(socket));
                boost::system::error_code accept_ec;
                connection->stream.accept(request, accept_ec);
                if (accept_ec) {
                    return;
                }

                const auto send =
                    [weak_connection = std::weak_ptr<WebsocketConnectionState>(connection)](
                        const std::string& message) {
                        const auto locked = weak_connection.lock();
                        if (locked == nullptr) {
                            return;
                        }

                        std::lock_guard<std::mutex> lock(locked->write_mutex);
                        if (!locked->open) {
                            return;
                        }

                        boost::system::error_code write_ec;
                        locked->stream.write(asio::buffer(message), write_ec);
                        if (write_ec) {
                            locked->open = false;
                        }
                    };

                auto session = handler(send);
                for (const auto& message : session.initial_messages) {
                    send(message);
                }

                boost::beast::flat_buffer websocket_buffer;
                for (;;) {
                    boost::system::error_code ws_read_ec;
                    connection->stream.read(websocket_buffer, ws_read_ec);
                    if (ws_read_ec) {
                        break;
                    }
                    websocket_buffer.consume(websocket_buffer.size());
                }

                {
                    std::lock_guard<std::mutex> lock(connection->write_mutex);
                    connection->open = false;
                }
                if (session.on_close) {
                    session.on_close();
                }
            }).detach();
            continue;
        }

        HttpResponse app_response;
        if (request.method() == http::verb::get && target.rfind("/api/", 0) == 0) {
            app_response = handle_get(target);
        } else if (request.method() == http::verb::post && target.rfind("/api/", 0) == 0) {
            app_response = handle_post(target, request.body());
        } else {
            std::string relative = target.empty() || target == "/" ? "/index.html" : target;
            if (!relative.empty() && relative.front() == '/') {
                relative.erase(0, 1);
            }

            const auto path = std::filesystem::path(static_root_) / relative;
            const auto body = read_file_or_empty(path);
            if (body.empty()) {
                app_response = HttpResponse{404, "not found", "text/plain; charset=utf-8"};
            } else {
                app_response = HttpResponse{200, body, content_type_for(path.string())};
            }
        }

        http::response<http::string_body> response{
            static_cast<http::status>(app_response.status), request.version()};
        response.set(http::field::server, "fishbot");
        response.set(http::field::content_type, app_response.content_type);
        response.keep_alive(false);
        response.body() = app_response.body;
        response.prepare_payload();

        boost::system::error_code write_ec;
        http::write(socket, response, write_ec);
        boost::system::error_code shutdown_ec;
        socket.shutdown(tcp::socket::shutdown_send, shutdown_ec);
    }
}
