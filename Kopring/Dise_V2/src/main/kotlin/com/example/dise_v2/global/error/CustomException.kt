package com.example.dise_v2.global.error

import kotlin.RuntimeException

class CustomException(
    private val error: ErrorResponse
) : RuntimeException() {
    val status: Int
        get() = error.status

    override val message: String
        get() = error.message
}