package com.mon0mon.bookstorebackend.services.impl

import com.mon0mon.bookstorebackend.domain.BookSummary
import com.mon0mon.bookstorebackend.domain.BookUpdateRequest
import com.mon0mon.bookstorebackend.domain.entities.BookEntity
import com.mon0mon.bookstorebackend.repositories.AuthorRepository
import com.mon0mon.bookstorebackend.repositories.BookRepository
import com.mon0mon.bookstorebackend.services.BookService
import com.mon0mon.bookstorebackend.toBookEntity
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BookServiceImpl(
    val bookRepository: BookRepository,
    val authorRepository: AuthorRepository,
) : BookService{
    @Transactional
    override fun createUpdate(isbn: String, bookSummary: BookSummary): Pair<BookEntity, Boolean> {
        val normalisedBook = bookSummary.copy(isbn = isbn)
        val isExists = bookRepository.existsById(isbn)

        val author = authorRepository.findByIdOrNull(normalisedBook.author.id)
        checkNotNull(author)

        val savedBook = bookRepository.save(normalisedBook.toBookEntity(author))
        return Pair(savedBook, !isExists)
    }

    override fun list(authorId: Long?): List<BookEntity> {
        return authorId?.let {
            bookRepository.findByAuthorEntityId(it)
        } ?: bookRepository.findAll()
    }

    override fun get(isbn: String): BookEntity? {
        return bookRepository.findByIdOrNull(isbn)
    }

    override fun partialUpdate(isbn: String, bookUpdateRequestDto: BookUpdateRequest): BookEntity {
        val existingBook = bookRepository.findByIdOrNull(isbn)
        checkNotNull(existingBook)

        val updatedBook = existingBook.copy(
            title = bookUpdateRequestDto.title ?: existingBook.title,
            description = bookUpdateRequestDto.description ?: existingBook.description,
            image = bookUpdateRequestDto.image ?: existingBook.image,
        )

        return bookRepository.save(updatedBook)
    }

    override fun delete(isbn: String) {
        bookRepository.deleteById(isbn)
    }
}
