#ifndef FISHBOT_BACKEND_MODEL_POINTRECORD_H_
#define FISHBOT_BACKEND_MODEL_POINTRECORD_H_

#include <string>

struct PointRecord {
    int id = 0;
    std::string name;
    std::string type;
    double x = 0.0;
    double y = 0.0;
    double theta = 0.0;
};

#endif
