package com.example.dise_v2.global.security.jwt

import com.example.dise_v2.domain.user.controller.dto.response.TokenResponse
import com.example.dise_v2.global.exception.ExpiredJwtExcpetion
import com.example.dise_v2.global.exception.InternalServerErrorException
import com.example.dise_v2.global.exception.InvalidJwtException
import com.example.dise_v2.global.security.auth.AuthDetailsService
import io.jsonwebtoken.Claims
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.InvalidClaimException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import jakarta.servlet.http.HttpServletRequest
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.lang.Exception
import java.util.*

@Component
class JwtTokenProvider(
    private val jwtProperties: JwtProperties,
    private val authDetailsService: AuthDetailsService
) {
    fun getToken(accountId: String): TokenResponse {
        val accessToken: String = generateToken(accountId, jwtProperties.accessExp)

        return TokenResponse(accessToken = accessToken)
    }

    private fun generateToken(accountId: String, expiration: Long): String {
        return "Bearer " + Jwts.builder().signWith(SignatureAlgorithm.HS256, jwtProperties.secret)
            .setSubject(accountId)
            .setHeaderParam("typ", "access")
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + expiration * 1000))
            .compact()
    }

    fun resolveToken(request: HttpServletRequest): String? {
        val bearer: String? = request.getHeader("Authorization")

        return parseToken(bearer)
    }

    fun parseToken(bearerToken: String?): String? {
        return if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.replace("Bearer ", "")
        } else return null
    }

    fun authorization(token: String): UsernamePasswordAuthenticationToken? {
        return token?.let {
            val userDetails: UserDetails = authDetailsService.loadUserByUsername(getTokenSubject(token))
            return UsernamePasswordAuthenticationToken(userDetails, "", userDetails.authorities)
        }
    }

    private fun getTokenSubject(subject: String): String {
        return getTokenBody(subject).subject
    }

    private fun getTokenBody(token: String?): Claims {
        return try {
            Jwts.parser().setSigningKey(jwtProperties.secret)
                .parseClaimsJwt(token).body
        } catch (e: Exception) {
            when (e) {
                is ExpiredJwtException -> throw ExpiredJwtExcpetion.EXCPETION
                is InvalidClaimException -> throw InvalidJwtException.EXCEPTION
                else -> throw InternalServerErrorException.EXCEPTION
            }
        }
    }
}