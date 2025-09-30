package ru.boardworld.user.dto.response.internal

import java.util.*

data class InReadUserDto(
    val id: UUID,
    val username: String,
    val displayedName: String,
    val passwordHash: String,
    val roles: Set<String>
)