package com.example.dise_v2.domain.feed.controller

import com.example.dise_v2.domain.feed.controller.dto.request.CreateFeedRequset
import com.example.dise_v2.domain.feed.service.CreateFeedService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RequestMapping("/feed")
@RestController
class FeedController(
    private val createFeedService: CreateFeedService
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun createFeed(@RequestBody @Valid request: CreateFeedRequset) {
        createFeedService.execute(request)
    }
}