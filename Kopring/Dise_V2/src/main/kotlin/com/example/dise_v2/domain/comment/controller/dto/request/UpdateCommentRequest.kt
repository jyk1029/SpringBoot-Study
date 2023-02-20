package com.example.dise_v2.domain.comment.controller.dto.request

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class UpdateCommentRequest(
    @field:NotBlank(message = "content는 null, 공백, 띄어쓰기가 불가합니다.")
    @field:Size(max = 1000, message = "content는 최대 1000자까지 가능합니다.")
    var content: String
)