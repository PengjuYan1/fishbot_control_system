#ifndef FISHBOT_BACKEND_MODEL_SCHEDULERECORD_H_
#define FISHBOT_BACKEND_MODEL_SCHEDULERECORD_H_

#include <string>

struct ScheduleRecord {
    int id = 0;
    std::string name;
    bool enabled = true;
    std::string cron_expr;
    std::string point_order_json = "[]";
};

#endif
