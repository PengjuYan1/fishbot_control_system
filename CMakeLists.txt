cmake_minimum_required(VERSION 3.16)
project(fishbot_control_system LANGUAGES CXX)

set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)
set(CMAKE_CXX_EXTENSIONS OFF)

enable_testing()

find_package(SQLite3 REQUIRED)

add_library(fishbot_bootstrap
    backend/bootstrap.cpp
    backend/app/AppContext.cpp
    backend/app/Config.cpp
    backend/app/Logger.cpp
)
target_include_directories(fishbot_bootstrap PUBLIC ${CMAKE_CURRENT_SOURCE_DIR})

add_library(fishbot_storage
    storage/Database.cpp
    storage/repositories/PointRepository.cpp
    storage/repositories/ScheduleRepository.cpp
    storage/repositories/TaskRunRepository.cpp
)
target_include_directories(fishbot_storage PUBLIC ${CMAKE_CURRENT_SOURCE_DIR})
target_link_libraries(fishbot_storage PUBLIC SQLite::SQLite3)

add_library(fishbot_adapter
    ros_adapter/IRobotAdapter.cpp
    ros_adapter/bridge_client/RosbridgeAdapter.cpp
    ros_adapter/native_ros/NativeRosAdapter.cpp
)
target_include_directories(fishbot_adapter PUBLIC ${CMAKE_CURRENT_SOURCE_DIR})

add_library(fishbot_backend
    backend/app/AppServer.cpp
    backend/api/HealthController.cpp
    backend/services/SystemService.cpp
    backend/api/SystemController.cpp
    backend/services/MapService.cpp
    backend/api/MapController.cpp
    backend/services/PointService.cpp
    backend/api/PointController.cpp
    backend/services/TaskService.cpp
    backend/api/TaskController.cpp
    backend/services/ScheduleService.cpp
    backend/api/ScheduleController.cpp
    backend/scheduler/BatteryWatcher.cpp
    backend/scheduler/TaskScheduler.cpp
    backend/state_machine/TaskStateMachine.cpp
    backend/websocket/StatusHub.cpp
)
target_include_directories(fishbot_backend PUBLIC ${CMAKE_CURRENT_SOURCE_DIR})
target_link_libraries(fishbot_backend PUBLIC fishbot_bootstrap fishbot_adapter fishbot_storage)

add_executable(fishbot_app
    backend/main.cpp
)
target_link_libraries(fishbot_app PRIVATE fishbot_bootstrap fishbot_backend)

add_executable(test_bootstrap
    tests/integration/test_bootstrap.cpp
)
target_link_libraries(test_bootstrap PRIVATE fishbot_bootstrap)

add_test(NAME BootstrapTest COMMAND test_bootstrap)
set_tests_properties(BootstrapTest PROPERTIES WORKING_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR})

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

add_executable(test_status_websocket
    tests/integration/api/test_status_websocket.cpp
)
target_link_libraries(test_status_websocket PRIVATE fishbot_backend)

add_test(NAME StatusWebSocketTest COMMAND test_status_websocket)
set_tests_properties(StatusWebSocketTest PROPERTIES WORKING_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR})

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
