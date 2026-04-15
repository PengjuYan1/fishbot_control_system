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
    bool save_map(const std::string& map_name);
    bool load_map(long floor_id, long map_id) const;
    std::vector<MapDescriptor> list_maps() const;
    bool delete_map(long floor_id, long map_id) const;
    MapSnapshot get_snapshot() const;
    void observe_system_snapshot(const SystemSnapshot& snapshot);

  private:
    struct SuppressedMapIdentity {
        long floor_id = 0;
        long map_id = 0;
        long long expires_ms = 0;
    };

    bool charging_detected(const SystemSnapshot& snapshot) const;
    bool try_seed_mapping_points_once();
    void run_seed_worker();
    void prune_suppressed_maps(long long now_ms) const;
    bool map_suppressed(long floor_id, long map_id) const;

    IRobotAdapter& adapter_;
    PointRepository* point_repository_ = nullptr;
    mutable std::mutex state_mutex_;
    bool mapping_active_ = false;
    bool mapping_seed_done_ = false;
    std::atomic<bool> mapping_seed_inflight_{false};
    mutable std::vector<MapDescriptor> cached_maps_;
    mutable long long last_maps_success_ms_ = 0;
    mutable std::vector<SuppressedMapIdentity> suppressed_maps_;
};

#endif
