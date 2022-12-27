package com.example.dise_v2.domain.user.controller.dto.request

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size

data class SignUpRequset(
    @field:NotBlank(message = "account_id는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @field:Size(min = 8, max = 20, message = "account_id는 8자 이상 20자 이하여야 합니다.")
    var accountId: String,

    @field:NotBlank(message = "password는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @field:Pattern(regexp = "(?=.*[a-z])(?=.*[0-9])(?=.*[!/?@])[a-zA-Z0-9!/" +
            "?@]{8,20}$",
        message = "password는 소문자, 숫자, 특수문자가 포함되어야 하며 8자 이상 20자 이하여야 합니다."
    )
    var password: String,

    @field:NotBlank(message = "name은 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @field:Size(max = 4, message = "name은 4자 이하여야 합니다.")
    var name: String
)