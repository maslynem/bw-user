import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.4.0" apply false
    id("io.spring.dependency-management") version "1.1.4" apply false
    kotlin("jvm") version "1.9.23" apply false
    kotlin("plugin.spring") version "1.9.23" apply false
    kotlin("plugin.jpa") version "1.9.23" apply false
}

allprojects {
    group = "com.boardworld"
    version = "0.0.1-SNAPSHOT"

    repositories {
        mavenCentral()
        mavenLocal()
        maven {
            name = "github"
            url = uri("https://maven.pkg.github.com/maslynem/BoardWorld")
            credentials {
                username = System.getenv("GITHUB_ACTOR") ?: project.findProperty("githubUsername") as? String ?: ""
                password = System.getenv("GITHUB_TOKEN") ?: project.findProperty("githubToken") as? String ?: ""
            }
        }
    }
}

subprojects {
    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs += "-Xjsr305=strict"
            jvmTarget = "17"
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

