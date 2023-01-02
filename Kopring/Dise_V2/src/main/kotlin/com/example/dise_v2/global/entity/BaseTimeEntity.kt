package com.example.dise_v2.global.entity

import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class BaseTimeEntity(
    createdAt: LocalDateTime
) {
    @CreatedDate
    @Column(nullable = false)
    var createdAt: LocalDateTime = createdAt
        protected set
}