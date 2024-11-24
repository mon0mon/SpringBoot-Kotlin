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
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is AuthorEntity) return false

        if (id != other.id) return false
        if (name != other.name) return false
        if (age != other.age) return false
        if (description != other.description) return false
        if (image != other.image) return false
//        if (bookEntities != other.bookEntities) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + name.hashCode()
        result = 31 * result + age
        result = 31 * result + description.hashCode()
        result = 31 * result + image.hashCode()
        result = 31 * result + bookEntities.hashCode()
        return result
    }
}
