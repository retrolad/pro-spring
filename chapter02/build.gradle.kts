plugins {
    application
}

dependencies {
    implementation("org.springframework:spring-context:5.3.14")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")

    implementation("com.google.guava:guava:31.0.1-jre")
}

application {
    mainClass.set("com.retrolad.ch02.HelloWorldSpringDI")
}

tasks.jar {
    manifest {
        attributes(
            "Implementation-Title" to "Pro Spring 5",
            "Implementation-Version" to archiveVersion,
            "Main-Class" to "com.retrolad.ch02.annotated.HelloWorldSpringAnnotated"
        )
    }
}

tasks.register<Jar>("uberJar") {
    manifest {
        attributes(
                "Implementation-Title" to "Pro Spring 5",
                "Implementation-Version" to archiveVersion,
                "Main-Class" to "com.retrolad.ch02.HelloWorldSpringDI"
        )
    }

    archiveClassifier.set("uber")

    from(sourceSets.main.get().output)
    dependsOn(configurations.runtimeClasspath)
    from({
        configurations.runtimeClasspath.get().filter { it.name.endsWith("jar")}.map { zipTree(it) }
    })
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

