#include "storage/repositories/TaskRunRepository.h"

#include <stdexcept>

TaskRunRepository::TaskRunRepository(const DatabaseHandle& db) : db_(db.connection) {}

int TaskRunRepository::insert_run(const std::string& trigger_type, const std::string& status) {
    sqlite3_stmt* statement = nullptr;
    const char* sql = "INSERT INTO task_runs (trigger_type, status, resume_context_json) VALUES (?, ?, ?)";
    if (sqlite3_prepare_v2(db_, sql, -1, &statement, nullptr) != SQLITE_OK) {
        throw std::runtime_error(sqlite3_errmsg(db_));
    }

    sqlite3_bind_text(statement, 1, trigger_type.c_str(), -1, SQLITE_TRANSIENT);
    sqlite3_bind_text(statement, 2, status.c_str(), -1, SQLITE_TRANSIENT);
    sqlite3_bind_text(statement, 3, "", -1, SQLITE_TRANSIENT);

    if (sqlite3_step(statement) != SQLITE_DONE) {
        const std::string message = sqlite3_errmsg(db_);
        sqlite3_finalize(statement);
        throw std::runtime_error(message);
    }

    sqlite3_finalize(statement);
    return static_cast<int>(sqlite3_last_insert_rowid(db_));
}

void TaskRunRepository::update_status(int run_id, const std::string& status) {
    sqlite3_stmt* statement = nullptr;
    const char* sql = "UPDATE task_runs SET status = ? WHERE id = ?";
    if (sqlite3_prepare_v2(db_, sql, -1, &statement, nullptr) != SQLITE_OK) {
        throw std::runtime_error(sqlite3_errmsg(db_));
    }

    sqlite3_bind_text(statement, 1, status.c_str(), -1, SQLITE_TRANSIENT);
    sqlite3_bind_int(statement, 2, run_id);

    if (sqlite3_step(statement) != SQLITE_DONE) {
        const std::string message = sqlite3_errmsg(db_);
        sqlite3_finalize(statement);
        throw std::runtime_error(message);
    }

    sqlite3_finalize(statement);
}

void TaskRunRepository::update_resume_context(int run_id, const std::string& resume_context_json) {
    sqlite3_stmt* statement = nullptr;
    const char* sql = "UPDATE task_runs SET resume_context_json = ? WHERE id = ?";
    if (sqlite3_prepare_v2(db_, sql, -1, &statement, nullptr) != SQLITE_OK) {
        throw std::runtime_error(sqlite3_errmsg(db_));
    }

    sqlite3_bind_text(statement, 1, resume_context_json.c_str(), -1, SQLITE_TRANSIENT);
    sqlite3_bind_int(statement, 2, run_id);

    if (sqlite3_step(statement) != SQLITE_DONE) {
        const std::string message = sqlite3_errmsg(db_);
        sqlite3_finalize(statement);
        throw std::runtime_error(message);
    }

    sqlite3_finalize(statement);
}

TaskRunRecord TaskRunRepository::latest_run() const {
    sqlite3_stmt* statement = nullptr;
    const char* sql =
        "SELECT id, trigger_type, status, resume_context_json FROM task_runs ORDER BY id DESC LIMIT 1";
    if (sqlite3_prepare_v2(db_, sql, -1, &statement, nullptr) != SQLITE_OK) {
        throw std::runtime_error(sqlite3_errmsg(db_));
    }

    TaskRunRecord record;
    if (sqlite3_step(statement) == SQLITE_ROW) {
        record.id = sqlite3_column_int(statement, 0);
        record.trigger_type = reinterpret_cast<const char*>(sqlite3_column_text(statement, 1));
        record.status = reinterpret_cast<const char*>(sqlite3_column_text(statement, 2));
        const unsigned char* text = sqlite3_column_text(statement, 3);
        record.resume_context_json = text == nullptr ? "" : reinterpret_cast<const char*>(text);
    }

    sqlite3_finalize(statement);
    return record;
}
