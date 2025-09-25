package ru.boardworld.user.service

import org.springframework.stereotype.Service
import ru.boardworld.user.entity.Role
import ru.boardworld.user.entity.RoleEnum
import ru.boardworld.user.repository.RoleRepository

@Service
class RoleService(val roleRepository: RoleRepository) {

    fun findByName(roleEnum: RoleEnum) : Role {
        return roleRepository.findByName(roleEnum.name)
    }
}