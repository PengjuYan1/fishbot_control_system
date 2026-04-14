#ifndef FISHBOT_BACKEND_SERVICES_POINTSERVICE_H_
#define FISHBOT_BACKEND_SERVICES_POINTSERVICE_H_

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
    int create_feed_point(const std::string& body);
    PointRecord create_current_initial_point();
    PointRecord create_current_charge_point();
    PointRecord create_current_feed_point();
    PointRecord delete_point(int id);
    std::vector<PointRecord> list_points() const;

  private:
    std::string next_point_name(const std::string& prefix, const std::string& point_kind,
                                const std::string& biz_role) const;
    PointRecord parse_point(const std::string& body, const std::string& point_kind,
                            const std::string& biz_role) const;
    PointRecord create_current_point(const std::string& point_kind, const std::string& biz_role,
                                     const std::string& prefix, long point_mode);

    PointRepository& repository_;
    IRobotAdapter* adapter_ = nullptr;
};

#endif
