package com.example.dise_v2.domain.user.service

import com.example.dise_v2.domain.user.controller.dto.request.UpdateUserInfoRequest
import com.example.dise_v2.domain.user.domain.User
import com.example.dise_v2.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UpdateUserInfoService(
    private val userFacade: UserFacade
) {
    @Transactional
    fun execute(request: UpdateUserInfoRequest) {
        val user = userFacade.getCurrentUser()

        user.updateUserInfo(
            request.name
        )
    }
}