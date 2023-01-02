package com.example.dise_v2.domain.feed.domain

import com.example.dise_v2.domain.feed.domain.type.Category
import com.example.dise_v2.domain.user.domain.User
import com.example.dise_v2.global.entity.BaseTimeEntity
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@EntityListeners(AuditingEntityListener::class)
class Feed(
    id: Long?,
    title: String,
    content: String,
    category: Category,
    createdAt: LocalDateTime,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    var user: User
) : BaseTimeEntity(createdAt) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = id

    @Column(length = 20, nullable = false)
    var title: String = title
        protected set

    @Column(length = 1000, nullable = false)
    var content: String = content
        protected set

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    var category: Category = category
        protected set
}