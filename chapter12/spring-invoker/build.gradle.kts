plugins {
    war
}

dependencies {

    val spring = rootProject.extra.get("spring") as Map<*,*>
    val web = rootProject.extra.get("web") as Map<*,*>

    implementation(spring["webmvc"] as String)
    implementation(web["servlet"] as String)
    implementation(project(":chapter12:base-remote"))
    testImplementation(spring["test"] as String)
}