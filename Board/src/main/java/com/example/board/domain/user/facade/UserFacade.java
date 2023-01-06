package com.example.board.domain.user.facade;

import com.example.board.domain.user.domain.User;
import com.example.board.domain.user.domain.repository.UserRepository;
import com.example.board.domain.auth.exception.PasswordMismatchedException;
import com.example.board.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserFacade {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User getCurrentUser() {
        String accountId = SecurityContextHolder.getContext().getAuthentication().getName();

        return userRepository.findByAccountId(accountId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    public void checkPassword(User user, String password) {
        if(!passwordEncoder.matches(password, user.getPassword())) {
            throw PasswordMismatchedException.EXCEPTION;
        }
    }

    public Boolean checkUserExist(String accountId) {
        return userRepository.existsByAccountId(accountId);
    }

    public Long getUserId() {
        return getCurrentUser().getId();
    }
}
