package com.example.dise_v2.domain.user.domain.repository

import com.example.dise_v2.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
    fun findByAccountId(accountId: String): User
    fun existsByAccountId(accountd: String): Boolean
}