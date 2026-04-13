#ifndef FISHBOT_BACKEND_API_CONTROLCONTROLLER_H_
#define FISHBOT_BACKEND_API_CONTROLCONTROLLER_H_

#include "backend/app/AppServer.h"
#include "backend/services/ManualControlService.h"

void register_control_routes(AppServer& server, ManualControlService& control_service);

#endif
