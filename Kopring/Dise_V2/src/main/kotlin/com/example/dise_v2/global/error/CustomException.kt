package com.example.dise_v2.global.error

import kotlin.RuntimeException

open class CustomException(
    private val error: ErrorCode
) : RuntimeException() {
    val status: Int
        get() = error.status

    override val message: String
        get() = error.message
}