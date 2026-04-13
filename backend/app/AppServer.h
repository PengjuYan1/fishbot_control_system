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
    using PostHandler = std::function<HttpResponse(const std::string& body)>;

    void register_get(const std::string& path, GetHandler handler);
    void register_post(const std::string& path, PostHandler handler);
    HttpResponse handle_get(const std::string& path) const;
    HttpResponse handle_post(const std::string& path, const std::string& body) const;

  private:
    std::unordered_map<std::string, GetHandler> get_handlers_;
    std::unordered_map<std::string, PostHandler> post_handlers_;
};

#endif
