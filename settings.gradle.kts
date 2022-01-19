/*
 * This file was generated by the Gradle 'init' task.
 *
 * The settings file is used to specify which projects to include in your build.
 *
 * Detailed information about configuring a multi-project build in Gradle can be found
 * in the user manual at https://docs.gradle.org/7.3.3/userguide/multi_project_builds.html
 */
rootProject.name = "pro-spring"
include("chapter02")

include("chapter03:bean-autowiring")
include("chapter03:collections")
include("chapter03:field-injection")
include("chapter03:injection")
include("chapter03:method-injection")
include("chapter03:nesting")
include("chapter03:setter-injection")
include("chapter03:simple-types")

include("chapter04:bean-init-method")
include("chapter04:initializing-bean")
include("chapter04:post-construct")
include("chapter04:factory-bean")
include("chapter04:bean-factory")
include("chapter04:message-source")
include("chapter04:events")
include("chapter04:resource")
