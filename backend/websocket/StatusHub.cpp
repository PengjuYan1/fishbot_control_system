#include "backend/websocket/StatusHub.h"

#include <algorithm>
#include <string>
#include <utility>

std::string StatusHub::connect_and_get_initial_message(const SystemSnapshot& snapshot) {
    return std::string("{\"type\":\"system_snapshot\",\"payload\":") + to_json(snapshot) + "}";
}

std::string StatusHub::build_map_snapshot_message(const MapSnapshot& snapshot) const {
    return std::string("{\"type\":\"map_snapshot\",\"payload\":") + to_json(snapshot) + "}";
}

std::string StatusHub::build_robot_pose_message(const Pose& pose) const {
    return std::string("{\"type\":\"robot_pose\",\"payload\":{\"x\":") +
        std::to_string(pose.x) + ",\"y\":" + std::to_string(pose.y) +
        ",\"theta\":" + std::to_string(pose.theta) + "}}";
}

std::string StatusHub::publish_system_snapshot(const SystemSnapshot& snapshot) const {
    const auto message =
        std::string("{\"type\":\"system_snapshot\",\"payload\":") + to_json(snapshot) + "}";
    broadcast(message);
    return message;
}

std::string StatusHub::publish_map_snapshot(const MapSnapshot& snapshot) const {
    const auto message = build_map_snapshot_message(snapshot);
    broadcast(message);
    return message;
}

std::string StatusHub::publish_robot_pose(const Pose& pose) const {
    const auto message = build_robot_pose_message(pose);
    broadcast(message);
    return message;
}

StatusHub::SubscriptionId StatusHub::subscribe(Subscriber subscriber) {
    std::lock_guard<std::mutex> lock(subscribers_mutex_);
    const auto subscription_id = next_subscription_id_++;
    subscribers_.emplace_back(subscription_id, std::move(subscriber));
    return subscription_id;
}

void StatusHub::unsubscribe(SubscriptionId subscription_id) {
    std::lock_guard<std::mutex> lock(subscribers_mutex_);
    subscribers_.erase(
        std::remove_if(
            subscribers_.begin(),
            subscribers_.end(),
            [subscription_id](const auto& entry) { return entry.first == subscription_id; }),
        subscribers_.end());
}

void StatusHub::broadcast(const std::string& message) const {
    std::vector<Subscriber> subscribers;
    {
        std::lock_guard<std::mutex> lock(subscribers_mutex_);
        for (const auto& entry : subscribers_) {
            subscribers.push_back(entry.second);
        }
    }

    for (const auto& subscriber : subscribers) {
        subscriber(message);
    }
}
