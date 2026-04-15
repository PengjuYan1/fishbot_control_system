#include <atomic>
#include <chrono>
#include <cstdlib>
#include <fstream>
#include <iostream>
#include <string>
#include <thread>

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

class FakeCapabilityRosbridgeServer {
  public:
    explicit FakeCapabilityRosbridgeServer(unsigned short port)
        : ioc_(), acceptor_(ioc_, tcp::endpoint(tcp::v4(), port)) {}

    void start() { thread_ = std::thread([this]() { run(); }); }

    void stop() {
        stop_requested_ = true;
        boost::system::error_code ignored;
        acceptor_.close(ignored);
        if (thread_.joinable()) {
            thread_.join();
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

    void publish_live_snapshot(websocket::stream<tcp::socket>& ws) {
        write_message(ws, "{\"op\":\"publish\",\"topic\":\"power_report\",\"msg\":{\"data\":88}}");
        write_message(ws, "{\"op\":\"publish\",\"topic\":\"androidmsg_locationstatus\",\"msg\":{\"data\":10}}");
        write_message(ws, "{\"op\":\"publish\",\"topic\":\"androidmsg_chargestatus\",\"msg\":{\"data\":41}}");
        write_message(ws, "{\"op\":\"publish\",\"topic\":\"androidmsg_navigationstatus\",\"msg\":{\"data\":83}}");
        write_message(ws, "{\"op\":\"publish\",\"topic\":\"motion_mode\",\"msg\":{\"data\":2}}");
        write_message(ws, "{\"op\":\"publish\",\"topic\":\"/odom\",\"msg\":{\"header\":{\"frame_id\":\"odom\"},\"child_frame_id\":\"base_link\",\"pose\":{\"pose\":{\"position\":{\"x\":1.0,\"y\":2.0,\"z\":0.0},\"orientation\":{\"x\":0.0,\"y\":0.0,\"z\":0.0,\"w\":1.0}}},\"twist\":{\"twist\":{\"linear\":{\"x\":0.1,\"y\":0.0,\"z\":0.0},\"angular\":{\"x\":0.0,\"y\":0.0,\"z\":0.0}}}}");
        write_message(ws, "{\"op\":\"publish\",\"topic\":\"/tf\",\"msg\":{\"transforms\":[{\"header\":{\"frame_id\":\"map\"},\"child_frame_id\":\"odom\",\"transform\":{\"translation\":{\"x\":0.0,\"y\":0.0,\"z\":0.0},\"rotation\":{\"x\":0.0,\"y\":0.0,\"z\":0.0,\"w\":1.0}}}]}}");
        write_message(ws, "{\"op\":\"publish\",\"topic\":\"/tf_static\",\"msg\":{\"transforms\":[{\"header\":{\"frame_id\":\"base_link\"},\"child_frame_id\":\"laser\",\"transform\":{\"translation\":{\"x\":0.0,\"y\":0.0,\"z\":0.1},\"rotation\":{\"x\":0.0,\"y\":0.0,\"z\":0.0,\"w\":1.0}}}]}}");
        write_message(ws, "{\"op\":\"publish\",\"topic\":\"/scan\",\"msg\":{\"header\":{\"frame_id\":\"laser\"},\"angle_min\":-1.57,\"angle_max\":1.57,\"angle_increment\":0.01,\"ranges\":[1.0,1.1,1.2]}}");
        write_message(ws, "{\"op\":\"publish\",\"topic\":\"/velodyne_points\",\"msg\":{\"header\":{\"frame_id\":\"velodyne\"},\"height\":1,\"width\":1,\"fields\":[],\"is_bigendian\":false,\"point_step\":16,\"row_step\":16,\"data\":[0,0,0,0],\"is_dense\":true}}");
        write_message(ws, "{\"op\":\"publish\",\"topic\":\"/camera/depth/image_raw\",\"msg\":{\"header\":{\"frame_id\":\"depth\"},\"height\":1,\"width\":1,\"encoding\":\"16UC1\",\"is_bigendian\":0,\"step\":2,\"data\":[0,1]}}");
        write_message(ws, "{\"op\":\"publish\",\"topic\":\"/camera/depth/camera_info\",\"msg\":{\"header\":{\"frame_id\":\"depth\"},\"height\":1,\"width\":1,\"distortion_model\":\"plumb_bob\",\"D\":[0.0],\"K\":[1,0,0,0,1,0,0,0,1],\"R\":[1,0,0,0,1,0,0,0,1],\"P\":[1,0,0,0,0,1,0,0,0,0,1,0]}}");
        write_message(ws,
                      "{\"op\":\"publish\",\"topic\":\"tracked_pose\",\"msg\":{\"pose\":{\"position\":{\"x\":1.2,\"y\":-0.4,\"z\":0.0},\"orientation\":{\"x\":0.0,\"y\":0.0,\"z\":0.0,\"w\":1.0}}}}");
        write_message(ws,
                      "{\"op\":\"publish\",\"topic\":\"/map\",\"msg\":{\"info\":{\"width\":5,\"height\":4,\"resolution\":0.05,\"origin\":{\"position\":{\"x\":-2.0,\"y\":-1.0}}},\"data\":[0,0,0,0]}}");
    }

    void run() {
        try {
            tcp::socket socket(ioc_);
            acceptor_.accept(socket);
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
                            "\"navi_targegoalplan\",\"point_set\",\"pointmanu_set\",\"list_navi_points\"]}",
                            id);
                        continue;
                    }
                    if (message.find("\"service\":\"/rosapi/topics\"") != std::string::npos ||
                        message.find("\"service\":\"rosapi/topics\"") != std::string::npos) {
                        write_service_response(
                            ws,
                            "/rosapi/topics",
                            "{\"topics\":[\"/cmd_vel\",\"/navi_stop\",\"autocharge\",\"outofcharge\",\"/initialpose\","
                            "\"androidmsg_locationstatus\",\"androidmsg_navigationstatus\",\"androidmsg_chargestatus\","
                            "\"tracked_pose\",\"/map\",\"/odom\",\"/tf\",\"/tf_static\",\"/scan\","
                            "\"/velodyne_points\",\"/camera/depth/image_raw\",\"/camera/depth/camera_info\"]}",
                            id);
                        continue;
                    }
                    if (message.find("\"service\":\"/rosapi/topic_type\"") != std::string::npos ||
                        message.find("\"service\":\"rosapi/topic_type\"") != std::string::npos) {
                        std::string values = "{\"type\":\"\"}";
                        if (message.find("\"topic\":\"/scan\"") != std::string::npos) {
                            values = "{\"type\":\"sensor_msgs/LaserScan\"}";
                        } else if (message.find("\"topic\":\"/velodyne_points\"") != std::string::npos) {
                            values = "{\"type\":\"sensor_msgs/PointCloud2\"}";
                        } else if (message.find("\"topic\":\"/camera/depth/image_raw\"") != std::string::npos) {
                            values = "{\"type\":\"sensor_msgs/Image\"}";
                        } else if (message.find("\"topic\":\"/camera/depth/camera_info\"") != std::string::npos) {
                            values = "{\"type\":\"sensor_msgs/CameraInfo\"}";
                        } else if (message.find("\"topic\":\"tracked_pose\"") != std::string::npos) {
                            values = "{\"type\":\"geometry_msgs/PoseStamped\"}";
                        } else if (message.find("\"topic\":\"/map\"") != std::string::npos) {
                            values = "{\"type\":\"nav_msgs/OccupancyGrid\"}";
                        } else if (message.find("\"topic\":\"/odom\"") != std::string::npos) {
                            values = "{\"type\":\"nav_msgs/Odometry\"}";
                        } else if (message.find("\"topic\":\"/tf_static\"") != std::string::npos) {
                            values = "{\"type\":\"tf2_msgs/TFMessage\"}";
                        } else if (message.find("\"topic\":\"/tf\"") != std::string::npos) {
                            values = "{\"type\":\"tf2_msgs/TFMessage\"}";
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
                    publish_live_snapshot(ws);
                    continue;
                }
            }
        } catch (const std::exception&) {
        }
    }

    asio::io_context ioc_;
    tcp::acceptor acceptor_;
    std::thread thread_;
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
        output.find("\"battery\":88") == std::string::npos ||
        output.find("\"location_status_code\":10") == std::string::npos ||
        output.find("\"navigation_status_code\":83") == std::string::npos) {
        std::cerr << "expected capability probe output to include rosapi and live status checks\n";
        return EXIT_FAILURE;
    }

    return EXIT_SUCCESS;
}
