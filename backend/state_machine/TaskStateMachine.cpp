#include "backend/state_machine/TaskStateMachine.h"

bool TaskStateMachine::start_run() {
    if (current_state_ != TaskState::Idle) {
        return false;
    }

    current_state_ = TaskState::WaitingForNavigation;
    return true;
}

bool TaskStateMachine::on_navigation_started() {
    if (current_state_ != TaskState::WaitingForNavigation) {
        return false;
    }

    current_state_ = TaskState::NavigatingToFeedPoint;
    return true;
}

bool TaskStateMachine::on_arrived_at_feed_point() {
    if (current_state_ != TaskState::NavigatingToFeedPoint) {
        return false;
    }

    current_state_ = TaskState::FeedingPause;
    return true;
}

TaskState TaskStateMachine::current_state() const {
    return current_state_;
}
