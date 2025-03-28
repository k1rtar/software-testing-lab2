plugins {
    kotlin("jvm") version "2.0.0"
}

group = "com.kirtar"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))

    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.11.1")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.11.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.11.2")
}

tasks.test {
    useJUnitPlatform()
}


kotlin {
    jvmToolchain(21)
}

