#ifndef FISHBOT_BACKEND_API_SCHEDULECONTROLLER_H_
#define FISHBOT_BACKEND_API_SCHEDULECONTROLLER_H_

#include "backend/app/AppServer.h"
#include "backend/services/ScheduleService.h"

void register_schedule_routes(AppServer& server, ScheduleService& schedule_service);

#endif
