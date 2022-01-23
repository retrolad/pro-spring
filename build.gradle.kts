buildscript {
    extra.apply {
        set("javaxAnnotationVersion", "1.3.2")

        // spring libs
        val springVersion = "5.3.14"

        val aspectjVersion = "1.9.7"
        val postgresqlVersion = "42.3.1"

        // testing libs
        val junitVersion = "4.13.2"

        // logging libs
        val slf4jVersion = "1.7.33"
        val logbackVersion = "1.2.10"



        set("spring", mapOf(
            "context" to "org.springframework:spring-context:$springVersion",
            "aop" to "org.springframework:spring-aop:$springVersion",
            "jdbc" to "org.springframework:spring-jdbc:$springVersion"
        ))

        set("testing", mapOf(
            "junit" to "junit:junit:$junitVersion"
        ))

        set("misc", mapOf(
            "aspectjweaver" to "org.aspectj:aspectjweaver:$aspectjVersion",
            "aspectjrt" to "org.aspectj:aspectjrt:$aspectjVersion",
            "lang3" to "org.apache.commons:commons-lang3:3.12.0",
            "logback" to "ch.qos.logback:logback-classic:$logbackVersion",
            "slf4j" to "org.slf4j:slf4j-api:$slf4jVersion"
        ))

        set("db", mapOf(
            "postgresql" to "org.postgresql:postgresql:$postgresqlVersion"
        ))
    }
}

allprojects {

    repositories {
        // Use Maven Central for resolving dependencies.
        mavenCentral()
    }
}
