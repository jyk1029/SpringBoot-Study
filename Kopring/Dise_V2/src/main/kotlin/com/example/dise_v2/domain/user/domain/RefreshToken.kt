package com.example.dise_v2.domain.user.domain

import jakarta.persistence.Id
import jakarta.validation.constraints.NotBlank
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.index.Indexed

@RedisHash(value = "RefreshToken", timeToLive = 60 * 60 * 2)
class RefreshToken(

    @Id
    val accountId: String,

    @Indexed
    @field:NotBlank
    val token: String
)