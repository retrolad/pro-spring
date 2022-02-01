dependencies {

    val spring = rootProject.extra.get("spring") as Map<*,*>
    val misc = rootProject.extra.get("misc") as Map<*,*>

    implementation(spring["jms"] as String)
    implementation(misc["jms"] as String)
    implementation(misc["artemisClient"] as String)
    testImplementation(spring["test"] as String)
}
