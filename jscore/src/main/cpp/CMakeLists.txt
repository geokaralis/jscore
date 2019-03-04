cmake_minimum_required(VERSION 3.4.1)

file(GLOB_RECURSE jscore_src
        *.h
        *.c
        *.cpp)

add_library( # Sets the name of the library.
        jscore-lib

        # Sets the library as a shared library.
        SHARED

        # Provides a relative path to your source file(s).
        ${jscore_src})

include_directories( ${CMAKE_SOURCE_DIR} )

# Include v8 library into the project
add_library(# Sets the name of the library
        libv8

        # Sets the library as a static library
        STATIC

        IMPORTED)

set_target_properties(
        libv8

        PROPERTIES

        IMPORTED_LOCATION ${CMAKE_SOURCE_DIR}/libs/v8/${ANDROID_ABI}/libv8.a

        INTERFACE_INCLUDE_DIRECTORIES ${CMAKE_SOURCE_DIR}/libs/v8/${ANDROID_ABI}/include)

find_library( # Sets the name of the path variable.
        log-lib

        # Specifies the name of the NDK library that
        # you want CMake to locate.
        log)

find_library( # Sets the name of the path variable.
        android-lib

        # Specifies the name of the NDK library that
        # you want CMake to locate.
        android )

target_link_libraries( # Specifies the target library.
        jscore-lib

        libv8

        # Links the target library to the log library
        # included in the NDK.
        ${log-lib}

        ${android-lib})


