#include "backend/services/ManualControlService.h"

ManualControlService::ManualControlService(IRobotAdapter& adapter) : adapter_(adapter) {}

bool ManualControlService::out_of_charge() {
    return adapter_.out_of_charge();
}

bool ManualControlService::move(double linear_speed, double angular_speed) {
    return adapter_.manual_move(linear_speed, angular_speed);
}

bool ManualControlService::stop() {
    return adapter_.manual_move(0.0, 0.0);
}
