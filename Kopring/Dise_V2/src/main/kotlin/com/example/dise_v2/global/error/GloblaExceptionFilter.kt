package com.example.dise_v2.global.error

import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GloblaExceptionFilter {
    @ExceptionHandler(CustomException::class)
    fun customException(e: CustomException): ResponseEntity<ErrorResponse> {
        return ResponseEntity(
            ErrorResponse.of(e),
            HttpStatusCode.valueOf(e.status)
        )
    }
}