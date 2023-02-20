package com.example.dise_v2.domain.comment.facade

import com.example.dise_v2.domain.comment.domain.Comment
import com.example.dise_v2.domain.comment.domain.repository.CommentRepository
import com.example.dise_v2.domain.comment.exception.CommentNotFoundException
import org.springframework.stereotype.Component

@Component
class CommentFacade(
    private val commentRepository: CommentRepository
) {
    fun getCommentById(commentId: Long): Comment {
        return commentRepository.findById(commentId)
            .orElseThrow { CommentNotFoundException.EXCEPTION }
    }
}