package com.scorp.easydone.exceptions

import com.scorp.easydone.enums.EasyDoneException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.time.LocalDateTime

@RestControllerAdvice
class CustomeExceptionHandler {

    @ExceptionHandler(EasyDoneException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleCustomException(ex: EasyDoneException): ResponseEntity<Any> {
        val customErrorResponse = CustomErrorResponse(
            timestamp = LocalDateTime.now(),
            status = HttpStatus.BAD_REQUEST.value(),
            error = "Bad Request",
            message = ex.message,
            errorCode = ex.errorCode
        )
        return ResponseEntity(customErrorResponse, HttpStatus.BAD_REQUEST)
    }
}