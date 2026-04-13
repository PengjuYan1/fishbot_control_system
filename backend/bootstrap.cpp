#include "backend/bootstrap.h"

#include "backend/app/AppContext.h"

#include <exception>

namespace {
bool is_supported_adapter_mode(const std::string& adapter_mode) {
    return adapter_mode == "rosbridge" || adapter_mode == "native" || adapter_mode == "fake";
}
}  // namespace

bool start_app_with_config(const std::string& config_path) {
    try {
        const auto context = build_app_context(config_path);
        return is_supported_adapter_mode(context.config.adapter_mode) &&
            (context.config.adapter_mode == "fake" || context.adapter != nullptr);
    } catch (const std::exception&) {
        return false;
    }
}
