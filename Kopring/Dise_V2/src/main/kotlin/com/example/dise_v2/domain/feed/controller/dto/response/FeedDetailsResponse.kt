package com.example.dise_v2.domain.feed.controller.dto.response

import java.time.LocalDateTime

data class FeedDetailsResponse(
    val feedId: Long,
    val title: String,
    val content: String,
    val userName: String,
    val createdAt: LocalDateTime,
    val isMine: Boolean
)