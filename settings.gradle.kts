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
include("chapter04:environment")
include("chapter04:property-placeholder")

include("chapter05:aop-hello-world")
include("chapter05:simple-before-advice")
include("chapter05:simple-after-returning-advice")
include("chapter05:static-pointcut")
include("chapter05:dynamic-pointcut")
include("chapter05:simple-name-matching")
include("chapter05:regex-pointcuts")
include("chapter05:aspectj-regex-pointcuts")
include("chapter05:annotation-pointcut")
include("chapter05:cflow-pointcuts")
include("chapter05:composable-pointcut")
include("chapter05:modification-introduction")
include("chapter05:proxyfactorybean")
include("chapter05:aop-namespace")
