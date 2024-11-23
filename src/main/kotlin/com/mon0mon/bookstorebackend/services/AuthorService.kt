package com.mon0mon.bookstorebackend.services

import com.mon0mon.bookstorebackend.domain.entities.AuthorEntity

interface AuthorService {
    fun save(authorEntity: AuthorEntity): AuthorEntity

    fun list(): List<AuthorEntity>
}
