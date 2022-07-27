plugins {
    `kotlin-dsl`
    `maven-publish`
    `java-gradle-plugin`
}

group = "ru.tim.demo.ci.gradle.plugin"
version = "1.0.0"

repositories {
    mavenCentral()
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

gradlePlugin {
    plugins {
        create("simplePlugin") {
            id = group.toString()
            implementationClass = "ru.tim.demo.ci.gradle.VerifyPlugin"
        }
    }
}