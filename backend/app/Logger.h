#ifndef FISHBOT_BACKEND_APP_LOGGER_H_
#define FISHBOT_BACKEND_APP_LOGGER_H_

#include <iostream>
#include <string>

class Logger {
  public:
    explicit Logger(std::ostream& output = std::clog);

    void info(const std::string& message) const;
    void error(const std::string& message) const;

  private:
    std::ostream* output_;
};

#endif
