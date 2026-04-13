#include "storage/repositories/EventLogRepository.h"

#include <stdexcept>

EventLogRepository::EventLogRepository(const DatabaseHandle& db) : db_(db.connection) {}

int EventLogRepository::insert_log(const std::string& level, const std::string& category,
                                   const std::string& message) {
    sqlite3_stmt* statement = nullptr;
    const char* sql = "INSERT INTO event_logs (level, category, message) VALUES (?, ?, ?)";
    if (sqlite3_prepare_v2(db_, sql, -1, &statement, nullptr) != SQLITE_OK) {
        throw std::runtime_error(sqlite3_errmsg(db_));
    }

    sqlite3_bind_text(statement, 1, level.c_str(), -1, SQLITE_TRANSIENT);
    sqlite3_bind_text(statement, 2, category.c_str(), -1, SQLITE_TRANSIENT);
    sqlite3_bind_text(statement, 3, message.c_str(), -1, SQLITE_TRANSIENT);

    if (sqlite3_step(statement) != SQLITE_DONE) {
        const std::string error = sqlite3_errmsg(db_);
        sqlite3_finalize(statement);
        throw std::runtime_error(error);
    }

    sqlite3_finalize(statement);
    return static_cast<int>(sqlite3_last_insert_rowid(db_));
}

std::vector<EventLogRecord> EventLogRepository::list_alerts() const {
    sqlite3_stmt* statement = nullptr;
    const char* sql =
        "SELECT id, level, category, message FROM event_logs "
        "WHERE level IN ('warning', 'error') ORDER BY id DESC";
    if (sqlite3_prepare_v2(db_, sql, -1, &statement, nullptr) != SQLITE_OK) {
        throw std::runtime_error(sqlite3_errmsg(db_));
    }

    std::vector<EventLogRecord> logs;
    while (sqlite3_step(statement) == SQLITE_ROW) {
        EventLogRecord log;
        log.id = sqlite3_column_int(statement, 0);
        log.level = reinterpret_cast<const char*>(sqlite3_column_text(statement, 1));
        log.category = reinterpret_cast<const char*>(sqlite3_column_text(statement, 2));
        log.message = reinterpret_cast<const char*>(sqlite3_column_text(statement, 3));
        logs.push_back(log);
    }

    sqlite3_finalize(statement);
    return logs;
}
