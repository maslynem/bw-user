package ru.boardworld.user.api

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import ru.boardworld.user.dto.request.CreateUserDto
import ru.boardworld.user.dto.response.ReadUserDto

@FeignClient(name = "bw-user-api", url = "\${bw.web.user.url}")
interface UserServiceApi {
    @PostMapping("/internal/api/v1/user/create")
    fun create(@RequestBody createUserDto: CreateUserDto): ReadUserDto
}