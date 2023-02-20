package com.example.dise_v2.domain.feed.service

import com.example.dise_v2.domain.feed.controller.dto.response.FeedElement
import com.example.dise_v2.domain.feed.controller.dto.response.FeedListResponse
import com.example.dise_v2.domain.feed.domain.Feed
import com.example.dise_v2.domain.feed.domain.repository.FeedRepository
import com.example.dise_v2.domain.user.domain.User
import com.example.dise_v2.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class QueryMyFeedService(
    private val userFacade: UserFacade,
    private val feedRepository: FeedRepository
) {

    @Transactional(readOnly = true)
    fun execute(): FeedListResponse {
        val user: User = userFacade.getCurrentUser()
        val feedList: List<FeedElement> = feedRepository.findAllByUserOrderByCreatedAtDesc(user)
            .stream()
            .map(this::feedBuilder)
            .toList()

        return FeedListResponse(feedList)
    }

    private fun feedBuilder(feed: Feed): FeedElement {
        return FeedElement(
            feedId = feed.id,
            title = feed.title,
            content = feed.content,
            name = feed.userName(),
            createdAt = feed.createdAt
        )
    }
}