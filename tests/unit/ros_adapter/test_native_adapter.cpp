#include <cstdlib>
#include <iostream>

#include "ros_adapter/native_ros/NativeRosAdapter.h"

int main() {
    NativeRosAdapter adapter;
    if (adapter.mode_name() != "native_ros") {
        std::cerr << "expected native_ros mode name\n";
        return EXIT_FAILURE;
    }

    return EXIT_SUCCESS;
}
