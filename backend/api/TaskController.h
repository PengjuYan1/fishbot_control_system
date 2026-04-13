#ifndef FISHBOT_BACKEND_API_TASKCONTROLLER_H_
#define FISHBOT_BACKEND_API_TASKCONTROLLER_H_

#include "backend/app/AppServer.h"
#include "backend/services/TaskService.h"

void register_task_routes(AppServer& server, TaskService& task_service);

#endif
