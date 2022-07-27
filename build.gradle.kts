plugins {
    `kotlin-dsl`
    `maven-publish`
}

group = "ru.tim.demo.ci.gradle.plugin"
version = "1.0.0"

repositories {
    mavenCentral()
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}
