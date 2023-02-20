package com.example.dise_v2.domain.feed.service

import com.example.dise_v2.domain.feed.controller.dto.response.FeedElement
import com.example.dise_v2.domain.feed.controller.dto.response.FeedListResponse
import com.example.dise_v2.domain.feed.domain.Feed
import com.example.dise_v2.domain.feed.domain.repository.FeedRepository
import com.example.dise_v2.domain.feed.domain.type.Category
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CategoryFeedListServcie(
    private val feedRepository: FeedRepository
) {
    @Transactional(readOnly = true)
    fun execute(category: Category): FeedListResponse {
        val feedElementList: List<FeedElement> = feedRepository.findByCategoryOrderByCreatedAtDesc(category)
            .stream()
            .map(this::feedBuilder)
            .toList()

        return FeedListResponse(feedElementList)
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