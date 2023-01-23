package com.example.dise_v2.domain.feed.service

import com.example.dise_v2.domain.feed.controller.dto.request.CreateFeedRequset
import com.example.dise_v2.domain.feed.domain.Feed
import com.example.dise_v2.domain.feed.domain.repository.FeedRepository
import com.example.dise_v2.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
class CreateFeedService(
    private val feedRepository: FeedRepository,
    private val userFacade: UserFacade
) {

    @Transactional
    fun execute(request: CreateFeedRequset) {

        var user = userFacade.getCurrentUser()

        feedRepository.save(
            Feed(
                id = 0,
                title = request.title,
                content = request.content,
                category = request.category,
                user = user,
                createdAt = LocalDateTime.now()
            )
        )
    }
}