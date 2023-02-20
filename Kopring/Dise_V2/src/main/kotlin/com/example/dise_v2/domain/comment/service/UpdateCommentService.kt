package com.example.dise_v2.domain.comment.service

import com.example.dise_v2.domain.comment.controller.dto.request.UpdateCommentRequest
import com.example.dise_v2.domain.comment.domain.Comment
import com.example.dise_v2.domain.comment.exception.NotModifyCommentException
import com.example.dise_v2.domain.comment.facade.CommentFacade
import com.example.dise_v2.domain.user.domain.User
import com.example.dise_v2.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UpdateCommentService(
    private val userFacade: UserFacade,
    private val commentFacade: CommentFacade
) {
    @Transactional
    fun execute(commentId: Long, request: UpdateCommentRequest) {
        val user: User = userFacade.getCurrentUser()
        val comment: Comment = commentFacade.getCommentById(commentId)

        if(!user.equals(comment.user)) {
            throw NotModifyCommentException.EXCEPTION
        }

        comment.modifyComment(request.content)
    }
}