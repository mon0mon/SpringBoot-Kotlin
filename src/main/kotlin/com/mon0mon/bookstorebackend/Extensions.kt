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
import com.mon0mon.bookstorebackend.exception.InvalidAuthorException

fun AuthorEntity.toAuthorDto() =
    AuthorDto(
        id = this.id,
        name = this.name,
        age = this.age,
        description = description,
        image = image
    )

fun AuthorDto.toAuthorEntity() =
    AuthorEntity(
        id = this.id,
        name = this.name,
        age = this.age,
        description = description,
        image = image
    )

fun AuthorUpdateRequestDto.toAuthorUpdateRequest() = AuthorUpdateRequest(
    id = this.id,
    name = this.name,
    age = this.age,
    description = description,
    image = image,
)

fun BookSummary.toBookEntity(author: AuthorEntity) = BookEntity(
    isbn = this.isbn,
    title = this.title,
    description = this.description,
    image = this.image,
    authorEntity = author,
)

fun AuthorSummaryDto.toAuthorSummary() = AuthorSummary(
    id = this.id,
    name = this.name,
    image = this.image
)

fun BookSummaryDto.toBookSummary() = BookSummary(
    isbn = this.isbn,
    title = this.title,
    description = this.description,
    image = this.image,
    author = this.author.toAuthorSummary()
)

fun AuthorEntity.toAuthorSummaryDto(): AuthorSummaryDto {
    val authorId = this.id ?: throw InvalidAuthorException()
    return AuthorSummaryDto(
        id = authorId,
        name = this.name,
        image = this.image
    )
}

fun BookEntity.toBookSummaryDto() = BookSummaryDto(
    isbn = this.isbn,
    title = this.title,
    description = this.description,
    image = this.image,
    author = this.authorEntity.toAuthorSummaryDto()
)
