package com.example.dise_v2.domain.user.controller.dto.request

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class UpdateUserInfoRequest (
    @field:NotBlank(message = "name은 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @field:Size(max = 4, message = "name은 4자 이하여야 합니다.")
    var name: String
)