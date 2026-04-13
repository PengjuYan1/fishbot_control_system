#include "backend/runtime/StatusStreamService.h"

StatusStreamService::StatusStreamService(SystemService& system_service, MapService& map_service, StatusHub& status_hub)
    : system_service_(system_service),
      map_service_(map_service),
      status_hub_(status_hub) {}

StatusStreamService::~StatusStreamService() {
    stop();
}

std::vector<std::string> StatusStreamService::connect_client() const {
    return {
        status_hub_.connect_and_get_initial_message(system_service_.get_snapshot()),
        status_hub_.publish_map_snapshot(map_service_.get_snapshot()),
    };
}

void StatusStreamService::subscribe(Subscriber subscriber) {
    subscribers_.push_back(std::move(subscriber));
}

void StatusStreamService::start(std::chrono::milliseconds interval) {
    stop();
    running_ = true;
    worker_thread_ = std::thread([this, interval]() {
        while (running_) {
            poll_once();
            std::this_thread::sleep_for(interval);
        }
    });
}

void StatusStreamService::stop() {
    running_ = false;
    if (worker_thread_.joinable()) {
        worker_thread_.join();
    }
}

void StatusStreamService::poll_once() {
    const auto snapshot = system_service_.get_snapshot();
    const auto map_snapshot = map_service_.get_snapshot();
    const std::vector<std::string> messages = {
        status_hub_.connect_and_get_initial_message(snapshot),
        status_hub_.publish_map_snapshot(map_snapshot),
        status_hub_.publish_robot_pose(snapshot.pose),
    };

    for (const auto& message : messages) {
        for (const auto& subscriber : subscribers_) {
            subscriber(message);
        }
    }
}
