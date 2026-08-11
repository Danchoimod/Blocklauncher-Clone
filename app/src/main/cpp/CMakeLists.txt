cmake_minimum_required(VERSION 3.22.1)

project("mcpelauncher")

add_library(mcpelauncher SHARED
    controller_jni.cpp
    dobby.cpp
    fmod_filesystem.cpp
    kamcord_fixer.cpp
    marauders_map.c
    modscript.cpp
    modscript_cape.cpp
    modscript_nextgen.cpp
    modscript_renderer.cpp
    nativepatch.c
    prepatch.cpp
    signalhandler.cpp
    signalhandler_arm.cpp
    signalhandler_x86.cpp
    simpleuuid.c
    utf8proc_slim.c
)

target_include_directories(mcpelauncher PRIVATE
    ${CMAKE_CURRENT_SOURCE_DIR}
    ${CMAKE_CURRENT_SOURCE_DIR}/json
    ${CMAKE_CURRENT_SOURCE_DIR}/mcpe
)

find_library(log-lib log)
find_library(android-lib android)

target_link_libraries(mcpelauncher
    ${log-lib}
    ${android-lib}
    dl
)
