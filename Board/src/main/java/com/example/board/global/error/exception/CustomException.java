package com.example.board.global.error.exception;

import com.example.board.global.error.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CustomException extends RuntimeException {

    private ErrorCode errorCode;
}
