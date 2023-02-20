package com.example.dise_v2.domain.comment.domain.repository

import com.example.dise_v2.domain.comment.domain.Comment
import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository : JpaRepository<Comment, Long> {
    fun findAllByFeedId(feedId: Long): List<Comment>
}