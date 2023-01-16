package com.example.dise_v2.domain.user.service

import com.example.dise_v2.domain.user.controller.dto.response.UserInfoResponse

import com.example.dise_v2.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class QueryUserInfoService(
    private val userFacade: UserFacade
) {
    @Transactional(readOnly = true)
    fun execute():UserInfoResponse {
        val user = userFacade.getCurrentUser()

        return UserInfoResponse(
            user.accountId,
            user.name
        )
    }
}