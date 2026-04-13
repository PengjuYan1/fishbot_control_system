#include "backend/app/AppContext.h"

AppContext build_app_context(const std::string& config_path) {
    AppContext context{load_config(config_path), Logger()};
    return context;
}
