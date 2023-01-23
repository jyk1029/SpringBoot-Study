package com.example.dise_v2.domain.feed.controller.dto.request

import com.example.dise_v2.domain.feed.domain.type.Category
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class CreateFeedRequset(

    @field:NotBlank(message = "title은 null, 공백, 띄어쓰기가 불가합니다.")
    @field:Size(max = 20, message = "title은 최대 20자까지 입니다.")
    var title: String,

    @field:NotBlank(message = "content는 null, 공백, 띄어쓰기가 불가합니다.")
    @field:Size(max = 100, message = "content는 최대 1000자까지 입니다")
    var content: String,

    @field:NotNull(message = "카테고리를 선택해주세요")
    var category: Category
)