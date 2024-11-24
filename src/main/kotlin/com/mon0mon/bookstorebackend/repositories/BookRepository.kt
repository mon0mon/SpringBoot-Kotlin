package com.mon0mon.bookstorebackend.repositories

import com.mon0mon.bookstorebackend.domain.entities.BookEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository : JpaRepository<BookEntity, String> {
    fun findByAuthorEntityId(id: Long): List<BookEntity>
}
