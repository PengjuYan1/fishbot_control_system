# Manual Control Rearchitecture Implementation Plan

> **For agentic workers:** REQUIRED: Use superpowers:subagent-driven-development (if subagents available) or superpowers:executing-plans to implement this plan. Steps use checkbox (`- [ ]`) syntax for tracking.

**Goal:** Rebuild manual control so joystick driving is immediate-stop direct drive, while undock and chassis takeover happen once through adapter-level control acquisition instead of backend background driving loops.

**Architecture:** Split manual control into two phases. First, adapter-level acquisition handles undock and navigation release as one atomic preparation step. Second, joystick requests only send direct drive commands and stop commands, with no persistent backend motion thread. APK `move_calibration` remains the design reference for strong takeover, but the web joystick remains continuous control.

**Tech Stack:** C++ backend services, rosbridge adapter, frontend dashboard JavaScript, integration and frontend tests.

---

### Task 1: Define adapter-level manual takeover contract

**Files:**
- Modify: `ros_adapter/IRobotAdapter.h`
- Modify: `ros_adapter/bridge_client/RosbridgeAdapter.h`
- Modify: `ros_adapter/bridge_client/RosbridgeAdapter.cpp`
- Modify: `ros_adapter/native_ros/NativeRosAdapter.h`
- Modify: `ros_adapter/native_ros/NativeRosAdapter.cpp`
- Modify: `backend/app/AppContext.cpp`

- [ ] Add an adapter method that acquires manual control once, including undock and navigation release.
- [ ] Keep direct velocity publishing separate from control acquisition.
- [ ] Implement rosbridge behavior inside the adapter, not in `ManualControlService`.

### Task 2: Simplify manual control service

**Files:**
- Modify: `backend/services/ManualControlService.h`
- Modify: `backend/services/ManualControlService.cpp`
- Modify: `backend/model/ManualControlState.h`
- Modify: `backend/api/ControlController.cpp`

- [ ] Remove backend background driving loops and lease-based motion persistence.
- [ ] Make first joystick motion trigger one acquisition step when needed.
- [ ] Make `move()` send only the requested twist for the current heartbeat.
- [ ] Make `stop()` always reset state and publish zero velocity immediately.

### Task 3: Restore joystick to pure heartbeat behavior

**Files:**
- Modify: `frontend/assets/js/dashboard.js`
- Modify: `frontend/assets/js/api.js` if needed

- [ ] Keep joystick on a fast heartbeat.
- [ ] Ignore stale in-flight responses after stop.
- [ ] Ensure release always issues stop and does not depend on backend session expiry.

### Task 4: Rebuild regression coverage

**Files:**
- Modify: `tests/integration/api/test_manual_control_api.cpp`
- Modify: `tests/frontend/test_dashboard_joystick.js`

- [ ] Replace tests that assume backend persistent driving.
- [ ] Add tests for one-shot acquire + direct drive + immediate stop.
- [ ] Verify no standalone undock button is required.
