# Runtime Flows

## Dashboard Refresh Flow

1. Browser loads `frontend/index.html`.
2. Frontend calls `/api/system/status` and subscribes to websocket updates.
3. Backend returns battery, pose, task summary, and connection diagnostics.
4. Browser renders map overlays, robot pose, and task summary cards.

## Manual Task Execution Flow

1. User presses the task start button.
2. Frontend posts to `/api/tasks/start`.
3. `TaskService` selects the first enabled feed point and opens a task run record.
4. Adapter receives a navigation target and backend marks the task as running.

## Low-Battery Return Flow

1. `BatteryWatcher` compares current battery level against the return threshold.
2. If the battery is below the threshold, the backend interrupts navigation.
3. `TaskService` marks the run as charging and persists remaining feed points.
4. Frontend and diagnostics page can display the charging state and saved context.

## Charge Recovery Flow

1. Charging completes and policy decides whether the task should resume.
2. If resume is enabled, `TaskService` reloads the remaining feed points from the task run record.
3. Backend issues navigation to the next remaining feed point.
4. If resume is disabled or no points remain, the system waits for a manual restart.

## Scheduled Task Flow

1. `TaskScheduler` polls enabled schedules.
2. A matching cron expression triggers `TaskService::start_scheduled_run`.
3. Backend records the trigger type as `schedule`.
4. Task execution then follows the same runtime path as a manual run.

## Connection Diagnostics Flow

1. `SystemService` reads adapter connection state on each status request.
2. Backend merges live health with last error message and reconnect attempts.
3. `/api/system/status` returns the diagnostics block.
4. `frontend/system.html` renders connection health and recent alerts for operators.
