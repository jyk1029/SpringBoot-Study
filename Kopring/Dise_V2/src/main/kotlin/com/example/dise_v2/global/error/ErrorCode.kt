package com.example.dise_v2.global.error

import org.springframework.http.HttpStatus

enum class ErrorCode(
    val status: Int,
    val message: String
) {
    EXPIRED_JWT(401, "만료된 토큰입니다."),
    INVALID_JWT(401, "유효하지 않은 토큰입니다."),
    PASSWORD_MISMATCH(401, "비밀번호가 불일치합니다."),
    NOT_MODIFY_FEED(401, "게시글을 수정할 수 없습니다."),

    USER_NOT_FOUND(404, "유저를 찾을 수 없습니다."),
    FEED_NOT_FOUND(404, "게시물을 찾을 수 없습니다."),

    ALREADY_USER_EXIST(409, "이미 존재하는 유저입니다."),

    INTERNAL_SERVER_ERROR(500, "내부 서버 오류입니다.");
}