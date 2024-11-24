package com.mon0mon.bookstorebackend.domain.dto

data class BookSummaryDto(
    val isbn: String,
    var title: String,
    var description: String,
    var image: String,
    var author: AuthorSummaryDto
)
