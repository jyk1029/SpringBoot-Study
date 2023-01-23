package com.example.dise_v2.domain.user.facade

import com.example.dise_v2.domain.user.domain.User
import com.example.dise_v2.domain.user.domain.repository.UserRepository
import com.example.dise_v2.domain.user.exception.AlreadyUserExistException
import com.example.dise_v2.domain.user.exception.PasswordMisMatshException
import com.example.dise_v2.domain.user.exception.UserNotFoundException
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class UserFacade(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {
    fun getCurrentUser(): User {
        val accountId: String = SecurityContextHolder.getContext().authentication.name

        return getByAccountId(accountId)
    }

    fun checkUserExist(accountId: String): Boolean {
        return userRepository.existsByAccountId(accountId)
    }

    fun checkPassword(user: User, passsword: String) {
        if (!passwordEncoder.matches(passsword, user.password)) {
            throw PasswordMisMatshException.EXCEPTION
        }
    }

    fun getByAccountId(accountId: String): User {
        return userRepository.findByAccountId(accountId) ?: throw UserNotFoundException.EXCEPTION
    }
}