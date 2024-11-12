package com.mon0mon.bookstorebackend.domain

data class Book(
    val isbn: String,
    var title: String,
    var description: String,
    var image: String,
    var author: Author,
)
