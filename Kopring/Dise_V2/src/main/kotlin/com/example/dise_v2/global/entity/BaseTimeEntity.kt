package com.example.dise_v2.global.entity

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime

@MappedSuperclass
abstract class BaseTimeEntity (
    createdAt: LocalDateTime
) {
    @CreatedDate
    @Column(nullable = false)
    var createdAt: LocalDateTime = createdAt
        protected set
}