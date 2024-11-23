package com.mon0mon.bookstorebackend.controllers

import com.fasterxml.jackson.databind.ObjectMapper
import com.mon0mon.bookstorebackend.domain.entities.AuthorEntity
import com.mon0mon.bookstorebackend.services.AuthorService
import com.mon0mon.bookstorebackend.testAuthorDtoA
import com.mon0mon.bookstorebackend.testAuthorEntityA
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import io.mockk.verify
import org.hamcrest.CoreMatchers.equalTo
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.BeforeEach
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post

private const val AUTHORS_BASE_URL = "/v1/authors"

@SpringBootTest
@AutoConfigureMockMvc
class AuthorsControllerTest @Autowired constructor(
    private val mockMvc: MockMvc,
    @MockkBean
    private val authorService: AuthorService,
) {
    val objectMapper = ObjectMapper()

    @BeforeEach
    fun extracted() {
        every {
            authorService.create(any())
        } answers {
            firstArg()
        }
    }

    @Test
    fun `test that create Author saves the Author`() {
        extracted()

        mockMvc.post(AUTHORS_BASE_URL) {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(testAuthorDtoA())
        }

        val expected = AuthorEntity(
            id = null,
            name = "John Doe",
            age = 30,
            description = "Some description",
            image = "author-image.jpeg",
        )

        verify { authorService.create(expected) }
    }

    @Test
    fun `test that create author returns a HTTP 201 status on a successful create`() {
        mockMvc.post(AUTHORS_BASE_URL) {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(testAuthorDtoA())
        }.andExpect {
            status { isCreated() }
        }
    }

    @Test
    fun `test that list returns an empty list and HTTP 200 when no authors in the database`() {
        every {
            authorService.list()
        } answers {
            emptyList()
        }

        mockMvc.get(AUTHORS_BASE_URL) {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isOk() }
            content { json("[]") }
        }
    }

    @Test
    fun `test that list returns authors and HTTP 200 when authors in the database`() {
        every {
            authorService.list()
        } answers {
            listOf(testAuthorEntityA(1))
        }

        mockMvc.get(AUTHORS_BASE_URL) {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isOk() }
            content { jsonPath("$[0].id", equalTo(1)) }
            content { jsonPath("$[0].name", equalTo("John Doe")) }
            content { jsonPath("$[0].age", equalTo(30)) }
            content { jsonPath("$[0].description", equalTo("Some description")) }
            content { jsonPath("$[0].image", equalTo("author-image.jpeg")) }
        }
    }

    @Test
    fun `test that get returns HTTP 404 when author not found in dtabase`() {
        every {
            authorService.get(any())
        } answers {
            null
        }

        mockMvc.get("$AUTHORS_BASE_URL/999") {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isNotFound() }
        }
    }

    @Test
    fun `test that get returns HTTP 200 author when author found`() {
        every {
            authorService.get(any())
        } answers {
            testAuthorEntityA(id = 999)
        }

        mockMvc.get("$AUTHORS_BASE_URL/999") {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isOk() }
            content { jsonPath("$.id", equalTo(999)) }
            content { jsonPath("$.name", equalTo("John Doe")) }
            content { jsonPath("$.age", equalTo(30)) }
            content { jsonPath("$.description", equalTo("Some description")) }
            content { jsonPath("$.image", equalTo("author-image.jpeg")) }
        }
    }
}
