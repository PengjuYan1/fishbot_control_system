#include <cstdlib>
#include <iostream>

#include "backend/app/Config.h"

int main() {
    const auto cfg = load_config("config/app.example.yaml");

    if (cfg.adapter_mode != "rosbridge") {
        std::cerr << "expected adapter_mode to be rosbridge\n";
        return EXIT_FAILURE;
    }

    if (cfg.battery_return_threshold != 25) {
        std::cerr << "expected battery_return_threshold to equal 25\n";
        return EXIT_FAILURE;
    }

    return EXIT_SUCCESS;
}
