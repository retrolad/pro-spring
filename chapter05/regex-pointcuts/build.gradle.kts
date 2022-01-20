dependencies {
    implementation(project(":chapter05:static-pointcut"))
    implementation(project(":chapter02"))
}

application {
    mainClass.set("com.retrolad.ch05.RegexPointcutDemo")
}