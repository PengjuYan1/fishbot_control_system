#include <cstdlib>
#include <iostream>
#include <string>

#include "backend/model/SystemSnapshot.h"
#include "backend/websocket/StatusHub.h"

int main() {
    StatusHub hub;
    SystemSnapshot snapshot;
    snapshot.battery = 78;
    snapshot.pose = Pose{1.0, 2.0, 0.5};
    snapshot.charging = false;
    snapshot.connected = true;
    snapshot.localized = true;
    snapshot.task = TaskSummary{"running", "F1"};
    snapshot.connection = ConnectionDiagnostics{true, "", 0, "rosbridge"};
    const auto message = hub.connect_and_get_initial_message(snapshot);

    if (message.find("\"type\":\"system_snapshot\"") == std::string::npos ||
        message.find("\"battery\":78") == std::string::npos ||
        message.find("\"adapter_mode\":\"rosbridge\"") == std::string::npos) {
        std::cerr << "expected system_snapshot websocket message\n";
        return EXIT_FAILURE;
    }

    const auto map_message = hub.publish_map_snapshot(MapSnapshot{4, 3, 0.05, {0, 100, -1, 0}, -1.0, -2.0});
    if (map_message.find("\"type\":\"map_snapshot\"") == std::string::npos ||
        map_message.find("\"origin_x\":-1.000000") == std::string::npos) {
        std::cerr << "expected map_snapshot websocket message\n";
        return EXIT_FAILURE;
    }

    return EXIT_SUCCESS;
}
