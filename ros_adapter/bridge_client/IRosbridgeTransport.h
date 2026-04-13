#ifndef FISHBOT_ROS_ADAPTER_BRIDGE_CLIENT_IROSBRIDGETRANSPORT_H_
#define FISHBOT_ROS_ADAPTER_BRIDGE_CLIENT_IROSBRIDGETRANSPORT_H_

#include <functional>
#include <string>

class IRosbridgeTransport {
  public:
    using MessageCallback = std::function<void(const std::string& payload)>;

    virtual ~IRosbridgeTransport() = default;
    virtual bool connect() = 0;
    virtual void disconnect() = 0;
    virtual bool is_connected() const = 0;
    virtual bool publish(const std::string& topic, const std::string& type, const std::string& payload) = 0;
    virtual bool call_service(const std::string& service, const std::string& type,
                              const std::string& request, std::string* response) = 0;
    virtual bool subscribe(const std::string& topic, const std::string& type, MessageCallback callback) = 0;
};

#endif
