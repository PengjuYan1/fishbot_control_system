#ifndef FISHBOT_BACKEND_SERVICES_POINTSERVICE_H_
#define FISHBOT_BACKEND_SERVICES_POINTSERVICE_H_

#include <string>
#include <vector>

#include "backend/model/PointRecord.h"
#include "storage/repositories/PointRepository.h"

class PointService {
  public:
    explicit PointService(PointRepository& repository);

    int create_charge_point(const std::string& body);
    int create_feed_point(const std::string& body);
    std::vector<PointRecord> list_points() const;

  private:
    PointRecord parse_point(const std::string& body, const std::string& type) const;

    PointRepository& repository_;
};

#endif
