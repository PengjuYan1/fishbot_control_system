#ifndef FISHBOT_BACKEND_SERVICES_MANUALCONTROLSERVICE_H_
#define FISHBOT_BACKEND_SERVICES_MANUALCONTROLSERVICE_H_

#include <chrono>
#include <mutex>

#include "backend/model/ManualControlState.h"
#include "ros_adapter/IRobotAdapter.h"

struct ManualControlCommandResult {
    bool ok = false;
    ManualControlState state;
};

class ManualControlService {
  public:
    explicit ManualControlService(IRobotAdapter& adapter);

    ManualControlCommandResult out_of_charge();
    ManualControlCommandResult undock();
    ManualControlCommandResult exit_navigation_mode();
    ManualControlCommandResult move(double linear_speed, double angular_speed);
    ManualControlCommandResult stop();
    ManualControlState get_state();

  private:
    void update_state_locked(ManualControlPhase phase, double linear_speed, double angular_speed,
                             bool session_active, bool pending_motion);
    ManualControlState snapshot_state_locked() const;
    void sync_session_from_status_locked(const RobotStatus& status);

    IRobotAdapter& adapter_;
    mutable std::mutex mutex_;
    ManualControlState session_state_;
    bool drive_command_active_ = false;
    bool manual_ready_latched_ = false;
    std::chrono::steady_clock::time_point undock_grace_deadline_{};
};

#endif
