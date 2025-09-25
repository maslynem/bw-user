package ru.boardworld.user.exception

import ru.boardworld.commons.rest.exception.exception.AbstractApiException
import ru.boardworld.user.exception.errorCode.UserErrorCode
import ru.boardworld.user.exception.errorCode.details.AlreadyExistsDetails

class EmailAlreadyExistsException(email: String) :
    AbstractApiException(UserErrorCode.EMAIL_ALREADY_EXISTS, AlreadyExistsDetails(email))
