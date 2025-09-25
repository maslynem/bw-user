package ru.boardworld.user.exception.errorCode

import org.springframework.http.HttpStatus
import ru.boardworld.commons.rest.exception.model.ApiErrorDetails
import ru.boardworld.commons.rest.exception.model.ErrorCode
import ru.boardworld.user.exception.errorCode.details.AlreadyExistsDetails

enum class UserErrorCode(
    private val details: Class<out ApiErrorDetails?>,
    private val httpStatus: HttpStatus
) : ErrorCode {
    EMAIL_ALREADY_EXISTS(AlreadyExistsDetails::class.java, HttpStatus.BAD_REQUEST),
    USERNAME_ALREADY_EXISTS(AlreadyExistsDetails::class.java, HttpStatus.BAD_REQUEST);

    override fun getHttpStatus(): HttpStatus? {
        return httpStatus
    }

    override fun getDetailsClass(): Class<out ApiErrorDetails?>? {
        return details
    }

    override fun getCodeName(): String? = name
}
