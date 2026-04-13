#ifndef FISHBOT_BACKEND_SERVICES_SYSTEMSERVICE_H_
#define FISHBOT_BACKEND_SERVICES_SYSTEMSERVICE_H_

#include "backend/model/SystemSnapshot.h"
#include "ros_adapter/IRobotAdapter.h"

class SystemService {
  public:
    explicit SystemService(IRobotAdapter& adapter);

    SystemSnapshot get_snapshot() const;
    void record_connection_error(const std::string& message);
    void set_reconnect_attempts(int attempts);

  private:
    IRobotAdapter& adapter_;
    std::string last_error_;
    int reconnect_attempts_ = 0;
};

#endif
