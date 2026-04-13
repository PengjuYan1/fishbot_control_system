#ifndef FISHBOT_BACKEND_APP_APPSERVER_H_
#define FISHBOT_BACKEND_APP_APPSERVER_H_

#include <functional>
#include <string>
#include <unordered_map>

struct HttpResponse {
    int status = 404;
    std::string body;
    std::string content_type = "application/json";
};

class AppServer {
  public:
    using GetHandler = std::function<HttpResponse()>;

    void register_get(const std::string& path, GetHandler handler);
    HttpResponse handle_get(const std::string& path) const;

  private:
    std::unordered_map<std::string, GetHandler> get_handlers_;
};

#endif
