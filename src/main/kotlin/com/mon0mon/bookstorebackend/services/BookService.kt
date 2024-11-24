package com.mon0mon.bookstorebackend.services

import com.mon0mon.bookstorebackend.domain.BookSummary
import com.mon0mon.bookstorebackend.domain.entities.BookEntity

interface BookService {
    fun createUpdate(isbn: String, bookSummary: BookSummary): Pair<BookEntity, Boolean>
}
