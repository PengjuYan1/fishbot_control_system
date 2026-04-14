#ifndef FISHBOT_ROS_ADAPTER_NATIVE_ROS_NATIVEROSADAPTER_H_
#define FISHBOT_ROS_ADAPTER_NATIVE_ROS_NATIVEROSADAPTER_H_

#include <string>

#include "ros_adapter/IRobotAdapter.h"

class NativeRosAdapter : public IRobotAdapter {
  public:
    NativeRosAdapter() = default;

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
    ManualControlAcquireResult acquire_manual_control() override;
    bool out_of_charge() override;
    bool manual_move(double linear_speed, double angular_speed) override;
    Pose get_robot_pose() const override;
    int get_battery() const override;
    RobotStatus get_robot_status() const override;
    MapSnapshot get_map_snapshot() const override;
    bool is_charging() const override;

  private:
    bool connected_ = false;
};

#endif
