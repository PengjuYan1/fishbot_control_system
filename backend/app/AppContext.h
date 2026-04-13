#ifndef FISHBOT_BACKEND_APP_APP_CONTEXT_H_
#define FISHBOT_BACKEND_APP_APP_CONTEXT_H_

#include <memory>

#include "backend/app/Config.h"
#include "backend/app/Logger.h"
#include "ros_adapter/IRobotAdapter.h"
#include "ros_adapter/bridge_client/IRosbridgeTransport.h"

struct AppContext {
    AppConfig config;
    Logger logger;
    std::unique_ptr<IRosbridgeTransport> rosbridge_transport;
    std::unique_ptr<IRobotAdapter> adapter;
};

AppContext build_app_context(const std::string& config_path);

#endif
