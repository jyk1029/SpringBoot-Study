package com.example.dise_v2.domain.user.service

import com.example.dise_v2.domain.user.controller.dto.request.UpdateUserInfoRequest
import com.example.dise_v2.domain.user.domain.User
import com.example.dise_v2.domain.user.facade.UserFacade
import org.springframework.stereotype.Service

@Service
class UpdateUserInfoService(
    private val userFacade: UserFacade
) {
    fun execute(request: UpdateUserInfoRequest) {
        val user:User = userFacade.getCurrentUser()

        user.updateUserInfo(
            request.name
        )
    }
}