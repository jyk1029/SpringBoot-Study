package com.example.board.domain.user.domain.repository;

import com.example.board.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByAccountId(String accountId); //Optional : 예상치못한 NPE를 제공되는 메소드로 null값으로 인해 발생하는 예외를 처리
    Boolean existsByAccountId(String accountId);
}
