package com.example.dise_v2.global.error

import com.example.dise_v2.global.exception.InternalServerErrorException
import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException
import java.nio.charset.StandardCharsets
import kotlin.Throws

@Component
class ExceptionFilter(
    private val objectMapper: ObjectMapper
) : OncePerRequestFilter() {
    @Throws(IOException::class)
    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
        try {
            filterChain.doFilter(request, response)
        } catch (e:Exception) {
           e.printStackTrace()
            when(e) {
                is CustomException -> sendErrorMessage(response, e)
                else -> sendErrorMessage(response, InternalServerErrorException.EXCEPTION)
            }
        }
    }
    @Throws(IOException::class)
    private fun sendErrorMessage(response: HttpServletResponse, e:CustomException) {
        val errorResponse: ErrorResponse = ErrorResponse.of(e)

        response.status = errorResponse.status
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.writer.write(objectMapper.writeValueAsString(errorResponse))
        response.characterEncoding = StandardCharsets.UTF_8.toString()
    }
}