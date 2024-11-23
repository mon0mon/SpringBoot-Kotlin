package com.mon0mon.bookstorebackend.domain.dto

import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

data class AuthorDto(
    val id: Long?,
    var name: String,
    var age: Int,
    var description: String,
    var image: String,
)
