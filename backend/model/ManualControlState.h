#ifndef FISHBOT_BACKEND_MODEL_MANUALCONTROLSTATE_H_
#define FISHBOT_BACKEND_MODEL_MANUALCONTROLSTATE_H_

#include <string>

enum class ManualControlPhase {
    kIdle,
    kUndockingRequested,
    kReadyForDrive,
    kDriving,
};

inline const char* to_string(ManualControlPhase phase) {
    switch (phase) {
        case ManualControlPhase::kUndockingRequested:
            return "undocking_requested";
        case ManualControlPhase::kReadyForDrive:
            return "ready_for_drive";
        case ManualControlPhase::kDriving:
            return "driving";
        case ManualControlPhase::kIdle:
        default:
            return "idle";
    }
}

struct ManualControlState {
    ManualControlPhase phase = ManualControlPhase::kIdle;
    double desired_linear = 0.0;
    double desired_angular = 0.0;
    bool session_active = false;
    bool pending_motion = false;
};

inline std::string to_json(const ManualControlState& state) {
    return std::string("{\"phase\":\"") + to_string(state.phase) +
        "\",\"desired_linear\":" + std::to_string(state.desired_linear) +
        ",\"desired_angular\":" + std::to_string(state.desired_angular) +
        ",\"session_active\":" + (state.session_active ? "true" : "false") +
        ",\"pending_motion\":" + (state.pending_motion ? "true" : "false") + "}";
}

#endif
