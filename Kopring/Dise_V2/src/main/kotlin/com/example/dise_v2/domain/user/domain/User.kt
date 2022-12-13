package com.example.dise_v2.domain.user.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity(name = "user")
class User(
    id: Long?,
    accountId: String,
    password: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = id
        protected set

    @Column(length = 20, nullable = false, unique = true, name = "account_id")
    var accountId: String = accountId
        protected set

    @Column(length = 60, nullable = false, name = "password")
    var password: String = password
        protected set
}