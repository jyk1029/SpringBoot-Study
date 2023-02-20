package com.example.dise_v2.domain.comment.exception

import com.example.dise_v2.global.error.CustomException
import com.example.dise_v2.global.error.ErrorCode

class CommentNotFoundException : CustomException(ErrorCode.COMMENT_NOT_FOUND) {
    companion object {
        @JvmField
        val EXCEPTION = CommentNotFoundException()
    }
}