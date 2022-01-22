dependencies {
    implementation(project(":chapter02"))
    implementation(project(":chapter05:proxyfactorybean"))
}

application {
    mainClass.set("com.retrolad.ch05.AopNamespaceDemo")
}