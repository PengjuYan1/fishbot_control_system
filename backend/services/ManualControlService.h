#ifndef FISHBOT_BACKEND_SERVICES_MANUALCONTROLSERVICE_H_
#define FISHBOT_BACKEND_SERVICES_MANUALCONTROLSERVICE_H_

#include <condition_variable>
#include <cstdint>
#include <mutex>
#include <thread>

#include "backend/model/ManualControlState.h"
#include "ros_adapter/IRobotAdapter.h"

struct ManualControlCommandResult {
    bool ok = false;
    ManualControlState state;
};

class ManualControlService {
  public:
    explicit ManualControlService(IRobotAdapter& adapter);
    ~ManualControlService();

    ManualControlCommandResult out_of_charge();
    ManualControlCommandResult exit_navigation_mode();
    ManualControlCommandResult move(double linear_speed, double angular_speed);
    ManualControlCommandResult stop();
    ManualControlState get_state();

  private:
    void control_loop();
    bool execute_control_step();
    bool release_navigation_control();
    ManualControlState snapshot_state_locked() const;
    void sync_session_from_status_locked(const RobotStatus& status);

    IRobotAdapter& adapter_;
    mutable std::mutex mutex_;
    std::condition_variable control_cv_;
    std::thread control_thread_;
    ManualControlState session_state_;
    bool drive_command_active_ = false;
    bool shutting_down_ = false;
    std::uint64_t command_revision_ = 0;
};

#endif
