package com.example.board.domain.user.service;

import com.example.board.domain.user.controller.dto.request.SignUpRequest;
import com.example.board.domain.user.domain.User;
import com.example.board.domain.user.domain.repository.UserRepository;
import com.example.board.domain.user.exception.UserAlreadyExitsException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UserSignUpService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Transactional
    public void execute(SignUpRequest request) {
        if (userRepository.findByAccountId(request.getAccountId()).isPresent()) {
            throw UserAlreadyExitsException.EXCEPTION;
        }

        User user = User.builder()
                .accountId(request.getAccountId())
                .password(passwordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
                .name(request.getName())
                .build();

        userRepository.save(user);
    }
}
