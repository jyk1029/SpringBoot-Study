package com.example.board.domain.user.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//명시적으로 AccessLevel을 명시해주지 않으면, 접근 제한자는 public
@Getter //getter : 필드를 리턴하는 것(ex. getAccountId, isAccountId)
@NoArgsConstructor(access = AccessLevel.PROTECTED) //NoArgsConstructor : 파라미터가 없는 생성자를 생성,  final로 생성되어 있는 경우에는 필드를 초기화 할 수 없기 때문에 생성자를 만들 수 없고 에러가 발생
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
