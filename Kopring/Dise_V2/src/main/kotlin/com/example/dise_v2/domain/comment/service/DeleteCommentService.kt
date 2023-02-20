package com.example.dise_v2.domain.comment.service

import com.example.dise_v2.domain.comment.domain.Comment
import com.example.dise_v2.domain.comment.domain.repository.CommentRepository
import com.example.dise_v2.domain.comment.exception.NotDeleteCommentException
import com.example.dise_v2.domain.comment.facade.CommentFacade
import com.example.dise_v2.domain.user.domain.User
import com.example.dise_v2.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DeleteCommentService(
    private val userFacade: UserFacade,
    private val commentFacade: CommentFacade,
    private val commentRepository: CommentRepository
) {
    @Transactional
    fun execute(commentId: Long) {
        val user: User = userFacade.getCurrentUser()
        val comment: Comment = commentFacade.getCommentById(commentId)

        if(!user.equals(comment.user)) {
            throw NotDeleteCommentException.EXCEPTION
        }

        commentRepository.delete(comment)
    }
}