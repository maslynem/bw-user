plugins {
    alias(libs.plugins.jetbrains.kotlin.jvm)
    alias(libs.plugins.jetbrains.kotlin.spring)
    alias(libs.plugins.spring.dependency.management)
    id("java-library")
    id("maven-publish")
}

description = "Библиотека bw-user API"

dependencies {
    implementation(platform(libs.spring.boot.bom))
    api(platform(libs.spring.cloud.bom))
    implementation(libs.kotlin.reflect)
    api(libs.spring.boot.starter)
    api(libs.spring.boot.starter.validation)
    api(libs.spring.boot.starter.openfeign)
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
            groupId = project.group.toString()
            artifactId = "user-service-api"
            version = project.version.toString()
        }
    }
    repositories {
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

