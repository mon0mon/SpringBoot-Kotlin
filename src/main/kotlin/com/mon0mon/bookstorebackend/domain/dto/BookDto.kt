package com.mon0mon.bookstorebackend.domain.dto

import com.mon0mon.bookstorebackend.domain.entities.AuthorEntity
import jakarta.persistence.*

data class BookDto(
    val isbn: String,
    var title: String,
    var description: String,
    var image: String,
    var authorEntity: AuthorEntity,
)
