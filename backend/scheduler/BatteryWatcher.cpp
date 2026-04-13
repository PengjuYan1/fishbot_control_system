#include "backend/scheduler/BatteryWatcher.h"

BatteryWatcher::BatteryWatcher(int return_threshold_percent)
    : return_threshold_percent_(return_threshold_percent) {}

bool BatteryWatcher::should_interrupt_for_charge(int battery_percent) const {
    return battery_percent < return_threshold_percent_;
}

bool BatteryWatcher::can_start_task(int battery_percent) const {
    return battery_percent >= return_threshold_percent_;
}
