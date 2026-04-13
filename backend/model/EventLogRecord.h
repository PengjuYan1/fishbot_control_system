#ifndef FISHBOT_BACKEND_MODEL_EVENTLOGRECORD_H_
#define FISHBOT_BACKEND_MODEL_EVENTLOGRECORD_H_

#include <string>

struct EventLogRecord {
    int id = 0;
    std::string level;
    std::string category;
    std::string message;
};

#endif
