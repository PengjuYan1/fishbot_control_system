#ifndef FISHBOT_ROS_ADAPTER_MODEL_LASERSCAN_SNAPSHOT_H_
#define FISHBOT_ROS_ADAPTER_MODEL_LASERSCAN_SNAPSHOT_H_

#include <vector>

struct LaserScanSnapshot {
    double angle_min = 0.0;
    double angle_increment = 0.0;
    double range_min = 0.0;
    double range_max = 0.0;
    long long received_steady_time_ms = 0;
    std::vector<double> ranges;
};

#endif
