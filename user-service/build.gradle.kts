plugins {
    alias(libs.plugins.jetbrains.kotlin.jvm)
    alias(libs.plugins.jetbrains.kotlin.spring)
    alias(libs.plugins.jetbrains.kotlin.jpa)
    alias(libs.plugins.jetbrains.kotlin.kapt)
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.spring.dependency.management)
}

allOpen {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.MappedSuperclass")
    annotation("jakarta.persistence.Embeddable")
}

description = "Основное приложение для управления пользователями"

dependencies {
    implementation(libs.kotlin.reflect)
    implementation(libs.jackson.module.kotlin)

    testImplementation(libs.spring.boot.starter.test)

    implementation(libs.spring.boot.starter.data.jpa)
    implementation(libs.spring.boot.starter.web)

    runtimeOnly(libs.postgresql)
    implementation(libs.liquibase.core)

    api(project(":data"))

    implementation(libs.bw.commons.web.security.starter)

    implementation(libs.mapstruct)
    kapt(libs.mapstruct.processor)
}

kapt {
    arguments {
        arg("mapstruct.defaultComponentModel", "spring")
    }
}
