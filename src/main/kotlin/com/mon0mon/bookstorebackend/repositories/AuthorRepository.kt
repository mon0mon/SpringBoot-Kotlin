package com.mon0mon.bookstorebackend.repositories

import com.mon0mon.bookstorebackend.domain.Author
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AuthorRepository : JpaRepository<Author, Long?>
