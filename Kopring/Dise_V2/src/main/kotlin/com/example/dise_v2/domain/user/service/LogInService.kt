package com.example.dise_v2.domain.user.service

import com.example.dise_v2.domain.user.controller.dto.request.LogInRequset
import com.example.dise_v2.domain.user.controller.dto.response.TokenResponse
import com.example.dise_v2.domain.user.exception.PasswordMisMatshException
import com.example.dise_v2.domain.user.facade.UserFacade
import com.example.dise_v2.global.security.jwt.JwtTokenProvider
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class LogInService(
    private val userFacade: UserFacade,
    private val passwordEncoder: PasswordEncoder,
    private val jwtTokenProvider: JwtTokenProvider
) {
    fun execute(request: LogInRequset) : TokenResponse {
        val user = userFacade.getUserCurrentUser(request.accountId)

        if(!passwordEncoder.matches(request.password, user.password)) {
            throw PasswordMisMatshException.EXCEPTION
        }
        return jwtTokenProvider.getToken(request.accountId)
    }
}