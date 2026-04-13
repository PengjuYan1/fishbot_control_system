# Manual Control Review Bundle

This bundle is prepared for external review of the robot manual-drive path.

## Goal

Compare the real APK control behavior against the current `fishbot_control_system` implementation for:

- manual drive over `/cmd_vel`
- navigation stop / control release via `/navi_stop`
- mode switching via `/set_mode`
- runtime status topics such as `motion_mode` and `androidmsg_navigationstatus`

## Directory Layout

- `apk/`
  - reverse-engineered Java files from the official Android APK
  - these are the reference implementation files
- `current/`
  - current C++ backend and web frontend files from this repository
  - these are the files that should be reviewed against the APK behavior

## Review Order

### 1. APK Reference

Start with these files in `apk/`:

- `JlNaviManager.java`
- `JoystickView.java`
- `MapActivity.java`
- `SpiritServiceClient.java`
- `SpiritTopicListener.java`
- `TopicNames.java`
- `ServiceNames.java`

Focus on:

- how `/cmd_vel` is published
- whether angular sign is inverted
- how `/navi_stop` is issued
- where `/set_mode` is called
- which status topics are subscribed and acted on

### 2. Current Implementation

Then compare against these files in `current/`:

- `ManualControlService.cpp`
- `ManualControlService.h`
- `ControlController.cpp`
- `SystemService.cpp`
- `RosbridgeAdapter.cpp`
- `RosbridgeAdapter.h`
- `dashboard.js`
- `api.js`
- `index.html`

Focus on:

- when control release happens before manual movement
- whether release is state-aware or only session-aware
- whether `navigation_status` and `motion_mode` are surfaced to the UI and used in control decisions
- whether front-end behavior matches the APK's hold-to-drive pattern

## Current Suspected Gap

The current code already matches the APK on the basic teleop transport:

- manual movement uses `/cmd_vel`
- release uses repeated `/navi_stop` followed by zero `cmd_vel`
- real-time state subscription already includes `motion_mode` and `androidmsg_navigationstatus`

The main remaining risk is higher-level control ownership:

- `navigation_status_` is subscribed in the adapter but not exposed in the API snapshot
- `motion_mode_code` is exposed but not used to gate or retry manual control release
- `ManualControlService` releases control only once per local session and does not re-check live robot state before subsequent drive commands

That is the area the reviewer should verify first.
