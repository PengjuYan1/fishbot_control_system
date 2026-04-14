#ifndef FISHBOT_BACKEND_MODEL_POINTRECORD_H_
#define FISHBOT_BACKEND_MODEL_POINTRECORD_H_

#include <string>

struct PointRecord {
    int id = 0;
    std::string name;
    std::string type;
    std::string point_kind = "navigation";
    std::string biz_role;
    double x = 0.0;
    double y = 0.0;
    double theta = 0.0;
    long floor_id = 0;
    long map_id = 0;
    long point_id = 0;
};

#endif
