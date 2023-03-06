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
@Configuration //설정파일을 만들기 위한 애노테이션 or Bean을 등록하기 위한 애노테이션
@EnableWebSecurity //스프링 시큐리티의 필터 연결을 설정하 위한 오버라이딩, SpringSecurityFilterChain이 자동 포함
public class SecurityConfig {
    private final JwtTokenProvider jwtTokenProvider;
    private final ObjectMapper objectMapper;

    //스프링 2.7.0 부턴 WebSecurityConfigurererAdapter 상속 받지 않고 빈으로 직접 등록하는 것이 더 좋다
    @Bean //Bean : Spring IoC(제어의 역전, Inversion Of Control) 컨테이너가 관리하는 자바 객체
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
