package com.example.dise_v2.domain.feed.service

import com.example.dise_v2.domain.feed.domain.repository.FeedRepository
import com.example.dise_v2.domain.feed.exception.NotDeleteFeedException
import com.example.dise_v2.domain.feed.facade.FeedFacade
import com.example.dise_v2.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DeleteFeedService(
    private val feedRepository: FeedRepository,
    private val feedFacade: FeedFacade,
    private val userFacade: UserFacade
) {
    @Transactional
    fun execute(feedId: Long) {
        var user = userFacade.getCurrentUser()
        var feed = feedFacade.getFeed(feedId)

        if (!user.equals(feed.user)) {
            throw NotDeleteFeedException.EXCEPTION
        }

        feedRepository.delete(feed)
    }
}