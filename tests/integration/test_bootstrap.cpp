#include <cstdlib>
#include <iostream>

#include "backend/bootstrap.h"

int main() {
    if (!start_app_with_config("config/app.example.yaml")) {
        std::cerr << "expected app bootstrap with example config to succeed\n";
        return EXIT_FAILURE;
    }

    return EXIT_SUCCESS;
}
