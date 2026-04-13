#include "backend/app/Logger.h"

Logger::Logger(std::ostream& output) : output_(&output) {}

void Logger::info(const std::string& message) const {
    (*output_) << "[info] " << message << '\n';
}

void Logger::error(const std::string& message) const {
    (*output_) << "[error] " << message << '\n';
}
