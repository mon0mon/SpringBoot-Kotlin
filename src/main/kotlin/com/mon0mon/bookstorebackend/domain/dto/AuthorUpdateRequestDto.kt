package com.mon0mon.bookstorebackend.domain.dto

data class AuthorUpdateRequestDto(
    val id: Long?,
    var name: String?,
    var age: Int?,
    var description: String?,
    var image: String?,
)
