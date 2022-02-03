dependencies {
    val spring = rootProject.extra.get("spring") as Map<*, *>
    val misc = rootProject.extra.get("misc") as Map<*, *>
    val testing = rootProject.extra.get("testing") as Map<*, *>
    val db = rootProject.extra.get("db") as Map<*, *>
    val hibernate = rootProject.extra.get("hibernate") as Map<*, *>

    implementation(testing["jmock"] as String)
    implementation(project(":chapter13:base-test"))
}