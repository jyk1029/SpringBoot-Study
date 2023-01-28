package com.example.dise_v2.domain.feed.domain.repository

import com.example.dise_v2.domain.feed.domain.Feed
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FeedRepository : JpaRepository<Feed, Long> {
    fun queryFeedList(): List<Feed>
}