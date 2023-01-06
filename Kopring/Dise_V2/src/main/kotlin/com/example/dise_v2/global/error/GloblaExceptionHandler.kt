package com.example.dise_v2.global.error

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GloblaExceptionHandler {
    @ExceptionHandler(CustomException::class)
    fun customException(e: CustomException): ResponseEntity<ErrorResponse> {
        return ResponseEntity(
            ErrorResponse.of(e),
            HttpStatus.valueOf(e.status)
        )
    }
}