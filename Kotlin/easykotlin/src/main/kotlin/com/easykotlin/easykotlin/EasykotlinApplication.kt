package com.easykotlin.easykotlin

import com.easykotlin.easykotlin.dao.ArticleRepository
import com.easykotlin.easykotlin.dao.PeopleRepository
import com.easykotlin.easykotlin.entity.Article
import com.easykotlin.easykotlin.entity.People
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import java.util.*

@SpringBootApplication
class EasykotlinApplication {
    private val log = LoggerFactory.getLogger(EasykotlinApplication::class.java)
    @Bean
    fun init(repository: ArticleRepository) = CommandLineRunner {
        val article: Article = Article()
        article.author = "kotlin"
        article.title = "easy kotlin${Date()}"
        article.content = "easy kotlin${Date()}"
        repository.save(article)
    }

    @Bean
    fun initPeople(repository: PeopleRepository) = CommandLineRunner {
        val now = Date()
        repository.save(People(null, "Jason", "Chen", "Male", 28, now, now))
        repository.save(People(null, "Bluce", "Li", "Male", 32, now, now))
        repository.save(People(null, "Corey", "Chen", "Female", 20, now, now))

        for (people in repository.findAll()!!) {
            log.info(people.toString())
        }
        val customer = repository.findById(1L)
        log.info(customer.toString())
        for (chen in repository.findByLastName("chen")!!) {
            log.info(chen.toString())
        }
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(EasykotlinApplication::class.java, *args)
}
