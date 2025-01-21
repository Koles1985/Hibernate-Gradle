plugins {
    id("java")
}

group = "com.prapor"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    // https://mvnrepository.com/artifact/org.hibernate.common/hibernate-commons-annotations
    implementation("org.hibernate.common:hibernate-commons-annotations:5.1.2.Final")
    // https://mvnrepository.com/artifact/org.hibernate.orm/hibernate-core
    implementation("org.hibernate.orm:hibernate-core:6.5.2.Final")
    // https://mvnrepository.com/artifact/com.mysql/mysql-connector-j
    implementation("com.mysql:mysql-connector-j:8.3.0")
    // https://mvnrepository.com/artifact/org.springframework/spring-context
    implementation("org.springframework:spring-context:6.2.0")
    // https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    // https://mvnrepository.com/artifact/javax.annotation/javax.annotation-api
    implementation("javax.annotation:javax.annotation-api:1.3.2")
    // https://mvnrepository.com/artifact/javax.xml.bind/jaxb-api
    implementation("javax.xml.bind:jaxb-api:2.3.1")
    // https://mvnrepository.com/artifact/com.sun.xml.bind/jaxb-core
    implementation("com.sun.xml.bind:jaxb-core:2.3.0.1")
    // https://mvnrepository.com/artifact/com.sun.xml.bind/jaxb-impl
    implementation("com.sun.xml.bind:jaxb-impl:4.0.5")
    // https://mvnrepository.com/artifact/org.javassist/javassist
    implementation("org.javassist:javassist:3.28.0-GA")





}

tasks.test {
    useJUnitPlatform()
}