package com.mon0mon.bookstorebackend.controllers

import com.fasterxml.jackson.databind.ObjectMapper
import com.mon0mon.bookstorebackend.services.impl.BookServiceImpl
import com.mon0mon.bookstorebackend.testAuthorEntityA
import com.mon0mon.bookstorebackend.testAuthorSummaryDtoA
import com.mon0mon.bookstorebackend.testBookEntityA
import com.mon0mon.bookstorebackend.testBookSummaryDtoA
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.put
import org.springframework.test.web.servlet.result.StatusResultMatchersDsl

@SpringBootTest
@AutoConfigureMockMvc
class BooksControllerTest @Autowired constructor(
    private val mockMvc: MockMvc,
    @MockkBean val bookService: BookServiceImpl,
) {
    val objectMapper = ObjectMapper()

    @Test
    fun `test that createFullUpdateBook return HTTP 201 when book is created`() {
        assertThatUserCreatedUpdated(true) { isCreated() }
    }

    @Test
    fun `test that createFullUpdateBook return HTTP 200 when book is created`() {
        assertThatUserCreatedUpdated(false) { isOk() }
    }

    @Test
    fun `test that createFullUpdateBook return HTTP 500 when author in the database does not have an ID`() {
        val isbn = "978-063-666162-0142"
        val author = testAuthorEntityA()
        val savedBook = testBookEntityA(isbn, author)

        val authorSummaryDto = testAuthorSummaryDtoA(id = 1)
        val bookSummaryDto = testBookSummaryDtoA(isbn, authorSummaryDto)

        every {
            bookService.createUpdate(isbn, any())
        } answers {
            Pair(savedBook, true)
        }

        mockMvc.put("/v1/books/$isbn") {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(bookSummaryDto)
        }.andExpect {
            status { isInternalServerError() }
        }
    }

    @Test
    fun `test that createFullUpdateBook returns HTTP 400 when author does not exist`() {
        val isbn = "978-063-666162-0142"

        val authorSummaryDto = testAuthorSummaryDtoA(id = 1)
        val bookSummaryDto = testBookSummaryDtoA(isbn, authorSummaryDto)

        every {
            bookService.createUpdate(isbn, any())
        } throws (IllegalStateException())

        mockMvc.put("/v1/books/$isbn") {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(bookSummaryDto)
        }.andExpect {
            status { isBadRequest() }
        }
    }

    private fun assertThatUserCreatedUpdated(
        isCreated: Boolean,
        statusCodeAssertion: StatusResultMatchersDsl.() -> Unit,
    ) {
        val isbn = "978-063-666162-0142"
        val author = testAuthorEntityA(id = 1)
        val savedBook = testBookEntityA(isbn, author)

        val authorSummaryDto = testAuthorSummaryDtoA(id = 1)
        val bookSummaryDto = testBookSummaryDtoA(isbn, authorSummaryDto)

        every {
            bookService.createUpdate(isbn, any())
        } answers {
            Pair(savedBook, isCreated)
        }

        mockMvc.put("/v1/books/$isbn") {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(bookSummaryDto)
        }.andExpect {
            status { statusCodeAssertion() }
        }
    }
}
