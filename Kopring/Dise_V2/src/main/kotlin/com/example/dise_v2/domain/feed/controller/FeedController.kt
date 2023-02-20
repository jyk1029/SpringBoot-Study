package com.example.dise_v2.domain.feed.controller

import com.example.dise_v2.domain.feed.controller.dto.request.CreateFeedRequset
import com.example.dise_v2.domain.feed.controller.dto.request.UpdateFeedRequest
import com.example.dise_v2.domain.feed.controller.dto.response.FeedDetailsResponse
import com.example.dise_v2.domain.feed.controller.dto.response.FeedListResponse
import com.example.dise_v2.domain.feed.domain.type.Category
import com.example.dise_v2.domain.feed.service.*
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RequestMapping("/feed")
@RestController
class FeedController(
    private val createFeedService: CreateFeedService,
    private val updateFeedService: UpdateFeedService,
    private val deleteFeedService: DeleteFeedService,
    private val feedDetailsService: FeedDetailsService,
    private val queryFeedAllService: QueryFeedAllService,
    private val queryMyFeedService: QueryMyFeedService,
    private val categoryFeedListServcie: CategoryFeedListServcie
) {
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun createFeed(@RequestBody @Valid request: CreateFeedRequset) {
        createFeedService.execute(request)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{feed-id}")
    fun modifyFeed(@PathVariable("feed-id") feedId: Long, @RequestBody @Valid request: UpdateFeedRequest) {
        updateFeedService.execute(feedId, request)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{feed-id}")
    fun deleteFeed(@PathVariable("feed-id") feedId: Long) {
        deleteFeedService.execute(feedId)
    }

    @GetMapping("/{feed-id}")
    fun feedDatails(@PathVariable("feed-id") feedId: Long): FeedDetailsResponse {
        return feedDetailsService.execute(feedId)
    }

    @GetMapping("/list")
    fun feedList(): FeedListResponse {
        return queryFeedAllService.execute()
    }

    @GetMapping
    fun myFeedList(): FeedListResponse {
        return queryMyFeedService.execute()
    }

    @GetMapping("/category/{category}")
    fun categoryFeedList(@PathVariable("category")category: Category): FeedListResponse {
        return categoryFeedListServcie.execute(category)
    }
}