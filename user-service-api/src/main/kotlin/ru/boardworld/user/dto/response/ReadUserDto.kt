package ru.boardworld.user.dto.response

import java.util.*

data class ReadUserDto(
    val id: UUID,
    val username: String,
    val displayedName: String,
    val roles: Set<String>
)
