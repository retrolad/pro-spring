buildscript {
    extra.apply {
        // spring libs
//        set("springVersion", "5.3.14")
        set("javaxAnnotationVersion", "1.3.2")

        val springVersion = "5.3.14"

        set("spring", mapOf(
            "context" to "org.springframework:spring-context:$springVersion",
            "aop" to "org.springframework:spring-aop:$springVersion"
        ))
    }
}

allprojects {

    repositories {
        // Use Maven Central for resolving dependencies.
        mavenCentral()
    }
}