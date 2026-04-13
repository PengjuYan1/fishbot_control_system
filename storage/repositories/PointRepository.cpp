#include "storage/repositories/PointRepository.h"

#include <stdexcept>

PointRepository::PointRepository(const DatabaseHandle& db) : db_(db.connection) {}

int PointRepository::insert_point(const PointRecord& point) {
    sqlite3_stmt* statement = nullptr;
    const char* sql = "INSERT INTO points (name, type, x, y, theta) VALUES (?, ?, ?, ?, ?)";
    if (sqlite3_prepare_v2(db_, sql, -1, &statement, nullptr) != SQLITE_OK) {
        throw std::runtime_error(sqlite3_errmsg(db_));
    }

    sqlite3_bind_text(statement, 1, point.name.c_str(), -1, SQLITE_TRANSIENT);
    sqlite3_bind_text(statement, 2, point.type.c_str(), -1, SQLITE_TRANSIENT);
    sqlite3_bind_double(statement, 3, point.x);
    sqlite3_bind_double(statement, 4, point.y);
    sqlite3_bind_double(statement, 5, point.theta);

    if (sqlite3_step(statement) != SQLITE_DONE) {
        const std::string message = sqlite3_errmsg(db_);
        sqlite3_finalize(statement);
        throw std::runtime_error(message);
    }

    sqlite3_finalize(statement);
    return static_cast<int>(sqlite3_last_insert_rowid(db_));
}

std::vector<PointRecord> PointRepository::list_points() const {
    sqlite3_stmt* statement = nullptr;
    const char* sql = "SELECT id, name, type, x, y, theta FROM points ORDER BY id";
    if (sqlite3_prepare_v2(db_, sql, -1, &statement, nullptr) != SQLITE_OK) {
        throw std::runtime_error(sqlite3_errmsg(db_));
    }

    std::vector<PointRecord> points;
    while (sqlite3_step(statement) == SQLITE_ROW) {
        PointRecord point;
        point.id = sqlite3_column_int(statement, 0);
        point.name = reinterpret_cast<const char*>(sqlite3_column_text(statement, 1));
        point.type = reinterpret_cast<const char*>(sqlite3_column_text(statement, 2));
        point.x = sqlite3_column_double(statement, 3);
        point.y = sqlite3_column_double(statement, 4);
        point.theta = sqlite3_column_double(statement, 5);
        points.push_back(point);
    }

    sqlite3_finalize(statement);
    return points;
}
