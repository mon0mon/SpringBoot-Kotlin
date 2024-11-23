package com.mon0mon.bookstorebackend

import com.mon0mon.bookstorebackend.domain.dto.AuthorDto

fun testAuthorDtoA(id: Long? = null) =
    AuthorDto(
        id = null,
        name = "John Doe",
        age = 30,
        description = "Some description",
        image = "author-image.jpeg",
    )

