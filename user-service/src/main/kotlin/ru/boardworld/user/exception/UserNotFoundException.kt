package ru.boardworld.ru.boardworld.user.exception

import ru.boardworld.commons.rest.exception.exception.db.EntityNotFoundException
import java.util.*

class UserNotFoundException(val value: String) :
    EntityNotFoundException("User", value) {

    constructor(id: UUID) : this(id.toString())
}