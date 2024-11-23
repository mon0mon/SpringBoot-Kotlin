package com.mon0mon.bookstorebackend.controllers

import com.mon0mon.bookstorebackend.domain.entities.AuthorEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthorsController {

    @PostMapping(path = ["/v1/authros"])
    fun createAuthor(@RequestBody authorEntity: AuthorEntity?) {

    }
}
