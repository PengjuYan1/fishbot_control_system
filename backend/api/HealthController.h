#ifndef FISHBOT_BACKEND_API_HEALTHCONTROLLER_H_
#define FISHBOT_BACKEND_API_HEALTHCONTROLLER_H_

#include "backend/app/AppServer.h"
#include "backend/app/Config.h"

void register_health_routes(AppServer& server, const AppConfig& config);

#endif
