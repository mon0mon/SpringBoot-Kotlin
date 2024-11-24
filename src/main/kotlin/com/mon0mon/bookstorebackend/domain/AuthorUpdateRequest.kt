package com.mon0mon.bookstorebackend.domain

data class AuthorUpdateRequest(
    val id: Long? = null,
    var name: String? = null,
    var age: Int? = null,
    var description: String? = null,
    var image: String? = null,
)
