plugins {
    war
}

dependencies {
    val spring = rootProject.extra.get("spring") as Map<*,*>
    val web = rootProject.extra.get("web") as Map<*,*>
    val misc = rootProject.extra.get("misc") as Map<*,*>

    implementation(spring["webmvc"] as String)
    implementation(spring["oxm"] as String)
    implementation(web["servlet"] as String)
    implementation(web["httpclient"] as String)
    implementation(misc["jacksonDatabind"] as String)
    implementation(misc["castor"] as String)
    implementation(project(":chapter12:base-remote"))
    testImplementation(spring["test"] as String)
}
