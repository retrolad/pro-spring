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

        if(!project.name.contains("boot")){
            implementation(spring["data"] as String)
            implementation(spring["context-support"] as String) {
                exclude("spring-context")
                exclude("spring-beans")
                exclude("spring-core")
            }
            implementation(misc["lang3"] as String)
            implementation(misc["logback"] as String )
            implementation(misc["slf4j"] as String)
            implementation(misc["guava"] as String)
            implementation(hibernate["em"] as String)
            implementation(hibernate["atomikos"] as String)
        }
        implementation(db["postgresql"] as String)
        testImplementation(testing["junit"] as String)
    }
}