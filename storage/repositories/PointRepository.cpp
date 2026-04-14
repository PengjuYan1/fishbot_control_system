#include "storage/repositories/PointRepository.h"

#include <optional>
#include <stdexcept>

namespace {
std::string canonical_type_for(const PointRecord& point) {
    if (point.point_kind == "charge") {
        return "charge";
    }
    if (point.point_kind == "initial") {
        return "initial";
    }
    if (point.biz_role == "feed") {
        return "feed";
    }
    return point.type.empty() ? "navigation" : point.type;
}
}  // namespace

PointRepository::PointRepository(const DatabaseHandle& db) : db_(db.connection) {}

int PointRepository::insert_point(const PointRecord& point) {
    sqlite3_stmt* statement = nullptr;
    const char* sql =
        "INSERT INTO points "
        "(name, type, point_kind, biz_role, x, y, theta, floor_id, map_id, point_id) "
        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    if (sqlite3_prepare_v2(db_, sql, -1, &statement, nullptr) != SQLITE_OK) {
        throw std::runtime_error(sqlite3_errmsg(db_));
    }

    const auto type = canonical_type_for(point);
    sqlite3_bind_text(statement, 1, point.name.c_str(), -1, SQLITE_TRANSIENT);
    sqlite3_bind_text(statement, 2, type.c_str(), -1, SQLITE_TRANSIENT);
    sqlite3_bind_text(statement, 3, point.point_kind.c_str(), -1, SQLITE_TRANSIENT);
    sqlite3_bind_text(statement, 4, point.biz_role.c_str(), -1, SQLITE_TRANSIENT);
    sqlite3_bind_double(statement, 5, point.x);
    sqlite3_bind_double(statement, 6, point.y);
    sqlite3_bind_double(statement, 7, point.theta);
    sqlite3_bind_int64(statement, 8, point.floor_id);
    sqlite3_bind_int64(statement, 9, point.map_id);
    sqlite3_bind_int64(statement, 10, point.point_id);

    if (sqlite3_step(statement) != SQLITE_DONE) {
        const std::string message = sqlite3_errmsg(db_);
        sqlite3_finalize(statement);
        throw std::runtime_error(message);
    }

    sqlite3_finalize(statement);
    return static_cast<int>(sqlite3_last_insert_rowid(db_));
}

std::optional<PointRecord> PointRepository::find_point(int id) const {
    sqlite3_stmt* statement = nullptr;
    const char* sql =
        "SELECT id, name, type, point_kind, biz_role, x, y, theta, floor_id, map_id, point_id "
        "FROM points WHERE id = ?";
    if (sqlite3_prepare_v2(db_, sql, -1, &statement, nullptr) != SQLITE_OK) {
        throw std::runtime_error(sqlite3_errmsg(db_));
    }

    sqlite3_bind_int(statement, 1, id);

    std::optional<PointRecord> point;
    if (sqlite3_step(statement) == SQLITE_ROW) {
        PointRecord record;
        record.id = sqlite3_column_int(statement, 0);
        record.name = reinterpret_cast<const char*>(sqlite3_column_text(statement, 1));
        record.type = reinterpret_cast<const char*>(sqlite3_column_text(statement, 2));
        record.point_kind = reinterpret_cast<const char*>(sqlite3_column_text(statement, 3));
        record.biz_role = reinterpret_cast<const char*>(sqlite3_column_text(statement, 4));
        record.x = sqlite3_column_double(statement, 5);
        record.y = sqlite3_column_double(statement, 6);
        record.theta = sqlite3_column_double(statement, 7);
        record.floor_id = sqlite3_column_int64(statement, 8);
        record.map_id = sqlite3_column_int64(statement, 9);
        record.point_id = sqlite3_column_int64(statement, 10);
        point = record;
    }

    sqlite3_finalize(statement);
    return point;
}

bool PointRepository::delete_point(int id) {
    sqlite3_stmt* statement = nullptr;
    const char* sql = "DELETE FROM points WHERE id = ?";
    if (sqlite3_prepare_v2(db_, sql, -1, &statement, nullptr) != SQLITE_OK) {
        throw std::runtime_error(sqlite3_errmsg(db_));
    }

    sqlite3_bind_int(statement, 1, id);

    if (sqlite3_step(statement) != SQLITE_DONE) {
        const std::string message = sqlite3_errmsg(db_);
        sqlite3_finalize(statement);
        throw std::runtime_error(message);
    }

    const bool deleted = sqlite3_changes(db_) > 0;
    sqlite3_finalize(statement);
    return deleted;
}

std::vector<PointRecord> PointRepository::list_points() const {
    sqlite3_stmt* statement = nullptr;
    const char* sql =
        "SELECT id, name, type, point_kind, biz_role, x, y, theta, floor_id, map_id, point_id "
        "FROM points ORDER BY id";
    if (sqlite3_prepare_v2(db_, sql, -1, &statement, nullptr) != SQLITE_OK) {
        throw std::runtime_error(sqlite3_errmsg(db_));
    }

    std::vector<PointRecord> points;
    while (sqlite3_step(statement) == SQLITE_ROW) {
        PointRecord point;
        point.id = sqlite3_column_int(statement, 0);
        point.name = reinterpret_cast<const char*>(sqlite3_column_text(statement, 1));
        point.type = reinterpret_cast<const char*>(sqlite3_column_text(statement, 2));
        point.point_kind = reinterpret_cast<const char*>(sqlite3_column_text(statement, 3));
        point.biz_role = reinterpret_cast<const char*>(sqlite3_column_text(statement, 4));
        point.x = sqlite3_column_double(statement, 5);
        point.y = sqlite3_column_double(statement, 6);
        point.theta = sqlite3_column_double(statement, 7);
        point.floor_id = sqlite3_column_int64(statement, 8);
        point.map_id = sqlite3_column_int64(statement, 9);
        point.point_id = sqlite3_column_int64(statement, 10);
        points.push_back(point);
    }

    sqlite3_finalize(statement);
    return points;
}
