package com.example.dise_v2.domain.comment.domain.repository

import com.example.dise_v2.domain.comment.domain.Comment
import org.springframework.data.repository.CrudRepository

interface CommentRepository : CrudRepository<Comment, Long> {
}