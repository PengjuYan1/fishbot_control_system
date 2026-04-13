#include <cstdlib>
#include <iostream>

#include "backend/scheduler/BatteryWatcher.h"

int main() {
    BatteryWatcher watcher(25);

    if (!watcher.should_interrupt_for_charge(24)) {
        std::cerr << "expected charge interrupt below threshold\n";
        return EXIT_FAILURE;
    }

    if (watcher.should_interrupt_for_charge(30)) {
        std::cerr << "expected no charge interrupt above threshold\n";
        return EXIT_FAILURE;
    }

    return EXIT_SUCCESS;
}
