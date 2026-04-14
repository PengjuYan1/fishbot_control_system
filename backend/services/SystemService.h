#ifndef FISHBOT_BACKEND_SERVICES_SYSTEMSERVICE_H_
#define FISHBOT_BACKEND_SERVICES_SYSTEMSERVICE_H_

#include <functional>

#include "backend/model/SystemSnapshot.h"
#include "ros_adapter/IRobotAdapter.h"

class SystemService {
  public:
    using TaskSummaryProvider = std::function<TaskSummary()>;
    using ManualControlStateProvider = std::function<ManualControlState()>;

    explicit SystemService(
        IRobotAdapter& adapter,
        TaskSummaryProvider task_summary_provider = {},
        ManualControlStateProvider manual_control_state_provider = {});

    SystemSnapshot get_snapshot() const;
    void record_connection_error(const std::string& message);
    void set_reconnect_attempts(int attempts);

  private:
    IRobotAdapter& adapter_;
    TaskSummaryProvider task_summary_provider_;
    ManualControlStateProvider manual_control_state_provider_;
    std::string last_error_;
    int reconnect_attempts_ = 0;
};

#endif
