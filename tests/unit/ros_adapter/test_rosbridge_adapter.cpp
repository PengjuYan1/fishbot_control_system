#include <cstdlib>
#include <iostream>
#include <string>

#include "ros_adapter/bridge_client/IRosbridgeTransport.h"
#include "ros_adapter/bridge_client/RosbridgeAdapter.h"

class FakeRosbridgeTransport : public IRosbridgeTransport {
  public:
    bool call_method(const std::string& method, const std::string& payload) override {
        last_method_ = method;
        last_payload_ = payload;
        return true;
    }

    std::string last_method() const { return last_method_; }
    std::string last_payload() const { return last_payload_; }

  private:
    std::string last_method_;
    std::string last_payload_;
};

int main() {
    FakeRosbridgeTransport transport;
    RosbridgeAdapter adapter(&transport);

    if (!adapter.navigate_to_pose({1.0, 2.0, 0.5})) {
        std::cerr << "expected navigate_to_pose to succeed\n";
        return EXIT_FAILURE;
    }

    if (transport.last_method() != "navigate_to_pose") {
        std::cerr << "expected navigate_to_pose transport method\n";
        return EXIT_FAILURE;
    }

    return EXIT_SUCCESS;
}
