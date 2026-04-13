#include "backend/app/AppContext.h"

#include <memory>
#include <utility>

#include "ros_adapter/bridge_client/RosbridgeAdapter.h"
#include "ros_adapter/bridge_client/RosbridgeWebsocketTransport.h"
#include "ros_adapter/native_ros/NativeRosAdapter.h"

namespace {
class FakeRobotAdapter : public IRobotAdapter {
  public:
    std::string mode_name() const override { return "fake"; }
    bool connect() override {
        connected_ = true;
        return true;
    }
    void disconnect() override { connected_ = false; }
    bool is_connected() const override { return connected_; }
    bool start_mapping() override { return true; }
    bool stop_mapping() override { return true; }
    bool save_map(const std::string&) override { return true; }
    bool load_map(const std::string&) override { return true; }
    bool navigate_to_pose(const Pose& pose) override {
        pose_ = pose;
        return true;
    }
    bool stop_navigation() override { return true; }
    bool set_initial_pose(const Pose& pose) override {
        pose_ = pose;
        return true;
    }
    bool out_of_charge() override { return true; }
    bool manual_move(double linear_speed, double angular_speed) override {
        pose_.x += linear_speed;
        pose_.theta += angular_speed;
        return true;
    }
    Pose get_robot_pose() const override { return pose_; }
    int get_battery() const override { return 100; }
    RobotStatus get_robot_status() const override { return RobotStatus{100, false, connected_, true}; }
    MapSnapshot get_map_snapshot() const override { return {}; }
    bool is_charging() const override { return false; }

  private:
    bool connected_ = false;
    Pose pose_;
};
}  // namespace

AppContext build_app_context(const std::string& config_path) {
    AppContext context{load_config(config_path), Logger(), nullptr, nullptr};
    if (context.config.adapter_mode == "rosbridge") {
        context.rosbridge_transport = std::make_unique<RosbridgeWebsocketTransport>(
            context.config.rosbridge_host, context.config.rosbridge_port);
        context.adapter = std::make_unique<RosbridgeAdapter>(context.rosbridge_transport.get());
    } else if (context.config.adapter_mode == "native") {
        context.adapter = std::make_unique<NativeRosAdapter>();
    } else if (context.config.adapter_mode == "fake") {
        context.adapter = std::make_unique<FakeRobotAdapter>();
    }
    return context;
}
