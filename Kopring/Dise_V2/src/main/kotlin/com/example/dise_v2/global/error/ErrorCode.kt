package com.example.dise_v2.global.error

import org.springframework.http.HttpStatus

enum class ErrorCode(
    val status: Int,
    val message: String
) {
    INTERNAL_SERVER_ERROR(500, "내부 서버 오류");
}