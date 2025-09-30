package ru.boardworld.user.api

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import ru.boardworld.commons.rest.openfeign.InternalFeignConfiguration
import ru.boardworld.user.dto.request.CreateUserDto
import ru.boardworld.user.dto.response.internal.InReadUserDto
import java.util.*

@FeignClient(name = "bw-user-api",
    url = "\${bw.web.user.url}",
    configuration = [InternalFeignConfiguration::class]
    )
interface UserServiceApi {
    @PostMapping("/internal/api/v1/user/create")
    fun create(@RequestBody createUserDto: CreateUserDto): InReadUserDto

    @GetMapping("/internal/api/v1/user")
    fun findById(@RequestParam id: UUID) : InReadUserDto

    @GetMapping("/internal/api/v1/user")
    fun findByUsername(@RequestParam username: String) : InReadUserDto
}