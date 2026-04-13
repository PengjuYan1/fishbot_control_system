#ifndef FISHBOT_BACKEND_SERVICES_MAPSERVICE_H_
#define FISHBOT_BACKEND_SERVICES_MAPSERVICE_H_

#include <string>

#include "ros_adapter/IRobotAdapter.h"

class MapService {
  public:
    explicit MapService(IRobotAdapter& adapter);

    bool start_mapping() const;
    bool stop_mapping() const;
    bool save_map(const std::string& map_name) const;

  private:
    IRobotAdapter& adapter_;
};

#endif
