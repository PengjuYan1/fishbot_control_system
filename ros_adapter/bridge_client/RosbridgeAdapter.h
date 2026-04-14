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
    bool out_of_charge() override;
    bool manual_move(double linear_speed, double angular_speed) override;
    Pose get_robot_pose() const override;
    int get_battery() const override;
    RobotStatus get_robot_status() const override;
    MapSnapshot get_map_snapshot() const override;
    bool is_charging() const override;
    bool create_current_pose_point(const std::string& name, long point_mode, PointRecord* point) override;
    bool delete_saved_point(const PointRecord& point) override;

  private:
    bool subscribe_status_topics();
    bool publish_topic(const std::string& topic, const std::string& type, const std::string& payload);
    bool call_service(const std::string& service, const std::string& type, const std::string& request,
                      std::string* response = nullptr);
    void handle_battery_message(const std::string& payload);
    void handle_charge_message(const std::string& payload);
    void handle_stm32_message(const std::string& payload);
    void handle_odom_message(const std::string& payload);
    void handle_emergency_message(const std::string& payload);
    void handle_motor_lock_message(const std::string& payload);
    void handle_motion_mode_message(const std::string& payload);
    void handle_location_message(const std::string& payload);
    void handle_navigation_message(const std::string& payload);
    void handle_out_of_charge_status_message(const std::string& payload);
    void handle_out_machine_signal_message(const std::string& payload);
    void handle_out_of_charge_result_message(const std::string& payload);
    void handle_pose_message(const std::string& payload);
    void handle_map_message(const std::string& payload);
    void handle_map_status_message(const std::string& payload);
    void handle_android_map_status_message(const std::string& payload);

    IRosbridgeTransport* transport_;
    bool connected_ = false;
    int battery_ = 0;
    bool charging_ = false;
    bool localized_ = false;
    bool emergency_stopped_ = false;
    int emergency_status_code_ = 0;
    bool motor_locked_ = false;
    int motor_status_code_ = 0;
    int charge_status_code_ = 0;
    int stm32_status_code_ = 0;
    int odom_status_code_ = 0;
    int motion_mode_code_ = 0;
    int out_of_charge_status_code_ = 0;
    bool out_machine_signal_ = false;
    int out_of_charge_result_code_ = 0;
    int navigation_status_ = 0;
    int map_status_ = 0;
    int android_map_status_ = 0;
    Pose pose_;
    MapSnapshot map_snapshot_;
};

#endif
