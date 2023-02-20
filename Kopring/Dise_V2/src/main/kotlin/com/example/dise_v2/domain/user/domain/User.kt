package com.example.dise_v2.domain.user.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
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

    fun updateUserInfo(name: String) {
        this.name = name
    }

    fun updatePassword(password: String) {
        this.password = password
    }
}