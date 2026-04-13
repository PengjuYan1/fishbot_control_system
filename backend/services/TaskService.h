#ifndef FISHBOT_BACKEND_SERVICES_TASKSERVICE_H_
#define FISHBOT_BACKEND_SERVICES_TASKSERVICE_H_

#include <string>

#include "backend/state_machine/TaskStateMachine.h"
#include "ros_adapter/IRobotAdapter.h"
#include "storage/repositories/PointRepository.h"

struct TaskStartResult {
    std::string status = "idle";
    std::string current_target_name;
};

class TaskService {
  public:
    TaskService(IRobotAdapter& adapter, PointRepository& point_repository);

    TaskStartResult start_manual_run();
    TaskStartResult start_scheduled_run(const std::string& schedule_name);
    TaskStartResult current_task() const;
    std::string last_trigger_type() const;

  private:
    TaskStartResult start_run(const std::string& trigger_type);
    PointRecord first_feed_point() const;

    IRobotAdapter& adapter_;
    PointRepository& point_repository_;
    TaskStateMachine state_machine_;
    TaskStartResult current_task_;
    std::string last_trigger_type_ = "manual";
};

#endif
