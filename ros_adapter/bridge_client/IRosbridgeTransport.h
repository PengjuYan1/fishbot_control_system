#ifndef FISHBOT_ROS_ADAPTER_BRIDGE_CLIENT_IROSBRIDGETRANSPORT_H_
#define FISHBOT_ROS_ADAPTER_BRIDGE_CLIENT_IROSBRIDGETRANSPORT_H_

#include <string>

class IRosbridgeTransport {
  public:
    virtual ~IRosbridgeTransport() = default;
    virtual bool call_method(const std::string& method, const std::string& payload) = 0;
};

#endif
