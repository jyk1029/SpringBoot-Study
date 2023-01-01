package com.example.dise_v2.global.security

import com.example.dise_v2.global.security.jwt.JwtTokenProvider
import com.fasterxml.jackson.databind.ObjectMapper
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
    private val objectMapper: ObjectMapper,
    private val jwtTokenProvider: JwtTokenProvider
) {
    @Bean
    @Throws(Exception::class)
    protected fun filterchain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf().disable()
            .formLogin().disable()
            .cors()

            .and()

            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()

            .authorizeRequests()
            .requestMatchers("/**").permitAll()
            .anyRequest().permitAll()
            .and().apply(FilterConfig(objectMapper, jwtTokenProvider))

        return http.build()
    }

    @Bean
    fun passwordEncorder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }
}