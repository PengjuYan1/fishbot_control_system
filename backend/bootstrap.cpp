#include "backend/bootstrap.h"

#include "backend/app/Config.h"

#include <exception>

bool start_app_with_config(const std::string& config_path) {
    try {
        const auto config = load_config(config_path);
        return !config.adapter_mode.empty();
    } catch (const std::exception&) {
        return false;
    }
}
