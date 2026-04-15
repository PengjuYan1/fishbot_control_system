#ifndef FISHBOT_BACKEND_SERVICES_POINTSERVICE_H_
#define FISHBOT_BACKEND_SERVICES_POINTSERVICE_H_

#include <atomic>
#include <mutex>
#include <string>
#include <vector>

#include "backend/model/PointRecord.h"
#include "storage/repositories/PointRepository.h"

class IRobotAdapter;

class PointService {
  public:
    explicit PointService(PointRepository& repository);
    PointService(PointRepository& repository, IRobotAdapter& adapter);

    int create_charge_point(const std::string& body);
    int create_nav_point(const std::string& body);
    int create_feed_point(const std::string& body);
    PointRecord create_current_charge_point();
    PointRecord create_current_nav_point();
    PointRecord create_current_feed_point();
    PointRecord delete_point(int id);
    std::vector<PointRecord> list_points() const;

  private:
    struct SuppressedNativeIdentity {
        long floor_id = 0;
        long map_id = 0;
        long point_id = 0;
        long long expires_ms = 0;
    };

    std::string next_point_name(const std::string& prefix, const std::string& type) const;
    PointRecord parse_point(const std::string& body, const std::string& type) const;
    PointRecord create_current_point(const std::string& type, const std::string& prefix, long point_mode);
    void schedule_native_sync() const;
    void run_native_sync_once() const;
    void remember_deleted_native_identity(const PointRecord& point);
    bool native_identity_suppressed(const PointRecord& point) const;
    void prune_suppressed_native_identities(long long now_ms) const;

    PointRepository& repository_;
    IRobotAdapter* adapter_ = nullptr;
    mutable std::atomic<bool> native_sync_inflight_{false};
    mutable std::atomic<long long> native_sync_started_ms_{0};
    mutable std::mutex suppressed_native_identities_mutex_;
    mutable std::vector<SuppressedNativeIdentity> suppressed_native_identities_;
};

#endif
