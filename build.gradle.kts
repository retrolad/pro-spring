buildscript {
    extra.apply {
        set("javaxAnnotationVersion", "1.3.2")

        // spring libs
        val springVersion = "5.3.14"

        val aspectjVersion = "1.9.7"

        // testing libs
        val junitVersion = "4.13.2"

        set("spring", mapOf(
            "context" to "org.springframework:spring-context:$springVersion",
            "aop" to "org.springframework:spring-aop:$springVersion"
        ))

        set("testing", mapOf(
            "junit" to "junit:junit:$junitVersion"
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