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
    password: String,
    name: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = id

    @Column(length = 20, nullable = false, unique = true)
    var accountId: String = accountId
        protected set

    @Column(length = 60, nullable = false)
    var password: String = password
        protected set

    @Column(length = 4, nullable = false)
    var name: String = name
            protected set
}