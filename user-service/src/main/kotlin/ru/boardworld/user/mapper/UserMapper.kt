package ru.boardworld.user.mapper

import org.mapstruct.Mapper
import org.mapstruct.MappingConstants
import org.mapstruct.ReportingPolicy
import ru.boardworld.user.dto.response.ReadUserDto
import ru.boardworld.user.entity.User

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface UserMapper {
    fun toDto(user: User): ReadUserDto
}