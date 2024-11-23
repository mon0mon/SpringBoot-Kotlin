package com.mon0mon.bookstorebackend.repositories

import com.mon0mon.bookstorebackend.domain.entities.AuthorEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AuthorRepository : JpaRepository<AuthorEntity, Long?>
