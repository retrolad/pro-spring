dependencies {
    val spring = rootProject.extra.get("spring") as Map<*, *>
    val db = rootProject.extra.get("db") as Map<*, *>
    val hibernate = rootProject.extra.get("hibernate") as Map<*, *>

    implementation(spring["data"] as String)
    implementation(db["postgresql"] as String)
    implementation(db["dbcp"] as String)
    implementation(hibernate["em"] as String)
}
