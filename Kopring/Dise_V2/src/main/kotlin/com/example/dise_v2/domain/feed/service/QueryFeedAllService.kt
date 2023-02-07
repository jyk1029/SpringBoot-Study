package com.example.dise_v2.domain.feed.service

import com.example.dise_v2.domain.feed.controller.dto.response.FeedElement
import com.example.dise_v2.domain.feed.controller.dto.response.FeedListResponse
import com.example.dise_v2.domain.feed.domain.Feed
import com.example.dise_v2.domain.feed.domain.repository.FeedRepository
import com.example.dise_v2.domain.feed.facade.FeedFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class QueryFeedAllService(
    private val feedRepository: FeedRepository
) {
    @Transactional(readOnly = true)
    fun execute(): FeedListResponse {

        return FeedListResponse(
            feedRepository.findAllByOrderByIdDesc().map {
                FeedElement(
                    feedId = it.id,
                    title = it.title,
                    content = it.content,
                    name = it.userName(),
                    createdAt = it.createdAt
                )
            }
        )
    }
}