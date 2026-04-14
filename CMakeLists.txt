cmake_minimum_required(VERSION 3.16)
project(fishbot_control_system LANGUAGES CXX)

set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)
set(CMAKE_CXX_EXTENSIONS OFF)

enable_testing()

find_package(SQLite3 REQUIRED)
find_package(Threads REQUIRED)

add_library(fishbot_bootstrap
    backend/bootstrap.cpp
    backend/app/AppContext.cpp
    backend/app/Config.cpp
    backend/app/Logger.cpp
)
target_include_directories(fishbot_bootstrap PUBLIC ${CMAKE_CURRENT_SOURCE_DIR})
target_link_libraries(fishbot_bootstrap PUBLIC fishbot_adapter)

add_library(fishbot_storage
    storage/Database.cpp
    storage/repositories/EventLogRepository.cpp
    storage/repositories/PointRepository.cpp
    storage/repositories/ScheduleRepository.cpp
    storage/repositories/TaskRunRepository.cpp
)
target_include_directories(fishbot_storage PUBLIC ${CMAKE_CURRENT_SOURCE_DIR})
target_link_libraries(fishbot_storage PUBLIC SQLite::SQLite3)

add_library(fishbot_adapter
    ros_adapter/IRobotAdapter.cpp
    ros_adapter/bridge_client/RosbridgeAdapter.cpp
    ros_adapter/bridge_client/RosbridgeWebsocketTransport.cpp
    ros_adapter/native_ros/NativeRosAdapter.cpp
)
target_include_directories(fishbot_adapter PUBLIC ${CMAKE_CURRENT_SOURCE_DIR})
target_link_libraries(fishbot_adapter PUBLIC Threads::Threads)

add_library(fishbot_backend
    backend/app/AppServer.cpp
    backend/api/ControlController.cpp
    backend/api/HealthController.cpp
    backend/services/ManualControlService.cpp
    backend/services/SystemService.cpp
    backend/api/SystemController.cpp
    backend/services/MapService.cpp
    backend/api/MapController.cpp
    backend/services/PointService.cpp
    backend/api/PointController.cpp
    backend/services/AlertService.cpp
    backend/api/AlertController.cpp
    backend/services/TaskService.cpp
    backend/api/TaskController.cpp
    backend/services/ScheduleService.cpp
    backend/api/ScheduleController.cpp
    backend/scheduler/BatteryWatcher.cpp
    backend/scheduler/TaskScheduler.cpp
    backend/runtime/StatusStreamService.cpp
    backend/state_machine/TaskStateMachine.cpp
    backend/websocket/StatusHub.cpp
)
target_include_directories(fishbot_backend PUBLIC ${CMAKE_CURRENT_SOURCE_DIR})
target_link_libraries(fishbot_backend PUBLIC fishbot_bootstrap fishbot_adapter fishbot_storage)

add_executable(fishbot_app
    backend/main.cpp
)
target_link_libraries(fishbot_app PRIVATE fishbot_bootstrap fishbot_backend)

add_executable(fishbot_rosbridge_probe
    tools/rosbridge_probe.cpp
)
target_link_libraries(fishbot_rosbridge_probe PRIVATE fishbot_adapter fishbot_bootstrap Threads::Threads)

add_executable(test_bootstrap
    tests/integration/test_bootstrap.cpp
)
target_link_libraries(test_bootstrap PRIVATE fishbot_bootstrap)

add_test(NAME BootstrapTest COMMAND test_bootstrap)
set_tests_properties(BootstrapTest PROPERTIES WORKING_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR})

add_executable(test_app_context
    tests/integration/test_app_context.cpp
)
target_link_libraries(test_app_context PRIVATE fishbot_bootstrap Threads::Threads)

add_test(NAME AppContextTest COMMAND test_app_context)
set_tests_properties(AppContextTest PROPERTIES WORKING_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR})

add_executable(test_config
    tests/unit/app/test_config.cpp
)
target_link_libraries(test_config PRIVATE fishbot_bootstrap)

add_test(NAME ConfigTest COMMAND test_config)
set_tests_properties(ConfigTest PROPERTIES WORKING_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR})

add_executable(test_migrations
    tests/integration/storage/test_migrations.cpp
)
target_link_libraries(test_migrations PRIVATE fishbot_storage)

add_test(NAME MigrationTest COMMAND test_migrations)
set_tests_properties(MigrationTest PROPERTIES WORKING_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR})

add_executable(test_interface_contract
    tests/unit/ros_adapter/test_interface_contract.cpp
)
target_link_libraries(test_interface_contract PRIVATE fishbot_adapter)

add_test(NAME AdapterContractTest COMMAND test_interface_contract)
set_tests_properties(AdapterContractTest PROPERTIES WORKING_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR})

add_executable(test_rosbridge_adapter
    tests/unit/ros_adapter/test_rosbridge_adapter.cpp
)
target_link_libraries(test_rosbridge_adapter PRIVATE fishbot_adapter)

add_test(NAME RosbridgeAdapterTest COMMAND test_rosbridge_adapter)
set_tests_properties(RosbridgeAdapterTest PROPERTIES WORKING_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR})

add_executable(test_native_adapter
    tests/unit/ros_adapter/test_native_adapter.cpp
)
target_link_libraries(test_native_adapter PRIVATE fishbot_adapter)

add_test(NAME NativeAdapterTest COMMAND test_native_adapter)
set_tests_properties(NativeAdapterTest PROPERTIES WORKING_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR})

add_executable(test_rosbridge_websocket_transport
    tests/unit/ros_adapter/test_rosbridge_websocket_transport.cpp
)
target_link_libraries(test_rosbridge_websocket_transport PRIVATE fishbot_adapter Threads::Threads)

add_test(NAME RosbridgeWebsocketTransportTest COMMAND test_rosbridge_websocket_transport)
set_tests_properties(RosbridgeWebsocketTransportTest PROPERTIES WORKING_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR})

add_executable(test_rosbridge_probe
    tests/integration/ros_adapter/test_rosbridge_probe.cpp
)
target_link_libraries(test_rosbridge_probe PRIVATE Threads::Threads)

add_test(NAME RosbridgeProbeTest COMMAND test_rosbridge_probe)
set_tests_properties(RosbridgeProbeTest PROPERTIES WORKING_DIRECTORY ${CMAKE_CURRENT_BINARY_DIR})

add_executable(test_health_endpoint
    tests/integration/api/test_health_endpoint.cpp
)
target_link_libraries(test_health_endpoint PRIVATE fishbot_backend)

add_test(NAME HealthEndpointTest COMMAND test_health_endpoint)
set_tests_properties(HealthEndpointTest PROPERTIES WORKING_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR})

add_executable(test_system_status
    tests/integration/api/test_system_status.cpp
)
target_link_libraries(test_system_status PRIVATE fishbot_backend)

add_test(NAME SystemStatusTest COMMAND test_system_status)
set_tests_properties(SystemStatusTest PROPERTIES WORKING_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR})

add_executable(test_system_status_trace
    tests/integration/api/test_system_status_trace.cpp
)
target_link_libraries(test_system_status_trace PRIVATE fishbot_backend)

add_test(NAME SystemStatusTraceTest COMMAND test_system_status_trace)
set_tests_properties(SystemStatusTraceTest PROPERTIES WORKING_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR})

add_executable(test_manual_control_api
    tests/integration/api/test_manual_control_api.cpp
)
target_link_libraries(test_manual_control_api PRIVATE fishbot_backend)

add_test(NAME ManualControlApiTest COMMAND test_manual_control_api)
set_tests_properties(ManualControlApiTest PROPERTIES WORKING_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR})

add_executable(test_status_websocket
    tests/integration/api/test_status_websocket.cpp
)
target_link_libraries(test_status_websocket PRIVATE fishbot_backend)

add_test(NAME StatusWebSocketTest COMMAND test_status_websocket)
set_tests_properties(StatusWebSocketTest PROPERTIES WORKING_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR})

add_executable(test_status_websocket_runtime
    tests/integration/runtime/test_status_websocket_runtime.cpp
)
target_link_libraries(test_status_websocket_runtime PRIVATE fishbot_backend Threads::Threads)

add_test(NAME StatusWebSocketRuntimeTest COMMAND test_status_websocket_runtime)
set_tests_properties(StatusWebSocketRuntimeTest PROPERTIES WORKING_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR})

add_executable(test_status_stream_service
    tests/integration/runtime/test_status_stream_service.cpp
)
target_link_libraries(test_status_stream_service PRIVATE fishbot_backend)

add_test(NAME StatusStreamServiceTest COMMAND test_status_stream_service)
set_tests_properties(StatusStreamServiceTest PROPERTIES WORKING_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR})

add_executable(test_http_runtime_server
    tests/integration/runtime/test_http_runtime_server.cpp
)
target_link_libraries(test_http_runtime_server PRIVATE fishbot_backend Threads::Threads)

add_test(NAME HttpRuntimeServerTest COMMAND test_http_runtime_server)
set_tests_properties(HttpRuntimeServerTest PROPERTIES WORKING_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR})

add_executable(test_map_workflow
    tests/integration/api/test_map_workflow.cpp
)
target_link_libraries(test_map_workflow PRIVATE fishbot_backend)

add_test(NAME MapWorkflowTest COMMAND test_map_workflow)
set_tests_properties(MapWorkflowTest PROPERTIES WORKING_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR})

add_executable(test_points_api
    tests/integration/api/test_points_api.cpp
)
target_link_libraries(test_points_api PRIVATE fishbot_backend)

add_test(NAME PointsApiTest COMMAND test_points_api)
set_tests_properties(PointsApiTest PROPERTIES WORKING_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR})

add_executable(test_current_pose_points_api
    tests/integration/api/test_current_pose_points_api.cpp
)
target_link_libraries(test_current_pose_points_api PRIVATE fishbot_backend)

add_test(NAME CurrentPosePointsApiTest COMMAND test_current_pose_points_api)
set_tests_properties(CurrentPosePointsApiTest PROPERTIES WORKING_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR})

add_executable(test_delete_points_api
    tests/integration/api/test_delete_points_api.cpp
)
target_link_libraries(test_delete_points_api PRIVATE fishbot_backend)

add_test(NAME DeletePointsApiTest COMMAND test_delete_points_api)
set_tests_properties(DeletePointsApiTest PROPERTIES WORKING_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR})

add_executable(test_task_state_machine
    tests/unit/state_machine/test_task_state_machine.cpp
)
target_link_libraries(test_task_state_machine PRIVATE fishbot_backend)

add_test(NAME TaskStateMachineTest COMMAND test_task_state_machine)
set_tests_properties(TaskStateMachineTest PROPERTIES WORKING_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR})

add_executable(test_manual_task_flow
    tests/integration/api/test_manual_task_flow.cpp
)
target_link_libraries(test_manual_task_flow PRIVATE fishbot_backend)

add_test(NAME ManualTaskFlowTest COMMAND test_manual_task_flow)
set_tests_properties(ManualTaskFlowTest PROPERTIES WORKING_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR})

add_executable(test_schedule_trigger
    tests/integration/api/test_schedule_trigger.cpp
)
target_link_libraries(test_schedule_trigger PRIVATE fishbot_backend fishbot_storage)

add_test(NAME ScheduleTriggerTest COMMAND test_schedule_trigger)
set_tests_properties(ScheduleTriggerTest PROPERTIES WORKING_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR})

add_executable(test_battery_watcher
    tests/unit/scheduler/test_battery_watcher.cpp
)
target_link_libraries(test_battery_watcher PRIVATE fishbot_backend)

add_test(NAME BatteryWatcherTest COMMAND test_battery_watcher)
set_tests_properties(BatteryWatcherTest PROPERTIES WORKING_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR})

add_executable(test_charge_recovery
    tests/integration/api/test_charge_recovery.cpp
)
target_link_libraries(test_charge_recovery PRIVATE fishbot_backend fishbot_storage)

add_test(NAME ChargeRecoveryTest COMMAND test_charge_recovery)
set_tests_properties(ChargeRecoveryTest PROPERTIES WORKING_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR})

add_executable(test_alerts_api
    tests/integration/api/test_alerts_api.cpp
)
target_link_libraries(test_alerts_api PRIVATE fishbot_backend fishbot_storage)

add_test(NAME AlertsApiTest COMMAND test_alerts_api)
set_tests_properties(AlertsApiTest PROPERTIES WORKING_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR})

add_executable(test_connection_diagnostics
    tests/integration/api/test_connection_diagnostics.cpp
)
target_link_libraries(test_connection_diagnostics PRIVATE fishbot_backend)

add_test(NAME ConnectionDiagnosticsTest COMMAND test_connection_diagnostics)
set_tests_properties(ConnectionDiagnosticsTest PROPERTIES WORKING_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR})

add_executable(test_end_to_end_fake_adapter
    tests/integration/test_end_to_end_fake_adapter.cpp
)
target_link_libraries(test_end_to_end_fake_adapter PRIVATE fishbot_backend fishbot_storage fishbot_bootstrap)

add_test(NAME EndToEndFakeAdapterTest COMMAND test_end_to_end_fake_adapter)
set_tests_properties(EndToEndFakeAdapterTest PROPERTIES WORKING_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR})
