dependencies {
    implementation(project(":chapter02"))
    implementation(project(":chapter05:regex-pointcuts"))
    implementation(project(":chapter05:static-pointcut"))
}

application {
    mainClass.set("com.retrolad.ch05.AspectjexpPointcutDemo")
}