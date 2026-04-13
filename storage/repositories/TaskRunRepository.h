#ifndef FISHBOT_STORAGE_REPOSITORIES_TASKRUNREPOSITORY_H_
#define FISHBOT_STORAGE_REPOSITORIES_TASKRUNREPOSITORY_H_

#include <string>

#include "backend/model/TaskRunRecord.h"
#include "storage/Database.h"

class TaskRunRepository {
  public:
    explicit TaskRunRepository(const DatabaseHandle& db);

    int insert_run(const std::string& trigger_type, const std::string& status);
    void update_status(int run_id, const std::string& status);
    void update_resume_context(int run_id, const std::string& resume_context_json);
    TaskRunRecord latest_run() const;

  private:
    sqlite3* db_;
};

#endif
