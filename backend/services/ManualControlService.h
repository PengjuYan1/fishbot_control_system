#ifndef FISHBOT_BACKEND_SERVICES_MANUALCONTROLSERVICE_H_
#define FISHBOT_BACKEND_SERVICES_MANUALCONTROLSERVICE_H_

#include "ros_adapter/IRobotAdapter.h"

class ManualControlService {
  public:
    explicit ManualControlService(IRobotAdapter& adapter);

    bool out_of_charge();
    bool move(double linear_speed, double angular_speed);
    bool stop();

  private:
    IRobotAdapter& adapter_;
};

#endif
