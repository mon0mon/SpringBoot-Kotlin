package com.mon0mon.bookstorebackend

import com.mon0mon.bookstorebackend.domain.AuthorUpdateRequest
import com.mon0mon.bookstorebackend.domain.dto.AuthorDto
import com.mon0mon.bookstorebackend.domain.dto.AuthorUpdateRequestDto
import com.mon0mon.bookstorebackend.domain.entities.AuthorEntity

fun AuthorEntity.toAuthorDto() =
    AuthorDto(
        id = this.id,
        name = this.name,
        age = this.age,
        description = description,
        image = image
    )

fun AuthorDto.toAuthorEntity() =
    AuthorEntity(
        id = this.id,
        name = this.name,
        age = this.age,
        description = description,
        image = image
    )

fun AuthorUpdateRequestDto.toAuthorUpdateRequest() = AuthorUpdateRequest(
    id = this.id,
    name = this.name,
    age = this.age,
    description = description,
    image = image,
)
