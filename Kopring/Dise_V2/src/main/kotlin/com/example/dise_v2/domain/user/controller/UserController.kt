package com.example.dise_v2.domain.user.controller

import com.example.dise_v2.domain.user.controller.dto.request.LogInRequset
import com.example.dise_v2.domain.user.controller.dto.request.SignUpRequset
import com.example.dise_v2.domain.user.controller.dto.request.UpdateUserInfoRequest
import com.example.dise_v2.domain.user.controller.dto.response.TokenResponse
import com.example.dise_v2.domain.user.service.LogInService
import com.example.dise_v2.domain.user.service.SignUpService
import com.example.dise_v2.domain.user.service.UpdateUserInfoService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RequestMapping("/user")
@RestController
class UserController(
    private val signUpService: SignUpService,
    private val loginService: LogInService,
    private val updateUserInfoService: UpdateUserInfoService
) {
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    fun signUp(@RequestBody @Valid request: SignUpRequset) {
        signUpService.execute(request)
    }

    @PostMapping("/login")
    fun login(@RequestBody @Valid requset: LogInRequset): TokenResponse {
        return loginService.execute(requset)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping
    fun updateUserInfo(@RequestBody @Valid request: UpdateUserInfoRequest) {
        updateUserInfoService.execute(request)
    }
}