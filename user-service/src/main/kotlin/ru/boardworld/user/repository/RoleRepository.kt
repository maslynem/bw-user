package ru.boardworld.user.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.boardworld.user.entity.Role

interface RoleRepository: JpaRepository<Role, Int> {
    fun findByName(name: String): Role
}