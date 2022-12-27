package com.example.dise_v2.global.exception

import com.example.dise_v2.global.error.CustomException
import com.example.dise_v2.global.error.ErrorCode

object InvalidJwtException:CustomException(ErrorCode.INVALID_JWT) {
    var EXCEPTION = InvalidJwtException
}