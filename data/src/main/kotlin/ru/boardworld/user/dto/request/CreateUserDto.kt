package ru.boardworld.user.dto.request

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class CreateUserDto(

    @field:NotBlank(message = "username обязателен")
    @field:Size(min = 3, max = 50, message = "username должен быть от 3 до 50 символов")
    val username: String,

    @field:NotBlank(message = "displayedName обязателен")
    @field:Size(min = 3, max = 50, message = "displayedName должен быть от 3 до 50 символов")
    val displayedName: String,


    @field:NotBlank(message = "Email обязателен")
    @field:Email(message = "Некорректный формат email")
    val email: String,

    @field:NotBlank(message = "password обязателен")
    @field:Size(min = 6, message = "password должен содержать минимум 6 символов")
    val password: String
    )