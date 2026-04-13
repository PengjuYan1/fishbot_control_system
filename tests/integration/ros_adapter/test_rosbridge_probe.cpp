#include <atomic>
#include <chrono>
#include <cstdlib>
#include <cstring>
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

class FakeProbeRosbridgeServer {
  public:
    explicit FakeProbeRosbridgeServer(unsigned short port)
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

    ~FakeProbeRosbridgeServer() { stop(); }

  private:
    void write_message(websocket::stream<tcp::socket>& ws, const std::string& message) {
        ws.write(asio::buffer(message));
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

                if (message.find("\"op\":\"subscribe\"") == std::string::npos) {
                    continue;
                }
                write_message(ws, "{\"op\":\"publish\",\"topic\":\"power_report\",\"msg\":{\"data\":67}}");
                write_message(ws, "{\"op\":\"publish\",\"topic\":\"androidmsg_emergencystatus\",\"msg\":{\"data\":32}}");
                write_message(ws, "{\"op\":\"publish\",\"topic\":\"androidmsg_motorenabledstatus\",\"msg\":{\"data\":34}}");
                write_message(ws, "{\"op\":\"publish\",\"topic\":\"androidmsg_chargestatus\",\"msg\":{\"data\":45}}");
                write_message(ws, "{\"op\":\"publish\",\"topic\":\"motion_mode\",\"msg\":{\"data\":1}}");
                write_message(ws, "{\"op\":\"publish\",\"topic\":\"outofcharge_status\",\"msg\":{\"data\":1}}");
                write_message(ws, "{\"op\":\"publish\",\"topic\":\"reviceOutMachineSignal\",\"msg\":{\"data\":1}}");
                write_message(ws, "{\"op\":\"publish\",\"topic\":\"androidmsg_outofchargepoint\",\"msg\":{\"data\":50}}");
                write_message(ws, "{\"op\":\"publish\",\"topic\":\"androidmsg_locationstatus\",\"msg\":{\"data\":10}}");
                write_message(ws,
                              "{\"op\":\"publish\",\"topic\":\"tracked_pose\",\"msg\":{\"pose\":{\"position\":{\"x\":1.5,\"y\":2.5,\"z\":0.0},\"orientation\":{\"x\":0.0,\"y\":0.0,\"z\":0.247404,\"w\":0.968912}}}}");
                write_message(ws,
                              "{\"op\":\"publish\",\"topic\":\"/map\",\"msg\":{\"info\":{\"width\":3,\"height\":2,\"resolution\":0.05,\"origin\":{\"position\":{\"x\":-1.5,\"y\":-2.5}}},\"data\":[0,100,-1,0,0,100]}}");
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
    constexpr unsigned short port = 19091;
    FakeProbeRosbridgeServer server(port);
    server.start();

    std::this_thread::sleep_for(std::chrono::milliseconds(50));

    const auto exit_code =
        std::system("./fishbot_rosbridge_probe 127.0.0.1 19091 3000 > /tmp/fishbot_rosbridge_probe.out");
    server.stop();

    if (exit_code != 0) {
        std::cerr << "expected rosbridge probe tool to succeed\n";
        return EXIT_FAILURE;
    }

    std::ifstream input("/tmp/fishbot_rosbridge_probe.out");
    const std::string output((std::istreambuf_iterator<char>(input)), std::istreambuf_iterator<char>());

    if (output.find("\"connected\":true") == std::string::npos ||
        output.find("\"battery\":67") == std::string::npos ||
        output.find("\"localized\":true") == std::string::npos ||
        output.find("\"charging\":true") == std::string::npos ||
        output.find("\"control\":{") == std::string::npos ||
        output.find("\"out_of_charge_result_code\":50") == std::string::npos ||
        output.find("\"pose\":{") == std::string::npos ||
        output.find("\"map\":{") == std::string::npos) {
        std::cerr << "expected rosbridge probe output to contain live snapshot data\n";
        return EXIT_FAILURE;
    }

    if (output.find("\"map\":{\"width\":") == std::string::npos) {
        std::cerr << "expected rosbridge probe output to contain map object\n";
        return EXIT_FAILURE;
    }

    return EXIT_SUCCESS;
}
