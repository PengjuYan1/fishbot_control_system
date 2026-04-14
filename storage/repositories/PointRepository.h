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
    std::optional<PointRecord> find_point(int id) const;
    bool delete_point(int id);
    std::vector<PointRecord> list_points() const;

  private:
    sqlite3* db_;
};

#endif
