package com.example.dise_v2.global.security.jwt

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "jwt")
object JwtProperties {
    const val secretKey = "SECRET_KEY"
    const val accessExp = "ACCESS_EXP"
}