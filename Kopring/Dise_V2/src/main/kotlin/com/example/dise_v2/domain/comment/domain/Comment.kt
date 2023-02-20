package com.example.dise_v2.domain.comment.domain

import com.example.dise_v2.domain.feed.domain.Feed
import com.example.dise_v2.domain.user.domain.User
import javax.persistence.*

@Entity
class Comment(
    id: Long?,
    content: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    var user: User,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feed_id", nullable = false)
    var feed: Feed
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = id

    @Column(length = 1000, nullable = false)
    var content: String = content
        protected set
}