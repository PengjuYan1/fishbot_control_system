#ifndef FISHBOT_BACKEND_SERVICES_NATIVEPOINTSYNC_H_
#define FISHBOT_BACKEND_SERVICES_NATIVEPOINTSYNC_H_

#include <vector>

#include "backend/model/PointRecord.h"
#include "ros_adapter/IRobotAdapter.h"
#include "storage/repositories/PointRepository.h"

inline bool sync_native_points_if_supported(IRobotAdapter& adapter, PointRepository& repository) {
    std::vector<PointRecord> native_points;
    if (!adapter.list_native_points(&native_points)) {
        return false;
    }

    repository.merge_native_points(native_points);
    return true;
}

#endif
