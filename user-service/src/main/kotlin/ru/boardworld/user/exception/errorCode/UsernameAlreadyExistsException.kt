package ru.boardworld.user.exception.errorCode

import ru.boardworld.commons.rest.exception.exception.AbstractApiException
import ru.boardworld.user.exception.errorCode.details.AlreadyExistsDetails

class UsernameAlreadyExistsException(username: String) :
    AbstractApiException(UserErrorCode.USERNAME_ALREADY_EXISTS, AlreadyExistsDetails(username))
