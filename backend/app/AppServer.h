#ifndef FISHBOT_BACKEND_APP_APPSERVER_H_
#define FISHBOT_BACKEND_APP_APPSERVER_H_

#include <atomic>
#include <functional>
#include <memory>
#include <mutex>
#include <string>
#include <thread>
#include <unordered_map>
#include <vector>

#include <boost/asio/io_context.hpp>
#include <boost/asio/ip/tcp.hpp>

struct HttpResponse {
    int status = 404;
    std::string body;
    std::string content_type = "application/json";
};

class AppServer {
  public:
    using GetHandler = std::function<HttpResponse()>;
    using PostHandler = std::function<HttpResponse(const std::string& body)>;
    using WebsocketSend = std::function<void(const std::string&)>;

    struct WebsocketSession {
        std::vector<std::string> initial_messages;
        std::function<void()> on_close;
    };

    using WebsocketHandler = std::function<WebsocketSession(WebsocketSend send)>;

    ~AppServer();

    void register_get(const std::string& path, GetHandler handler);
    void register_post(const std::string& path, PostHandler handler);
    void register_websocket(const std::string& path, WebsocketHandler handler);
    void set_static_root(const std::string& static_root);
    bool start(unsigned short port);
    void stop();
    void wait();
    HttpResponse handle_get(const std::string& path) const;
    HttpResponse handle_post(const std::string& path, const std::string& body) const;

  private:
    void serve_loop(unsigned short port);

    std::unordered_map<std::string, GetHandler> get_handlers_;
    std::unordered_map<std::string, PostHandler> post_handlers_;
    std::unordered_map<std::string, WebsocketHandler> websocket_handlers_;
    std::string static_root_ = "frontend";
    std::atomic<bool> running_{false};
    unsigned short listen_port_ = 0;
    std::thread server_thread_;
    std::unique_ptr<boost::asio::io_context> io_context_;
    std::unique_ptr<boost::asio::ip::tcp::acceptor> acceptor_;
};

#endif
