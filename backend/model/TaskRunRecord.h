#ifndef FISHBOT_BACKEND_MODEL_TASKRUNRECORD_H_
#define FISHBOT_BACKEND_MODEL_TASKRUNRECORD_H_

#include <string>

struct TaskRunRecord {
    int id = 0;
    std::string trigger_type;
    std::string status;
    std::string resume_context_json;
};

#endif
