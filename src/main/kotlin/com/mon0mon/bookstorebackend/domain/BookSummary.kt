package com.mon0mon.bookstorebackend.domain

import com.mon0mon.bookstorebackend.domain.dto.AuthorSummaryDto

data class BookSummary(
    val isbn: String,
    var title: String,
    var description: String,
    var image: String,
    var author: AuthorSummary
)
