package com.example.board.domain.user.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 15, nullable = false)
    private String accountId;

    @Column(length = 60, nullable = false)
    private String password;

    @Column(length = 5, nullable = false)
    private String name;

    @Column(length = 64, nullable = false)
    private String email;

    @Builder
    private User(String accountId, String password, String name, String email) {
        this.accountId = accountId;
        this.password = password;
        this.name = name;
        this.email = email;
    }
}
