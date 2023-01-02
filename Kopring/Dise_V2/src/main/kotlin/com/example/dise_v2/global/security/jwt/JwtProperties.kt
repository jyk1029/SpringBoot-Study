package com.example.dise_v2.global.security.jwt

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "jwt")
data class JwtProperties(
    var secret: String,
    val accessExp: Long,
    val refreshExp: Long
)