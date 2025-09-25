package ru.boardworld.user.controller.internal

import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*
import ru.boardworld.user.dto.request.CreateUserDto
import ru.boardworld.user.dto.response.ReadUserDto
import ru.boardworld.user.mapper.UserMapper
import ru.boardworld.user.service.UserService
import java.util.*

@RestController
@RequestMapping("\${bw.web.internal.user-base-url}")
class InUserController(
    val userService: UserService,
    val userMapper: UserMapper
) {

    @PostMapping("/create")
    fun create(@Valid @RequestBody createUserDto: CreateUserDto) : ReadUserDto =
        userMapper.toDto(userService.createUser(createUserDto))

    @GetMapping
    fun findById(@RequestParam id: UUID): ReadUserDto =
        userMapper.toDto(userService.findById(id))

}