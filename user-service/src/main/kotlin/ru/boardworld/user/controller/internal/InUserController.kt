package ru.boardworld.user.controller.internal

import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.boardworld.user.dto.request.CreateUserDto
import ru.boardworld.user.dto.response.ReadUserDto
import ru.boardworld.user.mapper.UserMapper
import ru.boardworld.user.service.UserService

@RestController
@RequestMapping("\${bw.web.internal.user-base-url}")
class InUserController(
    val userService: UserService,
    val userMapper: UserMapper
) {

    @PostMapping("/create")
    fun create(@Valid @RequestBody createUserDto: CreateUserDto) : ReadUserDto =
        userMapper.toDto(userService.createUser(createUserDto))

}