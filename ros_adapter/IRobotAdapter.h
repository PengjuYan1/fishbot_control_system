#ifndef FISHBOT_ROS_ADAPTER_IROBOTADAPTER_H_
#define FISHBOT_ROS_ADAPTER_IROBOTADAPTER_H_

#include <string>
#include <vector>

#include "backend/model/PointRecord.h"
#include "ros_adapter/model/MapSnapshot.h"
#include "ros_adapter/model/Pose.h"
#include "ros_adapter/model/RobotStatus.h"

enum class ManualControlAcquireState {
    kReady,
    kUndockingRequested,
    kFailed,
};

struct ManualControlAcquireResult {
    bool ok = false;
    ManualControlAcquireState state = ManualControlAcquireState::kFailed;
};

class IRobotAdapter {
  public:
    virtual ~IRobotAdapter() = default;

    virtual std::string mode_name() const = 0;
    virtual bool connect() = 0;
    virtual void disconnect() = 0;
    virtual bool is_connected() const = 0;
    virtual bool start_mapping() = 0;
    virtual bool stop_mapping() = 0;
    virtual bool save_map(const std::string& map_name) = 0;
    virtual bool load_map(const std::string& map_id) = 0;
    virtual bool navigate_to_pose(const Pose& pose) = 0;
    virtual bool stop_navigation() = 0;
    virtual bool set_initial_pose(const Pose& pose) = 0;
    virtual ManualControlAcquireResult acquire_manual_control() = 0;
    virtual bool out_of_charge() = 0;
    virtual bool go_charge() { return false; }
    virtual bool manual_move(double linear_speed, double angular_speed) = 0;
    virtual Pose get_robot_pose() const = 0;
    virtual int get_battery() const = 0;
    virtual RobotStatus get_robot_status() const = 0;
    virtual MapSnapshot get_map_snapshot() const = 0;
    virtual bool is_charging() const = 0;
    virtual bool create_current_pose_point(const std::string& name, long point_mode, PointRecord* point) {
        (void) name;
        (void) point_mode;
        (void) point;
        return false;
    }
    virtual bool delete_saved_point(const PointRecord& point) {
        (void) point;
        return false;
    }
};

std::vector<std::string> describe_adapter_contract();

#endif
