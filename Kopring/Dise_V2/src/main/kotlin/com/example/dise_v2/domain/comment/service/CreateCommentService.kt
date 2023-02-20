package com.example.dise_v2.domain.comment.service

import com.example.dise_v2.domain.comment.controller.dto.request.CreateCommentRequest
import com.example.dise_v2.domain.comment.domain.repository.CommentRepository
import com.example.dise_v2.domain.comment.domain.Comment
import com.example.dise_v2.domain.feed.facade.FeedFacade
import com.example.dise_v2.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CreateCommentService(
    private val userFacade: UserFacade,
    private val feedFacade: FeedFacade,
    private val commentRepository: CommentRepository
) {
    @Transactional
    fun execute(id: Long, request: CreateCommentRequest) {
        commentRepository.save(
            Comment(
                id = 0,
                content = request.content,
                user = userFacade.getCurrentUser(),
                feed = feedFacade.getFeed(id))
        )
    }
}