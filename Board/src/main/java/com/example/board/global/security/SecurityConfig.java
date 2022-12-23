package com.example.board.global.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean //Bean 직접 등록 방식
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf().disable() //사용자가 자신의 의지와는 무관하게 공격자가 의도한 행위을 특정 웹사이트에 요청하게 하는 공격 무력화
                .formLogin().disable() //Spring Security에서 제공하는 인증방식을 사용하지 않음
                .cors() //Cross-Origin Resource Sharing, 한 출처에 있는 자원에서 다른 출처에 있는 자원에 접근

                .and()

                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) //스프링시큐리티가 생성하지도않고 기존것을 사용하지도 않음

                .and().build();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(); // BCrypt 해싱 함수(BCrypt hashing function)를 사용해서 비밀번호를 인코딩
    }
}
