#include <cstdlib>
#include <iostream>

#include "backend/state_machine/TaskStateMachine.h"

int main() {
    TaskStateMachine machine;
    machine.start_run();
    machine.on_navigation_started();
    machine.on_arrived_at_feed_point();

    if (machine.current_state() != TaskState::FeedingPause) {
        std::cerr << "expected transition into FeedingPause\n";
        return EXIT_FAILURE;
    }

    return EXIT_SUCCESS;
}
