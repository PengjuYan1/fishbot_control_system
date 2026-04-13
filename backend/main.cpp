#include <iostream>
#include <string>

#include "backend/bootstrap.h"

int main(int argc, char** argv) {
    const std::string config_path = argc > 1 ? argv[1] : "config/app.example.yaml";

    if (!start_app_with_config(config_path)) {
        std::cerr << "failed to bootstrap with config: " << config_path << '\n';
        return 1;
    }

    std::cout << "fishbot app bootstrap ok\n";
    return 0;
}
