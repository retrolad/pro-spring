application {
    mainClass.set("com.retrolad.ch03.annotation.HelloWorldSpringAnnotated")
}

dependencies {
    implementation(project(":chapter02"))
}

tasks.jar {
    manifest {
        attributes(
                "Implementation-Title" to "Pro Spring 5",
                "Implementation-Version" to archiveVersion,
                "Main-Class" to "com.retrolad.ch03.App"
        )
    }
}
