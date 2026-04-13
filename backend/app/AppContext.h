#ifndef FISHBOT_BACKEND_APP_APP_CONTEXT_H_
#define FISHBOT_BACKEND_APP_APP_CONTEXT_H_

#include "backend/app/Config.h"
#include "backend/app/Logger.h"

struct AppContext {
    AppConfig config;
    Logger logger;
};

AppContext build_app_context(const std::string& config_path);

#endif
