package com.mon0mon.bookstorebackend.repositories

import com.mon0mon.bookstorebackend.domain.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository : JpaRepository<Book, String>
