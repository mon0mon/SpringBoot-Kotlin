package com.mon0mon.bookstorebackend.controllers

import com.fasterxml.jackson.databind.ObjectMapper
import com.mon0mon.bookstorebackend.domain.dto.AuthorDto
import com.mon0mon.bookstorebackend.domain.entities.AuthorEntity
import com.mon0mon.bookstorebackend.services.AuthorService
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import io.mockk.verify
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post

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
            authorService.save(any())
        } answers {
            firstArg()
        }
    }

    @Test
    fun `test that create Author saves the Author`() {
        extracted()

        mockMvc.post("/v1/authors") {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(
                AuthorDto(
                    id = null,
                    name = "John Doe",
                    age = 30,
                    image = "author-image.jpeg",
                    description = "some-description.jpeg"
                )
            )
        }

        val expected = AuthorEntity(
            id = null,
            name = "John Doe",
            age = 30,
            image = "author-image.jpeg",
            description = "some-description.jpeg"
        )

        verify { authorService.save(expected) }
    }

    @Test
    fun `test that create author returns a HTTP 201 status on a successful create`() {
        mockMvc.post("/v1/authors") {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(
                AuthorDto(
                    id = null,
                    name = "John Doe",
                    age = 30,
                    image = "author-image.jpeg",
                    description = "some-description.jpeg"
                )
            )
        }.andExpect {
            status { isCreated() }
        }
    }
}
