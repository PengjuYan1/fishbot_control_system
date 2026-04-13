# Fishbot Control System

Fishbot Control System is a new single-robot, single-map control stack for fish-farm feeding robots.
It replaces the older direct-to-ROS web control approach with a layered architecture that separates:

- web UI
- C++ backend business services
- ROS adapter implementations
- local persistence and runtime logs

## Current Status

This repository is in active bootstrap development.
The completed foundation currently includes:

- CMake-based project skeleton
- example runtime configuration
- app bootstrap entry point
- SQLite migration foundation
- ROS adapter interface contract
- rosbridge adapter skeleton
- native ROS adapter skeleton

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

## Tests

```bash
cmake -S . -B build
cmake --build build
cd build && ctest -V
```

## Repository Layout

```text
backend/        C++ application bootstrap and business logic
config/         example configuration
ros_adapter/    robot capability abstraction and concrete adapter skeletons
storage/        SQLite helpers and schema migrations
tests/          unit and integration tests
docs/           design and implementation plans
```
