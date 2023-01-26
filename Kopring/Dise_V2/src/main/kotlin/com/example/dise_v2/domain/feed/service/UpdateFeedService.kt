package com.example.dise_v2.domain.feed.service

import com.example.dise_v2.domain.feed.controller.dto.request.UpdateFeedRequest
import com.example.dise_v2.domain.feed.exception.NotModifyFeedException
import com.example.dise_v2.domain.feed.facade.FeedFacade
import com.example.dise_v2.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UpdateFeedService(
    private val userFacade: UserFacade,
    private val feedFacade: FeedFacade
) {
    @Transactional
    fun execute(feedId: Long, request: UpdateFeedRequest) {
        val user = userFacade.getCurrentUser()
        val feed = feedFacade.getFeed(feedId)

        if(!user.equals(feed.user)) {
            throw NotModifyFeedException.EXCEPTION
        }

        feed.modify(
            request.title,
            request.content,
            request.category
        )
    }
}