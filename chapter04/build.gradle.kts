plugins {
    application
}

subprojects {
    apply {
        plugin("application")
    }

    dependencies {
        val spring = rootProject.extra.get("spring") as? Map<String, String>
        val javaxAnnotationVersion = rootProject.extra.get("javaxAnnotationVersion")

        implementation(spring!!.getValue("context"))
        implementation("javax.annotation:javax.annotation-api:$javaxAnnotationVersion")
    }
}
