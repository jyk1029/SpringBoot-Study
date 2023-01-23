package com.example.dise_v2.domain.feed.exception

import com.example.dise_v2.global.error.CustomException
import com.example.dise_v2.global.error.ErrorCode

class NotModifyFeedException : CustomException(ErrorCode.NOT_MODIFY_FEED) {
    companion object {
        @JvmField
        val EXCEPTION = NotModifyFeedException()
    }
}