#ifndef FISHBOT_BACKEND_SERVICES_SYSTEMSERVICE_H_
#define FISHBOT_BACKEND_SERVICES_SYSTEMSERVICE_H_

#include "backend/model/SystemSnapshot.h"
#include "ros_adapter/IRobotAdapter.h"

class SystemService {
  public:
    explicit SystemService(IRobotAdapter& adapter);

    SystemSnapshot get_snapshot() const;

  private:
    IRobotAdapter& adapter_;
};

#endif
