#ifndef FISHBOT_BACKEND_SERVICES_MAPSERVICE_H_
#define FISHBOT_BACKEND_SERVICES_MAPSERVICE_H_

#include <string>

#include "ros_adapter/IRobotAdapter.h"
#include "storage/repositories/PointRepository.h"

struct MapWorkflowStatus {
    bool mapping_active = false;
    bool has_charge_point = false;
    bool has_initial_point = false;
    bool can_save_map = false;
    std::string next_step;
};

class MapService {
  public:
    MapService(IRobotAdapter& adapter, PointRepository& point_repository);

    bool start_mapping();
    bool stop_mapping();
    bool save_map(const std::string& map_name);
    MapSnapshot get_snapshot() const;
    MapWorkflowStatus get_workflow_status() const;

  private:
    MapWorkflowStatus build_workflow_status() const;

    IRobotAdapter& adapter_;
    PointRepository& point_repository_;
    bool mapping_active_ = false;
};

#endif
