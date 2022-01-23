plugins {
    application
}

subprojects {
    apply {
        plugin("application")
    }

    dependencies {
        val spring = rootProject.extra.get("spring") as Map<String, String>
        val misc = rootProject.extra.get("misc") as Map<String, String>
        val testing = rootProject.extra.get("testing") as Map<String, String>
        val db = rootProject.extra.get("db") as Map<String, String>

        implementation(spring.getValue("context"))
        implementation(spring.getValue("jdbc"))
        implementation(misc.getValue("lang3"))
        implementation(misc.getValue("logback"))
        implementation(misc.getValue("slf4j"))
        implementation(db.getValue("postgresql"))
        testImplementation(testing.getValue("junit"))
    }
}
