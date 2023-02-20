package com.example.dise_v2.domain.comment.controller.dto.response

data class CommentElement(
    private val commentId: Long?,
    private val content: String,
    private val name: String,
    private val isMine: Boolean?
)