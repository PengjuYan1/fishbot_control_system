#ifndef FISHBOT_BACKEND_SERVICES_SCHEDULESERVICE_H_
#define FISHBOT_BACKEND_SERVICES_SCHEDULESERVICE_H_

#include <string>
#include <vector>

#include "backend/model/ScheduleRecord.h"
#include "storage/repositories/ScheduleRepository.h"

class ScheduleService {
  public:
    explicit ScheduleService(ScheduleRepository& repository);

    int create_schedule(const std::string& body);
    std::vector<ScheduleRecord> list_schedules() const;

  private:
    ScheduleRecord parse_schedule(const std::string& body) const;

    ScheduleRepository& repository_;
};

#endif
