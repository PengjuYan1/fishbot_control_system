#ifndef FISHBOT_STORAGE_DATABASE_H_
#define FISHBOT_STORAGE_DATABASE_H_

#include <sqlite3.h>

#include <string>

struct DatabaseHandle {
    sqlite3* connection = nullptr;

    DatabaseHandle() = default;
    explicit DatabaseHandle(sqlite3* db);
    DatabaseHandle(const DatabaseHandle&) = delete;
    DatabaseHandle& operator=(const DatabaseHandle&) = delete;
    DatabaseHandle(DatabaseHandle&& other) noexcept;
    DatabaseHandle& operator=(DatabaseHandle&& other) noexcept;
    ~DatabaseHandle();
};

DatabaseHandle open_test_database();
DatabaseHandle open_database(const std::string& path);
void run_migrations(const DatabaseHandle& db);
bool table_exists(const DatabaseHandle& db, const std::string& table_name);

#endif
