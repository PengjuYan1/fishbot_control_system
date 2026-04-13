#ifndef FISHBOT_BACKEND_SERVICES_MANUALCONTROLSERVICE_H_
#define FISHBOT_BACKEND_SERVICES_MANUALCONTROLSERVICE_H_

#include "ros_adapter/IRobotAdapter.h"

class ManualControlService {
  public:
    explicit ManualControlService(IRobotAdapter& adapter);

    bool out_of_charge();
    bool exit_navigation_mode();
    bool move(double linear_speed, double angular_speed);
    bool stop();

  private:
    bool release_navigation_control();

    IRobotAdapter& adapter_;
    bool control_session_active_ = false;
};

#endif
