#ifndef FISHBOT_BACKEND_SERVICES_TASKSERVICE_H_
#define FISHBOT_BACKEND_SERVICES_TASKSERVICE_H_

#include <string>
#include <vector>

#include "backend/state_machine/TaskStateMachine.h"
#include "ros_adapter/IRobotAdapter.h"
#include "storage/repositories/PointRepository.h"
#include "storage/repositories/TaskRunRepository.h"

struct TaskStartResult {
    std::string status = "idle";
    std::string current_target_name;
};

class TaskService {
  public:
    TaskService(IRobotAdapter& adapter, PointRepository& point_repository);
    TaskService(IRobotAdapter& adapter, PointRepository& point_repository,
                TaskRunRepository* task_run_repository);

    TaskStartResult start_manual_run();
    TaskStartResult start_scheduled_run(const std::string& schedule_name);
    TaskStartResult start_charge_return();
    void complete_current_feed_point();
    void interrupt_for_low_battery();
    void on_charge_completed(bool resume_after_charge);
    TaskStartResult current_task() const;
    std::string last_trigger_type() const;

  private:
    TaskStartResult start_run(const std::string& trigger_type);
    PointRecord find_charge_point() const;
    std::vector<PointRecord> list_feed_points() const;
    void navigate_to_point(const PointRecord& point);
    std::string serialize_remaining_points() const;
    std::vector<std::string> parse_remaining_point_names(const std::string& value) const;
    int index_of_point_name(const std::string& point_name) const;

    IRobotAdapter& adapter_;
    PointRepository& point_repository_;
    TaskRunRepository* task_run_repository_ = nullptr;
    TaskStateMachine state_machine_;
    TaskStartResult current_task_;
    std::string last_trigger_type_ = "manual";
    std::vector<PointRecord> feed_points_;
    std::size_t current_feed_index_ = 0;
    int active_run_id_ = 0;
};

#endif
