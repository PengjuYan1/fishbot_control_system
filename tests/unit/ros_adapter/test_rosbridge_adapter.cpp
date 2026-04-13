#include <algorithm>
#include <cmath>
#include <cstdlib>
#include <functional>
#include <iostream>
#include <string>
#include <sstream>
#include <unordered_map>
#include <vector>

#include "ros_adapter/bridge_client/IRosbridgeTransport.h"
#include "ros_adapter/bridge_client/RosbridgeAdapter.h"

class FakeRosbridgeTransport : public IRosbridgeTransport {
  public:
    bool connect() override {
        connected_ = true;
        return true;
    }

    void disconnect() override { connected_ = false; }

    bool is_connected() const override { return connected_; }

    bool publish(const std::string& topic, const std::string& type, const std::string& payload) override {
        last_topic_ = topic;
        last_type_ = type;
        last_payload_ = payload;
        published_count_ += 1;
        published_topics_.push_back(topic);
        published_payloads_.push_back(payload);
        return true;
    }

    bool call_service(const std::string& service, const std::string& type, const std::string& request,
                      std::string* response) override {
        last_service_ = service;
        last_type_ = type;
        last_payload_ = request;
        if (response != nullptr) {
            *response = "{}";
        }
        return true;
    }

    bool subscribe(const std::string& topic, const std::string& type, MessageCallback callback) override {
        subscriptions_[topic] = std::move(callback);
        subscription_types_[topic] = type;
        return true;
    }

    void emit(const std::string& topic, const std::string& payload) {
        subscriptions_.at(topic)(payload);
    }

    bool has_subscription(const std::string& topic) const {
        return subscriptions_.find(topic) != subscriptions_.end();
    }

    std::string last_service() const { return last_service_; }
    std::string last_topic() const { return last_topic_; }
    std::string last_type() const { return last_type_; }
    std::string last_payload() const { return last_payload_; }
    int published_count() const { return published_count_; }
    std::size_t subscription_count() const { return subscriptions_.size(); }
    const std::vector<std::string>& published_topics() const { return published_topics_; }
    const std::vector<std::string>& published_payloads() const { return published_payloads_; }

  private:
    bool connected_ = false;
    std::string last_service_;
    std::string last_topic_;
    std::string last_type_;
    std::string last_payload_;
    int published_count_ = 0;
    std::vector<std::string> published_topics_;
    std::vector<std::string> published_payloads_;
    std::unordered_map<std::string, MessageCallback> subscriptions_;
    std::unordered_map<std::string, std::string> subscription_types_;
};

int main() {
    FakeRosbridgeTransport transport;
    RosbridgeAdapter adapter(&transport);

    if (!adapter.connect()) {
        std::cerr << "expected adapter connect to succeed\n";
        return EXIT_FAILURE;
    }

    const std::vector<std::string> expected_topics = {
        "power_report",
        "androidmsg_emergencystatus",
        "androidmsg_motorenabledstatus",
        "androidmsg_chargestatus",
        "androidmsg_stm32status",
        "androidmsg_odomstatus",
        "motion_mode",
        "outofcharge_status",
        "reviceOutMachineSignal",
        "androidmsg_outofchargepoint",
        "androidmsg_locationstatus",
        "androidmsg_navigationstatus",
        "tracked_pose",
        "/map",
        "androidmsg_mapstatus",
        "map_status",
    };

    for (const auto& topic : expected_topics) {
        if (!transport.has_subscription(topic)) {
            std::cerr << "expected subscription for real APK topic: " << topic << "\n";
            return EXIT_FAILURE;
        }
    }

    transport.emit("power_report", "{\"data\":67}");
    transport.emit("androidmsg_emergencystatus", "{\"data\":31}");
    transport.emit("androidmsg_motorenabledstatus", "{\"data\":33}");
    transport.emit("androidmsg_locationstatus", "{\"data\":10}");
    transport.emit("androidmsg_chargestatus", "{\"data\":45}");
    transport.emit("androidmsg_stm32status", "{\"data\":17}");
    transport.emit("androidmsg_odomstatus", "{\"data\":19}");
    transport.emit("motion_mode", "{\"data\":1}");
    transport.emit("outofcharge_status", "{\"data\":1}");
    transport.emit("reviceOutMachineSignal", "{\"data\":1}");
    transport.emit("androidmsg_outofchargepoint", "{\"data\":49}");
    transport.emit("androidmsg_navigationstatus", "{\"data\":1}");
    transport.emit("tracked_pose", "{\"pose\":{\"position\":{\"x\":1.5,\"y\":2.5,\"z\":0.0},\"orientation\":{\"x\":0.0,\"y\":0.0,\"z\":0.247404,\"w\":0.968912}}}");
    transport.emit("/map", "{\"info\":{\"width\":3,\"height\":2,\"resolution\":0.05,\"origin\":{\"position\":{\"x\":-1.5,\"y\":-2.5}}},\"data\":[0,100,-1,0,0,100]}");

    if (adapter.get_battery() != 67) {
        std::cerr << "expected battery cache to update from power_report\n";
        return EXIT_FAILURE;
    }

    if (!adapter.get_robot_status().localized || !adapter.is_charging()) {
        std::cerr << "expected localized and charging states from subscriptions\n";
        return EXIT_FAILURE;
    }

    const auto status = adapter.get_robot_status();
    if (!status.emergency_stopped || !status.motor_locked ||
        status.charge_status_code != 45 || status.stm32_status_code != 17 ||
        status.odom_status_code != 19 || status.motion_mode_code != 1 ||
        status.out_of_charge_status_code != 1 || !status.out_machine_signal ||
        status.out_of_charge_result_code != 49) {
        std::cerr << "expected control diagnostics to update from rosbridge status topics\n";
        return EXIT_FAILURE;
    }

    if (adapter.get_map_snapshot().width != 3) {
        std::cerr << "expected map cache to update from /map\n";
        return EXIT_FAILURE;
    }

    if (std::abs(adapter.get_map_snapshot().origin_x + 1.5) > 1e-6 ||
        std::abs(adapter.get_map_snapshot().origin_y + 2.5) > 1e-6) {
        std::cerr << "expected /map origin to be cached for frontend projection\n";
        return EXIT_FAILURE;
    }

    const auto pose = adapter.get_robot_pose();
    if (std::abs(pose.x - 1.5) > 1e-6 || std::abs(pose.y - 2.5) > 1e-6) {
        std::cerr << "expected tracked_pose to update cached robot pose\n";
        return EXIT_FAILURE;
    }

    Pose goal{};
    goal.point_id = 12;
    goal.map_id = 34;
    goal.floor_id = 56;

    if (!adapter.navigate_to_pose(goal)) {
        std::cerr << "expected navigate_to_pose to succeed\n";
        return EXIT_FAILURE;
    }

    if (transport.last_service() != "navi_targegoalplan") {
        std::cerr << "expected navi_targegoalplan service call without leading slash\n";
        return EXIT_FAILURE;
    }

    if (transport.last_payload().find("\"floor_id\":56") == std::string::npos ||
        transport.last_payload().find("\"map_id\":34") == std::string::npos ||
        transport.last_payload().find("\"point_id\":12") == std::string::npos) {
        std::cerr << "expected floor/map/point ids in target plan request\n";
        return EXIT_FAILURE;
    }

    if (!adapter.load_map("56:34")) {
        std::cerr << "expected load_map to accept floor_id:map_id selector\n";
        return EXIT_FAILURE;
    }

    if (transport.last_service() != "/publish_map") {
        std::cerr << "expected /publish_map service call\n";
        return EXIT_FAILURE;
    }

    if (transport.last_payload().find("\"floor_id\":56") == std::string::npos ||
        transport.last_payload().find("\"map_id\":34") == std::string::npos) {
        std::cerr << "expected floor/map ids in publish_map request\n";
        return EXIT_FAILURE;
    }

    if (!adapter.stop_navigation()) {
        std::cerr << "expected stop_navigation to succeed\n";
        return EXIT_FAILURE;
    }

    const auto& stop_topics = transport.published_topics();
    const auto& stop_payloads = transport.published_payloads();
    if (stop_topics.size() < 4) {
        std::cerr << "expected repeated stop_navigation publishes\n";
        return EXIT_FAILURE;
    }

    if (stop_topics[stop_topics.size() - 4] != "/navi_stop" ||
        stop_topics[stop_topics.size() - 3] != "/navi_stop" ||
        stop_topics[stop_topics.size() - 2] != "/navi_stop" ||
        stop_topics.back() != "cmd_vel") {
        std::cerr << "expected stop_navigation to publish repeated /navi_stop then zero cmd_vel\n";
        return EXIT_FAILURE;
    }

    if (stop_payloads[stop_payloads.size() - 4].find("\"data\":5") == std::string::npos ||
        stop_payloads.back().find("\"x\":0") == std::string::npos ||
        stop_payloads.back().find("\"z\":0") == std::string::npos) {
        std::cerr << "expected repeated stop payload and zero velocity release\n";
        return EXIT_FAILURE;
    }

    if (!adapter.out_of_charge()) {
        std::cerr << "expected out_of_charge to succeed\n";
        return EXIT_FAILURE;
    }

    if (transport.last_topic() != "outofcharge" ||
        transport.last_payload().find("\"data\":1") == std::string::npos) {
        std::cerr << "expected outofcharge publish with data=1\n";
        return EXIT_FAILURE;
    }

    if (!adapter.manual_move(0.2, 0.4)) {
        std::cerr << "expected manual_move to succeed\n";
        return EXIT_FAILURE;
    }

    if (transport.last_topic() != "cmd_vel" ||
        transport.last_type() != "geometry_msgs/Twist" ||
        transport.last_payload().find("\"x\":0.2") == std::string::npos ||
        transport.last_payload().find("\"z\":-0.4") == std::string::npos) {
        std::cerr << "expected cmd_vel publish to match apk motion command format\n";
        return EXIT_FAILURE;
    }

    if (!adapter.manual_move(0.18, 0.0)) {
        std::cerr << "expected forward directional move to succeed\n";
        return EXIT_FAILURE;
    }

    if (transport.last_topic() != "cmd_vel" ||
        transport.last_type() != "geometry_msgs/Twist" ||
        transport.last_payload().find("\"x\":0.18") == std::string::npos ||
        transport.last_payload().find("\"z\":0") == std::string::npos) {
        std::cerr << "expected forward button move to use repeated cmd_vel teleop format\n";
        return EXIT_FAILURE;
    }

    if (!adapter.manual_move(-0.12, 0.0)) {
        std::cerr << "expected backward directional move to succeed\n";
        return EXIT_FAILURE;
    }

    if (transport.last_topic() != "cmd_vel" ||
        transport.last_type() != "geometry_msgs/Twist" ||
        transport.last_payload().find("\"x\":-0.12") == std::string::npos ||
        transport.last_payload().find("\"z\":0") == std::string::npos) {
        std::cerr << "expected backward button move to use repeated cmd_vel teleop format\n";
        return EXIT_FAILURE;
    }

    if (!adapter.manual_move(0.0, 0.8)) {
        std::cerr << "expected left turn directional move to succeed\n";
        return EXIT_FAILURE;
    }

    if (transport.last_topic() != "cmd_vel" ||
        transport.last_type() != "geometry_msgs/Twist" ||
        transport.last_payload().find("\"x\":0") == std::string::npos ||
        transport.last_payload().find("\"z\":-0.8") == std::string::npos) {
        std::cerr << "expected left turn button move to use repeated cmd_vel teleop format\n";
        return EXIT_FAILURE;
    }

    if (!adapter.manual_move(0.0, -0.8)) {
        std::cerr << "expected right turn directional move to succeed\n";
        return EXIT_FAILURE;
    }

    if (transport.last_topic() != "cmd_vel" ||
        transport.last_type() != "geometry_msgs/Twist" ||
        transport.last_payload().find("\"x\":0") == std::string::npos ||
        transport.last_payload().find("\"z\":0.8") == std::string::npos) {
        std::cerr << "expected right turn button move to use repeated cmd_vel teleop format\n";
        return EXIT_FAILURE;
    }

    if (!adapter.manual_move(0.0, 0.0)) {
        std::cerr << "expected stop directional move to succeed\n";
        return EXIT_FAILURE;
    }

    if (transport.last_topic() != "cmd_vel" ||
        transport.last_type() != "geometry_msgs/Twist" ||
        transport.last_payload().find("\"x\":0") == std::string::npos ||
        transport.last_payload().find("\"z\":0") == std::string::npos) {
        std::cerr << "expected stop move to use zero cmd_vel\n";
        return EXIT_FAILURE;
    }

    std::ostringstream huge_map;
    huge_map << "{\"info\":{\"width\":500,\"height\":500,\"resolution\":0.05,"
             << "\"origin\":{\"position\":{\"x\":-1.5,\"y\":-2.5}}},\"data\":[";
    for (int index = 0; index < 250000; ++index) {
        if (index > 0) {
            huge_map << ',';
        }
        huge_map << '0';
    }
    huge_map << "]}";
    transport.emit("/map", huge_map.str());

    const auto huge_snapshot = adapter.get_map_snapshot();
    if (huge_snapshot.width != 500 || huge_snapshot.height != 500 ||
        huge_snapshot.occupancy_data.size() != 250000) {
        std::cerr << "expected large /map payload to parse without crashing\n";
        return EXIT_FAILURE;
    }

    return EXIT_SUCCESS;
}
