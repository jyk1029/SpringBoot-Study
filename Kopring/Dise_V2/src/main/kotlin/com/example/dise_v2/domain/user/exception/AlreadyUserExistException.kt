package com.example.dise_v2.domain.user.exception

import com.example.dise_v2.global.error.CustomException
import com.example.dise_v2.global.error.ErrorCode
import com.example.dise_v2.global.error.ErrorResponse

class AlreadyUserExistException() : CustomException(ErrorCode.ALREADY_USER_EXIST) {
    companion object {
        @JvmField
        val EXCEPTION = AlreadyUserExistException()
    }
}