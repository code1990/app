package com.easykotlin.easykotlin.dao

import com.easykotlin.easykotlin.entity.People
import org.springframework.data.repository.CrudRepository

interface PeopleRepository : CrudRepository<People, Long> {
    fun findByLastName(lastName: String): List<People>?
}