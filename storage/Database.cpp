#include "storage/Database.h"

#include <filesystem>
#include <fstream>
#include <stdexcept>

namespace {
std::string read_file(const std::string& path) {
    std::ifstream input(path);
    if (!input.is_open()) {
        throw std::runtime_error("unable to open migration file: " + path);
    }

    return std::string((std::istreambuf_iterator<char>(input)), std::istreambuf_iterator<char>());
}

void exec_sql(sqlite3* db, const std::string& sql) {
    char* error_message = nullptr;
    const int rc = sqlite3_exec(db, sql.c_str(), nullptr, nullptr, &error_message);
    if (rc != SQLITE_OK) {
        const std::string message = error_message ? error_message : "unknown sqlite error";
        sqlite3_free(error_message);
        throw std::runtime_error(message);
    }
}

bool column_exists(sqlite3* db, const std::string& table_name, const std::string& column_name) {
    sqlite3_stmt* statement = nullptr;
    const std::string sql = "PRAGMA table_info(" + table_name + ")";
    if (sqlite3_prepare_v2(db, sql.c_str(), -1, &statement, nullptr) != SQLITE_OK) {
        throw std::runtime_error(sqlite3_errmsg(db));
    }

    bool exists = false;
    while (sqlite3_step(statement) == SQLITE_ROW) {
        const auto* name = reinterpret_cast<const char*>(sqlite3_column_text(statement, 1));
        if (name != nullptr && column_name == name) {
            exists = true;
            break;
        }
    }

    sqlite3_finalize(statement);
    return exists;
}

void add_column_if_missing(sqlite3* db, const std::string& table_name,
                           const std::string& column_name, const std::string& column_definition) {
    if (column_exists(db, table_name, column_name)) {
        return;
    }

    exec_sql(db, "ALTER TABLE " + table_name + " ADD COLUMN " + column_definition);
}
}  // namespace

DatabaseHandle::DatabaseHandle(sqlite3* db) : connection(db) {}

DatabaseHandle::DatabaseHandle(DatabaseHandle&& other) noexcept : connection(other.connection) {
    other.connection = nullptr;
}

DatabaseHandle& DatabaseHandle::operator=(DatabaseHandle&& other) noexcept {
    if (this != &other) {
        if (connection != nullptr) {
            sqlite3_close(connection);
        }
        connection = other.connection;
        other.connection = nullptr;
    }
    return *this;
}

DatabaseHandle::~DatabaseHandle() {
    if (connection != nullptr) {
        sqlite3_close(connection);
    }
}

DatabaseHandle open_test_database() {
    return open_database(":memory:");
}

DatabaseHandle open_database(const std::string& path) {
    sqlite3* db = nullptr;
    if (path != ":memory:") {
        const std::filesystem::path database_path(path);
        if (database_path.has_parent_path()) {
            std::filesystem::create_directories(database_path.parent_path());
        }
    }

    if (sqlite3_open(path.c_str(), &db) != SQLITE_OK) {
        const std::string message = db ? sqlite3_errmsg(db) : "failed to allocate sqlite database";
        if (db != nullptr) {
            sqlite3_close(db);
        }
        throw std::runtime_error(message);
    }
    return DatabaseHandle(db);
}

void run_migrations(const DatabaseHandle& db) {
    exec_sql(db.connection, read_file("storage/migrations/001_init.sql"));

    add_column_if_missing(db.connection, "points", "floor_id", "floor_id INTEGER NOT NULL DEFAULT 0");
    add_column_if_missing(db.connection, "points", "map_id", "map_id INTEGER NOT NULL DEFAULT 0");
    add_column_if_missing(db.connection, "points", "point_id", "point_id INTEGER NOT NULL DEFAULT 0");
}

bool table_exists(const DatabaseHandle& db, const std::string& table_name) {
    sqlite3_stmt* statement = nullptr;
    const char* sql = "SELECT name FROM sqlite_master WHERE type = 'table' AND name = ? LIMIT 1";
    if (sqlite3_prepare_v2(db.connection, sql, -1, &statement, nullptr) != SQLITE_OK) {
        throw std::runtime_error(sqlite3_errmsg(db.connection));
    }

    sqlite3_bind_text(statement, 1, table_name.c_str(), -1, SQLITE_TRANSIENT);
    const int step_result = sqlite3_step(statement);
    const bool exists = step_result == SQLITE_ROW;
    sqlite3_finalize(statement);
    return exists;
}
