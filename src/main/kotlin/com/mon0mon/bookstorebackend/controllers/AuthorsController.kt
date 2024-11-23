package com.mon0mon.bookstorebackend.controllers

import com.mon0mon.bookstorebackend.domain.dto.AuthorDto
import com.mon0mon.bookstorebackend.domain.entities.AuthorEntity
import com.mon0mon.bookstorebackend.services.AuthorService
import com.mon0mon.bookstorebackend.toAuthorDto
import com.mon0mon.bookstorebackend.toAuthorEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/authors")
class AuthorsController(
    private val authorService: AuthorService,
) {

    @PostMapping
    fun createAuthor(@RequestBody authorDto: AuthorDto): ResponseEntity<AuthorDto> {
        val createdAuthor = authorService.save(authorDto.toAuthorEntity())
            .toAuthorDto()
        return ResponseEntity(createdAuthor, HttpStatus.CREATED)
    }

    @GetMapping
    fun readManyAuthor(): List<AuthorDto> {
        return authorService.list().map(AuthorEntity::toAuthorDto)
    }
}
