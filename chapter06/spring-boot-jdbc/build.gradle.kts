plugins {
    id("org.springframework.boot") version "2.6.2"
}

dependencies {
    val boot = rootProject.extra.get("boot") as Map<*, *>

    implementation(boot["starterJdbc"] as String)
    implementation(project(":chapter06:plain-jdbc"))
}

application {
    mainClass.set("com.retrolad.ch06.Application")
}