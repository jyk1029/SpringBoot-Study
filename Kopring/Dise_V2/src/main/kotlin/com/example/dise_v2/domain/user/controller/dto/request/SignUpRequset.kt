package com.example.dise_v2.domain.user.controller.dto.request

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size

data class SignUpRequset(
    @NotBlank(message = "account_id는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @Size(min = 8, max = 20, message = "account_id는 8자 이상 20자 이하여야 합니다.")
    var accountId: String,

    @NotBlank(message = "password는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @Size(min = 20, max = 20)
    var password: String,

    @NotBlank(message = "name은 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @Size(max = 4, message = "name은 4자 이하여야 합니다.")
    var name: String
)