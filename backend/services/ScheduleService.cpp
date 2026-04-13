#include "backend/services/ScheduleService.h"

#include <sstream>
#include <unordered_map>

namespace {
std::unordered_map<std::string, std::string> parse_form_encoded(const std::string& body) {
    std::unordered_map<std::string, std::string> values;
    std::stringstream stream(body);
    std::string pair;
    while (std::getline(stream, pair, '&')) {
        const auto separator = pair.find('=');
        if (separator == std::string::npos) {
            continue;
        }
        values[pair.substr(0, separator)] = pair.substr(separator + 1);
    }
    return values;
}
}  // namespace

ScheduleService::ScheduleService(ScheduleRepository& repository) : repository_(repository) {}

int ScheduleService::create_schedule(const std::string& body) {
    return repository_.insert_schedule(parse_schedule(body));
}

std::vector<ScheduleRecord> ScheduleService::list_schedules() const {
    return repository_.list_schedules();
}

ScheduleRecord ScheduleService::parse_schedule(const std::string& body) const {
    const auto values = parse_form_encoded(body);
    ScheduleRecord schedule;
    schedule.name = values.at("name");
    schedule.enabled = values.count("enabled") == 0 ? true : values.at("enabled") != "0";
    schedule.cron_expr = values.at("cron");
    schedule.point_order_json = values.count("point_order_json") == 0 ? "[]" : values.at("point_order_json");
    return schedule;
}
