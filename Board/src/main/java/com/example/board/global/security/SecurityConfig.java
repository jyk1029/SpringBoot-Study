package com.example.board.global.security;

import com.example.board.global.config.FilterConfig;
import com.example.board.global.security.jwt.JwtTokenProvider;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtTokenProvider jwtTokenProvider;
    private final ObjectMapper objectMapper;

    @Bean //Bean 직접 등록 방식
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf().disable()
                .formLogin().disable()
                .cors()

                .and()

                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .authorizeRequests()


                .antMatchers("/user").permitAll()

                .antMatchers("/feed").permitAll()

                .antMatchers("/auth/token").permitAll()

                .anyRequest().authenticated()

                .and()
                .apply(new FilterConfig(jwtTokenProvider, objectMapper))

                .and().build();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(); // BCrypt 해싱 함수(BCrypt hashing function)를 사용해서 비밀번호를 인코딩
    }
}
