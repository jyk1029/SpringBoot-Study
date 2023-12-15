package com.example.board.domain.user.exception;

import com.example.board.global.error.exception.CustomException;
import com.example.board.global.error.exception.ErrorCode;

public class UserAlreadyExitsException extends CustomException {
    public static final CustomException EXCEPTION = //Singleton Pattern(Design Pattern) : 객체의 인스턴스가 오직 1개만 생성되는 패턴
            new UserAlreadyExitsException();

    private UserAlreadyExitsException() {
        super(ErrorCode.ALREADY_USER_EIXTS); //super : 상속받은 부모 클래스의 변수명이나 클래스 변수를 참조하고, super() 는 부모 클래스 생성자를 호출
    }
}
