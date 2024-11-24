package com.mon0mon.bookstorebackend.domain

data class BookUpdateRequest(
    var title: String?,
    var description: String?,
    var image: String?,
)
