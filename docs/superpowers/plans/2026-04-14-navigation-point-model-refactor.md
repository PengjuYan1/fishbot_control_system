# Navigation Point Model Refactor Implementation Plan

> **For agentic workers:** REQUIRED: Use superpowers:subagent-driven-development (if subagents available) or superpowers:executing-plans to implement this plan. Steps use checkbox (`- [ ]`) syntax for tracking.

**Goal:** Align point creation, feed-point semantics, and charge-return behavior with the APK/manual model.

**Architecture:** Split point meaning into low-level robot point kind and business role. Route point creation through APK-compatible point modes, and change go-charge from ordinary navigation to the dedicated `autocharge` robot command.

**Tech Stack:** C++, SQLite migrations, rosbridge adapter, vanilla frontend JS, CTest, Node syntax/tests

---

## Chunk 1: Point Data Model

### Task 1: Extend point schema

**Files:**
- Create: `storage/migrations/003_split_point_kind_and_role.sql`
- Modify: `backend/model/PointRecord.h`
- Modify: `storage/repositories/PointRepository.h`
- Modify: `storage/repositories/PointRepository.cpp`

- [ ] Add new DB columns for low-level point kind and business role
- [ ] Update `PointRecord` to carry explicit `point_kind` and `biz_role`
- [ ] Update repository insert/find/list SQL to read and write the new fields
- [ ] Preserve backward compatibility for old rows via migration defaults

### Task 2: Define point-kind helpers

**Files:**
- Modify: `backend/services/PointService.h`
- Modify: `backend/services/PointService.cpp`

- [ ] Replace direct `feed/charge` type assumptions with explicit kind/role helpers
- [ ] Make current-point creation choose APK point modes by low-level kind
- [ ] Keep naming rules distinct for navigation/feed vs charge vs initial points

## Chunk 2: Adapter And Charge Flow

### Task 3: Expose dedicated go-charge command

**Files:**
- Modify: `ros_adapter/IRobotAdapter.h`
- Modify: `ros_adapter/native_ros/NativeRosAdapter.h`
- Modify: `ros_adapter/native_ros/NativeRosAdapter.cpp`
- Modify: `ros_adapter/bridge_client/RosbridgeAdapter.h`
- Modify: `ros_adapter/bridge_client/RosbridgeAdapter.cpp`

- [ ] Add `go_charge()` to the adapter contract
- [ ] Implement rosbridge publishing to `autocharge` with APK-compatible payload
- [ ] Keep native/fake adapters returning sensible test behavior

### Task 4: Route charge return through robot charging flow

**Files:**
- Modify: `backend/services/TaskService.h`
- Modify: `backend/services/TaskService.cpp`
- Modify: `tests/integration/api/test_manual_task_flow.cpp`
- Modify: `tests/integration/api/test_points_api.cpp`
- Modify: `tests/unit/ros_adapter/test_rosbridge_adapter.cpp`

- [ ] Change `start_charge_return()` to call `adapter_.go_charge()`
- [ ] Remove dependence on ordinary `navigate_to_pose` for charge return
- [ ] Keep task state transitions coherent for manual charge start

## Chunk 3: Feed Points As Navigation Points

### Task 5: Reclassify feed points

**Files:**
- Modify: `backend/services/PointService.h`
- Modify: `backend/services/PointService.cpp`
- Modify: `backend/services/TaskService.cpp`
- Modify: `backend/api/PointController.cpp`
- Modify: `tests/integration/api/test_current_pose_points_api.cpp`
- Modify: `tests/integration/api/test_points_api.cpp`

- [ ] Make feed-point creation use navigation point mode (`point_mode=0`)
- [ ] Persist feed points as `point_kind=navigation` and `biz_role=feed`
- [ ] Make task selection consume only navigation points tagged as feed

### Task 6: Add initial-point support

**Files:**
- Modify: `backend/services/PointService.h`
- Modify: `backend/services/PointService.cpp`
- Modify: `backend/api/PointController.cpp`
- Modify: `frontend/assets/js/api.js`
- Modify: `frontend/assets/js/dashboard.js`
- Modify: `frontend/index.html`

- [ ] Add backend route for creating current initial point
- [ ] Add frontend action for creating an initial point
- [ ] Keep charge point and initial point clearly separate in UI copy

## Chunk 4: Frontend Semantics And Verification

### Task 7: Stop flattening all points into one concept

**Files:**
- Modify: `frontend/assets/js/dashboard.js`
- Modify: `frontend/assets/js/map-canvas.js`
- Modify: `frontend/assets/js/api.js`
- Modify: `frontend/index.html`

- [ ] Render point kind and business role distinctly
- [ ] Label feed points as navigation-backed business points
- [ ] Keep current-point creation failures visible instead of silently fabricating state

### Task 8: Verification

**Files:**
- Modify as needed from earlier tasks

- [ ] Run targeted backend tests
- [ ] Run full `ctest --output-on-failure`
- [ ] Run frontend syntax and existing JS tests
- [ ] Review git diff for unrelated fallout before commit
