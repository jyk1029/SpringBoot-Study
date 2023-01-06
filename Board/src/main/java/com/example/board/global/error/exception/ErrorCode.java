package com.example.board.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    EXPIRED_TOKEN(401, "Expired Token"),
    INVALID_TOKEN(401, "Invalid Token"),
    PASSWORD_MISMATCHED(401, "Password Mismatched"),

    USER_NOT_FOUND(404, "User Not Found"),
    REFRESH_TOKEN_NOT_FOUND(404, " Refresh Token Not Found"),

    ALREADY_USER_EIXTS(409, "Already User Exits"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error");

    private final int status;
    private final String message;
}
