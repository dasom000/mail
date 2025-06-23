package com.main.dasom

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DasomApplication

fun main(args: Array<String>) {
	runApplication<DasomApplication>(*args)
}
