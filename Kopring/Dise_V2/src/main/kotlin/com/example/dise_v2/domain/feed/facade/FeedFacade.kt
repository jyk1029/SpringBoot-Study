package com.example.dise_v2.domain.feed.facade

import com.example.dise_v2.domain.feed.domain.Feed
import com.example.dise_v2.domain.feed.domain.repository.FeedRepository
import com.example.dise_v2.domain.feed.exception.FeedNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class FeedFacade(
    private val feedRepository: FeedRepository
) {

    fun getFeed(id: Long): Feed {
        return feedRepository.findById(id)
            .orElseThrow { FeedNotFoundException.EXCEPTION }
    }
}