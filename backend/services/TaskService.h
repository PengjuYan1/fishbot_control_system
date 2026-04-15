#ifndef FISHBOT_BACKEND_SERVICES_TASKSERVICE_H_
#define FISHBOT_BACKEND_SERVICES_TASKSERVICE_H_

#include <atomic>
#include <cstdint>
#include <mutex>
#include <string>
#include <thread>
#include <vector>

#include "backend/model/SystemSnapshot.h"
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
    ~TaskService();

    TaskStartResult start_manual_run();
    TaskStartResult start_scheduled_run(const std::string& schedule_name);
    TaskStartResult start_charge_return();
    TaskStartResult start_navigation_to_point(int point_id);
    TaskStartResult start_self_charge();
    void observe_system_snapshot(const SystemSnapshot& snapshot);
    void complete_current_feed_point();
    void interrupt_for_low_battery();
    void on_charge_completed(bool resume_after_charge);
    TaskStartResult current_task() const;
    std::string last_trigger_type() const;

  private:
    enum class SelfChargePhase {
        kIdle,
        kNavigating,
        kDocking,
        kCharging,
        kFailed,
    };

    TaskStartResult start_run(const std::string& trigger_type);
    PointRecord find_charge_point() const;
    std::vector<PointRecord> list_feed_points() const;
    void navigate_to_point(const PointRecord& point);
    void update_current_task(const std::string& status, const std::string& target_name);
    void run_self_charge_loop(PointRecord charge_point, std::uint64_t generation);
    void stop_self_charge_worker();
    std::string serialize_remaining_points() const;
    std::vector<std::string> parse_remaining_point_names(const std::string& value) const;
    int index_of_point_name(const std::string& point_name) const;

    IRobotAdapter& adapter_;
    PointRepository& point_repository_;
    TaskRunRepository* task_run_repository_ = nullptr;
    TaskStateMachine state_machine_;
    mutable std::mutex current_task_mutex_;
    TaskStartResult current_task_;
    std::string last_trigger_type_ = "manual";
    std::vector<PointRecord> feed_points_;
    std::size_t current_feed_index_ = 0;
    int active_run_id_ = 0;
    std::atomic<std::uint64_t> self_charge_generation_{0};
    SelfChargePhase self_charge_phase_ = SelfChargePhase::kIdle;
    std::thread self_charge_thread_;
};

#endif
