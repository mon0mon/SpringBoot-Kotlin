package com.mon0mon.bookstorebackend.services.impl

import com.mon0mon.bookstorebackend.domain.entities.AuthorEntity
import com.mon0mon.bookstorebackend.repositories.AuthorRepository
import com.mon0mon.bookstorebackend.testAuthorEntityA
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.repository.findByIdOrNull

@SpringBootTest
class AuthorServiceImplTest @Autowired constructor(
    private val underTest: AuthorServiceImpl,
    private val authorRepository: AuthorRepository,
) {

    @Test
    fun `test that save persists the Author in the database`() {
        val savedAuthor = underTest.save(testAuthorEntityA())
        assertThat(savedAuthor.id).isNotNull()

        val recalledAuthor = authorRepository.findByIdOrNull(savedAuthor.id!!)
        assertThat(recalledAuthor).isNotNull()
        assertThat(recalledAuthor!!).isEqualTo(
            testAuthorEntityA(id = savedAuthor.id)
        )
    }

    @Test
    fun `test that list returns empty list when no authors in the database`() {
        val result = underTest.list()
        assertThat(result).isEmpty()
    }

    @Test
    fun `test that list returns authors when authors present in the database`() {
        val savedAuthor = authorRepository.save(testAuthorEntityA())
        val expected = listOf(savedAuthor)
        val result = underTest.list()
        assertThat(result).isEqualTo(expected)
    }
}