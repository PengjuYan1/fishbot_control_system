#include "backend/services/MapService.h"

MapService::MapService(IRobotAdapter& adapter) : adapter_(adapter) {}

bool MapService::start_mapping() const {
    return adapter_.start_mapping();
}

bool MapService::stop_mapping() const {
    return adapter_.stop_mapping();
}

bool MapService::save_map(const std::string& map_name) const {
    return adapter_.save_map(map_name);
}
