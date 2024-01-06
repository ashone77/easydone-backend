package com.scorp.easydone

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EasydoneApplication

fun main(args: Array<String>) {
	runApplication<EasydoneApplication>(*args)
}
