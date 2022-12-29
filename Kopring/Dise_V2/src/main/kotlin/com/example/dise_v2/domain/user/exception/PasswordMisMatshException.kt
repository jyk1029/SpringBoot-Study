package com.example.dise_v2.domain.user.exception

import com.example.dise_v2.global.error.CustomException
import com.example.dise_v2.global.error.ErrorCode

class PasswordMisMatshException : CustomException(ErrorCode.PASSWORD_MISMATCH) {
    companion object {
        @JvmField
        val EXCEPTION = PasswordMisMatshException()
    }
}