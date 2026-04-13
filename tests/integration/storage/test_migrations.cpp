#include <cstdlib>
#include <iostream>

#include "storage/Database.h"

int main() {
    auto db = open_test_database();
    run_migrations(db);

    if (!table_exists(db, "system_config")) {
        std::cerr << "expected system_config table to exist\n";
        return EXIT_FAILURE;
    }

    if (!table_exists(db, "points")) {
        std::cerr << "expected points table to exist\n";
        return EXIT_FAILURE;
    }

    if (!table_exists(db, "task_runs")) {
        std::cerr << "expected task_runs table to exist\n";
        return EXIT_FAILURE;
    }

    return EXIT_SUCCESS;
}
