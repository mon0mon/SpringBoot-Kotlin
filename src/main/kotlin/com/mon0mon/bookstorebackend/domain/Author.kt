package com.mon0mon.bookstorebackend.domain

data class Author(
    val id: Long?,
    var name: String,
    var age: Int,
    var description: String,
    var image: String,
)
