#ifndef FISHBOT_BACKEND_API_ALERTCONTROLLER_H_
#define FISHBOT_BACKEND_API_ALERTCONTROLLER_H_

#include "backend/app/AppServer.h"
#include "backend/services/AlertService.h"

void register_alert_routes(AppServer& server, const AlertService& alert_service);

#endif
