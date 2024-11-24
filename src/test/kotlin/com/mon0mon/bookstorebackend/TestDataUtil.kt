package com.mon0mon.bookstorebackend

import com.mon0mon.bookstorebackend.domain.AuthorSummary
import com.mon0mon.bookstorebackend.domain.AuthorUpdateRequest
import com.mon0mon.bookstorebackend.domain.BookSummary
import com.mon0mon.bookstorebackend.domain.dto.AuthorDto
import com.mon0mon.bookstorebackend.domain.dto.AuthorSummaryDto
import com.mon0mon.bookstorebackend.domain.dto.AuthorUpdateRequestDto
import com.mon0mon.bookstorebackend.domain.dto.BookSummaryDto
import com.mon0mon.bookstorebackend.domain.entities.AuthorEntity
import com.mon0mon.bookstorebackend.domain.entities.BookEntity

const val BOOK_A_ISBN = "978-063-666162-0142"

fun testAuthorDtoA(id: Long? = null) =
    AuthorDto(
        id = id,
        name = "John Doe",
        age = 30,
        description = "Some description",
        image = "author-image.jpeg",
    )

fun testAuthorEntityA(id: Long? = null) =
    AuthorEntity(
        id = id,
        name = "John Doe",
        age = 30,
        description = "Some description",
        image = "author-image.jpeg",
    )

fun testAuthorEntityB(id: Long? = null) =
    AuthorEntity(
        id = id,
        name = "Donh Joe",
        age = 65,
        description = "Some other description",
        image = "some-other-image.jpeg",
    )

fun testAuthorUpdateRequestDtoA(id: Long? = null) = AuthorUpdateRequestDto(
    id = id,
    name = "John Doe",
    age = 30,
    description = "Some description",
    image = "author-image.jpeg",
)

fun testAuthorUpdateRequestA(id: Long? = null) = AuthorUpdateRequest(
    id = id,
    name = "John Doe",
    age = 30,
    description = "Some description",
    image = "author-image.jpeg",
)

fun testBookEntityA(isbn: String, author: AuthorEntity) = BookEntity(
    isbn = isbn,
    title = "Test Book A",
    description = "A test book",
    image = "book-image.jpeg",
    authorEntity = author
)

fun testAuthorSummaryDtoA(id: Long) = AuthorSummaryDto(
    id = id,
    name = "John Doe",
    image = "author-image.jpeg"
)

fun testBookSummaryDtoA(isbn: String, author: AuthorSummaryDto) = BookSummaryDto(
    isbn = isbn,
    title = "Test Book A",
    description = "A test book",
    image = "book-image.jpeg",
    author = author
)

fun testBookSummaryA(isbn: String, author: AuthorSummary) = BookSummary(
    isbn = isbn,
    title = "Test Book A",
    description = "A test book",
    image = "book-image.jpeg",
    author = author
)

fun testBookSummaryB(isbn: String, author: AuthorSummary) = BookSummary(
    isbn = isbn,
    title = "Test Book B",
    description = "Another test book",
    image = "book-image-b.jpeg",
    author = author
)

fun testAuthorSummaryA(id: Long) = AuthorSummary(
    id = id,
    name = "John Doe",
    image = "author-image.jpeg"
)


