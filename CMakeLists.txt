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
)
target_include_directories(fishbot_storage PUBLIC ${CMAKE_CURRENT_SOURCE_DIR})
target_link_libraries(fishbot_storage PUBLIC SQLite::SQLite3)

add_executable(fishbot_app
    backend/main.cpp
)
target_link_libraries(fishbot_app PRIVATE fishbot_bootstrap)

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
