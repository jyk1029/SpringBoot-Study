package com.example.dise_v2.domain.user.service

import com.example.dise_v2.domain.user.controller.dto.request.UpdatePasswordRequest
import com.example.dise_v2.domain.user.domain.User
import com.example.dise_v2.domain.user.facade.UserFacade
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UpdatePasswordService(
    private val userFacade: UserFacade,
    private val encoder: PasswordEncoder
) {
    @Transactional
    fun execute(request: UpdatePasswordRequest) {
        var user: User = userFacade.getCurrentUser()
        userFacade.checkPassword(user, request.password)

        user.updatePassword(encoder.encode(request.newPassword))
    }
}