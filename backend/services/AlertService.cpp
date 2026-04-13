#include "backend/services/AlertService.h"

AlertService::AlertService(EventLogRepository& repository) : repository_(repository) {}

std::vector<EventLogRecord> AlertService::list_alerts() const {
    return repository_.list_alerts();
}
