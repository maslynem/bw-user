import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(libs.plugins.jetbrains.kotlin.jvm) apply false
    alias(libs.plugins.jetbrains.kotlin.spring) apply false
    alias(libs.plugins.jetbrains.kotlin.jpa) apply false
    alias(libs.plugins.spring.boot) apply false
    alias(libs.plugins.spring.dependency.management) apply false
    alias(libs.plugins.jetbrains.kotlin.kapt) apply false
}

allprojects {
    group = "ru.boardworld.user"
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

