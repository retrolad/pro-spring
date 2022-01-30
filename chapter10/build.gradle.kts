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
        val hibernate = rootProject.extra.get("hibernate") as Map<*, *>

        implementation(spring["context-support"] as String)
        implementation(misc["lang3"] as String)
        implementation(misc["logback"] as String )
        implementation(misc["slf4j"] as String)
        implementation(misc["joda"] as String)
        implementation(misc["validation"] as String)
        implementation(misc["javaxAnnotation"] as String)
        implementation(hibernate["em"] as String)
        implementation(hibernate["validator"] as String)
        testImplementation(testing["junit"] as String)
    }
}