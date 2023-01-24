package com.example.dise_v2.domain.feed.exception

import com.example.dise_v2.global.error.CustomException
import com.example.dise_v2.global.error.ErrorCode

class NotDeleteFeedException : CustomException(ErrorCode.NOT_DELETE_FEED) {
    companion object {
        @JvmField
        val EXCEPTION = NotDeleteFeedException()
    }
}