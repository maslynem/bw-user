package ru.boardworld.user

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BwUserServiceApplication

fun main(args: Array<String>) {
    runApplication<BwUserServiceApplication>(*args)
}