package com.example.dise_v2.global.error

import org.springframework.http.HttpStatus

enum class ErrorCode(
    val status: Int,
    val message: String
) {
    USER_NOT_FOUND(404, "유저를 찾을 수 없습니다."),

    ALREADY_USER_EXIST(409, "이미 존재하는 유저입니다."),

    INTERNAL_SERVER_ERROR(500, "내부 서버 오류입니다.");
}