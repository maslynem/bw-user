package ru.boardworld.user.service

import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.boardworld.ru.boardworld.user.exception.UserNotFoundException
import ru.boardworld.user.dto.request.CreateUserDto
import ru.boardworld.user.entity.Role
import ru.boardworld.user.entity.RoleEnum
import ru.boardworld.user.entity.User
import ru.boardworld.user.exception.EmailAlreadyExistsException
import ru.boardworld.user.exception.errorCode.UsernameAlreadyExistsException
import ru.boardworld.user.repository.UserRepository
import java.time.OffsetDateTime
import java.util.*

@Service
class UserService(
    val userRepository: UserRepository,
    val roleService: RoleService,
    val passwordEncoder: PasswordEncoder
) {
    @Transactional
    fun createUser(dto: CreateUserDto) : User {
        checkExistsByUsername(dto.username)
        checkExistsByEmail(dto.email)
        val passwordHash: String = passwordEncoder.encode(dto.password)
        val userRole: Role = roleService.findByName(RoleEnum.USER)

        val user = User(
            displayedName = dto.displayedName,
            username = dto.username,
            email = dto.email,
            passwordHash = passwordHash,
            roles = mutableSetOf(userRole),
            lastLogin = OffsetDateTime.now())
        return userRepository.save(user)
    }

    @Transactional(readOnly = true)
    fun findById(id: UUID): User {
        return userRepository.findById(id).orElseThrow { UserNotFoundException(id) }!!
    }

    @Transactional(readOnly = true)
    fun checkExistsByUsername(username: String) {
        if (userRepository.existsByUsername(username)) {
            throw UsernameAlreadyExistsException(username)
        }
    }

    @Transactional(readOnly = true)
    fun checkExistsByEmail(email: String) {
        if (userRepository.existsByEmail(email)) {
            throw EmailAlreadyExistsException(email)
        }
    }

    @Transactional(readOnly = true)
    fun findByUsername(username: String): User =
        userRepository.findByUsername(username) ?: throw UserNotFoundException(username)
}