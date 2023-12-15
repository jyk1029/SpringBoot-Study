package com.example.board.global.error;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE) //클래스에 존재하는 모든 필드에 대한 생성자를 자동으로 생성
@Builder //생성자를 호출할 수 있게 빌더 클래스를 생성
public class ErrorResponse {
    private final int status;
    private final String message;
}
