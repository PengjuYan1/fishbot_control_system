#ifndef FISHBOT_BACKEND_SCHEDULER_BATTERYWATCHER_H_
#define FISHBOT_BACKEND_SCHEDULER_BATTERYWATCHER_H_

class BatteryWatcher {
  public:
    explicit BatteryWatcher(int return_threshold_percent);

    bool should_interrupt_for_charge(int battery_percent) const;
    bool can_start_task(int battery_percent) const;

  private:
    int return_threshold_percent_ = 25;
};

#endif
