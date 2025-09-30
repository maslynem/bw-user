package ru.boardworld.user.dto.response.external

import java.util.*

data class ExReadUserDto(
    val id: UUID,
    val username: String,
    val displayedName: String,
)