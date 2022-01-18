buildscript {
    extra.apply {
        // spring libs
        set("springVersion", "5.3.14")
        set("javaxAnnotationVersion", "1.3.2")


//        val spring = mapOf(
//                "context" to "org.springframework:spring-context:$springVersion"
//        )
    }
}

allprojects {

    repositories {
        // Use Maven Central for resolving dependencies.
        mavenCentral()
    }
}