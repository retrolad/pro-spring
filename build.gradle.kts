buildscript {
    extra.apply {
        set("javaxAnnotationVersion", "1.3.2")

        // spring libs
        val springVersion = "5.3.14"
        val springDataVersion = "2.6.1"
        val bootVersion by extra {"2.6.2"}
        val springSecurityVersion = "5.5.1"

        val aspectjVersion = "1.9.7"
        val javaxAnnotationVersion = "1.3.2"
        val jmsVersion =  "2.0.1"
        val artemisVersion = "2.17.0"
        val httpclientVersion = "4.5.13"
        val castorVersion = "1.4.1"

        // db libs
        val derbyVersion = "10.15.2.0"
        val dbcpVersion = "2.8.0"
        val h2Version = "2.1.210"
        val postgresqlVersion = "42.3.1"

        // persistence
        val hibernateVersion = "5.6.3.Final"
        val hibernateJpaVersion = "1.0.0.Beta2"
        val atomikosVersion = "5.0.8"

        // testing libs
        val junitVersion = "4.13.2"

        // logging libs
        val slf4jVersion = "1.7.33"
        val logbackVersion = "1.2.10"

        val javaxValidationVersion = "2.0.1.Final"
        val guavaVersion = "31.0.1-jre"
        val jodaTimeVersion = "2.10.13"
        val hibernateValidatorVersion = "7.0.1.Final"
        val utVersion = "6.0.1.GA"

        set("spring", mapOf(
            "context" to "org.springframework:spring-context:$springVersion",
            "webmvc" to "org.springframework:spring-webmvc:$springVersion",
            "aop" to "org.springframework:spring-aop:$springVersion",
            "aspects" to "org.springframework:spring-aspects:$springVersion",
            "jdbc" to "org.springframework:spring-jdbc:$springVersion",
            "orm" to "org.springframework:spring-orm:$springVersion",
            "data" to "org.springframework.data:spring-data-jpa:$springDataVersion",
            "context-support" to "org.springframework:spring-context-support:$springVersion",
            "test" to "org.springframework:spring-test:$springVersion",
            "tx" to "org.springframework:spring-tx:$springVersion",
            "jms" to "org.springframework:spring-jms:$springVersion",
            "oxm" to "org.springframework:spring-oxm:$springVersion",
            "securityWeb" to "org.springframework.security:spring-security-web:$springSecurityVersion",
            "securityConfig" to "org.springframework.security:spring-security-config:$springSecurityVersion"
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
            "slf4j" to "org.slf4j:slf4j-api:$slf4jVersion",
            "guava" to "com.google.guava:guava:$guavaVersion",
            "artemis" to "org.apache.activemq:artemis-jms-server:2.17.0",
            "joda" to "joda-time:joda-time:$jodaTimeVersion",
            "validation" to "javax.validation:validation-api:$javaxValidationVersion",
            "usertype" to "org.jadira.usertype:usertype.core:$utVersion",
            "jacksonDatabind" to "com.fasterxml.jackson.core:jackson-databind:2.13.1",
            "hornetq" to "org.hornetq:hornetq-jms-client:2.4.8.Final",
            "artemisClient" to "org.apache.activemq:artemis-jms-client:$artemisVersion",
            "artemisServer" to "org.apache.activemq:artemis-jms-server:$artemisVersion",
            "jms" to "javax.jms:javax.jms-api:$jmsVersion",
            "castor" to "org.codehaus.castor:castor-xml:$castorVersion"
        ))

        set("db", mapOf(
            "derby"         to "org.apache.derby:derby:$derbyVersion",
            "dbcp"          to "org.apache.commons:commons-dbcp2:$dbcpVersion",
            "h2"     to "com.h2database:h2:$h2Version",
            "postgresql"    to "org.postgresql:postgresql:$postgresqlVersion"
        ))

        set("boot", mapOf(
            "starterJdbc" to "org.springframework.boot:spring-boot-starter-jdbc:$bootVersion",
            "starterJpa" to "org.springframework.boot:spring-boot-starter-data-jpa:$bootVersion",
            "starterJta" to "org.springframework.boot:spring-boot-starter-jta-atomikos:$bootVersion",
            "starterJms" to "org.springframework.boot:spring-boot-starter-artemis:$bootVersion"
        ))

        set("hibernate", mapOf(
            "em" to "org.hibernate:hibernate-entitymanager:$hibernateVersion",
            "jpaApi" to "org.hibernate.javax.persistence:hibernate-jpa-2.2-api:$hibernateJpaVersion",
            "jpaModelGen" to "org.hibernate:hibernate-jpamodelgen:$hibernateVersion",
            "envers" to "org.hibernate:hibernate-envers:$hibernateVersion",
            "atomikos" to "com.atomikos:transactions-hibernate4:$atomikosVersion",
            "validator" to "org.hibernate.validator:hibernate-validator:$hibernateValidatorVersion",
        ))

        set("web", mapOf(
            "servlet" to "javax:javaee-web-api:8.0.1",
            "httpclient" to "org.apache.httpcomponents:httpclient:$httpclientVersion"
        ))
    }
}

allprojects {

    repositories {
        // Use Maven Central for resolving dependencies.
        mavenCentral()
    }
}
