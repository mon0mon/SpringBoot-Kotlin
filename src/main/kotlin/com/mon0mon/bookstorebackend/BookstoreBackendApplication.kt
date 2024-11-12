package com.mon0mon.bookstorebackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BookstoreBackendApplication

fun main(args: Array<String>) {
    runApplication<BookstoreBackendApplication>(*args)
}
