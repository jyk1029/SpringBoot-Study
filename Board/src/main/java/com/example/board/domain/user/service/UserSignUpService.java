package com.example.board.domain.user.service;

import com.example.board.domain.user.controller.dto.request.SignUpRequest;
import com.example.board.domain.user.domain.User;
import com.example.board.domain.user.domain.repository.UserRepository;
import com.example.board.domain.user.exception.UserAlreadyExitsException;
import com.example.board.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UserSignUpService {

    private final PasswordEncoder passwordEncoder; //PasswordEncoder : 비밀번호를 암호화하는 역할(스프링 시큐리티의 인터페이스 객체)
    private final UserRepository userRepository;
    private final UserFacade userFacade;

    @Transactional //클래스나 메서드에 붙여줄 경우, 해당 범위 내 메서드가 트랜잭션(Rollback)이 되도록 보장
    public void execute(SignUpRequest request) {
        if (userFacade.checkUserExist(request.getAccountId())) { //Facade 패턴 적용
            throw UserAlreadyExitsException.EXCEPTION; //예외처리
        }

        User user = User.builder() //Builder Pattern(Design Pattern) : 복합 객체의 생성 과정과 표현 방법을 분리하여 동일한 생성 절차에서 서로 다른 표현 결과를 만들 수 있게 하는 패턴
                .accountId(request.getAccountId())
                .password(passwordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
                .name(request.getName())
                .build();

        userRepository.save(user); //UserRepository에 user 값 저장
    }
}
