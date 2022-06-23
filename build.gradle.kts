plugins {
    `java-library`
    id("com.github.johnrengelman.shadow") version "7.1.2"
    id ("io.freefair.lombok") version "6.5.0.2"
}

group = "dev.emortal"
version = "1.0"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {
    compileOnly("com.github.Minestom:Minestom:024ba736ce") // Improve tasks performance commit
    implementation("net.kyori:adventure-text-minimessage:4.10.1")
    implementation("com.google.guava:guava:31.1-jre")
    implementation("com.typesafe:config:1.4.2")

    testImplementation("com.github.Minestom:Minestom:024ba736ce")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}