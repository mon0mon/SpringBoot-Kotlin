package com.mon0mon.bookstorebackend.services.impl

import com.mon0mon.bookstorebackend.domain.entities.AuthorEntity
import com.mon0mon.bookstorebackend.repositories.AuthorRepository
import com.mon0mon.bookstorebackend.services.AuthorService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class AuthorServiceImpl(
    private val authorRepository: AuthorRepository
) : AuthorService{
    override fun save(authorEntity: AuthorEntity): AuthorEntity {
        return authorRepository.save(authorEntity)
    }

    override fun list(): List<AuthorEntity> {
        return authorRepository.findAll()
    }

    override fun get(id: Long): AuthorEntity? {
        return authorRepository.findByIdOrNull(id)
    }
}
