package com.example.dise_v2.domain.comment.exception

import com.example.dise_v2.global.error.CustomException
import com.example.dise_v2.global.error.ErrorCode

class NotModifyCommentException : CustomException(ErrorCode.NOT_MODIFY_COMMENT) {
    companion object {
        @JvmField
        val EXCEPTION = NotModifyCommentException()
    }
}