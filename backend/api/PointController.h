#ifndef FISHBOT_BACKEND_API_POINTCONTROLLER_H_
#define FISHBOT_BACKEND_API_POINTCONTROLLER_H_

#include "backend/app/AppServer.h"
#include "backend/services/PointService.h"

void register_point_routes(AppServer& server, PointService& point_service);

#endif
