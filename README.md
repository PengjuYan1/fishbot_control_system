# Fishbot Control System

Fishbot Control System is a new single-robot, single-map control stack for fish-farm feeding robots.
It replaces the older direct-to-ROS web control approach with a layered architecture that separates:

- web UI
- C++ backend business services
- ROS adapter implementations
- local persistence and runtime logs

## Current Status

This repository is already runnable for single-robot, single-map deployment and now includes:

- real HTTP runtime entrypoint (`fishbot_app`)
- rosbridge live status integration
- map snapshot and robot pose visualization
- feed point / charge point persistence
- task start and go-charge control
- out-of-charge / unlock control
- web manual drive controls backed by `cmd_vel`
- full C++ test suite (`26/26` passing at the latest local verification)

## Planned Capabilities

- map-first dashboard with robot pose and overlays
- feed point and charge point management
- timed and manual feeding tasks
- low-battery auto-charge with resumable task context
- diagnostics, alerts, and system logs

## Local Development

```bash
./scripts/dev_run.sh
```

Or run the compiled app directly:

```bash
cmake -S . -B build
cmake --build build -j"$(nproc)"
./build/fishbot_app config/app.local.yaml
```

## Real Robot Probe

Use the rosbridge probe before real robot联调. It only connects and subscribes to live topics, and does not issue navigation or map-changing commands.

```bash
cmake -S . -B build
cmake --build build --target fishbot_rosbridge_probe
./build/fishbot_rosbridge_probe 10.7.5.88 9090 2000
```

Expected output is a single JSON line with current connection state, battery, localization, charging flag, pose, and the latest map snapshot cache.

## Tests

```bash
cmake -S . -B build
cmake --build build
cd build && ctest -V
```

Frontend syntax checks:

```bash
node --check frontend/assets/js/api.js
node --check frontend/assets/js/dashboard.js
```

## Web Controls

The dashboard home page now exposes:

- `开始建图`
- `保存地图`
- `启动任务`
- `立即回充`
- `脱离充电 / 解锁`
- manual drive buttons for forward / backward / left / right / stop

Manual drive behavior:

- press and hold a direction button to keep sending low-speed movement commands
- release, blur the page, or switch tabs to auto-stop
- center `停止` and `立即停止` both send zero velocity

The real robot rosbridge topics confirmed from the APK and used by this project are:

- `outofcharge` with `std_msgs/Int16` payload `{"data":1}`
- `cmd_vel` with `geometry_msgs/Twist`
- `angular.z` uses the APK-compatible sign convention

## Repository Layout

```text
backend/        C++ application bootstrap and business logic
config/         example configuration
ros_adapter/    robot capability abstraction and concrete adapter skeletons
storage/        SQLite helpers and schema migrations
tests/          unit and integration tests
docs/           design and implementation plans
reverse_engineering/ APK reverse-engineering references used for ROS/API verification
```
