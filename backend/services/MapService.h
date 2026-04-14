#ifndef FISHBOT_BACKEND_SERVICES_MAPSERVICE_H_
#define FISHBOT_BACKEND_SERVICES_MAPSERVICE_H_

#include <atomic>
#include <mutex>
#include <string>
#include <vector>

#include "backend/model/SystemSnapshot.h"
#include "ros_adapter/IRobotAdapter.h"
#include "ros_adapter/model/MapDescriptor.h"

class PointRepository;

class MapService {
  public:
    explicit MapService(IRobotAdapter& adapter, PointRepository* point_repository = nullptr);

    bool start_mapping();
    bool stop_mapping();
    bool save_map(const std::string& map_name) const;
    std::vector<MapDescriptor> list_maps() const;
    bool delete_map(long floor_id, long map_id) const;
    MapSnapshot get_snapshot() const;
    void observe_system_snapshot(const SystemSnapshot& snapshot);

  private:
    bool charging_detected(const SystemSnapshot& snapshot) const;
    bool try_seed_mapping_points_once();
    void run_seed_worker();

    IRobotAdapter& adapter_;
    PointRepository* point_repository_ = nullptr;
    std::mutex state_mutex_;
    bool mapping_active_ = false;
    bool mapping_seed_done_ = false;
    std::atomic<bool> mapping_seed_inflight_{false};
};

#endif
