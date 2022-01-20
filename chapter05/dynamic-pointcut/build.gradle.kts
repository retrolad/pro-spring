application {
    mainClass.set("com.retrolad.ch05.DynamicPointcutDemo")
}

dependencies {
    implementation(project(":chapter05:static-pointcut"))
}