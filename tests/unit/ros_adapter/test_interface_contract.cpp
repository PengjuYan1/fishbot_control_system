#include <algorithm>
#include <cstdlib>
#include <iostream>
#include <string>
#include <vector>

#include "ros_adapter/IRobotAdapter.h"

namespace {
bool contains(const std::vector<std::string>& values, const std::string& target) {
    return std::find(values.begin(), values.end(), target) != values.end();
}
}  // namespace

int main() {
    const auto capabilities = describe_adapter_contract();

    if (!contains(capabilities, "navigate_to_pose")) {
        std::cerr << "expected navigate_to_pose capability\n";
        return EXIT_FAILURE;
    }

    if (!contains(capabilities, "get_battery")) {
        std::cerr << "expected get_battery capability\n";
        return EXIT_FAILURE;
    }

    if (!contains(capabilities, "start_mapping")) {
        std::cerr << "expected start_mapping capability\n";
        return EXIT_FAILURE;
    }

    if (!contains(capabilities, "out_of_charge")) {
        std::cerr << "expected out_of_charge capability\n";
        return EXIT_FAILURE;
    }

    if (!contains(capabilities, "manual_move")) {
        std::cerr << "expected manual_move capability\n";
        return EXIT_FAILURE;
    }

    return EXIT_SUCCESS;
}
