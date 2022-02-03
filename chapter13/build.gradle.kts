plugins {
    application
}

subprojects {
    apply {
        plugin("application")
    }

    dependencies {
        val spring = rootProject.extra.get("spring") as Map<*, *>
        val misc = rootProject.extra.get("misc") as Map<*, *>
        val testing = rootProject.extra.get("testing") as Map<*, *>
        val db = rootProject.extra.get("db") as Map<*, *>
        val hibernate = rootProject.extra.get("hibernate") as Map<*, *>

        if(!project.name.contains("junit5")) {
            implementation(spring["context"] as String)
            implementation(spring["webmvc"] as String)
            implementation(spring["test"] as String)
            implementation(misc["slf4j"] as String)
            implementation(misc["logback"] as String)
            implementation(misc["lang3"] as String)
            implementation(misc["guava"] as String)
            implementation(misc["javaxAnnotation"] as String)
            testImplementation(testing["mockito"] as String)
            testImplementation(testing["junit"] as String)
            testImplementation(testing["dbunit"] as String)
        }
    }
}