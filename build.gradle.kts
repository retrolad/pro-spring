buildscript {
    extra.apply {
        set("javaxAnnotationVersion", "1.3.2")

        // spring libs
        val springVersion = "5.3.14"
        val bootVersion by extra {"2.6.2"}

        val aspectjVersion = "1.9.7"
        val javaxAnnotationVersion = "1.3.2"

        // db libs
        val derbyVersion = "10.15.2.0"
        val dbcpVersion = "2.8.0"
        val h2Version = "2.1.210"
        val postgresqlVersion = "42.3.1"

        // persistence
        val hibernateVersion = "5.6.3.Final"
        val hibernateJpaVersion = "1.0.0.Beta2"

        // testing libs
        val junitVersion = "4.13.2"

        // logging libs
        val slf4jVersion = "1.7.33"
        val logbackVersion = "1.2.10"



        set("spring", mapOf(
            "context" to "org.springframework:spring-context:$springVersion",
            "aop" to "org.springframework:spring-aop:$springVersion",
            "jdbc" to "org.springframework:spring-jdbc:$springVersion",
            "orm" to "org.springframework:spring-orm:$springVersion",
        ))

        set("testing", mapOf(
            "junit" to "junit:junit:$junitVersion"
        ))

        set("misc", mapOf(
            "aspectjweaver" to "org.aspectj:aspectjweaver:$aspectjVersion",
            "aspectjrt" to "org.aspectj:aspectjrt:$aspectjVersion",
            "javaxAnnotation" to "javax.annotation:javax.annotation-api:$javaxAnnotationVersion",
            "lang3" to "org.apache.commons:commons-lang3:3.12.0",
            "logback" to "ch.qos.logback:logback-classic:$logbackVersion",
            "slf4j" to "org.slf4j:slf4j-api:$slf4jVersion"
        ))

        set("db", mapOf(
            "derby"         to "org.apache.derby:derby:$derbyVersion",
            "dbcp"          to "org.apache.commons:commons-dbcp2:$dbcpVersion",
            "h2"     to "com.h2database:h2:$h2Version",
            "postgresql"    to "org.postgresql:postgresql:$postgresqlVersion"
        ))

        set("boot", mapOf(
            "starterJdbc" to "org.springframework.boot:spring-boot-starter-jdbc:$bootVersion"
        ))

        set("hibernate", mapOf(
            "em" to "org.hibernate:hibernate-entitymanager:$hibernateVersion",
            "jpaApi" to "org.hibernate.javax.persistence:hibernate-jpa-2.2-api:$hibernateJpaVersion"
        ))
    }
}

allprojects {

    repositories {
        // Use Maven Central for resolving dependencies.
        mavenCentral()
    }
}
