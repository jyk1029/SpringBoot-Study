package com.example.dise_v2.domain.user.controller.dto.request

import javax.validation.constraints.NotBlank

data class LogInRequset(
    @field:NotBlank(message = "account_id는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    var accountId: String,

    @field:NotBlank(message = "password는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    var password: String
)