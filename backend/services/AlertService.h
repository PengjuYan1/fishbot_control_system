#ifndef FISHBOT_BACKEND_SERVICES_ALERTSERVICE_H_
#define FISHBOT_BACKEND_SERVICES_ALERTSERVICE_H_

#include <vector>

#include "backend/model/EventLogRecord.h"
#include "storage/repositories/EventLogRepository.h"

class AlertService {
  public:
    explicit AlertService(EventLogRepository& repository);

    std::vector<EventLogRecord> list_alerts() const;

  private:
    EventLogRepository& repository_;
};

#endif
