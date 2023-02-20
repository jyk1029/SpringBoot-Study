package com.example.dise_v2.domain.feed.service

import com.example.dise_v2.domain.feed.controller.dto.response.FeedDetailsResponse
import com.example.dise_v2.domain.feed.facade.FeedFacade
import com.example.dise_v2.domain.user.exception.UserNotFoundException
import com.example.dise_v2.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class FeedDetailsService(
    private val userFacade: UserFacade,
    private val feedFacade: FeedFacade
) {
    @Transactional(readOnly = true)
    fun execute(feedId: Long): FeedDetailsResponse {
        val feed = feedFacade.getFeed(feedId)
        val userId = feed.userId()

        return FeedDetailsResponse(
            feedId = feed.id,
            title = feed.title,
            content = feed.content,
            userName = feed.userName(),
            createdAt = feed.createdAt,
            isMine = getIsMine(userId)
        )
    }

    private fun getIsMine(userId: Long?): Boolean {
        try {
            return userFacade.getUserId()!!.equals(userId)
        } catch(e: UserNotFoundException) {
            return false
        }
    }
}