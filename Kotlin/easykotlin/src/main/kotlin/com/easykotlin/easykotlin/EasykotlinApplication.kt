package com.easykotlin.easykotlin

import com.easykotlin.easykotlin.dao.ArticleRepository
import com.easykotlin.easykotlin.entity.Article
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import java.util.*

@SpringBootApplication
class EasykotlinApplication {
    @Bean
    fun init(repository: ArticleRepository) = CommandLineRunner {
        val article: Article = Article()
        article.author = "kotlin"
        article.title = "easy kotlin${Date()}"
        article.content = "easy kotlin${Date()}"
        repository.save(article)
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(EasykotlinApplication::class.java, *args)
}
