package com.example.board.domain.auth.exception;

import com.example.board.global.error.exception.CustomException;
import com.example.board.global.error.exception.ErrorCode;

public class PasswordMismatchedException extends CustomException {

    public static final CustomException EXCEPTION =
            new PasswordMismatchedException();

    private PasswordMismatchedException() {
        super(ErrorCode.PASSWORD_MISMATCHED);
    }
}
