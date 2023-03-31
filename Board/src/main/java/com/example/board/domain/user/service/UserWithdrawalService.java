package com.example.board.domain.user.service;

import com.example.board.domain.user.domain.User;
import com.example.board.domain.user.domain.repository.UserRepository;
import com.example.board.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserWithdrawalService {
    private final UserFacade userFacade;
    private final UserRepository userRepository;

    @Transactional
    public void execute() {
        User user = userFacade.getCurrentUser();
        userRepository.delete(user);
    }
}
