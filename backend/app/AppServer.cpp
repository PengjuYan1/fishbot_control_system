#include "backend/app/AppServer.h"

void AppServer::register_get(const std::string& path, GetHandler handler) {
    get_handlers_[path] = std::move(handler);
}

void AppServer::register_post(const std::string& path, PostHandler handler) {
    post_handlers_[path] = std::move(handler);
}

HttpResponse AppServer::handle_get(const std::string& path) const {
    const auto it = get_handlers_.find(path);
    if (it == get_handlers_.end()) {
        return HttpResponse{404, "{\"error\":\"not_found\"}", "application/json"};
    }

    return it->second();
}

HttpResponse AppServer::handle_post(const std::string& path, const std::string& body) const {
    const auto it = post_handlers_.find(path);
    if (it == post_handlers_.end()) {
        return HttpResponse{404, "{\"error\":\"not_found\"}", "application/json"};
    }

    return it->second(body);
}
