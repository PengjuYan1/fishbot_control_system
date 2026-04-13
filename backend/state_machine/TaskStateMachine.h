#ifndef FISHBOT_BACKEND_STATE_MACHINE_TASKSTATEMACHINE_H_
#define FISHBOT_BACKEND_STATE_MACHINE_TASKSTATEMACHINE_H_

#include "backend/state_machine/TaskState.h"

class TaskStateMachine {
  public:
    TaskStateMachine() = default;

    bool start_run();
    bool on_navigation_started();
    bool on_arrived_at_feed_point();
    TaskState current_state() const;

  private:
    TaskState current_state_ = TaskState::Idle;
};

#endif
