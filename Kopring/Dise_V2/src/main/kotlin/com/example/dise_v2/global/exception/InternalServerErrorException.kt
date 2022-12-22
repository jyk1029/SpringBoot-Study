package com.example.dise_v2.global.exception

import com.example.dise_v2.global.error.CustomException
import com.example.dise_v2.global.error.ErrorCode

class InternalServerErrorException() : CustomException(ErrorCode.INTERNAL_SERVER_ERROR) {
    companion object {
        @JvmField
        val EXCEPTION = InternalServerErrorException()
    }
}