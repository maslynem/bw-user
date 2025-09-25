package ru.boardworld.user.config

import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.cloud.openfeign.EnableFeignClients
import ru.boardworld.user.api.UserServiceApi

@AutoConfiguration
@EnableConfigurationProperties(UserApiProperties::class)
@EnableFeignClients(clients = [UserServiceApi::class])
class UserApiConfiguration {
}