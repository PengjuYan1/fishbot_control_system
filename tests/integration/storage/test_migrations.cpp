#include <cstdlib>
#include <iostream>
#include <string>

#include <sqlite3.h>

#include "storage/Database.h"

namespace {
bool has_column(const DatabaseHandle& db, const std::string& table_name, const std::string& column_name) {
    sqlite3_stmt* statement = nullptr;
    const std::string sql = "PRAGMA table_info(" + table_name + ")";
    if (sqlite3_prepare_v2(db.connection, sql.c_str(), -1, &statement, nullptr) != SQLITE_OK) {
        throw std::runtime_error(sqlite3_errmsg(db.connection));
    }

    bool found = false;
    while (sqlite3_step(statement) == SQLITE_ROW) {
        const auto* name = reinterpret_cast<const char*>(sqlite3_column_text(statement, 1));
        if (name != nullptr && column_name == name) {
            found = true;
            break;
        }
    }

    sqlite3_finalize(statement);
    return found;
}
}  // namespace

int main() {
    {
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

        if (!has_column(db, "points", "floor_id") ||
            !has_column(db, "points", "map_id") ||
            !has_column(db, "points", "point_id")) {
            std::cerr << "expected points table to contain robot-native identifier columns\n";
            return EXIT_FAILURE;
        }
    }

    {
        auto db = open_test_database();
        sqlite3_exec(db.connection,
                     "CREATE TABLE points ("
                     "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                     "name TEXT NOT NULL,"
                     "type TEXT NOT NULL,"
                     "x REAL NOT NULL,"
                     "y REAL NOT NULL,"
                     "theta REAL NOT NULL,"
                     "sort_order INTEGER NOT NULL DEFAULT 0,"
                     "enabled INTEGER NOT NULL DEFAULT 1,"
                     "created_at TEXT DEFAULT CURRENT_TIMESTAMP,"
                     "floor_id INTEGER NOT NULL DEFAULT 0,"
                     "map_id INTEGER NOT NULL DEFAULT 0"
                     ");",
                     nullptr,
                     nullptr,
                     nullptr);

        run_migrations(db);

        if (!has_column(db, "points", "point_id")) {
            std::cerr << "expected migrations to repair partially upgraded points schema\n";
            return EXIT_FAILURE;
        }
    }

    return EXIT_SUCCESS;
}
