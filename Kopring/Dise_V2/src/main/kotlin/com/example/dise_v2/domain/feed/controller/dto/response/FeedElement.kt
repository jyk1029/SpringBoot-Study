package com.example.dise_v2.domain.feed.controller.dto.response

import java.time.LocalDateTime

data class FeedElement(
    private val feedId: Long,
    private val title: String,
    private val content: String,
    private val createdAt: LocalDateTime,
    private val name: String
)