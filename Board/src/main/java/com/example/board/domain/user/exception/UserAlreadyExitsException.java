package com.example.board.domain.user.exception;

import com.example.board.global.error.exception.CustomException;
import com.example.board.global.error.exception.ErrorCode;

public class UserAlreadyExitsException extends CustomException {

    public static final CustomException EXCEPTION =
            new UserAlreadyExitsException();

    private UserAlreadyExitsException() {
        super(ErrorCode.ALREADY_USER_EIXTS);
    }
}
