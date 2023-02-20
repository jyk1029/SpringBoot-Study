package com.example.dise_v2.domain.comment.controller

import com.example.dise_v2.domain.comment.controller.dto.request.CreateCommentRequest
import com.example.dise_v2.domain.comment.service.CreateCommentService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RequestMapping("/comment")
@RestController
class CommentController(
    private val createCommentService: CreateCommentService
) {
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{feed-id}")
    fun createComment(@PathVariable("feed-id") feedId: Long, @RequestBody @Valid request: CreateCommentRequest) {
        createCommentService.execute(feedId, request)
    }
}