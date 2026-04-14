#include <algorithm>
#include <cmath>
#include <cstdlib>
#include <functional>
#include <iostream>
#include <map>
#include <sstream>
#include <string>
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
        auto it = publish_failures_remaining_.find(topic);
        if (it != publish_failures_remaining_.end() && it->second > 0) {
            it->second -= 1;
            return false;
        }
        return true;
    }

    bool call_service(const std::string& service, const std::string& type, const std::string& request,
                      std::string* response) override {
        last_service_ = service;
        last_type_ = type;
        last_payload_ = request;
        called_services_.push_back(service);
        called_payloads_.push_back(request);
        if (response != nullptr) {
            auto response_it = service_responses_.find(service);
            *response = response_it != service_responses_.end() ? response_it->second : "{}";
        }
        auto it = service_failures_remaining_.find(service);
        if (it != service_failures_remaining_.end() && it->second > 0) {
            it->second -= 1;
            return false;
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
    const std::vector<std::string>& called_services() const { return called_services_; }
    const std::vector<std::string>& called_payloads() const { return called_payloads_; }
    void fail_publish(const std::string& topic, int times) { publish_failures_remaining_[topic] = times; }
    void fail_service(const std::string& service, int times) { service_failures_remaining_[service] = times; }
    void set_service_response(const std::string& service, const std::string& response) {
        service_responses_[service] = response;
    }

  private:
    bool connected_ = false;
    std::string last_service_;
    std::string last_topic_;
    std::string last_type_;
    std::string last_payload_;
    int published_count_ = 0;
    std::vector<std::string> published_topics_;
    std::vector<std::string> published_payloads_;
    std::vector<std::string> called_services_;
    std::vector<std::string> called_payloads_;
    std::map<std::string, int> publish_failures_remaining_;
    std::map<std::string, int> service_failures_remaining_;
    std::map<std::string, std::string> service_responses_;
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

    const auto& called_services = transport.called_services();
    const auto& called_payloads = transport.called_payloads();
    if (called_services.empty() || called_services.back() != "/set_mode" ||
        called_payloads.back().find("\"mode\":0") == std::string::npos) {
        std::cerr << "expected stop_navigation to request manual mode via /set_mode\n";
        return EXIT_FAILURE;
    }

    const auto& stop_topics = transport.published_topics();
    const auto& stop_payloads = transport.published_payloads();
    if (stop_topics.size() < 2) {
        std::cerr << "expected stop_navigation publishes\n";
        return EXIT_FAILURE;
    }

    if (stop_topics[stop_topics.size() - 2] != "/navi_stop" ||
        stop_topics.back() != "/cmd_vel") {
        std::cerr << "expected stop_navigation to publish /navi_stop then zero cmd_vel\n";
        return EXIT_FAILURE;
    }

    if (stop_payloads[stop_payloads.size() - 2].find("\"data\":5") == std::string::npos ||
        stop_payloads.back().find("\"x\":0") == std::string::npos ||
        stop_payloads.back().find("\"z\":0") == std::string::npos) {
        std::cerr << "expected stop payload and zero velocity release\n";
        return EXIT_FAILURE;
    }

    const auto charging_takeover = adapter.acquire_manual_control();
    if (!charging_takeover.ok ||
        charging_takeover.state != ManualControlAcquireState::kUndockingRequested) {
        std::cerr << "expected acquire_manual_control to request undocking while charge is active\n";
        return EXIT_FAILURE;
    }

    const auto& outcharge_topics = transport.published_topics();
    const auto& outcharge_payloads = transport.published_payloads();
    if (outcharge_topics.size() < 5) {
        std::cerr << "expected charging takeover to publish an undock assist sequence\n";
        return EXIT_FAILURE;
    }

    if (outcharge_topics[outcharge_topics.size() - 3] != "/navi_stop" ||
        outcharge_topics[outcharge_topics.size() - 2] != "/cmd_vel" ||
        outcharge_topics.back() != "outofcharge") {
        std::cerr << "expected charging takeover to publish navi_stop, zero cmd_vel and outofcharge\n";
        return EXIT_FAILURE;
    }

    if (outcharge_payloads[outcharge_payloads.size() - 3].find("\"data\":5") == std::string::npos ||
        outcharge_payloads[outcharge_payloads.size() - 2].find("\"x\":0") == std::string::npos ||
        outcharge_payloads[outcharge_payloads.size() - 2].find("\"z\":0") == std::string::npos ||
        outcharge_payloads.back().find("\"data\":1") == std::string::npos) {
        std::cerr << "expected charging takeover payloads to match navi_stop, zero cmd_vel and outofcharge\n";
        return EXIT_FAILURE;
    }

    transport.emit("androidmsg_chargestatus", "{\"data\":41}");
    const auto ready_takeover = adapter.acquire_manual_control();
    if (!ready_takeover.ok || ready_takeover.state != ManualControlAcquireState::kReady) {
        std::cerr << "expected acquire_manual_control to report ready once charging clears\n";
        return EXIT_FAILURE;
    }

    if (!adapter.out_of_charge()) {
        std::cerr << "expected explicit out_of_charge request to succeed\n";
        return EXIT_FAILURE;
    }

    if (!adapter.manual_move(0.2, 0.4)) {
        std::cerr << "expected manual_move to succeed\n";
        return EXIT_FAILURE;
    }

    if (transport.last_topic() != "/cmd_vel" ||
        transport.last_type() != "geometry_msgs/Twist" ||
        transport.last_payload().find("\"x\":0.2") == std::string::npos ||
        transport.last_payload().find("\"z\":0.4") == std::string::npos) {
        std::cerr << "expected cmd_vel publish to match apk motion command format\n";
        return EXIT_FAILURE;
    }

    if (!adapter.manual_move(0.18, 0.0)) {
        std::cerr << "expected forward directional move to succeed\n";
        return EXIT_FAILURE;
    }

    if (transport.last_topic() != "/cmd_vel" ||
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

    if (transport.last_topic() != "/cmd_vel" ||
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

    if (transport.last_topic() != "/cmd_vel" ||
        transport.last_type() != "geometry_msgs/Twist" ||
        transport.last_payload().find("\"x\":0") == std::string::npos ||
        transport.last_payload().find("\"z\":0.8") == std::string::npos) {
        std::cerr << "expected left turn button move to use repeated cmd_vel teleop format\n";
        return EXIT_FAILURE;
    }

    if (!adapter.manual_move(0.0, -0.8)) {
        std::cerr << "expected right turn directional move to succeed\n";
        return EXIT_FAILURE;
    }

    if (transport.last_topic() != "/cmd_vel" ||
        transport.last_type() != "geometry_msgs/Twist" ||
        transport.last_payload().find("\"x\":0") == std::string::npos ||
        transport.last_payload().find("\"z\":-0.8") == std::string::npos) {
        std::cerr << "expected right turn button move to use repeated cmd_vel teleop format\n";
        return EXIT_FAILURE;
    }

    if (!adapter.manual_move(0.0, 0.0)) {
        std::cerr << "expected stop directional move to succeed\n";
        return EXIT_FAILURE;
    }

    if (transport.last_topic() != "/cmd_vel" ||
        transport.last_type() != "geometry_msgs/Twist" ||
        transport.last_payload().find("\"x\":0") == std::string::npos ||
        transport.last_payload().find("\"z\":0") == std::string::npos) {
        std::cerr << "expected stop move to use zero cmd_vel\n";
        return EXIT_FAILURE;
    }

    transport.set_service_response("point_set", "{\"result\":99}");
    transport.set_service_response(
        "get_maps",
        "{\"success\":true,\"message\":\"{\\\"defaultFloor\\\":56,\\\"floors\\\":[{\\\"floorId\\\":56,\\\"defaultmap\\\":34}]}\"}");
    PointRecord created_point;
    if (!adapter.create_current_pose_point("C2", 1, &created_point)) {
        std::cerr << "expected create_current_pose_point to succeed\n";
        return EXIT_FAILURE;
    }

    if (transport.last_service() != "get_maps" || transport.last_type() != "std_srvs/Trigger") {
        std::cerr << "expected get_maps lookup to use std_srvs/Trigger service type\n";
        return EXIT_FAILURE;
    }

    const auto& create_services = transport.called_services();
    const auto& create_payloads = transport.called_payloads();
    if (create_services.size() < 2 ||
        create_services[create_services.size() - 2] != "point_set" ||
        create_services.back() != "get_maps") {
        std::cerr << "expected create_current_pose_point to call point_set then get_maps\n";
        return EXIT_FAILURE;
    }

    if (create_payloads[create_payloads.size() - 2].find("\"point_name\":\"C2\"") == std::string::npos ||
        create_payloads[create_payloads.size() - 2].find("\"point_mode\":1") == std::string::npos) {
        std::cerr << "expected point_set payload to include point identity\n";
        return EXIT_FAILURE;
    }

    if (create_payloads[create_payloads.size() - 2].find("\"point\":") != std::string::npos) {
        std::cerr << "expected point_set payload to avoid manual coordinate body\n";
        return EXIT_FAILURE;
    }

    if (created_point.name != "C2" || created_point.floor_id != 56 ||
        created_point.map_id != 34 || created_point.point_id != 99) {
        std::cerr << "expected created current point to include resolved floor/map/point ids\n";
        return EXIT_FAILURE;
    }

    transport.set_service_response("point_set", "{\"result\":0}");
    transport.set_service_response("pointmanu_set", "{\"result\":123}");
    PointRecord fallback_point;
    if (!adapter.create_current_pose_point("C3", 1, &fallback_point)) {
        std::cerr << "expected create_current_pose_point to fall back to pointmanu_set\n";
        return EXIT_FAILURE;
    }

    if (fallback_point.point_id != 123) {
        std::cerr << "expected fallback point creation to use pointmanu_set result\n";
        return EXIT_FAILURE;
    }

    if (transport.called_services().size() < 3 ||
        transport.called_services()[transport.called_services().size() - 3] != "point_set" ||
        transport.called_services()[transport.called_services().size() - 2] != "pointmanu_set" ||
        transport.called_services().back() != "get_maps") {
        std::cerr << "expected fallback creation to call point_set, pointmanu_set, then get_maps\n";
        return EXIT_FAILURE;
    }

    if (transport.called_payloads()[transport.called_payloads().size() - 2].find("\"point\":") == std::string::npos) {
        std::cerr << "expected fallback pointmanu_set payload to include explicit pose body\n";
        return EXIT_FAILURE;
    }

    transport.set_service_response(
        "get_maps",
        "{\"success\":true,\"message\":\"{\\\"defaultFloor\\\":56,\\\"floors\\\":[{\\\"floorId\\\":56,\\\"defaultmap\\\":34,\\\"maps\\\":[{\\\"mapId\\\":34,\\\"chargeId\\\":99,\\\"initialId\\\":100}]}]}\"}");
    transport.set_service_response(
        "list_navi_points",
        "{\"list_system_points\":[{\"point_id\":\"99\",\"point_name\":\"C1\",\"x\":1.0,\"y\":2.0,\"z\":0.1},"
        "{\"point_id\":\"100\",\"point_name\":\"I1\",\"x\":1.1,\"y\":2.1,\"z\":0.2}],"
        "\"list_navi_points\":[{\"point_id\":\"101\",\"point_name\":\"P1\",\"x\":3.0,\"y\":4.0,\"z\":0.3}]}");
    std::vector<PointRecord> native_points;
    if (!adapter.list_native_points(&native_points)) {
        std::cerr << "expected list_native_points to succeed\n";
        return EXIT_FAILURE;
    }

    if (native_points.size() != 3 ||
        native_points[0].point_kind != "charge" ||
        native_points[1].point_kind != "initial" ||
        native_points[2].point_kind != "navigation") {
        std::cerr << "expected native point sync to classify charge, initial, and navigation points\n";
        return EXIT_FAILURE;
    }

    if (!adapter.delete_saved_point(created_point)) {
        std::cerr << "expected delete_saved_point to succeed\n";
        return EXIT_FAILURE;
    }

    if (transport.last_service() != "delete_test_point" ||
        transport.last_type() != "map_msgs/DeleteTestPoint" ||
        transport.last_payload().find("\"floor_id\":56") == std::string::npos ||
        transport.last_payload().find("\"map_id\":34") == std::string::npos ||
        transport.last_payload().find("\"point_id\":99") == std::string::npos) {
        std::cerr << "expected delete_saved_point to use apk delete_test_point contract, got service="
                  << transport.last_service() << " type=" << transport.last_type()
                  << " payload=" << transport.last_payload() << "\n";
        return EXIT_FAILURE;
    }

    if (!adapter.go_charge()) {
        std::cerr << "expected go_charge to publish apk autocharge topic\n";
        return EXIT_FAILURE;
    }

    if (transport.last_topic() != "autocharge" ||
        transport.last_type() != "std_msgs/Int16" ||
        transport.last_payload().find("\"data\":1") == std::string::npos) {
        std::cerr << "expected go_charge to publish autocharge Int16(1)\n";
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

    FakeRosbridgeTransport flaky_transport;
    RosbridgeAdapter flaky_adapter(&flaky_transport);
    if (!flaky_adapter.connect()) {
        std::cerr << "expected flaky adapter connect to succeed\n";
        return EXIT_FAILURE;
    }

    flaky_transport.fail_service("/set_mode", 1);
    if (flaky_adapter.out_of_charge()) {
        std::cerr << "expected out_of_charge to fail when manual takeover cannot be acquired\n";
        return EXIT_FAILURE;
    }

    return EXIT_SUCCESS;
}
