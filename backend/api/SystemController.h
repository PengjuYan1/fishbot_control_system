#ifndef FISHBOT_BACKEND_API_SYSTEMCONTROLLER_H_
#define FISHBOT_BACKEND_API_SYSTEMCONTROLLER_H_

#include "backend/app/AppServer.h"
#include "backend/services/SystemService.h"

void register_system_routes(AppServer& server, const SystemService& system_service);

#endif
