plugins {
    kotlin("jvm") version "1.8.0"
    id("io.qameta.allure") version "2.11.2"
}

group = "ru.tinkoff.fintech"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.2"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("io.qameta.allure:allure-junit5:2.21.0")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(11)
}