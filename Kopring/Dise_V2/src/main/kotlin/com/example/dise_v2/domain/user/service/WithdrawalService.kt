package com.example.dise_v2.domain.user.service

import com.example.dise_v2.domain.user.domain.User
import com.example.dise_v2.domain.user.domain.repository.UserRepository
import com.example.dise_v2.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class WithdrawalService(
    private val userFacade: UserFacade,
    private val userRepository: UserRepository
) {
    @Transactional
    fun execute() {
        var user: User = userFacade.getCurrentUser()

        userRepository.delete(user)
    }
}