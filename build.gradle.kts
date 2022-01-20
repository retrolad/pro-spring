buildscript {
    extra.apply {
        // spring libs
//        set("springVersion", "5.3.14")
        set("javaxAnnotationVersion", "1.3.2")

        val springVersion = "5.3.14"
        val aspectjVersion = "1.9.7"

        set("spring", mapOf(
            "context" to "org.springframework:spring-context:$springVersion",
            "aop" to "org.springframework:spring-aop:$springVersion"
        ))

        set("misc", mapOf(
            "aspectjweaver" to "org.aspectj:aspectjweaver:$aspectjVersion",
            "aspectjrt" to "org.aspectj:aspectjrt:$aspectjVersion",
        ))
    }
}

allprojects {

    repositories {
        // Use Maven Central for resolving dependencies.
        mavenCentral()
    }
}