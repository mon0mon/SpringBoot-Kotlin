package com.mon0mon.bookstorebackend.domain

data class AuthorSummary(
    val id: Long,
    val name: String? = null,
    val image: String? = null,
)
