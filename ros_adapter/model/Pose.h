#ifndef FISHBOT_ROS_ADAPTER_MODEL_POSE_H_
#define FISHBOT_ROS_ADAPTER_MODEL_POSE_H_

struct Pose {
    double x = 0.0;
    double y = 0.0;
    double theta = 0.0;
    long floor_id = 0;
    long map_id = 0;
    long point_id = 0;
};

#endif
