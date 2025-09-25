package ru.boardworld.user.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "bw.web.user")
data class UserApiProperties(
    val url: String
)