package ru.boardworld.user.exception.errorCode.details

import ru.boardworld.commons.rest.exception.model.ApiErrorDetails

data class AlreadyExistsDetails(
    val value: String
) : ApiErrorDetails()