package com.example.dise_v2.domain.feed.domain.repository

import com.example.dise_v2.domain.feed.domain.Feed
import com.example.dise_v2.domain.feed.domain.type.Category
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FeedRepository : JpaRepository<Feed, Long> {
    fun findAllByOrderByIdDesc(): List<Feed>
    fun findByCategoryOrderByCreatedAtDesc(category: Category) : List<Feed>
}