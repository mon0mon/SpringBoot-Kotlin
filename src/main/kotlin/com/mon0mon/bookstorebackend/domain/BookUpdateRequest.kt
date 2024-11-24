package com.mon0mon.bookstorebackend.domain

data class BookUpdateRequest(
    var title: String? = null,
    var description: String? = null,
    var image: String? = null,
)
