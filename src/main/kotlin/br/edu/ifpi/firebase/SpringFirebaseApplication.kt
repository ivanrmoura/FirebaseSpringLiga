package br.edu.ifpi.firebase

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.core.io.ResourceLoader
import java.io.File

@SpringBootApplication
class SpringFirebaseApplication

fun main(args: Array<String>) {
	runApplication<SpringFirebaseApplication>(*args)
}
