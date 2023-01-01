package com.example.dise_v2

import com.example.dise_v2.global.security.jwt.JwtProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan
@EnableConfigurationProperties(JwtProperties::class)
@SpringBootApplication
class DiseV2Application

fun main(args: Array<String>) {
    runApplication<DiseV2Application>(*args)
}
