#ifndef FISHBOT_BACKEND_WEBSOCKET_STATUSHUB_H_
#define FISHBOT_BACKEND_WEBSOCKET_STATUSHUB_H_

#include <functional>
#include <mutex>
#include <string>
#include <vector>

#include "backend/model/SystemSnapshot.h"
#include "ros_adapter/model/MapSnapshot.h"

class StatusHub {
  public:
    using Subscriber = std::function<void(const std::string&)>;
    using SubscriptionId = std::size_t;

    std::string connect_and_get_initial_message(const SystemSnapshot& snapshot);
    std::string build_map_snapshot_message(const MapSnapshot& snapshot) const;
    std::string build_robot_pose_message(const Pose& pose) const;
    std::string publish_system_snapshot(const SystemSnapshot& snapshot) const;
    std::string publish_map_snapshot(const MapSnapshot& snapshot) const;
    std::string publish_robot_pose(const Pose& pose) const;
    SubscriptionId subscribe(Subscriber subscriber);
    void unsubscribe(SubscriptionId subscription_id);

  private:
    void broadcast(const std::string& message) const;

    mutable std::mutex subscribers_mutex_;
    mutable SubscriptionId next_subscription_id_ = 1;
    mutable std::vector<std::pair<SubscriptionId, Subscriber>> subscribers_;
};

#endif
