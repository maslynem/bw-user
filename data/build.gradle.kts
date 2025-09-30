plugins {
    alias(libs.plugins.jetbrains.kotlin.jvm)
    alias(libs.plugins.jetbrains.kotlin.spring)
    alias(libs.plugins.spring.dependency.management)
    `java-library`
    `maven-publish`
}

dependencies {
    api(platform(libs.spring.boot.bom))
    api(libs.spring.boot.starter.validation)
}

java {
    withSourcesJar()
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
            groupId = project.group.toString()
            artifactId = "user-data" // можно назвать по-хорошему; по умолчанию будет project.name ("data")
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