#include "storage/repositories/ScheduleRepository.h"

#include <stdexcept>

ScheduleRepository::ScheduleRepository(const DatabaseHandle& db) : db_(db.connection) {}

int ScheduleRepository::insert_schedule(const ScheduleRecord& schedule) {
    sqlite3_stmt* statement = nullptr;
    const char* sql =
        "INSERT INTO task_schedules (name, enabled, cron_expr, point_order_json) VALUES (?, ?, ?, ?)";
    if (sqlite3_prepare_v2(db_, sql, -1, &statement, nullptr) != SQLITE_OK) {
        throw std::runtime_error(sqlite3_errmsg(db_));
    }

    sqlite3_bind_text(statement, 1, schedule.name.c_str(), -1, SQLITE_TRANSIENT);
    sqlite3_bind_int(statement, 2, schedule.enabled ? 1 : 0);
    sqlite3_bind_text(statement, 3, schedule.cron_expr.c_str(), -1, SQLITE_TRANSIENT);
    sqlite3_bind_text(statement, 4, schedule.point_order_json.c_str(), -1, SQLITE_TRANSIENT);

    if (sqlite3_step(statement) != SQLITE_DONE) {
        const std::string message = sqlite3_errmsg(db_);
        sqlite3_finalize(statement);
        throw std::runtime_error(message);
    }

    sqlite3_finalize(statement);
    return static_cast<int>(sqlite3_last_insert_rowid(db_));
}

std::vector<ScheduleRecord> ScheduleRepository::list_schedules() const {
    return list_with_enabled_filter(false);
}

std::vector<ScheduleRecord> ScheduleRepository::list_enabled_schedules() const {
    return list_with_enabled_filter(true);
}

std::vector<ScheduleRecord> ScheduleRepository::list_with_enabled_filter(bool enabled_only) const {
    sqlite3_stmt* statement = nullptr;
    const char* sql_all =
        "SELECT id, name, enabled, cron_expr, point_order_json FROM task_schedules ORDER BY id";
    const char* sql_enabled =
        "SELECT id, name, enabled, cron_expr, point_order_json FROM task_schedules WHERE enabled = 1 ORDER BY id";
    const char* sql = enabled_only ? sql_enabled : sql_all;
    if (sqlite3_prepare_v2(db_, sql, -1, &statement, nullptr) != SQLITE_OK) {
        throw std::runtime_error(sqlite3_errmsg(db_));
    }

    std::vector<ScheduleRecord> schedules;
    while (sqlite3_step(statement) == SQLITE_ROW) {
        ScheduleRecord schedule;
        schedule.id = sqlite3_column_int(statement, 0);
        schedule.name = reinterpret_cast<const char*>(sqlite3_column_text(statement, 1));
        schedule.enabled = sqlite3_column_int(statement, 2) == 1;
        schedule.cron_expr = reinterpret_cast<const char*>(sqlite3_column_text(statement, 3));
        schedule.point_order_json = reinterpret_cast<const char*>(sqlite3_column_text(statement, 4));
        schedules.push_back(schedule);
    }

    sqlite3_finalize(statement);
    return schedules;
}
