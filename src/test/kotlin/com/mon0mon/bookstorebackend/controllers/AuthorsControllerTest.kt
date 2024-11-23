package com.mon0mon.bookstorebackend.controllers

import com.fasterxml.jackson.databind.ObjectMapper
import com.mon0mon.bookstorebackend.domain.dto.AuthorDto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post

@SpringBootTest
@AutoConfigureMockMvc
class AuthorsControllerTest @Autowired constructor(
    private val mockMvc: MockMvc,
) {
    val objectMapper = ObjectMapper()

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
