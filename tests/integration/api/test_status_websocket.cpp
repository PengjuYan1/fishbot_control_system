#include <cstdlib>
#include <iostream>
#include <string>

#include "backend/model/SystemSnapshot.h"
#include "backend/websocket/StatusHub.h"

int main() {
    StatusHub hub;
    const SystemSnapshot snapshot{78, Pose{1.0, 2.0, 0.5}, false, true, true, TaskSummary{"running", "F1"}};
    const auto message = hub.connect_and_get_initial_message(snapshot);

    if (message.find("\"type\":\"robot_pose\"") == std::string::npos) {
        std::cerr << "expected robot_pose websocket message\n";
        return EXIT_FAILURE;
    }

    return EXIT_SUCCESS;
}
