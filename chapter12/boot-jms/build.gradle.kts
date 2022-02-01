dependencies {
    val boot = rootProject.extra.get("boot") as Map<*,*>
    val misc = rootProject.extra.get("misc") as Map<*,*>

    implementation(boot["starterJms"] as String)
    implementation(misc["artemisServer"] as String)
}
