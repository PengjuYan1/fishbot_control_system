# Navigation Point Model And Charge Flow Design

## Goal

Refactor the point model and map-management flow so the system follows the navigation app's real semantics:

- navigation points are the base navigable targets
- feed points are navigation points with business meaning
- charge points and initial points are system points with dedicated roles
- "go charge" uses the app's `autocharge` flow instead of treating charge return as ordinary navigation

## Background

The current implementation mixes business concepts and low-level robot concepts in the same `PointRecord.type` field. That has already caused concrete failures:

- charge point creation could appear to succeed in the UI while not producing a valid robot-side point
- go-charge behavior was implemented as "navigate to a stored charge point", which does not match the app
- feed points were modeled as a separate low-level point type even though the app only distinguishes them through how navigation points are used

Both the PDF manual and the decompiled APK show a different model:

- `point_mode = 0`: navigation point
- `point_mode = 1`: charge point
- `point_mode = 2`: initial point
- manual coordinate point placement uses `pointmanu_set`
- current robot position point creation uses `point_set`
- automatic charging is triggered by publishing `Int16(data=1)` to topic `autocharge`

## Source Findings

### Manual

From `/home/ypj/ROS/ROS/导航App操作手册（搬运机器人）1.1.pdf`:

- map management includes add navigation point, add charge point, add initial point, auto charge, stop move
- when creating a new map, the robot must have a charge point and an initial point before map save
- the charge point should be created when the robot is facing the charger from about 0.5m in front
- charge point and initial point are separate concepts
- navigation tests and charge tests both operate on navigation-point lists

### APK

Relevant decompiled paths:

- `SpiritServiceClient.addPosintServices(...)` uses service `point_set`
- `SpiritServiceClient.addManuPosintServices(...)` uses service `pointmanu_set`
- `JlNaviManager.addCurrentPosition(...)` maps:
  - `"充电桩"` -> `point_mode = 1`
  - `"初始点"` -> `point_mode = 2`
  - default -> `point_mode = 0`
- `MapActivity` "自动回充" publishes to topic `autocharge`
- normal named navigation uses `set_goal`
- direct navigation by ids uses `navi_targegoalplan`

## Design

### 1. Point Model

Replace the single overloaded `PointRecord.type` meaning with two layers:

#### Low-level point kind

This is the robot/system meaning and must align with APK semantics.

- `navigation`
- `charge`
- `initial`

#### Business role

This is application meaning layered on top of a low-level point kind.

- empty / none
- `feed`
- future-safe for `inspect`, `pickup`, etc.

### 2. Rules

- every feed point is a `navigation` point
- no feed point can be a `charge` point or `initial` point
- `charge` and `initial` points are system-owned anchor points
- `go charge` must not depend on treating the charge point as an ordinary task destination

### 3. Creation Flows

#### Navigation point

Primary flow:

- create from current robot pose via `point_set(point_mode=0, point_name=...)`

Optional manual map-edit flow:

- create from explicit coordinates via `pointmanu_set(point_mode=0, ...)`

If a navigation point is meant for feeding:

- store it as `low_level_kind=navigation`
- set `biz_role=feed`

#### Charge point

Primary flow:

- create from current robot pose via `point_set(point_mode=1, point_name=...)`

Optional manual map-edit flow:

- create via `pointmanu_set(point_mode=1, ...)`

Constraints:

- should only be created in map-management/system-point flow
- must be shown as a system point

#### Initial point

Primary flow:

- create from current robot pose via `point_set(point_mode=2, point_name=...)`

Optional manual map-edit flow:

- create via `pointmanu_set(point_mode=2, ...)`

Constraints:

- should only be created in map-management/system-point flow
- must be shown as a system point

### 4. Charge Return Flow

`go charge` must be aligned to the app:

- publish `Int16(data=1)` to topic `autocharge`

This means:

- `TaskService::start_charge_return()` should no longer be implemented as `find charge point -> navigate_to_pose`
- if we keep a task-layer wrapper, that wrapper should trigger the robot's charge-return command and then update task state based on command acceptance and runtime status

Charge point data is still important, but the charge-return action itself belongs to the robot-side charging workflow, not to ordinary point navigation.

### 5. UI Semantics

The frontend must stop presenting all points as one flat concept.

Recommended UI split:

- system points
  - charge point
  - initial point
- business navigation points
  - feed points
  - future navigation roles

Map actions should become explicit:

- add feed point
- add charge point
- add initial point
- auto charge

Point management should show both:

- low-level kind
- business role

### 6. Task System Semantics

Feed tasks should consume:

- points where `low_level_kind = navigation`
- and `biz_role = feed`

The task system should not iterate over all navigation points blindly.

Charge return should be a separate task/state transition, not "navigate to a feed-like point named charge".

### 7. Data Migration

Existing stored points need migration.

Current approximate mapping:

- old `type = charge` -> `low_level_kind = charge`, `biz_role = ''`
- old `type = feed` -> `low_level_kind = navigation`, `biz_role = feed`

Initial points likely do not exist in the current web DB model and will need explicit support.

Migration must be backward-safe:

- preserve existing rows
- backfill new columns
- keep old data readable during rollout if temporary compatibility is required

### 8. Adapter Responsibilities

`IRobotAdapter` and rosbridge/native implementations should expose dedicated operations for:

- create current point by low-level kind
- optionally create manual point by low-level kind and pose
- trigger auto charge

They should not encode business terms like "feed point".

### 9. Error Handling

The frontend must not fake success for current-point creation failures.

If point creation fails:

- display the backend error
- do not synthesize a mock point
- do not refresh UI as if creation succeeded

If auto charge fails:

- show the immediate command failure
- keep system/task state unchanged unless the backend confirms state transition

## Proposed Architecture Changes

### Backend model

- extend `PointRecord` with explicit system kind and business role
- update repository schema and CRUD serialization

### Backend services

- `PointService`
  - create navigation/feed/system points through explicit kind-based entry points
- `TaskService`
  - consume feed-role navigation points for task runs
  - trigger `autocharge` for charge return instead of ordinary navigation

### Adapter layer

- keep low-level semantics only
- add explicit `go_charge()` operation
- route current-point creation through `point_set` semantics by kind

### Frontend

- separate point creation buttons and labels by system meaning
- display feed points as business-tagged navigation points
- remove any fake-success fallback for point creation

## Testing Strategy

Tests must cover:

- low-level point kind mapping to robot `point_mode`
- feed-point creation path using navigation-point semantics
- charge-point creation path using charge semantics
- initial-point creation path using initial semantics
- task selection only consuming navigation points marked as feed
- go-charge publishing `autocharge`
- frontend showing failure instead of fake point creation success
- migration of existing `feed` and `charge` rows

## Non-Goals

- redesigning the full map editor UI in this pass
- implementing all APK map-editing features such as highway, virtual wall, clean area
- changing the manual joystick control flow already fixed in previous work

## Recommendation

Implement the refactor in this order:

1. point data model split: low-level kind + business role
2. adapter support for kind-based current-point creation and `autocharge`
3. backend service/task flow migration
4. frontend UI semantics update
5. compatibility migration and cleanup
