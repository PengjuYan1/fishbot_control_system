#include <iostream>
#include <chrono>
#include <string>

#include "backend/api/AlertController.h"
#include "backend/api/ControlController.h"
#include "backend/api/HealthController.h"
#include "backend/api/MapController.h"
#include "backend/api/PointController.h"
#include "backend/api/ScheduleController.h"
#include "backend/api/SystemController.h"
#include "backend/api/TaskController.h"
#include "backend/app/AppContext.h"
#include "backend/app/AppServer.h"
#include "backend/app/Config.h"
#include "backend/bootstrap.h"
#include "backend/runtime/StatusStreamService.h"
#include "backend/scheduler/BatteryWatcher.h"
#include "backend/scheduler/TaskScheduler.h"
#include "backend/services/AlertService.h"
#include "backend/services/MapService.h"
#include "backend/services/ManualControlService.h"
#include "backend/services/PointService.h"
#include "backend/services/ScheduleService.h"
#include "backend/services/SystemService.h"
#include "backend/services/TaskService.h"
#include "backend/websocket/StatusHub.h"
#include "storage/Database.h"
#include "storage/repositories/EventLogRepository.h"
#include "storage/repositories/PointRepository.h"
#include "storage/repositories/ScheduleRepository.h"
#include "storage/repositories/TaskRunRepository.h"

int main(int argc, char** argv) {
    const std::string config_path = argc > 1 ? argv[1] : "config/app.example.yaml";
    auto context = build_app_context(config_path);

    if (!start_app_with_config(config_path)) {
        std::cerr << "failed to bootstrap with config: " << config_path << '\n';
        return 1;
    }

    auto database = open_database(context.config.database_path);
    run_migrations(database);

    PointRepository point_repository(database);
    ScheduleRepository schedule_repository(database);
    TaskRunRepository task_run_repository(database);
    EventLogRepository event_log_repository(database);

    if (context.adapter != nullptr && !context.adapter->connect()) {
        context.logger.error("robot adapter connect failed; starting http server in degraded mode");
    }

    TaskService task_service(*context.adapter, point_repository, &task_run_repository);
    ManualControlService control_service(*context.adapter);
    SystemService system_service(*context.adapter, [&task_service]() {
        const auto task = task_service.current_task();
        return TaskSummary{task.status, task.current_target_name};
    }, [&control_service]() {
        return control_service.get_state();
    });
    MapService map_service(*context.adapter, &point_repository);
    PointService point_service(point_repository, *context.adapter);
    ScheduleService schedule_service(schedule_repository);
    AlertService alert_service(event_log_repository);
    TaskScheduler task_scheduler(schedule_repository, task_service);
    BatteryWatcher battery_watcher(context.config.battery_return_threshold);
    StatusHub status_hub;
    StatusStreamService status_stream_service(system_service, map_service, status_hub);

    AppServer server;
    server.set_static_root(context.config.static_root);
    register_health_routes(server, context.config);
    register_control_routes(server, control_service);
    register_system_routes(server, system_service);
    register_map_routes(server, map_service);
    register_point_routes(server, point_service);
    register_task_routes(server, task_service);
    register_schedule_routes(server, schedule_service);
    register_alert_routes(server, alert_service);
    server.register_websocket("/ws/status", [&status_stream_service, &status_hub](AppServer::WebsocketSend send) {
        const auto subscription_id = status_hub.subscribe(std::move(send));
        return AppServer::WebsocketSession{
            status_stream_service.connect_client(),
            [&status_hub, subscription_id]() { status_hub.unsubscribe(subscription_id); },
        };
    });

    status_stream_service.start(std::chrono::milliseconds(100));
    (void) task_scheduler;
    (void) battery_watcher;

    if (!server.start(static_cast<unsigned short>(context.config.listen_port))) {
        std::cerr << "failed to start http server on port " << context.config.listen_port << '\n';
        return 1;
    }

    std::cout << "fishbot app running on http://" << context.config.listen_host
              << ":" << context.config.listen_port
              << " (" << context.config.adapter_mode << ")\n";
    server.wait();
    status_stream_service.stop();
    return 0;
}
