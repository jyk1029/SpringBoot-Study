package com.example.dise_v2.domain.comment.controller

import com.example.dise_v2.domain.comment.controller.dto.request.CreateCommentRequest
import com.example.dise_v2.domain.comment.controller.dto.request.UpdateCommentRequest
import com.example.dise_v2.domain.comment.service.CreateCommentService
import com.example.dise_v2.domain.comment.service.DeleteCommentService
import com.example.dise_v2.domain.comment.service.UpdateCommentService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RequestMapping("/comment")
@RestController
class CommentController(
    private val createCommentService: CreateCommentService,
    private val updateCommentService: UpdateCommentService,
    private val deleteCommentService: DeleteCommentService
) {
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{feed-id}")
    fun createComment(@PathVariable("feed-id") feedId: Long, @RequestBody @Valid request: CreateCommentRequest) {
        createCommentService.execute(feedId, request)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{comment-id}")
    fun modifyComment(@PathVariable("comment-id") commentId: Long, @RequestBody @Valid request: UpdateCommentRequest) {
        updateCommentService.execute(commentId, request)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{comment-id}")
    fun deleteComment(@PathVariable("comment-id") commentId: Long) {
        deleteCommentService.execute(commentId)
    }
}