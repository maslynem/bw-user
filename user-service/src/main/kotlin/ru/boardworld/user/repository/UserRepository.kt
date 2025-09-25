package ru.boardworld.user.repository

import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import ru.boardworld.user.entity.User
import java.util.*

interface UserRepository : JpaRepository<User, UUID> {
    fun existsByUsername(username: String): Boolean

    fun existsByEmail(email: String): Boolean

    @EntityGraph(attributePaths = ["roles"])
    fun findByUsername(username: String): User?
}