package com.mon0mon.bookstorebackend.domain.entities

import jakarta.persistence.*

@Entity
@Table(name = "books")
data class BookEntity(
    @Id
    @Column(name = "isbn")
    val isbn: String,
    @Column(name = "title")
    var title: String,
    @Column(name = "description")
    var description: String,
    @Column(name = "image")
    var image: String,
    @ManyToOne(cascade = [CascadeType.DETACH])
    @JoinColumn(name = "author_id")
    var authorEntity: AuthorEntity,
)
