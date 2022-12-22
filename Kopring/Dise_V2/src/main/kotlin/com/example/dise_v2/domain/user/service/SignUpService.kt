package com.example.dise_v2.domain.user.service

import com.example.dise_v2.domain.user.controller.dto.request.SignUpRequset
import com.example.dise_v2.domain.user.domain.User
import com.example.dise_v2.domain.user.domain.repository.UserRepository
import com.example.dise_v2.domain.user.exception.AlreadyUserExistException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class SignUpService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {
    fun execute(request: SignUpRequset) {
        if (userRepository.existsByAccountId(request.accountId)) {
            throw AlreadyUserExistException.EXCEPTION
        }

        userRepository.save(
            User(
                id = 0,
                accountId = request.accountId,
                password = passwordEncoder.encode(request.password),
                name = request.name
            )
        )
    }
}