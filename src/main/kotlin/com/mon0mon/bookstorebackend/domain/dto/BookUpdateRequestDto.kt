package com.mon0mon.bookstorebackend.domain.dto

data class BookUpdateRequestDto(
    var title: String? = null,
    var description: String? = null,
    var image: String? = null,
)
