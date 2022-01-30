plugins {
    id("org.springframework.boot") version "2.6.2"
}

dependencies {
    val boot = rootProject.extra.get("boot") as Map<*,*>
    val misc = rootProject.extra.get("misc") as Map<*,*>

    implementation(boot["starterJpa"] as String)
    implementation(boot["starterJta"] as String)
    implementation(boot["starterJms"] as String)
    implementation(misc["artemis"] as String) {
        exclude("org.apache.geronimo.specs", "geronimo-jms_2.0_spec");
    }
}