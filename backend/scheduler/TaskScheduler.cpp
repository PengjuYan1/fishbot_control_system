#include "backend/scheduler/TaskScheduler.h"

#include <sstream>
#include <vector>

namespace {
std::vector<std::string> split_by_space(const std::string& value) {
    std::stringstream stream(value);
    std::vector<std::string> parts;
    std::string part;
    while (stream >> part) {
        parts.push_back(part);
    }
    return parts;
}
}  // namespace

TaskScheduler::TaskScheduler(ScheduleRepository& schedule_repository, TaskService& task_service)
    : schedule_repository_(schedule_repository), task_service_(task_service) {}

void TaskScheduler::tick(const std::string& hhmm) {
    const auto schedules = schedule_repository_.list_enabled_schedules();
    for (const auto& schedule : schedules) {
        if (matches_time(schedule.cron_expr, hhmm)) {
            task_service_.start_scheduled_run(schedule.name);
        }
    }
}

bool TaskScheduler::matches_time(const std::string& cron_expr, const std::string& hhmm) const {
    const auto cron_parts = split_by_space(cron_expr);
    if (cron_parts.size() < 2 || hhmm.size() != 5 || hhmm[2] != ':') {
        return false;
    }

    const auto minute = hhmm.substr(3, 2);
    const auto hour = hhmm.substr(0, 2);
    return cron_parts[0] == std::to_string(std::stoi(minute)) &&
        cron_parts[1] == std::to_string(std::stoi(hour));
}
