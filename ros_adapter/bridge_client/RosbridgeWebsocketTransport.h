#ifndef FISHBOT_ROS_ADAPTER_BRIDGE_CLIENT_ROSBRIDGEWEBSOCKETTRANSPORT_H_
#define FISHBOT_ROS_ADAPTER_BRIDGE_CLIENT_ROSBRIDGEWEBSOCKETTRANSPORT_H_

#include <atomic>
#include <condition_variable>
#include <cstdint>
#include <memory>
#include <mutex>
#include <queue>
#include <string>
#include <thread>
#include <unordered_map>

#include <boost/asio/io_context.hpp>
#include <boost/beast/core/tcp_stream.hpp>
#include <boost/beast/websocket.hpp>

#include "ros_adapter/bridge_client/IRosbridgeTransport.h"

class RosbridgeWebsocketTransport : public IRosbridgeTransport {
  public:
    RosbridgeWebsocketTransport(std::string host, int port, std::string path = "/");
    ~RosbridgeWebsocketTransport() override;

    bool connect() override;
    void disconnect() override;
    bool is_connected() const override;
    bool publish(const std::string& topic, const std::string& type, const std::string& payload) override;
    bool call_service(const std::string& service, const std::string& type,
                      const std::string& request, std::string* response) override;
    bool subscribe(const std::string& topic, const std::string& type, MessageCallback callback) override;

  private:
    struct PendingResponse {
        std::mutex mutex;
        std::condition_variable cv;
        bool done = false;
        bool ok = false;
        std::string payload;
    };

    struct OutboundFrame {
        std::mutex mutex;
        std::condition_variable cv;
        std::string payload;
        bool done = false;
        bool ok = false;
    };

    using WebsocketStream = boost::beast::websocket::stream<boost::beast::tcp_stream>;

    bool enqueue_frame(const std::string& frame);
    void worker_loop();
    void handle_incoming_message(const std::string& message);
    std::string next_request_id();

    std::string host_;
    int port_;
    std::string path_;
    std::unique_ptr<boost::asio::io_context> io_context_;
    std::unique_ptr<WebsocketStream> websocket_;
    std::thread worker_thread_;
    std::atomic<bool> connected_{false};
    std::atomic<bool> stop_requested_{false};
    std::atomic<std::uint64_t> request_counter_{0};

    mutable std::mutex connection_mutex_;
    std::mutex websocket_mutex_;
    std::mutex queue_mutex_;
    std::condition_variable queue_cv_;
    std::queue<std::shared_ptr<OutboundFrame>> outbound_frames_;

    std::mutex callback_mutex_;
    std::unordered_map<std::string, MessageCallback> subscriptions_;
    std::unordered_map<std::string, std::shared_ptr<PendingResponse>> pending_responses_;
};

#endif
