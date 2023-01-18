package com.example.dise_v2.domain.user.controller.dto.request

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern

data class UpdatePasswordRequest (

    @field:NotBlank(message = "password는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    var password: String,

    @field:NotBlank(message = "new_password는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @field:Pattern(regexp = "(?=.*[a-z])(?=.*[0-9])(?=.*[!/?@])[a-zA-Z0-9!/" +
            "?@]{8,20}$",
        message = "new_password는 소문자, 숫자, 특수문자가 포함되어야 하며 8자 이상 20자 이하여야 합니다."
    )
    var newPassword: String
)