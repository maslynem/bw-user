plugins {
    id("io.spring.dependency-management")
    id("java-library")
    id("maven-publish")
    kotlin("plugin.spring")
    kotlin("jvm")
}

description = "Библиотека bw-user API"

dependencyManagement {
    imports {
        mavenBom("org.springframework.boot:spring-boot-dependencies:3.4.0")
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:2023.0.1")
    }
}
dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.springframework.boot:spring-boot-starter")
    api("org.springframework.boot:spring-boot-starter-validation")
    api("org.springframework.cloud:spring-cloud-starter-openfeign")
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

