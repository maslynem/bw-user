package ru.boardworld.user.mapper

import org.mapstruct.Mapper
import org.mapstruct.MappingConstants
import org.mapstruct.ReportingPolicy
import ru.boardworld.user.dto.response.external.ExReadUserDto
import ru.boardworld.user.dto.response.internal.InReadUserDto
import ru.boardworld.user.entity.Role
import ru.boardworld.user.entity.User

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface UserMapper {
    fun toInDto(user: User): InReadUserDto

    fun toExDto(user: User): ExReadUserDto

    fun map(role: Role): String {
        return role.name!!
    }
}