cmake_minimum_required(VERSION 3.4.1)



add_library(libv8-base STATIC IMPORTED)
set_target_properties(libv8-base PROPERTIES IMPORTED_LOCATION ${PROJECT_SOURCE_DIR}/${ANDROID_ABI}/libv8_base.a)

add_library(libv8-external-snapshot STATIC IMPORTED)
set_target_properties(libv8-external-snapshot PROPERTIES IMPORTED_LOCATION ${PROJECT_SOURCE_DIR}/${ANDROID_ABI}/libv8_snapshot.a)


add_library( # Sets the name of the library.
        jscore-lib

        # Sets the library as a shared library.
        SHARED

        # Provides a relative path to your source file(s).
        jscore-lib.cpp)
target_include_directories( jscore-lib PRIVATE ${PROJECT_SOURCE_DIR}/include )

find_library( # Sets the name of the path variable.
        log-lib

        # Specifies the name of the NDK library that
        # you want CMake to locate.
        log)

target_link_libraries( # Specifies the target library.
        jscore-lib
        libv8-base
        libv8-external-snapshot

        # Links the target library to the log library
        # included in the NDK.
        ${log-lib})