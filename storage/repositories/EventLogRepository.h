#ifndef FISHBOT_STORAGE_REPOSITORIES_EVENTLOGREPOSITORY_H_
#define FISHBOT_STORAGE_REPOSITORIES_EVENTLOGREPOSITORY_H_

#include <vector>

#include "backend/model/EventLogRecord.h"
#include "storage/Database.h"

class EventLogRepository {
  public:
    explicit EventLogRepository(const DatabaseHandle& db);

    int insert_log(const std::string& level, const std::string& category, const std::string& message);
    std::vector<EventLogRecord> list_alerts() const;

  private:
    sqlite3* db_;
};

#endif
