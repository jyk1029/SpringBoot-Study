package com.example.dise_v2.domain.comment.service

import com.example.dise_v2.domain.comment.controller.dto.response.CommentElement
import com.example.dise_v2.domain.comment.controller.dto.response.CommentListResponse
import com.example.dise_v2.domain.comment.domain.Comment
import com.example.dise_v2.domain.comment.domain.repository.CommentRepository
import com.example.dise_v2.domain.feed.domain.Feed
import com.example.dise_v2.domain.feed.facade.FeedFacade
import com.example.dise_v2.domain.user.exception.UserNotFoundException
import com.example.dise_v2.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class QueryCommentService(
    private val userFacade: UserFacade,
    private val feedFacade: FeedFacade,
    private val commentRepository: CommentRepository
) {
    @Transactional(readOnly = true)
    fun execute(feedId: Long): CommentListResponse {
        val feed: Feed = feedFacade.getFeed(feedId)
        val commentList: List<CommentElement> = commentRepository.findAllByFeedId(feed.id)
            .stream()
            .map(this::buildCommentList)
            .toList()


        return CommentListResponse(commentList)

    }

    private fun buildCommentList(comment: Comment): CommentElement {
        val userId: Long? = comment.getUserId()

        return CommentElement(
            commentId = comment.id,
            content = comment.content,
            name = comment.getUserName(),
            isMine = getIsMine(userId)
        )
    }

    private fun getIsMine(userId: Long?): Boolean {
        try {
            return userFacade.getUserId()!!.equals(userId)
        } catch (e: UserNotFoundException) {
            return false
        }
    }
}