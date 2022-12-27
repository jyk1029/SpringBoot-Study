package com.example.dise_v2.global.security.jwt

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "jwt")
data class JwtProperties(
    var secretKey: String,
    val accessExp: Long
) {
}