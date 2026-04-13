#ifndef FISHBOT_BACKEND_API_MAPCONTROLLER_H_
#define FISHBOT_BACKEND_API_MAPCONTROLLER_H_

#include "backend/app/AppServer.h"
#include "backend/services/MapService.h"

void register_map_routes(AppServer& server, const MapService& map_service);

#endif
