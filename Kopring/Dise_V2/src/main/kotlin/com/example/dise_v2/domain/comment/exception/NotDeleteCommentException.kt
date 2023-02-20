package com.example.dise_v2.domain.comment.exception

import com.example.dise_v2.global.error.CustomException
import com.example.dise_v2.global.error.ErrorCode

class NotDeleteCommentException: CustomException(ErrorCode.NOT_DELETE_COMMENT) {
    companion object {
        @JvmField
        val EXCEPTION = NotDeleteCommentException()
    }
}