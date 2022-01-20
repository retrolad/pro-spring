application {
    mainClass.set("com.retrolad.ch05.SimpleAfterReturningAdvice")
}

dependencies {
    implementation(project(":chapter02"))
    implementation(project(":chapter05:simple-before-advice"))
}