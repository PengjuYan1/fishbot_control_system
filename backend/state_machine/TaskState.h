#ifndef FISHBOT_BACKEND_STATE_MACHINE_TASKSTATE_H_
#define FISHBOT_BACKEND_STATE_MACHINE_TASKSTATE_H_

enum class TaskState {
    Idle,
    WaitingForNavigation,
    NavigatingToFeedPoint,
    FeedingPause,
    ReturningToCharge,
    Completed,
    Faulted
};

#endif
