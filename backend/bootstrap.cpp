#include "backend/bootstrap.h"

#include "backend/app/Config.h"

#include <exception>

namespace {
bool is_supported_adapter_mode(const std::string& adapter_mode) {
    return adapter_mode == "rosbridge" || adapter_mode == "native" || adapter_mode == "fake";
}
}  // namespace

bool start_app_with_config(const std::string& config_path) {
    try {
        const auto config = load_config(config_path);
        return is_supported_adapter_mode(config.adapter_mode);
    } catch (const std::exception&) {
        return false;
    }
}
