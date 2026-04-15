# Self-Developed Charge Return Implementation Plan

> **For agentic workers:** REQUIRED: Use superpowers:subagent-driven-development (if subagents available) or superpowers:executing-plans to implement this plan. Steps use checkbox (`- [ ]`) syntax for tracking.

**Goal:** Build a self-developed flow that auto-captures the charge point during mapping, navigates to a saved point, and returns to the charge point without using vendor `autocharge`.

**Architecture:** Keep the existing joystick/undock path untouched and add a new backend-managed self-charge task flow. Reuse existing point/map persistence, add automatic charge-point capture from live charging state, add a dedicated self-charge state machine in the task service, and implement a minimal local docking controller that uses `/scan`-derived alignment plus `/cmd_vel` control and charge-status confirmation.

**Tech Stack:** C++, existing backend services/controllers, rosbridge adapter, existing point repository/API tests.

---

## Chunk 1: Auto charge-point capture

### Task 1: Add failing integration test for charge-point auto capture
**Files:**
- Modify: `tests/integration/api/test_points_api.cpp`
- Modify: `tests/integration/api/test_map_workflow.cpp`
- Test: `tests/integration/api/test_points_api.cpp`

- [ ] Step 1: Write a failing test proving that when mapping is active and charging is detected, the current pose is stored as a charge point (and initial point if missing).
- [ ] Step 2: Run the focused test and verify the expected failure.
- [ ] Step 3: Implement the minimal service/controller changes to satisfy the test.
- [ ] Step 4: Re-run the focused test and verify it passes.

### Task 2: Wire charge-point auto capture into map/system flow
**Files:**
- Modify: `backend/services/MapService.cpp`
- Modify: `backend/services/SystemService.cpp`
- Modify: `backend/model/SystemSnapshot.h`
- Test: `tests/integration/api/test_map_workflow.cpp`

- [ ] Step 1: Write a failing test for one-shot capture semantics so repeated charging snapshots do not keep creating duplicate points.
- [ ] Step 2: Run the focused test and verify the expected failure.
- [ ] Step 3: Implement minimal dedupe/state tracking for auto capture.
- [ ] Step 4: Re-run the focused tests and verify they pass.

## Chunk 2: Self-charge task API and state machine

### Task 3: Add failing task-service test for self-charge start
**Files:**
- Modify: `tests/integration/api/test_manual_task_flow.cpp`
- Modify: `backend/services/TaskService.h`
- Test: `tests/integration/api/test_manual_task_flow.cpp`

- [ ] Step 1: Write a failing test proving `self-charge` chooses the configured charge point and enters a dedicated self-charge task state instead of calling vendor `autocharge`.
- [ ] Step 2: Run the focused test and verify the expected failure.
- [ ] Step 3: Add the minimal task-service interface/state to satisfy the test.
- [ ] Step 4: Re-run the focused test and verify it passes.

### Task 4: Add API endpoint for self-charge
**Files:**
- Modify: `backend/api/TaskController.cpp`
- Modify: `frontend/assets/js/api.js`
- Modify: `frontend/assets/js/dashboard.js`
- Test: `tests/integration/api/test_manual_task_flow.cpp`

- [ ] Step 1: Write a failing API test for `POST /api/tasks/self-charge`.
- [ ] Step 2: Run the focused test and verify the expected failure.
- [ ] Step 3: Implement the minimal endpoint/wiring.
- [ ] Step 4: Re-run the focused test and verify it passes.

## Chunk 3: Pre-dock navigation and local docking controller

### Task 5: Add failing unit test for pre-dock pose computation
**Files:**
- Create: `tests/unit/backend/test_self_charge_planner.cpp`
- Modify: `backend/services/TaskService.cpp`
- Test: `tests/unit/backend/test_self_charge_planner.cpp`

- [ ] Step 1: Write a failing unit test that computes a pre-dock pose from the saved charge point pose.
- [ ] Step 2: Run the focused test and verify the expected failure.
- [ ] Step 3: Implement the minimal helper and use it from the self-charge flow.
- [ ] Step 4: Re-run the focused test and verify it passes.

### Task 6: Add failing test for docking success by charge-status confirmation
**Files:**
- Modify: `tests/unit/ros_adapter/test_rosbridge_adapter.cpp`
- Create: `tests/integration/api/test_self_charge_docking.cpp`
- Modify: `backend/services/TaskService.cpp`
- Test: `tests/integration/api/test_self_charge_docking.cpp`

- [ ] Step 1: Write a failing integration test showing the task transitions from pre-dock arrival into low-speed local docking and completes when charge status enters a charging code.
- [ ] Step 2: Run the focused test and verify the expected failure.
- [ ] Step 3: Implement the minimal local docking loop using pose/scan-derived alignment hooks and `/cmd_vel` output.
- [ ] Step 4: Re-run the focused test and verify it passes.

## Chunk 4: Focused verification

### Task 7: Run focused verification suite
**Files:**
- Test: `tests/integration/api/test_points_api.cpp`
- Test: `tests/integration/api/test_map_workflow.cpp`
- Test: `tests/integration/api/test_manual_task_flow.cpp`
- Test: `tests/integration/api/test_self_charge_docking.cpp`
- Test: `tests/unit/backend/test_self_charge_planner.cpp`

- [ ] Step 1: Run the focused build targets.
- [ ] Step 2: Run the focused test binaries and check exit codes.
- [ ] Step 3: Fix any regressions uncovered by the focused suite.
- [ ] Step 4: Re-run the same verification commands and record the final evidence.
