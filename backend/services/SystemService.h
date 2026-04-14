#ifndef FISHBOT_BACKEND_SERVICES_SYSTEMSERVICE_H_
#define FISHBOT_BACKEND_SERVICES_SYSTEMSERVICE_H_

#include <cstddef>
#include <deque>
#include <functional>
#include <mutex>
#include <string>

#include "backend/model/SystemSnapshot.h"
#include "ros_adapter/IRobotAdapter.h"

struct TimedSystemSnapshot {
    long long timestamp_ms = 0;
    SystemSnapshot snapshot;
};

class SystemService {
  public:
    using TaskSummaryProvider = std::function<TaskSummary()>;
    using ManualControlStateProvider = std::function<ManualControlState()>;

    explicit SystemService(
        IRobotAdapter& adapter,
        TaskSummaryProvider task_summary_provider = {},
        ManualControlStateProvider manual_control_state_provider = {});

    SystemSnapshot get_snapshot() const;
    SystemSnapshot capture_snapshot();
    std::string get_trace_json(std::size_t limit = 60) const;
    void record_connection_error(const std::string& message);
    void set_reconnect_attempts(int attempts);

  private:
    void append_trace_entry(const SystemSnapshot& snapshot);

    IRobotAdapter& adapter_;
    TaskSummaryProvider task_summary_provider_;
    ManualControlStateProvider manual_control_state_provider_;
    std::string last_error_;
    int reconnect_attempts_ = 0;
    mutable std::mutex trace_mutex_;
    std::deque<TimedSystemSnapshot> trace_entries_;
    std::size_t max_trace_entries_ = 240;
};

#endif
