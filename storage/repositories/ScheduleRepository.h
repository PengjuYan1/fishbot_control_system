#ifndef FISHBOT_STORAGE_REPOSITORIES_SCHEDULEREPOSITORY_H_
#define FISHBOT_STORAGE_REPOSITORIES_SCHEDULEREPOSITORY_H_

#include <vector>

#include "backend/model/ScheduleRecord.h"
#include "storage/Database.h"

class ScheduleRepository {
  public:
    explicit ScheduleRepository(const DatabaseHandle& db);

    int insert_schedule(const ScheduleRecord& schedule);
    std::vector<ScheduleRecord> list_schedules() const;
    std::vector<ScheduleRecord> list_enabled_schedules() const;

  private:
    std::vector<ScheduleRecord> list_with_enabled_filter(bool enabled_only) const;

    sqlite3* db_;
};

#endif
