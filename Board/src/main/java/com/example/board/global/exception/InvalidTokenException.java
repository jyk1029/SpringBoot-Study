package com.example.board.global.exception;

import com.example.board.global.error.exception.CustomException;
import com.example.board.global.error.exception.ErrorCode;

public class InvalidTokenException extends CustomException {

    public static final CustomException EXCEPTION =
            new InvalidTokenException();

    private InvalidTokenException() {
        super(ErrorCode.INVALID_TOKEN);
    }
}
