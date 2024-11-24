package com.mon0mon.bookstorebackend

import com.mon0mon.bookstorebackend.domain.AuthorUpdateRequest
import com.mon0mon.bookstorebackend.domain.dto.AuthorDto
import com.mon0mon.bookstorebackend.domain.dto.AuthorUpdateRequestDto
import com.mon0mon.bookstorebackend.domain.entities.AuthorEntity

fun testAuthorDtoA(id: Long? = null) =
    AuthorDto(
        id = id,
        name = "John Doe",
        age = 30,
        description = "Some description",
        image = "author-image.jpeg",
    )

fun testAuthorEntityA(id: Long? = null) =
    AuthorEntity(
        id = id,
        name = "John Doe",
        age = 30,
        description = "Some description",
        image = "author-image.jpeg",
    )

fun testAuthorEntityB(id: Long? = null) =
    AuthorEntity(
        id = id,
        name = "Donh Joe",
        age = 65,
        description = "Some other description",
        image = "some-other-image.jpeg",
    )

fun testAuthorUpdateRequestDtoA(id: Long? = null) = AuthorUpdateRequestDto(
    id = id,
    name = "John Doe",
    age = 30,
    description = "Some description",
    image = "author-image.jpeg",
)

fun testAuthorUpdateRequestA(id: Long? = null) = AuthorUpdateRequest(
    id = id,
    name = "John Doe",
    age = 30,
    description = "Some description",
    image = "author-image.jpeg",
)
