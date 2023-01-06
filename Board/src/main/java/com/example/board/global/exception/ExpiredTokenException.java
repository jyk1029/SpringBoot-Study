package com.example.board.global.exception;

import com.example.board.global.error.exception.CustomException;
import com.example.board.global.error.exception.ErrorCode;

public class ExpiredTokenException extends CustomException {
    public static final CustomException EXCEPTION =
            new ExpiredTokenException();

    private ExpiredTokenException() {
        super(ErrorCode.EXPIRED_TOKEN);
    }
}
