package com.example.dise_v2.domain.feed.exception

import com.example.dise_v2.global.error.CustomException
import com.example.dise_v2.global.error.ErrorCode

class FeedNotFoundException : CustomException(ErrorCode.FEED_NOT_FOUND) {
    companion object {
        @JvmField
        val EXCEPTION = FeedNotFoundException()
    }
}