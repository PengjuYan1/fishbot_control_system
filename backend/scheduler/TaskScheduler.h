#ifndef FISHBOT_BACKEND_SCHEDULER_TASKSCHEDULER_H_
#define FISHBOT_BACKEND_SCHEDULER_TASKSCHEDULER_H_

#include <string>

#include "backend/services/TaskService.h"
#include "storage/repositories/ScheduleRepository.h"

class TaskScheduler {
  public:
    TaskScheduler(ScheduleRepository& schedule_repository, TaskService& task_service);

    void tick(const std::string& hhmm);

  private:
    bool matches_time(const std::string& cron_expr, const std::string& hhmm) const;

    ScheduleRepository& schedule_repository_;
    TaskService& task_service_;
};

#endif
