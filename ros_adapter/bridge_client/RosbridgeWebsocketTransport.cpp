#include "ros_adapter/bridge_client/RosbridgeWebsocketTransport.h"

#include <chrono>
#include <sstream>
#include <utility>

#include <boost/asio/connect.hpp>
#include <boost/asio/ip/tcp.hpp>
#include <boost/beast/core/buffers_to_string.hpp>
#include <boost/beast/core/flat_buffer.hpp>

namespace {
namespace asio = boost::asio;
using tcp = asio::ip::tcp;

std::string json_escape(const std::string& value) {
    std::string escaped;
    escaped.reserve(value.size());
    for (const char ch : value) {
        switch (ch) {
            case '\\':
                escaped += "\\\\";
                break;
            case '"':
                escaped += "\\\"";
                break;
            case '\n':
                escaped += "\\n";
                break;
            case '\r':
                escaped += "\\r";
                break;
            case '\t':
                escaped += "\\t";
                break;
            default:
                escaped += ch;
                break;
        }
    }
    return escaped;
}

std::string extract_json_value(const std::string& payload, const std::string& key) {
    const auto token = std::string("\"") + key + "\":";
    const auto key_pos = payload.find(token);
    if (key_pos == std::string::npos) {
        return "";
    }

    std::size_t pos = key_pos + token.size();
    while (pos < payload.size() &&
           (payload[pos] == ' ' || payload[pos] == '\n' || payload[pos] == '\r' || payload[pos] == '\t')) {
        ++pos;
    }
    if (pos >= payload.size()) {
        return "";
    }

    if (payload[pos] == '"') {
        ++pos;
        std::string value;
        bool escaped = false;
        for (; pos < payload.size(); ++pos) {
            const char ch = payload[pos];
            if (escaped) {
                value += ch;
                escaped = false;
                continue;
            }
            if (ch == '\\') {
                escaped = true;
                continue;
            }
            if (ch == '"') {
                return value;
            }
            value += ch;
        }
        return value;
    }

    if (payload[pos] == '{' || payload[pos] == '[') {
        const char open = payload[pos];
        const char close = open == '{' ? '}' : ']';
        int depth = 0;
        bool in_string = false;
        bool escaped = false;
        const auto start = pos;
        for (; pos < payload.size(); ++pos) {
            const char ch = payload[pos];
            if (in_string) {
                if (escaped) {
                    escaped = false;
                } else if (ch == '\\') {
                    escaped = true;
                } else if (ch == '"') {
                    in_string = false;
                }
                continue;
            }

            if (ch == '"') {
                in_string = true;
                continue;
            }
            if (ch == open) {
                ++depth;
            } else if (ch == close) {
                --depth;
                if (depth == 0) {
                    return payload.substr(start, pos - start + 1);
                }
            }
        }
        return payload.substr(start);
    }

    const auto start = pos;
    while (pos < payload.size() && payload[pos] != ',' && payload[pos] != '}') {
        ++pos;
    }
    return payload.substr(start, pos - start);
}

bool extract_bool_value(const std::string& payload, const std::string& key, bool default_value) {
    const auto value = extract_json_value(payload, key);
    if (value == "true") {
        return true;
    }
    if (value == "false") {
        return false;
    }
    return default_value;
}
}  // namespace

RosbridgeWebsocketTransport::RosbridgeWebsocketTransport(std::string host, int port, std::string path)
    : host_(std::move(host)), port_(port), path_(std::move(path)) {}

RosbridgeWebsocketTransport::~RosbridgeWebsocketTransport() { disconnect(); }

bool RosbridgeWebsocketTransport::connect() {
    std::lock_guard<std::mutex> lock(connection_mutex_);
    if (connected_) {
        return true;
    }

    try {
        io_context_ = std::make_unique<asio::io_context>();
        tcp::resolver resolver(*io_context_);
        auto endpoints = resolver.resolve(host_, std::to_string(port_));

        {
            std::lock_guard<std::mutex> websocket_lock(websocket_mutex_);
            websocket_ = std::make_unique<WebsocketStream>(*io_context_);
            boost::beast::get_lowest_layer(*websocket_).connect(endpoints);
            websocket_->handshake(host_ + ":" + std::to_string(port_), path_);
            websocket_->text(true);
        }
        stop_requested_ = false;
        connected_ = true;
        worker_thread_ = std::thread([this]() { worker_loop(); });
        return true;
    } catch (const std::exception&) {
        websocket_.reset();
        io_context_.reset();
        connected_ = false;
        stop_requested_ = false;
        return false;
    }
}

void RosbridgeWebsocketTransport::disconnect() {
    {
        std::lock_guard<std::mutex> lock(connection_mutex_);
        if (!connected_ && websocket_ == nullptr) {
            return;
        }
    }

    {
        std::lock_guard<std::mutex> callback_lock(callback_mutex_);
        for (auto& item : pending_responses_) {
            auto& pending = item.second;
            {
                std::lock_guard<std::mutex> pending_lock(pending->mutex);
                pending->done = true;
                pending->ok = false;
            }
            pending->cv.notify_all();
        }
    }

    stop_requested_ = true;
    connected_ = false;
    queue_cv_.notify_all();

    if (worker_thread_.joinable()) {
        worker_thread_.join();
    }

    {
        std::lock_guard<std::mutex> websocket_lock(websocket_mutex_);
        if (websocket_ != nullptr) {
            boost::system::error_code ec;
            websocket_->close(boost::beast::websocket::close_code::normal, ec);
        }
    }

    std::lock_guard<std::mutex> lock(connection_mutex_);
    websocket_.reset();
    io_context_.reset();
}

bool RosbridgeWebsocketTransport::is_connected() const { return connected_; }

bool RosbridgeWebsocketTransport::publish(const std::string& topic, const std::string& type,
                                          const std::string& payload) {
    std::ostringstream frame;
    frame << "{\"op\":\"publish\",\"topic\":\"" << json_escape(topic) << "\"";
    if (!type.empty()) {
        frame << ",\"type\":\"" << json_escape(type) << "\"";
    }
    frame << ",\"msg\":" << payload << "}";
    return enqueue_frame(frame.str());
}

bool RosbridgeWebsocketTransport::call_service(const std::string& service, const std::string& type,
                                               const std::string& request, std::string* response) {
    if (!connected_) {
        return false;
    }

    const auto request_id = next_request_id();
    const auto pending = std::make_shared<PendingResponse>();
    {
        std::lock_guard<std::mutex> lock(callback_mutex_);
        pending_responses_[request_id] = pending;
    }

    std::ostringstream frame;
    frame << "{\"op\":\"call_service\",\"service\":\"" << json_escape(service) << "\"";
    if (!type.empty()) {
        frame << ",\"type\":\"" << json_escape(type) << "\"";
    }
    frame << ",\"args\":" << request << ",\"id\":\"" << request_id << "\"}";

    if (!enqueue_frame(frame.str())) {
        std::lock_guard<std::mutex> lock(callback_mutex_);
        pending_responses_.erase(request_id);
        return false;
    }

    std::unique_lock<std::mutex> lock(pending->mutex);
    if (!pending->cv.wait_for(lock, std::chrono::seconds(5), [&]() { return pending->done; })) {
        lock.unlock();
        std::lock_guard<std::mutex> callback_lock(callback_mutex_);
        pending_responses_.erase(request_id);
        return false;
    }

    if (response != nullptr) {
        *response = pending->payload;
    }
    const bool ok = pending->ok;
    lock.unlock();

    std::lock_guard<std::mutex> callback_lock(callback_mutex_);
    pending_responses_.erase(request_id);
    return ok;
}

bool RosbridgeWebsocketTransport::subscribe(const std::string& topic, const std::string& type,
                                            MessageCallback callback) {
    if (!connected_) {
        return false;
    }

    {
        std::lock_guard<std::mutex> lock(callback_mutex_);
        subscriptions_[topic] = std::move(callback);
    }

    std::ostringstream frame;
    frame << "{\"op\":\"subscribe\",\"topic\":\"" << json_escape(topic) << "\"";
    if (!type.empty()) {
        frame << ",\"type\":\"" << json_escape(type) << "\"";
    }
    frame << "}";
    return enqueue_frame(frame.str());
}

bool RosbridgeWebsocketTransport::enqueue_frame(const std::string& frame) {
    if (!connected_) {
        return false;
    }

    const auto outbound = std::make_shared<OutboundFrame>();
    outbound->payload = frame;
    {
        std::lock_guard<std::mutex> lock(queue_mutex_);
        outbound_frames_.push(outbound);
    }
    queue_cv_.notify_all();

    std::unique_lock<std::mutex> lock(outbound->mutex);
    if (!outbound->cv.wait_for(lock, std::chrono::seconds(2), [&]() { return outbound->done || !connected_; })) {
        return false;
    }
    return outbound->ok;
}

void RosbridgeWebsocketTransport::worker_loop() {
    while (!stop_requested_) {
        std::shared_ptr<OutboundFrame> outbound;
        {
            std::unique_lock<std::mutex> queue_lock(queue_mutex_);
            queue_cv_.wait_for(queue_lock, std::chrono::milliseconds(20), [&]() {
                return stop_requested_ || !outbound_frames_.empty();
            });
            if (!outbound_frames_.empty()) {
                outbound = outbound_frames_.front();
                outbound_frames_.pop();
            }
        }

        if (outbound != nullptr) {
            try {
                {
                    std::lock_guard<std::mutex> websocket_lock(websocket_mutex_);
                    websocket_->write(asio::buffer(outbound->payload));
                }
                {
                    std::lock_guard<std::mutex> lock(outbound->mutex);
                    outbound->done = true;
                    outbound->ok = true;
                }
                outbound->cv.notify_all();
            } catch (const std::exception&) {
                {
                    std::lock_guard<std::mutex> lock(outbound->mutex);
                    outbound->done = true;
                    outbound->ok = false;
                }
                outbound->cv.notify_all();
                stop_requested_ = true;
                connected_ = false;
                return;
            }
        }

        try {
            boost::system::error_code ec;
            std::size_t available = 0;
            {
                std::lock_guard<std::mutex> websocket_lock(websocket_mutex_);
                available = websocket_->next_layer().socket().available(ec);
            }
            if (ec) {
                stop_requested_ = true;
                connected_ = false;
                return;
            }
            if (available == 0) {
                continue;
            }

            boost::beast::flat_buffer buffer;
            {
                std::lock_guard<std::mutex> websocket_lock(websocket_mutex_);
                websocket_->read(buffer);
            }
            handle_incoming_message(boost::beast::buffers_to_string(buffer.data()));
        } catch (const std::exception&) {
            stop_requested_ = true;
            connected_ = false;
            return;
        }
    }
}

void RosbridgeWebsocketTransport::handle_incoming_message(const std::string& message) {
    const auto op = extract_json_value(message, "op");
    if (op == "publish") {
        const auto topic = extract_json_value(message, "topic");
        const auto payload = extract_json_value(message, "msg");
        MessageCallback callback;
        {
            std::lock_guard<std::mutex> lock(callback_mutex_);
            const auto it = subscriptions_.find(topic);
            if (it != subscriptions_.end()) {
                callback = it->second;
            }
        }
        if (callback) {
            callback(payload);
        }
        return;
    }

    if (op == "service_response") {
        const auto id = extract_json_value(message, "id");
        std::shared_ptr<PendingResponse> pending;
        {
            std::lock_guard<std::mutex> lock(callback_mutex_);
            const auto it = pending_responses_.find(id);
            if (it != pending_responses_.end()) {
                pending = it->second;
            }
        }
        if (pending != nullptr) {
            {
                std::lock_guard<std::mutex> lock(pending->mutex);
                pending->payload = extract_json_value(message, "values");
                pending->ok = extract_bool_value(message, "result", true);
                pending->done = true;
            }
            pending->cv.notify_all();
        }
    }
}

std::string RosbridgeWebsocketTransport::next_request_id() {
    return std::string("service-") + std::to_string(++request_counter_);
}
