cmake_minimum_required(VERSION 3.4.1)

add_library( v8_base STATIC IMPORTED )
set_target_properties( v8_base PROPERTIES IMPORTED_LOCATION ${CMAKE_SOURCE_DIR}/libs/${ANDROID_ABI}/libv8_base.a )

add_library( v8_snap STATIC IMPORTED )
set_target_properties( v8_snap PROPERTIES IMPORTED_LOCATION ${CMAKE_SOURCE_DIR}/libs/${ANDROID_ABI}/libv8_snapshot.a )

add_library( jscore-lib SHARED src/main/cpp/jscore-lib.cpp )
target_include_directories( jscore-lib PRIVATE ${CMAKE_SOURCE_DIR}/libs/include )

target_link_libraries( jscore-lib v8_base v8_snap log )