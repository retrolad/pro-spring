plugins {
    application
}

subprojects {
    apply {
        plugin("application")
    }

    dependencies {
//        val springVersion = rootProject.extra.get("springVersion")
//        val javaxAnnotationVersion = rootProject.extra.get("javaxAnnotationVersion")
//
//        implementation("org.springframework:spring-context:$springVersion")
//        implementation("javax.annotation:javax.annotation-api:$javaxAnnotationVersion")
    }
}
