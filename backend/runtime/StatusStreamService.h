#ifndef FISHBOT_BACKEND_RUNTIME_STATUSSTREAMSERVICE_H_
#define FISHBOT_BACKEND_RUNTIME_STATUSSTREAMSERVICE_H_

#include <atomic>
#include <chrono>
#include <functional>
#include <string>
#include <thread>
#include <vector>

#include "backend/services/MapService.h"
#include "backend/services/SystemService.h"
#include "backend/websocket/StatusHub.h"

class StatusStreamService {
  public:
    using Subscriber = std::function<void(const std::string&)>;

    StatusStreamService(SystemService& system_service, MapService& map_service, StatusHub& status_hub);
    ~StatusStreamService();

    std::vector<std::string> connect_client() const;
    void subscribe(Subscriber subscriber);
    void start(std::chrono::milliseconds interval);
    void stop();
    void poll_once();

  private:
    SystemService& system_service_;
    MapService& map_service_;
    StatusHub& status_hub_;
    std::vector<Subscriber> subscribers_;
    std::atomic<bool> running_{false};
    std::thread worker_thread_;
};

#endif
