package com.mon0mon.bookstorebackend.controllers

import com.mon0mon.bookstorebackend.domain.dto.BookSummaryDto
import com.mon0mon.bookstorebackend.domain.entities.BookEntity
import com.mon0mon.bookstorebackend.exception.InvalidAuthorException
import com.mon0mon.bookstorebackend.services.BookService
import com.mon0mon.bookstorebackend.toBookSummary
import com.mon0mon.bookstorebackend.toBookSummaryDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/v1/books"])
class BooksController(
    val bookService: BookService,
) {

    @PutMapping(path = ["/{isbn}"])
    fun createFullUpdateBook(
        @PathVariable("isbn") isbn: String,
        @RequestBody book: BookSummaryDto,
    ): ResponseEntity<BookSummaryDto> {
        try {
            val (savedBook, isCreated) = bookService.createUpdate(isbn, book.toBookSummary())
            val responseCode = if (isCreated) HttpStatus.CREATED else HttpStatus.OK
            return ResponseEntity(savedBook.toBookSummaryDto(), responseCode)
        } catch(ex: InvalidAuthorException) {
            return ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        } catch (ex: IllegalStateException) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }

    }

    @GetMapping
    fun readManyBooks(
        @RequestParam("author") authorId: Long?
    ): List<BookSummaryDto> {
        return bookService.list(authorId).map(BookEntity::toBookSummaryDto)
    }

    @GetMapping(path = ["/{isbn}"])
    fun readOneBook(
        @PathVariable("isbn") isbn: String
    ): ResponseEntity<BookSummaryDto> {
        return bookService.get(isbn)?.let { ResponseEntity(it.toBookSummaryDto(), HttpStatus.OK) }
            ?: ResponseEntity(HttpStatus.NOT_FOUND)
    }
}
