package ru.boardworld.user.controller.external

import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.boardworld.commons.web.security.model.user.AuthenticatedUser
import ru.boardworld.user.mapper.UserMapper
import ru.boardworld.user.service.UserService

@RestController
@RequestMapping("\${bw.web.external.user-base-url}")
class ExUserController(
    val userService: UserService,
    val userMapper: UserMapper
) {

    @GetMapping("/me")
    fun getCurrentUser(@AuthenticationPrincipal authenticatedUser: AuthenticatedUser) =
        userMapper.toDto(userService.findById(authenticatedUser.id))


    @GetMapping("check-username")
    fun isUsernameAvailable(@RequestParam("username") username: String) {
        userService.checkExistsByUsername(username)
    }

    @GetMapping("check-email")
    fun isEmailAvailable(@RequestParam("email") email: String) {
        userService.checkExistsByEmail(email)
    }
}