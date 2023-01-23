package com.example.dise_v2.global.exception

import com.example.dise_v2.global.error.CustomException
import com.example.dise_v2.global.error.ErrorCode

object ExpiredJwtExcpetion : CustomException(ErrorCode.EXPIRED_JWT) {
    val EXCPETION = ExpiredJwtExcpetion
}