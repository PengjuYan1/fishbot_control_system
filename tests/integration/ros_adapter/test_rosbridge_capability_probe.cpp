#include <atomic>
#include <chrono>
#include <cstdlib>
#include <fstream>
#include <iostream>
#include <mutex>
#include <string>
#include <thread>
#include <vector>

#include <boost/asio.hpp>
#include <boost/beast/core.hpp>
#include <boost/beast/websocket.hpp>

namespace {
namespace asio = boost::asio;
namespace websocket = boost::beast::websocket;
using tcp = asio::ip::tcp;

std::string extract_id(const std::string& message) {
    const auto id_token = std::string("\"id\":\"");
    const auto start = message.find(id_token);
    if (start == std::string::npos) {
        return "";
    }
    const auto id_start = start + id_token.size();
    const auto id_end = message.find('"', id_start);
    if (id_end == std::string::npos) {
        return "";
    }
    return message.substr(id_start, id_end - id_start);
}

std::string extract_string_field(const std::string& message, const std::string& field) {
    const auto token = std::string("\"") + field + "\":\"";
    const auto start = message.find(token);
    if (start == std::string::npos) {
        return "";
    }
    const auto value_start = start + token.size();
    const auto value_end = message.find('"', value_start);
    if (value_end == std::string::npos) {
        return "";
    }
    return message.substr(value_start, value_end - value_start);
}

class FakeCapabilityRosbridgeServer {
  public:
    explicit FakeCapabilityRosbridgeServer(unsigned short port)
        : ioc_(), acceptor_(ioc_, tcp::endpoint(tcp::v4(), port)) {}

    void start() { thread_ = std::thread([this]() { run(); }); }

    void stop() {
        stop_requested_ = true;
        boost::system::error_code ignored;
        acceptor_.cancel(ignored);
        acceptor_.close(ignored);
        {
            std::lock_guard<std::mutex> lock(sessions_mutex_);
            for (auto& session : sessions_) {
                if (session.joinable()) {
                    session.detach();
                }
            }
            sessions_.clear();
        }
        if (thread_.joinable()) {
            thread_.detach();
        }
    }

    ~FakeCapabilityRosbridgeServer() { stop(); }

  private:
    void write_message(websocket::stream<tcp::socket>& ws, const std::string& message) {
        ws.write(asio::buffer(message));
    }

    void write_service_response(websocket::stream<tcp::socket>& ws, const std::string& service,
                                const std::string& values, const std::string& id) {
        write_message(ws,
                      std::string("{\"op\":\"service_response\",\"service\":\"") + service +
                          "\",\"values\":" + values +
                          ",\"result\":true,\"id\":\"" + id + "\"}");
    }

    void publish_topic_snapshot(websocket::stream<tcp::socket>& ws, const std::string& topic) {
        if (topic == "power_report" || topic == "/power_report") {
            write_message(ws, "{\"op\":\"publish\",\"topic\":\"power_report\",\"msg\":{\"data\":88}}");
        } else if (topic == "androidmsg_initstatus" || topic == "/androidmsg_initstatus") {
            write_message(ws, "{\"op\":\"publish\",\"topic\":\"androidmsg_initstatus\",\"msg\":{\"data\":12}}");
        } else if (topic == "androidmsg_emergencystatus" || topic == "/androidmsg_emergencystatus") {
            write_message(ws, "{\"op\":\"publish\",\"topic\":\"/androidmsg_emergencystatus\",\"msg\":{\"data\":32}}");
        } else if (topic == "androidmsg_motorenabledstatus" || topic == "/androidmsg_motorenabledstatus") {
            write_message(ws, "{\"op\":\"publish\",\"topic\":\"/androidmsg_motorenabledstatus\",\"msg\":{\"data\":34}}");
        } else if (topic == "androidmsg_locationstatus" || topic == "/androidmsg_locationstatus") {
            write_message(ws, "{\"op\":\"publish\",\"topic\":\"androidmsg_locationstatus\",\"msg\":{\"data\":10}}");
        } else if (topic == "androidmsg_chargestatus" || topic == "/androidmsg_chargestatus") {
            write_message(ws, "{\"op\":\"publish\",\"topic\":\"androidmsg_chargestatus\",\"msg\":{\"data\":41}}");
        } else if (topic == "wall_update" || topic == "/wall_update") {
            write_message(ws, "{\"op\":\"publish\",\"topic\":\"wall_update\",\"msg\":{\"data\":1}}");
        } else if (topic == "androidmsg_navigationstatus" || topic == "/androidmsg_navigationstatus") {
            write_message(ws, "{\"op\":\"publish\",\"topic\":\"androidmsg_navigationstatus\",\"msg\":{\"data\":83}}");
        } else if (topic == "androidmsg_virtualmapstatus" || topic == "/androidmsg_virtualmapstatus") {
            write_message(ws, "{\"op\":\"publish\",\"topic\":\"androidmsg_virtualmapstatus\",\"msg\":{\"data\":61}}");
        } else if (topic == "androidmsg_stm32status" || topic == "/androidmsg_stm32status") {
            write_message(ws, "{\"op\":\"publish\",\"topic\":\"/androidmsg_stm32status\",\"msg\":{\"data\":18}}");
        } else if (topic == "androidmsg_odomstatus" || topic == "/androidmsg_odomstatus") {
            write_message(ws, "{\"op\":\"publish\",\"topic\":\"/androidmsg_odomstatus\",\"msg\":{\"data\":20}}");
        } else if (topic == "motion_mode" || topic == "/motion_mode") {
            write_message(ws, "{\"op\":\"publish\",\"topic\":\"motion_mode\",\"msg\":{\"data\":2}}");
        } else if (topic == "outofcharge_status" || topic == "/outofcharge_status") {
            write_message(ws, "{\"op\":\"publish\",\"topic\":\"/outofcharge_status\",\"msg\":{\"data\":1}}");
        } else if (topic == "reviceOutMachineSignal" || topic == "/reviceOutMachineSignal") {
            write_message(ws, "{\"op\":\"publish\",\"topic\":\"/reviceOutMachineSignal\",\"msg\":{\"data\":1}}");
        } else if (topic == "androidmsg_outofchargepoint" || topic == "/androidmsg_outofchargepoint") {
            write_message(ws, "{\"op\":\"publish\",\"topic\":\"/androidmsg_outofchargepoint\",\"msg\":{\"data\":50}}");
        } else if (topic == "androidmsg_mapstatus" || topic == "/androidmsg_mapstatus") {
            write_message(ws, "{\"op\":\"publish\",\"topic\":\"/androidmsg_mapstatus\",\"msg\":{\"data\":6}}");
        } else if (topic == "map_status" || topic == "/map_status") {
            write_message(ws, "{\"op\":\"publish\",\"topic\":\"/map_status\",\"msg\":{\"data\":7}}");
        } else if (topic == "raw_odom" || topic == "/raw_odom" || topic == "odom" || topic == "/odom") {
            write_message(ws, "{\"op\":\"publish\",\"topic\":\"raw_odom\",\"msg\":{\"header\":{\"frame_id\":\"odom\"},\"child_frame_id\":\"base_link\",\"pose\":{\"pose\":{\"position\":{\"x\":1.0,\"y\":2.0,\"z\":0.0},\"orientation\":{\"x\":0.0,\"y\":0.0,\"z\":0.0,\"w\":1.0}}},\"twist\":{\"twist\":{\"linear\":{\"x\":0.1,\"y\":0.0,\"z\":0.0},\"angular\":{\"x\":0.0,\"y\":0.0,\"z\":0.0}}}}");
        } else if (topic == "tf" || topic == "/tf") {
            write_message(ws, "{\"op\":\"publish\",\"topic\":\"/tf\",\"msg\":{\"transforms\":[{\"header\":{\"frame_id\":\"map\"},\"child_frame_id\":\"odom\",\"transform\":{\"translation\":{\"x\":0.0,\"y\":0.0,\"z\":0.0},\"rotation\":{\"x\":0.0,\"y\":0.0,\"z\":0.0,\"w\":1.0}}}]}}");
        } else if (topic == "tf_static" || topic == "/tf_static") {
            write_message(ws, "{\"op\":\"publish\",\"topic\":\"/tf_static\",\"msg\":{\"transforms\":[{\"header\":{\"frame_id\":\"base_link\"},\"child_frame_id\":\"laser\",\"transform\":{\"translation\":{\"x\":0.0,\"y\":0.0,\"z\":0.1},\"rotation\":{\"x\":0.0,\"y\":0.0,\"z\":0.0,\"w\":1.0}}}]}}");
        } else if (topic == "scan" || topic == "/scan") {
            write_message(ws, "{\"op\":\"publish\",\"topic\":\"/scan\",\"msg\":{\"header\":{\"frame_id\":\"laser\"},\"angle_min\":-1.57,\"angle_max\":1.57,\"angle_increment\":0.01,\"ranges\":[1.0,1.1,1.2]}}");
        } else if (topic == "scan_pose" || topic == "/scan_pose") {
            write_message(ws, "{\"op\":\"publish\",\"topic\":\"/scan_pose\",\"msg\":{\"position\":{\"x\":0.3,\"y\":-0.2,\"z\":0.0},\"orientation\":{\"x\":0.0,\"y\":0.0,\"z\":0.0,\"w\":1.0}}}");
        } else if (topic == "velodyne_points" || topic == "/velodyne_points") {
            write_message(ws, "{\"op\":\"publish\",\"topic\":\"/velodyne_points\",\"msg\":{\"header\":{\"frame_id\":\"velodyne\"},\"height\":1,\"width\":1,\"fields\":[],\"is_bigendian\":false,\"point_step\":16,\"row_step\":16,\"data\":[0,0,0,0],\"is_dense\":true}}");
        } else if (topic == "camera/depth/image_raw" || topic == "/camera/depth/image_raw") {
            write_message(ws, "{\"op\":\"publish\",\"topic\":\"/camera/depth/image_raw\",\"msg\":{\"header\":{\"frame_id\":\"depth\"},\"height\":1,\"width\":1,\"encoding\":\"16UC1\",\"is_bigendian\":0,\"step\":2,\"data\":[0,1]}}");
        } else if (topic == "camera/depth/camera_info" || topic == "/camera/depth/camera_info") {
            write_message(ws, "{\"op\":\"publish\",\"topic\":\"/camera/depth/camera_info\",\"msg\":{\"header\":{\"frame_id\":\"depth\"},\"height\":1,\"width\":1,\"distortion_model\":\"plumb_bob\",\"D\":[0.0],\"K\":[1,0,0,0,1,0,0,0,1],\"R\":[1,0,0,0,1,0,0,0,1],\"P\":[1,0,0,0,0,1,0,0,0,0,1,0]}}");
        } else if (topic == "tracked_pose" || topic == "/tracked_pose") {
            write_message(ws, "{\"op\":\"publish\",\"topic\":\"tracked_pose\",\"msg\":{\"pose\":{\"position\":{\"x\":1.2,\"y\":-0.4,\"z\":0.0},\"orientation\":{\"x\":0.0,\"y\":0.0,\"z\":0.0,\"w\":1.0}}}}");
        } else if (topic == "visualization_marker" || topic == "/visualization_marker") {
            write_message(ws, "{\"op\":\"publish\",\"topic\":\"visualization_marker\",\"msg\":{\"header\":{\"frame_id\":\"map\"},\"ns\":\"path\",\"id\":1,\"type\":4,\"action\":0,\"pose\":{\"position\":{\"x\":0.0,\"y\":0.0,\"z\":0.0},\"orientation\":{\"x\":0.0,\"y\":0.0,\"z\":0.0,\"w\":1.0}},\"scale\":{\"x\":0.05,\"y\":0.0,\"z\":0.0},\"color\":{\"a\":1.0,\"r\":0.0,\"g\":1.0,\"b\":0.0},\"points\":[{\"x\":0.0,\"y\":0.0,\"z\":0.0},{\"x\":1.0,\"y\":0.0,\"z\":0.0}]}}");
        } else if (topic == "map" || topic == "/map") {
            write_message(ws, "{\"op\":\"publish\",\"topic\":\"/map\",\"msg\":{\"info\":{\"width\":5,\"height\":4,\"resolution\":0.05,\"origin\":{\"position\":{\"x\":-2.0,\"y\":-1.0}}},\"data\":[0,0,0,0]}}");
        }
    }

    void handle_session(tcp::socket socket) {
        try {
            websocket::stream<tcp::socket> ws(std::move(socket));
            ws.accept();
            while (!stop_requested_) {
                boost::beast::flat_buffer buffer;
                ws.read(buffer);
                const auto message = boost::beast::buffers_to_string(buffer.data());

                if (message.find("\"op\":\"call_service\"") != std::string::npos) {
                    const auto id = extract_id(message);
                    if (message.find("\"service\":\"/rosapi/services\"") != std::string::npos ||
                        message.find("\"service\":\"rosapi/services\"") != std::string::npos) {
                        write_service_response(
                            ws,
                            "/rosapi/services",
                            "{\"services\":[\"/set_mode\",\"set_relocation\",\"get_maps\",\"/publish_map\","
                            "\"navi_targegoalplan\",\"point_set\",\"pointmanu_set\",\"list_navi_points\","
                            "\"move_calibration\",\"/set_navi_cmd\",\"/get_position\",\"clear_map\","
                            "\"delete_map\",\"delete_allmap\",\"set_shape\",\"set_region\",\"robot_ssh\"]}",
                            id);
                        continue;
                    }
                    if (message.find("\"service\":\"/rosapi/topics\"") != std::string::npos ||
                        message.find("\"service\":\"rosapi/topics\"") != std::string::npos) {
                        write_service_response(
                            ws,
                            "/rosapi/topics",
                            "{\"topics\":[\"/cmd_vel\",\"/navi_stop\",\"autocharge\",\"outofcharge\",\"/initialpose\","
                            "\"androidmsg_initstatus\",\"wall_update\",\"androidmsg_virtualmapstatus\","
                            "\"power_report\",\"/androidmsg_emergencystatus\",\"/androidmsg_motorenabledstatus\","
                            "\"androidmsg_locationstatus\",\"androidmsg_navigationstatus\",\"androidmsg_chargestatus\","
                            "\"/androidmsg_stm32status\",\"/androidmsg_odomstatus\",\"motion_mode\","
                            "\"/outofcharge_status\",\"/reviceOutMachineSignal\",\"/androidmsg_outofchargepoint\","
                            "\"/androidmsg_mapstatus\",\"/map_status\","
                            "\"tracked_pose\",\"/map\",\"raw_odom\",\"/tf\",\"/tf_static\",\"/scan\","
                            "\"/scan_pose\",\"visualization_marker\","
                            "\"/velodyne_points\",\"/camera/depth/image_raw\",\"/camera/depth/camera_info\"]}",
                            id);
                        continue;
                    }
                    if (message.find("\"service\":\"/rosapi/topic_type\"") != std::string::npos ||
                        message.find("\"service\":\"rosapi/topic_type\"") != std::string::npos) {
                        std::string values = "{\"type\":\"\"}";
                        if (message.find("\"topic\":\"/scan\"") != std::string::npos) {
                            values = "{\"type\":\"sensor_msgs/LaserScan\"}";
                        } else if (message.find("\"topic\":\"/scan_pose\"") != std::string::npos) {
                            values = "{\"type\":\"geometry_msgs/Pose\"}";
                        } else if (message.find("\"topic\":\"/velodyne_points\"") != std::string::npos) {
                            values = "{\"type\":\"sensor_msgs/PointCloud2\"}";
                        } else if (message.find("\"topic\":\"/camera/depth/image_raw\"") != std::string::npos) {
                            values = "{\"type\":\"sensor_msgs/Image\"}";
                        } else if (message.find("\"topic\":\"/camera/depth/camera_info\"") != std::string::npos) {
                            values = "{\"type\":\"sensor_msgs/CameraInfo\"}";
                        } else if (message.find("\"topic\":\"visualization_marker\"") != std::string::npos) {
                            values = "{\"type\":\"visualization_msgs/Marker\"}";
                        } else if (message.find("\"topic\":\"tracked_pose\"") != std::string::npos) {
                            values = "{\"type\":\"geometry_msgs/PoseStamped\"}";
                        } else if (message.find("\"topic\":\"/map\"") != std::string::npos) {
                            values = "{\"type\":\"nav_msgs/OccupancyGrid\"}";
                        } else if (message.find("\"topic\":\"raw_odom\"") != std::string::npos) {
                            values = "{\"type\":\"nav_msgs/Odometry\"}";
                        } else if (message.find("\"topic\":\"/tf_static\"") != std::string::npos) {
                            values = "{\"type\":\"tf2_msgs/TFMessage\"}";
                        } else if (message.find("\"topic\":\"/tf\"") != std::string::npos) {
                            values = "{\"type\":\"tf2_msgs/TFMessage\"}";
                        } else if (message.find("\"topic\":\"power_report\"") != std::string::npos ||
                                   message.find("\"topic\":\"androidmsg_initstatus\"") != std::string::npos ||
                                   message.find("\"topic\":\"wall_update\"") != std::string::npos ||
                                   message.find("\"topic\":\"androidmsg_virtualmapstatus\"") != std::string::npos ||
                                   message.find("\"topic\":\"/androidmsg_") != std::string::npos ||
                                   message.find("\"topic\":\"motion_mode\"") != std::string::npos ||
                                   message.find("\"topic\":\"/outofcharge_status\"") != std::string::npos ||
                                   message.find("\"topic\":\"/reviceOutMachineSignal\"") != std::string::npos ||
                                   message.find("\"topic\":\"/map_status\"") != std::string::npos) {
                            values = "{\"type\":\"std_msgs/Int16\"}";
                        }
                        write_service_response(
                            ws,
                            "/rosapi/topic_type",
                            values,
                            id);
                        continue;
                    }
                    write_service_response(ws, "unknown", "{}", id);
                    continue;
                }

                if (message.find("\"op\":\"subscribe\"") != std::string::npos) {
                    publish_topic_snapshot(ws, extract_string_field(message, "topic"));
                    continue;
                }
            }
        } catch (const std::exception&) {
        }
    }

    void run() {
        try {
            while (!stop_requested_) {
                tcp::socket socket(ioc_);
                acceptor_.accept(socket);
                std::lock_guard<std::mutex> lock(sessions_mutex_);
                sessions_.emplace_back([this, socket = std::move(socket)]() mutable {
                    handle_session(std::move(socket));
                });
            }
        } catch (const std::exception&) {
        }
    }

    asio::io_context ioc_;
    tcp::acceptor acceptor_;
    std::thread thread_;
    std::mutex sessions_mutex_;
    std::vector<std::thread> sessions_;
    std::atomic<bool> stop_requested_{false};
};
}  // namespace

int main() {
    constexpr unsigned short port = 19092;
    FakeCapabilityRosbridgeServer server(port);
    server.start();

    std::this_thread::sleep_for(std::chrono::milliseconds(50));
    const auto exit_code = std::system(
        "./fishbot_rosbridge_capability_probe 127.0.0.1 19092 3000 > /tmp/fishbot_rosbridge_capability_probe.out");
    server.stop();

    if (exit_code != 0) {
        std::cerr << "expected rosbridge capability probe tool to succeed\n";
        return EXIT_FAILURE;
    }

    std::ifstream input("/tmp/fishbot_rosbridge_capability_probe.out");
    const std::string output((std::istreambuf_iterator<char>(input)), std::istreambuf_iterator<char>());

    if (output.find("\"services_query_ok\":true") == std::string::npos ||
        output.find("\"topics_query_ok\":true") == std::string::npos ||
        output.find("\"name\":\"set_relocation\",\"available\":true") == std::string::npos ||
        output.find("\"name\":\"cmd_vel\",\"available\":true") == std::string::npos ||
        output.find("\"required_services_available\":8") == std::string::npos ||
        output.find("\"required_topics_available\":10") == std::string::npos ||
        output.find("\"name\":\"laser_scan\",\"topic_present\":true") == std::string::npos ||
        output.find("\"name\":\"point_cloud\",\"topic_present\":true") == std::string::npos ||
        output.find("\"name\":\"depth_image\",\"topic_present\":true") == std::string::npos ||
        output.find("\"name\":\"depth_camera_info\",\"topic_present\":true") == std::string::npos ||
        output.find("\"perception_streams_live\":4") == std::string::npos ||
        output.find("\"name\":\"odom\",\"topic_present\":true") == std::string::npos ||
        output.find("\"name\":\"tf\",\"topic_present\":true") == std::string::npos ||
        output.find("\"name\":\"tf_static\",\"topic_present\":true") == std::string::npos ||
        output.find("\"name\":\"tracked_pose\",\"topic_present\":true") == std::string::npos ||
        output.find("\"name\":\"map\",\"topic_present\":true") == std::string::npos ||
        output.find("\"navigation_streams_live\":5") == std::string::npos ||
        output.find("\"name\":\"power_report\",\"topic_present\":true") == std::string::npos ||
        output.find("\"name\":\"location_status\",\"topic_present\":true") == std::string::npos ||
        output.find("\"name\":\"navigation_status\",\"topic_present\":true") == std::string::npos ||
        output.find("\"name\":\"charge_status\",\"topic_present\":true") == std::string::npos ||
        output.find("\"status_types_matched\":14") == std::string::npos ||
        output.find("\"status_streams_live\":14") == std::string::npos ||
        output.find("\"name\":\"move_calibration\",\"available\":true") == std::string::npos ||
        output.find("\"name\":\"set_navi_cmd\",\"available\":true") == std::string::npos ||
        output.find("\"name\":\"robot_ssh\",\"available\":true") == std::string::npos ||
        output.find("\"vendor_services_available\":9") == std::string::npos ||
        output.find("\"name\":\"init_status\",\"topic_present\":true") == std::string::npos ||
        output.find("\"name\":\"wall_update\",\"topic_present\":true") == std::string::npos ||
        output.find("\"name\":\"virtual_map_status\",\"topic_present\":true") == std::string::npos ||
        output.find("\"name\":\"raw_odom\",\"topic_present\":true") == std::string::npos ||
        output.find("\"name\":\"scan_pose\",\"topic_present\":true") == std::string::npos ||
        output.find("\"name\":\"visualization_marker\",\"topic_present\":true") == std::string::npos ||
        output.find("\"vendor_topics_present\":6") == std::string::npos ||
        output.find("\"vendor_topics_type_matched\":6") == std::string::npos ||
        output.find("\"vendor_topics_live\":6") == std::string::npos ||
        output.find("\"sample_data\":12") == std::string::npos ||
        output.find("\"sample_data\":61") == std::string::npos ||
        output.find("\"sample_data\":88") == std::string::npos ||
        output.find("\"sample_data\":83") == std::string::npos ||
        output.find("\"battery\":88") == std::string::npos ||
        output.find("\"location_status_code\":10") == std::string::npos ||
        output.find("\"navigation_status_code\":83") == std::string::npos) {
        std::cerr << "expected capability probe output to include rosapi and live status checks\n";
        return EXIT_FAILURE;
    }

    return EXIT_SUCCESS;
}
