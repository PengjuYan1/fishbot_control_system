#include <cstdlib>
#include <iostream>

#include "ros_adapter/native_ros/NativeRosAdapter.h"

int main() {
    NativeRosAdapter adapter;
    if (adapter.mode_name() != "native_ros") {
        std::cerr << "expected native_ros mode name\n";
        return EXIT_FAILURE;
    }

    const auto acquire = adapter.acquire_manual_control();
    if (acquire.ok || acquire.state != ManualControlAcquireState::kFailed) {
        std::cerr << "expected disconnected native adapter takeover to fail\n";
        return EXIT_FAILURE;
    }

    return EXIT_SUCCESS;
}
