package com.mon0mon.bookstorebackend.services

import com.mon0mon.bookstorebackend.domain.AuthorUpdateRequest
import com.mon0mon.bookstorebackend.domain.entities.AuthorEntity

interface AuthorService {
    fun create(authorEntity: AuthorEntity): AuthorEntity

    fun list(): List<AuthorEntity>

    fun get(id: Long): AuthorEntity?

    fun fullUpdate(id: Long, authorEntity: AuthorEntity): AuthorEntity

    fun partialUpdate(id: Long, authorEntity: AuthorUpdateRequest): AuthorEntity

    fun delete(id: Long)
}
