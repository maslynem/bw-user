package ru.boardworld.user.controller.internal

import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*
import ru.boardworld.user.dto.request.CreateUserDto
import ru.boardworld.user.dto.response.internal.InReadUserDto
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
    fun create(@Valid @RequestBody createUserDto: CreateUserDto) : InReadUserDto =
        userMapper.toInDto(userService.createUser(createUserDto))

    @GetMapping(params = ["id"])
    fun findById(@RequestParam id: UUID): InReadUserDto =
        userMapper.toInDto(userService.findById(id))

    @GetMapping(params = ["username"])
    fun findByUsername(@RequestParam username: String): InReadUserDto =
        userMapper.toInDto(userService.findByUsername(username))

}