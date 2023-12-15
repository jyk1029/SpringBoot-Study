package com.example.board.domain.auth.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RedisHash
public class RefreshToken {

    @Id
    private String userId;

    @Indexed
    private String refreshToken;

    @TimeToLive //토큰 만료시간을 seconds 단위로 설정핫기  위한 어노테이션
    private Long timeToLive;

    @Builder
    public RefreshToken(String accountId, String refreshToken) {
        this.userId = accountId;
        this.refreshToken = refreshToken;
        this.timeToLive = 3600L *2;
    }

    public void updateRefreshToken(String refreshToken, Long timeToLive) {
        this.refreshToken = refreshToken;
        this.timeToLive = timeToLive;
    }
}
