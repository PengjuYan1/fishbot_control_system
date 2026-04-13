#ifndef FISHBOT_ROS_ADAPTER_BRIDGE_CLIENT_ROSBRIDGEADAPTER_H_
#define FISHBOT_ROS_ADAPTER_BRIDGE_CLIENT_ROSBRIDGEADAPTER_H_

#include <string>

#include "ros_adapter/IRobotAdapter.h"
#include "ros_adapter/bridge_client/IRosbridgeTransport.h"

class RosbridgeAdapter : public IRobotAdapter {
  public:
    explicit RosbridgeAdapter(IRosbridgeTransport* transport);

    std::string mode_name() const override;
    bool connect() override;
    void disconnect() override;
    bool is_connected() const override;
    bool start_mapping() override;
    bool stop_mapping() override;
    bool save_map(const std::string& map_name) override;
    bool load_map(const std::string& map_id) override;
    bool navigate_to_pose(const Pose& pose) override;
    bool stop_navigation() override;
    bool set_initial_pose(const Pose& pose) override;
    Pose get_robot_pose() const override;
    int get_battery() const override;
    RobotStatus get_robot_status() const override;
    MapSnapshot get_map_snapshot() const override;
    bool is_charging() const override;

  private:
    bool call_simple(const std::string& method, const std::string& payload);

    IRosbridgeTransport* transport_;
    bool connected_ = false;
};

#endif
