package com.mon0mon.bookstorebackend.domain.entities

import jakarta.persistence.*

@Entity
@Table(name = "authors")
data class AuthorEntity(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_id_seq")
    val id: Long?,
    @Column(name = "name")
    var name: String,
    @Column(name = "age")
    var age: Int,
    @Column(name = "description")
    var description: String,
    @Column(name = "image")
    var image: String,

    @OneToMany(mappedBy = "authorEntity", cascade = [CascadeType.REMOVE])
    val bookEntities: List<BookEntity> = emptyList(),
)
