# Fishbot Control System Implementation Plan

> **For agentic workers:** REQUIRED: Use superpowers:subagent-driven-development (if subagents available) or superpowers:executing-plans to implement this plan. Steps use checkbox (`- [ ]`) syntax for tracking.

**Goal:** Build a new single-robot, single-map fish-farm feeding control system with a map-first web UI, C++ backend, ROS adapter layer, task scheduling, auto-charge, and recoverable task execution.

**Architecture:** The system uses a static web frontend plus a C++ service that owns business APIs, WebSocket updates, persistence, scheduling, and task state transitions. ROS communication is isolated behind an adapter interface so the same backend can run either against rosbridge on an upper computer or native ROS on the robot host.

**Tech Stack:** C++, CMake, Crow or oat++, asio, SQLite3, nlohmann/json, yaml-cpp, HTML/CSS/JavaScript, REST, WebSocket

---

## File Structure

- `fishbot_control_system/CMakeLists.txt` - top-level build, options, targets
- `fishbot_control_system/config/app.example.yaml` - deployable configuration template
- `fishbot_control_system/backend/main.cpp` - service entry point and bootstrap wiring
- `fishbot_control_system/backend/app/AppServer.h` - owns HTTP/WebSocket server lifecycle
- `fishbot_control_system/backend/app/AppServer.cpp` - server setup and dependency wiring
- `fishbot_control_system/backend/api/*.h` / `*.cpp` - REST handlers grouped by domain
- `fishbot_control_system/backend/websocket/StatusHub.h` - realtime publish/subscribe abstraction
- `fishbot_control_system/backend/websocket/StatusHub.cpp` - websocket connection management
- `fishbot_control_system/backend/services/SystemService.*` - high-level robot/system snapshot reads
- `fishbot_control_system/backend/services/MapService.*` - map workflow orchestration
- `fishbot_control_system/backend/services/PointService.*` - charge/feed point CRUD
- `fishbot_control_system/backend/services/TaskService.*` - task start/pause/resume/stop orchestration
- `fishbot_control_system/backend/services/ScheduleService.*` - timed job management
- `fishbot_control_system/backend/services/AlertService.*` - alert generation and querying
- `fishbot_control_system/backend/state_machine/TaskStateMachine.*` - explicit task state transitions
- `fishbot_control_system/backend/state_machine/TaskState.h` - state/event enums and result structs
- `fishbot_control_system/backend/scheduler/TaskScheduler.*` - timer-driven schedule executor
- `fishbot_control_system/backend/scheduler/BatteryWatcher.*` - threshold monitoring
- `fishbot_control_system/backend/model/*.h` - DTOs for system state, points, task runs, alerts
- `fishbot_control_system/ros_adapter/IRobotAdapter.h` - stable capability interface
- `fishbot_control_system/ros_adapter/model/*.h` - adapter-facing pose, battery, map, nav data types
- `fishbot_control_system/ros_adapter/bridge_client/RosbridgeAdapter.*` - rosbridge-backed implementation
- `fishbot_control_system/ros_adapter/native_ros/NativeRosAdapter.*` - native-ROS-backed implementation
- `fishbot_control_system/storage/Database.*` - SQLite connection and migration runner
- `fishbot_control_system/storage/migrations/001_init.sql` - initial schema
- `fishbot_control_system/storage/repositories/*.h` / `*.cpp` - repository layer for tables
- `fishbot_control_system/frontend/index.html` - dashboard shell
- `fishbot_control_system/frontend/map.html` - map and point management page shell
- `fishbot_control_system/frontend/tasks.html` - scheduling page shell
- `fishbot_control_system/frontend/system.html` - diagnostics page shell
- `fishbot_control_system/frontend/assets/css/*.css` - page styles
- `fishbot_control_system/frontend/assets/js/api.js` - REST client
- `fishbot_control_system/frontend/assets/js/ws.js` - WebSocket client
- `fishbot_control_system/frontend/assets/js/store.js` - in-browser reactive state store
- `fishbot_control_system/frontend/assets/js/map-canvas.js` - map rendering and overlays
- `fishbot_control_system/frontend/assets/js/dashboard.js` - dashboard behavior
- `fishbot_control_system/frontend/assets/js/points.js` - point management behavior
- `fishbot_control_system/frontend/assets/js/tasks.js` - scheduling behavior
- `fishbot_control_system/frontend/assets/js/system.js` - diagnostics behavior
- `fishbot_control_system/tests/unit/...` - focused C++ unit tests
- `fishbot_control_system/tests/integration/...` - API, persistence, and fake-adapter integration tests
- `fishbot_control_system/tests/frontend/...` - lightweight browser-side behavior tests if added
- `fishbot_control_system/scripts/dev_run.sh` - local dev launch helper
- `fishbot_control_system/scripts/package.sh` - deployment bundle helper
- `fishbot_control_system/docs/architecture/runtime-flows.md` - runtime sequence notes from implementation

## Chunk 1: Project Bootstrap And Core Infrastructure

### Task 1: Initialize buildable project skeleton

**Files:**
- Create: `fishbot_control_system/CMakeLists.txt`
- Create: `fishbot_control_system/backend/main.cpp`
- Create: `fishbot_control_system/config/app.example.yaml`
- Create: `fishbot_control_system/scripts/dev_run.sh`
- Test: `fishbot_control_system/tests/integration/test_bootstrap.cpp`

- [ ] **Step 1: Write the failing bootstrap test**

```cpp
TEST(BootstrapTest, StartsWithExampleConfigPath) {
  EXPECT_TRUE(start_app_with_config("config/app.example.yaml"));
}
```

- [ ] **Step 2: Run test to verify it fails**

Run: `ctest --test-dir build -R BootstrapTest -V`
Expected: FAIL because the app target and bootstrap function do not exist yet.

- [ ] **Step 3: Write minimal implementation**

Add the top-level CMake target, a minimal `main.cpp`, config loader wiring, and a shell script that launches the binary with the example config.

- [ ] **Step 4: Run test to verify it passes**

Run: `cmake -S . -B build && cmake --build build && ctest --test-dir build -R BootstrapTest -V`
Expected: PASS with the service able to parse config and exit cleanly in test mode.

- [ ] **Step 5: Commit**

```bash
git add CMakeLists.txt backend/main.cpp config/app.example.yaml scripts/dev_run.sh tests/integration/test_bootstrap.cpp
git commit -m "chore: bootstrap fishbot control system"
```

### Task 2: Add config, logging, and dependency container

**Files:**
- Create: `fishbot_control_system/backend/app/AppContext.h`
- Create: `fishbot_control_system/backend/app/AppContext.cpp`
- Create: `fishbot_control_system/backend/app/Config.h`
- Create: `fishbot_control_system/backend/app/Config.cpp`
- Create: `fishbot_control_system/backend/app/Logger.h`
- Create: `fishbot_control_system/backend/app/Logger.cpp`
- Test: `fishbot_control_system/tests/unit/app/test_config.cpp`

- [ ] **Step 1: Write the failing config test**

```cpp
TEST(ConfigTest, ReadsAdapterModeAndBatteryThresholds) {
  auto cfg = load_config("config/app.example.yaml");
  EXPECT_EQ(cfg.adapter_mode, "rosbridge");
  EXPECT_EQ(cfg.battery_return_threshold, 25);
}
```

- [ ] **Step 2: Run test to verify it fails**

Run: `ctest --test-dir build -R ConfigTest -V`
Expected: FAIL because config structures and loader do not exist.

- [ ] **Step 3: Write minimal implementation**

Implement a small config struct, YAML parsing, and a logger interface that can be injected into later services.

- [ ] **Step 4: Run test to verify it passes**

Run: `cmake --build build && ctest --test-dir build -R ConfigTest -V`
Expected: PASS and config values match the example file.

- [ ] **Step 5: Commit**

```bash
git add backend/app config/app.example.yaml tests/unit/app/test_config.cpp
git commit -m "feat: add config and logging foundation"
```

### Task 3: Create SQLite database and migrations foundation

**Files:**
- Create: `fishbot_control_system/storage/Database.h`
- Create: `fishbot_control_system/storage/Database.cpp`
- Create: `fishbot_control_system/storage/migrations/001_init.sql`
- Test: `fishbot_control_system/tests/integration/storage/test_migrations.cpp`

- [ ] **Step 1: Write the failing migration test**

```cpp
TEST(MigrationTest, CreatesCoreTables) {
  auto db = open_test_database();
  run_migrations(db);
  EXPECT_TRUE(table_exists(db, "system_config"));
  EXPECT_TRUE(table_exists(db, "points"));
  EXPECT_TRUE(table_exists(db, "task_runs"));
}
```

- [ ] **Step 2: Run test to verify it fails**

Run: `ctest --test-dir build -R MigrationTest -V`
Expected: FAIL because migration runner and schema are missing.

- [ ] **Step 3: Write minimal implementation**

Implement SQLite open/close helpers, a migration runner, and an initial SQL schema for config, maps, points, schedules, task runs, and event logs.

- [ ] **Step 4: Run test to verify it passes**

Run: `cmake --build build && ctest --test-dir build -R MigrationTest -V`
Expected: PASS and all required tables exist.

- [ ] **Step 5: Commit**

```bash
git add storage tests/integration/storage/test_migrations.cpp
git commit -m "feat: add sqlite schema foundation"
```

## Chunk 2: ROS Adapter Abstraction

### Task 4: Define robot capability interface and shared models

**Files:**
- Create: `fishbot_control_system/ros_adapter/IRobotAdapter.h`
- Create: `fishbot_control_system/ros_adapter/model/Pose.h`
- Create: `fishbot_control_system/ros_adapter/model/RobotStatus.h`
- Create: `fishbot_control_system/ros_adapter/model/MapSnapshot.h`
- Test: `fishbot_control_system/tests/unit/ros_adapter/test_interface_contract.cpp`

- [ ] **Step 1: Write the failing interface contract test**

```cpp
TEST(AdapterContractTest, ExposesCapabilitiesNeededByBusinessLayer) {
  auto capabilities = describe_adapter_contract();
  EXPECT_THAT(capabilities, Contains("navigate_to_pose"));
  EXPECT_THAT(capabilities, Contains("get_battery"));
  EXPECT_THAT(capabilities, Contains("start_mapping"));
}
```

- [ ] **Step 2: Run test to verify it fails**

Run: `ctest --test-dir build -R AdapterContractTest -V`
Expected: FAIL because no interface contract exists yet.

- [ ] **Step 3: Write minimal implementation**

Define the pure virtual adapter interface and DTOs needed by services and state machine code.

- [ ] **Step 4: Run test to verify it passes**

Run: `cmake --build build && ctest --test-dir build -R AdapterContractTest -V`
Expected: PASS and the contract surface matches the planned robot capabilities.

- [ ] **Step 5: Commit**

```bash
git add ros_adapter tests/unit/ros_adapter/test_interface_contract.cpp
git commit -m "feat: define robot adapter interface"
```

### Task 5: Add rosbridge adapter skeleton with fake transport seam

**Files:**
- Create: `fishbot_control_system/ros_adapter/bridge_client/RosbridgeAdapter.h`
- Create: `fishbot_control_system/ros_adapter/bridge_client/RosbridgeAdapter.cpp`
- Create: `fishbot_control_system/ros_adapter/bridge_client/IRosbridgeTransport.h`
- Test: `fishbot_control_system/tests/unit/ros_adapter/test_rosbridge_adapter.cpp`

- [ ] **Step 1: Write the failing rosbridge adapter test**

```cpp
TEST(RosbridgeAdapterTest, ConvertsBusinessNavigateRequestToTransportCall) {
  FakeRosbridgeTransport transport;
  RosbridgeAdapter adapter(&transport);
  adapter.navigate_to_pose({1.0, 2.0, 0.5});
  EXPECT_EQ(transport.last_method(), "navigate_to_pose");
}
```

- [ ] **Step 2: Run test to verify it fails**

Run: `ctest --test-dir build -R RosbridgeAdapterTest -V`
Expected: FAIL because the adapter and fake transport seam do not exist.

- [ ] **Step 3: Write minimal implementation**

Create a transport abstraction around rosbridge messaging and implement command translation stubs for navigation, map save/load, and status reads.

- [ ] **Step 4: Run test to verify it passes**

Run: `cmake --build build && ctest --test-dir build -R RosbridgeAdapterTest -V`
Expected: PASS with request conversion verified via the fake transport.

- [ ] **Step 5: Commit**

```bash
git add ros_adapter/bridge_client tests/unit/ros_adapter/test_rosbridge_adapter.cpp
git commit -m "feat: add rosbridge adapter skeleton"
```

### Task 6: Add native ROS adapter skeleton matching the same interface

**Files:**
- Create: `fishbot_control_system/ros_adapter/native_ros/NativeRosAdapter.h`
- Create: `fishbot_control_system/ros_adapter/native_ros/NativeRosAdapter.cpp`
- Test: `fishbot_control_system/tests/unit/ros_adapter/test_native_adapter.cpp`

- [ ] **Step 1: Write the failing native adapter test**

```cpp
TEST(NativeAdapterTest, ReportsConfiguredModeName) {
  NativeRosAdapter adapter;
  EXPECT_EQ(adapter.mode_name(), "native_ros");
}
```

- [ ] **Step 2: Run test to verify it fails**

Run: `ctest --test-dir build -R NativeAdapterTest -V`
Expected: FAIL because native adapter files do not exist.

- [ ] **Step 3: Write minimal implementation**

Add a skeleton native adapter implementing the same interface, with non-networked methods stubbed behind compile-time guards until robot-host deployment is exercised.

- [ ] **Step 4: Run test to verify it passes**

Run: `cmake --build build && ctest --test-dir build -R NativeAdapterTest -V`
Expected: PASS and adapter mode is selectable.

- [ ] **Step 5: Commit**

```bash
git add ros_adapter/native_ros tests/unit/ros_adapter/test_native_adapter.cpp
git commit -m "feat: add native ros adapter skeleton"
```

## Chunk 3: Backend Service Skeleton And Realtime Status

### Task 7: Build HTTP server shell and health endpoint

**Files:**
- Create: `fishbot_control_system/backend/app/AppServer.h`
- Create: `fishbot_control_system/backend/app/AppServer.cpp`
- Create: `fishbot_control_system/backend/api/HealthController.h`
- Create: `fishbot_control_system/backend/api/HealthController.cpp`
- Test: `fishbot_control_system/tests/integration/api/test_health_endpoint.cpp`

- [ ] **Step 1: Write the failing health endpoint test**

```cpp
TEST(HealthEndpointTest, ReturnsOkAndAdapterMode) {
  auto response = http_get("/api/health");
  EXPECT_EQ(response.status, 200);
  EXPECT_EQ(response.json["status"], "ok");
  EXPECT_TRUE(response.json.contains("adapter_mode"));
}
```

- [ ] **Step 2: Run test to verify it fails**

Run: `ctest --test-dir build -R HealthEndpointTest -V`
Expected: FAIL because no server or endpoint exists.

- [ ] **Step 3: Write minimal implementation**

Wire the web framework, register a health endpoint, and return process status plus configured adapter mode.

- [ ] **Step 4: Run test to verify it passes**

Run: `cmake --build build && ctest --test-dir build -R HealthEndpointTest -V`
Expected: PASS with valid JSON output.

- [ ] **Step 5: Commit**

```bash
git add backend/app backend/api tests/integration/api/test_health_endpoint.cpp
git commit -m "feat: add app server health endpoint"
```

### Task 8: Implement system snapshot service and status API

**Files:**
- Create: `fishbot_control_system/backend/services/SystemService.h`
- Create: `fishbot_control_system/backend/services/SystemService.cpp`
- Create: `fishbot_control_system/backend/api/SystemController.h`
- Create: `fishbot_control_system/backend/api/SystemController.cpp`
- Test: `fishbot_control_system/tests/integration/api/test_system_status.cpp`

- [ ] **Step 1: Write the failing system status test**

```cpp
TEST(SystemStatusTest, ReturnsBatteryPoseAndTaskSummary) {
  auto response = http_get("/api/system/status");
  EXPECT_EQ(response.status, 200);
  EXPECT_TRUE(response.json.contains("battery"));
  EXPECT_TRUE(response.json.contains("pose"));
  EXPECT_TRUE(response.json.contains("task"));
}
```

- [ ] **Step 2: Run test to verify it fails**

Run: `ctest --test-dir build -R SystemStatusTest -V`
Expected: FAIL because no snapshot service exists.

- [ ] **Step 3: Write minimal implementation**

Use a fake adapter in tests, aggregate robot and task snapshot data, and expose it through `/api/system/status`.

- [ ] **Step 4: Run test to verify it passes**

Run: `cmake --build build && ctest --test-dir build -R SystemStatusTest -V`
Expected: PASS with battery, pose, and task summary fields present.

- [ ] **Step 5: Commit**

```bash
git add backend/services/SystemService.* backend/api/SystemController.* tests/integration/api/test_system_status.cpp
git commit -m "feat: add system status api"
```

### Task 9: Add WebSocket status hub

**Files:**
- Create: `fishbot_control_system/backend/websocket/StatusHub.h`
- Create: `fishbot_control_system/backend/websocket/StatusHub.cpp`
- Test: `fishbot_control_system/tests/integration/api/test_status_websocket.cpp`

- [ ] **Step 1: Write the failing WebSocket test**

```cpp
TEST(StatusWebSocketTest, BroadcastsRobotPoseMessage) {
  auto message = connect_and_wait_for_ws_message("/ws/status");
  EXPECT_EQ(message["type"], "robot_pose");
}
```

- [ ] **Step 2: Run test to verify it fails**

Run: `ctest --test-dir build -R StatusWebSocketTest -V`
Expected: FAIL because the WebSocket endpoint does not exist.

- [ ] **Step 3: Write minimal implementation**

Implement a connection registry and publish an initial pose snapshot on connect.

- [ ] **Step 4: Run test to verify it passes**

Run: `cmake --build build && ctest --test-dir build -R StatusWebSocketTest -V`
Expected: PASS with a structured pose message.

- [ ] **Step 5: Commit**

```bash
git add backend/websocket tests/integration/api/test_status_websocket.cpp
git commit -m "feat: add realtime status websocket"
```

## Chunk 4: Frontend Shell And Map-First Dashboard

### Task 10: Create frontend shell and dashboard layout

**Files:**
- Create: `fishbot_control_system/frontend/index.html`
- Create: `fishbot_control_system/frontend/assets/css/base.css`
- Create: `fishbot_control_system/frontend/assets/css/dashboard.css`
- Create: `fishbot_control_system/frontend/assets/js/api.js`
- Create: `fishbot_control_system/frontend/assets/js/dashboard.js`
- Test: `fishbot_control_system/tests/frontend/test_dashboard_structure.md`

- [ ] **Step 1: Write the failing dashboard structure check**

```text
Open frontend/index.html and verify it contains:
- map canvas container
- status panel
- task panel
- quick action buttons
```

- [ ] **Step 2: Run the structure check to verify it fails**

Run: `rg "map-canvas|status-panel|task-panel|quick-actions" frontend/index.html`
Expected: FAIL because the dashboard file does not exist yet.

- [ ] **Step 3: Write minimal implementation**

Create the dashboard HTML with the approved map-first layout and placeholder cards for robot state, current task, and quick actions.

- [ ] **Step 4: Run the structure check to verify it passes**

Run: `rg "map-canvas|status-panel|task-panel|quick-actions" frontend/index.html`
Expected: PASS with all sections present.

- [ ] **Step 5: Commit**

```bash
git add frontend/index.html frontend/assets/css frontend/assets/js/api.js frontend/assets/js/dashboard.js tests/frontend/test_dashboard_structure.md
git commit -m "feat: add map-first dashboard shell"
```

### Task 11: Render map overlays and realtime robot pose in browser

**Files:**
- Create: `fishbot_control_system/frontend/assets/js/ws.js`
- Create: `fishbot_control_system/frontend/assets/js/store.js`
- Create: `fishbot_control_system/frontend/assets/js/map-canvas.js`
- Modify: `fishbot_control_system/frontend/assets/js/dashboard.js`
- Test: `fishbot_control_system/tests/frontend/test_map_overlay.md`

- [ ] **Step 1: Write the failing overlay behavior check**

```text
Given a status message with robot pose and points,
when map-canvas.js renders,
then the robot marker, heading, charge point, and feed points appear.
```

- [ ] **Step 2: Run the check to verify it fails**

Run: `rg "renderRobot|renderPoints|renderHeading" frontend/assets/js/map-canvas.js`
Expected: FAIL because the map renderer does not exist.

- [ ] **Step 3: Write minimal implementation**

Add a tiny in-browser store, connect to the status WebSocket, and render robot pose plus points on the map canvas.

- [ ] **Step 4: Run the check to verify it passes**

Run: `rg "renderRobot|renderPoints|renderHeading" frontend/assets/js/map-canvas.js`
Expected: PASS with map overlay functions present.

- [ ] **Step 5: Commit**

```bash
git add frontend/assets/js/ws.js frontend/assets/js/store.js frontend/assets/js/map-canvas.js frontend/assets/js/dashboard.js tests/frontend/test_map_overlay.md
git commit -m "feat: render realtime map overlays"
```

## Chunk 5: Map And Point Management

### Task 12: Implement map workflow service and API

**Files:**
- Create: `fishbot_control_system/backend/services/MapService.h`
- Create: `fishbot_control_system/backend/services/MapService.cpp`
- Create: `fishbot_control_system/backend/api/MapController.h`
- Create: `fishbot_control_system/backend/api/MapController.cpp`
- Test: `fishbot_control_system/tests/integration/api/test_map_workflow.cpp`

- [ ] **Step 1: Write the failing map workflow test**

```cpp
TEST(MapWorkflowTest, StartsStopsAndSavesMap) {
  EXPECT_EQ(http_post("/api/map/start-mapping").status, 200);
  EXPECT_EQ(http_post("/api/map/stop-mapping").status, 200);
  EXPECT_EQ(http_post_json("/api/map/save", {{"name", "pond_a"}}).status, 200);
}
```

- [ ] **Step 2: Run test to verify it fails**

Run: `ctest --test-dir build -R MapWorkflowTest -V`
Expected: FAIL because map API endpoints and service are missing.

- [ ] **Step 3: Write minimal implementation**

Use the adapter interface to orchestrate map start/stop/save and return business-friendly responses.

- [ ] **Step 4: Run test to verify it passes**

Run: `cmake --build build && ctest --test-dir build -R MapWorkflowTest -V`
Expected: PASS for start, stop, and save operations under a fake adapter.

- [ ] **Step 5: Commit**

```bash
git add backend/services/MapService.* backend/api/MapController.* tests/integration/api/test_map_workflow.cpp
git commit -m "feat: add map workflow api"
```

### Task 13: Implement point persistence, API, and point-management page

**Files:**
- Create: `fishbot_control_system/storage/repositories/PointRepository.h`
- Create: `fishbot_control_system/storage/repositories/PointRepository.cpp`
- Create: `fishbot_control_system/backend/services/PointService.h`
- Create: `fishbot_control_system/backend/services/PointService.cpp`
- Create: `fishbot_control_system/backend/api/PointController.h`
- Create: `fishbot_control_system/backend/api/PointController.cpp`
- Create: `fishbot_control_system/frontend/map.html`
- Create: `fishbot_control_system/frontend/assets/js/points.js`
- Test: `fishbot_control_system/tests/integration/api/test_points_api.cpp`

- [ ] **Step 1: Write the failing point API test**

```cpp
TEST(PointsApiTest, CreatesChargePointAndFeedPoint) {
  auto charge = http_post_json("/api/points/charge", { {"name", "C1"}, {"x", 1.0}, {"y", 2.0}, {"theta", 0.0} });
  auto feed = http_post_json("/api/points/feed", { {"name", "F1"}, {"x", 3.0}, {"y", 4.0}, {"theta", 1.0} });
  EXPECT_EQ(charge.status, 200);
  EXPECT_EQ(feed.status, 200);
}
```

- [ ] **Step 2: Run test to verify it fails**

Run: `ctest --test-dir build -R PointsApiTest -V`
Expected: FAIL because point persistence and endpoints are missing.

- [ ] **Step 3: Write minimal implementation**

Implement point CRUD, repository storage, and a point-management page that lists and edits charge/feed points.

- [ ] **Step 4: Run test to verify it passes**

Run: `cmake --build build && ctest --test-dir build -R PointsApiTest -V`
Expected: PASS with point records persisted and returned.

- [ ] **Step 5: Commit**

```bash
git add storage/repositories/PointRepository.* backend/services/PointService.* backend/api/PointController.* frontend/map.html frontend/assets/js/points.js tests/integration/api/test_points_api.cpp
git commit -m "feat: add point management workflow"
```

## Chunk 6: Task State Machine And Manual Control Flow

### Task 14: Implement explicit task state machine

**Files:**
- Create: `fishbot_control_system/backend/state_machine/TaskState.h`
- Create: `fishbot_control_system/backend/state_machine/TaskStateMachine.h`
- Create: `fishbot_control_system/backend/state_machine/TaskStateMachine.cpp`
- Test: `fishbot_control_system/tests/unit/state_machine/test_task_state_machine.cpp`

- [ ] **Step 1: Write the failing state machine test**

```cpp
TEST(TaskStateMachineTest, TransitionsFromNavigatingToFeedingPauseOnArrival) {
  TaskStateMachine machine;
  machine.start_run();
  machine.on_navigation_started();
  machine.on_arrived_at_feed_point();
  EXPECT_EQ(machine.current_state(), TaskState::FeedingPause);
}
```

- [ ] **Step 2: Run test to verify it fails**

Run: `ctest --test-dir build -R TaskStateMachineTest -V`
Expected: FAIL because no explicit state machine exists.

- [ ] **Step 3: Write minimal implementation**

Define states, events, guard checks, and transition results for the planned execution flow.

- [ ] **Step 4: Run test to verify it passes**

Run: `cmake --build build && ctest --test-dir build -R TaskStateMachineTest -V`
Expected: PASS and state transitions match the design.

- [ ] **Step 5: Commit**

```bash
git add backend/state_machine tests/unit/state_machine/test_task_state_machine.cpp
git commit -m "feat: add task state machine"
```

### Task 15: Implement task service and manual task endpoints

**Files:**
- Create: `fishbot_control_system/backend/services/TaskService.h`
- Create: `fishbot_control_system/backend/services/TaskService.cpp`
- Create: `fishbot_control_system/backend/api/TaskController.h`
- Create: `fishbot_control_system/backend/api/TaskController.cpp`
- Test: `fishbot_control_system/tests/integration/api/test_manual_task_flow.cpp`

- [ ] **Step 1: Write the failing manual task flow test**

```cpp
TEST(ManualTaskFlowTest, StartsTaskAndTargetsFirstFeedPoint) {
  auto response = http_post("/api/tasks/start");
  EXPECT_EQ(response.status, 200);
  EXPECT_EQ(response.json["status"], "running");
  EXPECT_EQ(response.json["current_target_name"], "F1");
}
```

- [ ] **Step 2: Run test to verify it fails**

Run: `ctest --test-dir build -R ManualTaskFlowTest -V`
Expected: FAIL because task orchestration and endpoints are missing.

- [ ] **Step 3: Write minimal implementation**

Use point order plus state machine transitions to start a manual task and issue the first navigation command through the adapter.

- [ ] **Step 4: Run test to verify it passes**

Run: `cmake --build build && ctest --test-dir build -R ManualTaskFlowTest -V`
Expected: PASS with a running task targeting the first feed point.

- [ ] **Step 5: Commit**

```bash
git add backend/services/TaskService.* backend/api/TaskController.* tests/integration/api/test_manual_task_flow.cpp
git commit -m "feat: add manual task execution"
```

### Task 16: Add task scheduling service and schedule management endpoints

**Files:**
- Create: `fishbot_control_system/storage/repositories/ScheduleRepository.h`
- Create: `fishbot_control_system/storage/repositories/ScheduleRepository.cpp`
- Create: `fishbot_control_system/backend/services/ScheduleService.h`
- Create: `fishbot_control_system/backend/services/ScheduleService.cpp`
- Create: `fishbot_control_system/backend/scheduler/TaskScheduler.h`
- Create: `fishbot_control_system/backend/scheduler/TaskScheduler.cpp`
- Create: `fishbot_control_system/frontend/tasks.html`
- Create: `fishbot_control_system/frontend/assets/js/tasks.js`
- Test: `fishbot_control_system/tests/integration/api/test_schedule_trigger.cpp`

- [ ] **Step 1: Write the failing schedule trigger test**

```cpp
TEST(ScheduleTriggerTest, FiresEnabledScheduleIntoTaskService) {
  seed_schedule("0 8 * * *", true);
  simulate_scheduler_tick("08:00");
  EXPECT_TRUE(task_run_started_from_schedule());
}
```

- [ ] **Step 2: Run test to verify it fails**

Run: `ctest --test-dir build -R ScheduleTriggerTest -V`
Expected: FAIL because no scheduler exists.

- [ ] **Step 3: Write minimal implementation**

Implement schedule persistence, a polling scheduler, and a page to manage schedule definitions.

- [ ] **Step 4: Run test to verify it passes**

Run: `cmake --build build && ctest --test-dir build -R ScheduleTriggerTest -V`
Expected: PASS with enabled schedules starting task runs.

- [ ] **Step 5: Commit**

```bash
git add storage/repositories/ScheduleRepository.* backend/services/ScheduleService.* backend/scheduler/TaskScheduler.* frontend/tasks.html frontend/assets/js/tasks.js tests/integration/api/test_schedule_trigger.cpp
git commit -m "feat: add timed task scheduling"
```

## Chunk 7: Auto-Charge And Recovery Logic

### Task 17: Implement battery watcher and low-battery interrupt

**Files:**
- Create: `fishbot_control_system/backend/scheduler/BatteryWatcher.h`
- Create: `fishbot_control_system/backend/scheduler/BatteryWatcher.cpp`
- Test: `fishbot_control_system/tests/unit/scheduler/test_battery_watcher.cpp`

- [ ] **Step 1: Write the failing battery watcher test**

```cpp
TEST(BatteryWatcherTest, RequestsReturnToChargeBelowThreshold) {
  BatteryWatcher watcher(25);
  EXPECT_TRUE(watcher.should_interrupt_for_charge(24));
  EXPECT_FALSE(watcher.should_interrupt_for_charge(30));
}
```

- [ ] **Step 2: Run test to verify it fails**

Run: `ctest --test-dir build -R BatteryWatcherTest -V`
Expected: FAIL because battery threshold logic does not exist.

- [ ] **Step 3: Write minimal implementation**

Implement threshold checks for task start and in-run charge interruption, with no hysteresis beyond the planned double-threshold policy.

- [ ] **Step 4: Run test to verify it passes**

Run: `cmake --build build && ctest --test-dir build -R BatteryWatcherTest -V`
Expected: PASS and low-battery interrupt decisions match config.

- [ ] **Step 5: Commit**

```bash
git add backend/scheduler/BatteryWatcher.* tests/unit/scheduler/test_battery_watcher.cpp
git commit -m "feat: add battery threshold watcher"
```

### Task 18: Save resume context and recover after charging

**Files:**
- Modify: `fishbot_control_system/backend/services/TaskService.h`
- Modify: `fishbot_control_system/backend/services/TaskService.cpp`
- Create: `fishbot_control_system/storage/repositories/TaskRunRepository.h`
- Create: `fishbot_control_system/storage/repositories/TaskRunRepository.cpp`
- Test: `fishbot_control_system/tests/integration/api/test_charge_recovery.cpp`

- [ ] **Step 1: Write the failing charge recovery test**

```cpp
TEST(ChargeRecoveryTest, ResumesRemainingFeedPointsWhenConfigured) {
  seed_running_task_with_remaining_points({"F2", "F3"});
  simulate_low_battery_interrupt();
  simulate_charge_complete(true);
  EXPECT_EQ(current_target_name(), "F2");
}
```

- [ ] **Step 2: Run test to verify it fails**

Run: `ctest --test-dir build -R ChargeRecoveryTest -V`
Expected: FAIL because resume context persistence is missing.

- [ ] **Step 3: Write minimal implementation**

Persist run context on interrupt, transition into charging, and branch into resume or wait modes when charging completes.

- [ ] **Step 4: Run test to verify it passes**

Run: `cmake --build build && ctest --test-dir build -R ChargeRecoveryTest -V`
Expected: PASS with the configured recovery behavior applied.

- [ ] **Step 5: Commit**

```bash
git add backend/services/TaskService.* storage/repositories/TaskRunRepository.* tests/integration/api/test_charge_recovery.cpp
git commit -m "feat: add charge recovery workflow"
```

## Chunk 8: Monitoring, Logs, And Diagnostics

### Task 19: Add event log repository, alert service, and system page

**Files:**
- Create: `fishbot_control_system/storage/repositories/EventLogRepository.h`
- Create: `fishbot_control_system/storage/repositories/EventLogRepository.cpp`
- Create: `fishbot_control_system/backend/services/AlertService.h`
- Create: `fishbot_control_system/backend/services/AlertService.cpp`
- Create: `fishbot_control_system/backend/api/AlertController.h`
- Create: `fishbot_control_system/backend/api/AlertController.cpp`
- Create: `fishbot_control_system/frontend/system.html`
- Create: `fishbot_control_system/frontend/assets/js/system.js`
- Test: `fishbot_control_system/tests/integration/api/test_alerts_api.cpp`

- [ ] **Step 1: Write the failing alerts API test**

```cpp
TEST(AlertsApiTest, ReturnsLatestWarningsAndErrors) {
  seed_event_log("warning", "battery_low", "Battery below return threshold");
  auto response = http_get("/api/alerts");
  EXPECT_EQ(response.status, 200);
  EXPECT_EQ(response.json[0]["category"], "battery_low");
}
```

- [ ] **Step 2: Run test to verify it fails**

Run: `ctest --test-dir build -R AlertsApiTest -V`
Expected: FAIL because alert persistence and endpoint are missing.

- [ ] **Step 3: Write minimal implementation**

Persist event logs, derive alert views, and render a diagnostics page showing warnings, errors, and connection health.

- [ ] **Step 4: Run test to verify it passes**

Run: `cmake --build build && ctest --test-dir build -R AlertsApiTest -V`
Expected: PASS with seeded alerts returned in order.

- [ ] **Step 5: Commit**

```bash
git add storage/repositories/EventLogRepository.* backend/services/AlertService.* backend/api/AlertController.* frontend/system.html frontend/assets/js/system.js tests/integration/api/test_alerts_api.cpp
git commit -m "feat: add diagnostics and alerts"
```

### Task 20: Add adapter health checks and connection diagnostics

**Files:**
- Modify: `fishbot_control_system/backend/services/SystemService.h`
- Modify: `fishbot_control_system/backend/services/SystemService.cpp`
- Create: `fishbot_control_system/tests/integration/api/test_connection_diagnostics.cpp`
- Modify: `fishbot_control_system/frontend/system.html`
- Modify: `fishbot_control_system/frontend/assets/js/system.js`

- [ ] **Step 1: Write the failing diagnostics test**

```cpp
TEST(ConnectionDiagnosticsTest, ReportsAdapterHealthAndLastError) {
  simulate_adapter_disconnect("rosbridge timeout");
  auto response = http_get("/api/system/status");
  EXPECT_EQ(response.json["connection"]["healthy"], false);
  EXPECT_EQ(response.json["connection"]["last_error"], "rosbridge timeout");
}
```

- [ ] **Step 2: Run test to verify it fails**

Run: `ctest --test-dir build -R ConnectionDiagnosticsTest -V`
Expected: FAIL because connection diagnostics fields are missing.

- [ ] **Step 3: Write minimal implementation**

Expose adapter health, last error, reconnect attempts, and show them on the diagnostics page.

- [ ] **Step 4: Run test to verify it passes**

Run: `cmake --build build && ctest --test-dir build -R ConnectionDiagnosticsTest -V`
Expected: PASS with degraded connection details present.

- [ ] **Step 5: Commit**

```bash
git add backend/services/SystemService.* frontend/system.html frontend/assets/js/system.js tests/integration/api/test_connection_diagnostics.cpp
git commit -m "feat: add connection diagnostics"
```

## Chunk 9: Integration, Packaging, And Verification

### Task 21: Add fake-adapter end-to-end smoke test

**Files:**
- Create: `fishbot_control_system/tests/integration/test_end_to_end_fake_adapter.cpp`
- Modify: `fishbot_control_system/backend/main.cpp`
- Modify: `fishbot_control_system/config/app.example.yaml`

- [ ] **Step 1: Write the failing end-to-end test**

```cpp
TEST(EndToEndFakeAdapterTest, CompletesSingleFeedRunAndPublishesUpdates) {
  launch_app_in_fake_mode();
  seed_points({"C1", "F1"});
  auto response = http_post("/api/tasks/start");
  EXPECT_EQ(response.status, 200);
  EXPECT_TRUE(wait_for_task_completion());
}
```

- [ ] **Step 2: Run test to verify it fails**

Run: `ctest --test-dir build -R EndToEndFakeAdapterTest -V`
Expected: FAIL until all critical app layers are wired together.

- [ ] **Step 3: Write minimal implementation**

Add a fake adapter mode in config, wire it into app startup, and close any remaining gaps needed to complete one full synthetic task run.

- [ ] **Step 4: Run test to verify it passes**

Run: `cmake --build build && ctest --test-dir build -R EndToEndFakeAdapterTest -V`
Expected: PASS with one synthetic feed run completed successfully.

- [ ] **Step 5: Commit**

```bash
git add backend/main.cpp config/app.example.yaml tests/integration/test_end_to_end_fake_adapter.cpp
git commit -m "test: add end-to-end fake adapter smoke test"
```

### Task 22: Add packaging scripts and implementation-facing docs

**Files:**
- Create: `fishbot_control_system/scripts/package.sh`
- Create: `fishbot_control_system/docs/architecture/runtime-flows.md`
- Modify: `fishbot_control_system/docs/superpowers/specs/2026-04-13-fishbot-control-system-design.md`

- [ ] **Step 1: Write the failing packaging checklist**

```text
Verify the repo contains:
- a build/package helper script
- runtime flow documentation
- updated design doc with implementation notes link
```

- [ ] **Step 2: Run the checklist to verify it fails**

Run: `rg "runtime-flows|package.sh|Implementation notes" docs scripts`
Expected: FAIL because these files do not exist yet.

- [ ] **Step 3: Write minimal implementation**

Add packaging helpers, document runtime flows for dashboard, task execution, low-battery return, and reconnect handling, and link those notes from the design doc.

- [ ] **Step 4: Run the checklist to verify it passes**

Run: `rg "runtime-flows|package.sh|Implementation notes" docs scripts`
Expected: PASS with all support assets present.

- [ ] **Step 5: Commit**

```bash
git add scripts/package.sh docs/architecture/runtime-flows.md docs/superpowers/specs/2026-04-13-fishbot-control-system-design.md
git commit -m "docs: add packaging and runtime notes"
```

## Verification Checklist

- [ ] Build the project from a clean `build/` directory.
- [ ] Run all unit tests.
- [ ] Run all integration tests against fake adapter mode.
- [ ] Open the dashboard and verify map, robot pose, points, and task summary render.
- [ ] Trigger one manual task and verify feed-point pause behavior.
- [ ] Trigger low-battery interrupt in fake mode and verify charge recovery branch.
- [ ] Create one schedule and verify timed execution path.
- [ ] Review diagnostics page for adapter health, alerts, and event logs.

## Suggested Execution Order

1. Chunk 1
2. Chunk 2
3. Chunk 3
4. Chunk 4
5. Chunk 5
6. Chunk 6
7. Chunk 7
8. Chunk 8
9. Chunk 9

Plan complete and saved to `docs/superpowers/plans/2026-04-13-fishbot-control-system-implementation.md`. Ready to execute?
