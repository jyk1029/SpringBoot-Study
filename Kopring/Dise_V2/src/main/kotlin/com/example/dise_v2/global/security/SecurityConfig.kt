package com.example.dise_v2.global.security

import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.FilterChain
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import java.lang.Exception

@EnableWebSecurity
@Configuration
class SecurityConfig(
    val objectMapper: ObjectMapper
) {
    @Bean
    @Throws(Exception::class)
    fun filterchain(http: HttpSecurity): SecurityFilterChain {
        return http
            .csrf().disable()
            .formLogin().disable()
            .cors()

            .and()

            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()

            .authorizeRequests()
            .requestMatchers("").permitAll()
            .anyRequest().permitAll()
            .and().build()
    }

    @Bean
    fun passwordEncorder() : PasswordEncoder {
        return BCryptPasswordEncoder()
    }
}