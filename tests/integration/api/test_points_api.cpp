#include <cstdlib>
#include <iostream>
#include <string>

#include "backend/api/PointController.h"
#include "backend/app/AppServer.h"
#include "backend/services/PointService.h"
#include "storage/Database.h"
#include "storage/repositories/PointRepository.h"

int main() {
    auto db = open_test_database();
    run_migrations(db);
    PointRepository repository(db);
    PointService service(repository);
    AppServer server;
    register_point_routes(server, service);

    const auto charge = server.handle_post(
        "/api/points/charge", "name=C1&x=1&y=2&theta=0&floor_id=9&map_id=19&point_id=29");
    const auto feed = server.handle_post(
        "/api/points/feed", "name=F1&x=3&y=4&theta=1&floor_id=10&map_id=20&point_id=30");

    if (charge.status != 200) {
        std::cerr << "expected successful charge point creation\n";
        return EXIT_FAILURE;
    }

    if (feed.status != 200) {
        std::cerr << "expected successful feed point creation\n";
        return EXIT_FAILURE;
    }

    const auto points = repository.list_points();
    if (points.size() != 2) {
        std::cerr << "expected two stored points\n";
        return EXIT_FAILURE;
    }

    if (points[0].type != "charge" || points[1].type != "feed") {
        std::cerr << "expected charge/feed point types\n";
        return EXIT_FAILURE;
    }

    if (points[0].floor_id != 9 || points[0].map_id != 19 || points[0].point_id != 29) {
        std::cerr << "expected charge point robot ids to be stored\n";
        return EXIT_FAILURE;
    }

    if (points[1].floor_id != 10 || points[1].map_id != 20 || points[1].point_id != 30) {
        std::cerr << "expected feed point robot ids to be stored\n";
        return EXIT_FAILURE;
    }

    const auto list_response = server.handle_get("/api/points");
    if (list_response.body.find("\"floor_id\":10") == std::string::npos ||
        list_response.body.find("\"point_id\":30") == std::string::npos) {
        std::cerr << "expected point list api to expose robot ids\n";
        return EXIT_FAILURE;
    }

    return EXIT_SUCCESS;
}
