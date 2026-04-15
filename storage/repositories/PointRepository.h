#ifndef FISHBOT_STORAGE_REPOSITORIES_POINTREPOSITORY_H_
#define FISHBOT_STORAGE_REPOSITORIES_POINTREPOSITORY_H_

#include <optional>
#include <vector>

#include "backend/model/PointRecord.h"
#include "storage/Database.h"

class PointRepository {
  public:
    explicit PointRepository(const DatabaseHandle& db);

    int insert_point(const PointRecord& point);
    int upsert_point(const PointRecord& point);
    std::optional<PointRecord> find_point(int id) const;
    std::optional<PointRecord> find_by_native_identity(long floor_id, long map_id, long point_id) const;
    bool delete_point(int id);
    int delete_points_by_map(long floor_id, long map_id);
    std::vector<PointRecord> list_points() const;
    void merge_native_points(const std::vector<PointRecord>& points);

  private:
    void update_point(const PointRecord& point);

    sqlite3* db_;
};

#endif
