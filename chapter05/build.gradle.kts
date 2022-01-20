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

        implementation(spring.getValue("context"))
        implementation(misc.getValue("aspectjrt"))
        implementation(misc.getValue("aspectjweaver"))
    }
}
