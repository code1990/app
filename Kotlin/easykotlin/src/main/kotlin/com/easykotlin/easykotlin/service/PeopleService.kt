package com.easykotlin.easykotlin.service

import com.easykotlin.easykotlin.dao.PeopleRepository
import com.easykotlin.easykotlin.entity.People
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class PeopleService : PeopleRepository {

    @Autowired
    val peopleRepository: PeopleRepository? = null

    override fun <S : People?> save(p0: S): S {
        return peopleRepository!!.save(p0)
    }

    override fun findByLastName(lastName: String): List<People>? {
        return peopleRepository?.findByLastName(lastName)
    }

    override fun findAll(): MutableIterable<People> {
        return peopleRepository!!.findAll();
    }

    override fun deleteById(id: Long) {
        peopleRepository?.deleteById(id)
    }

    override fun deleteAll(entity: MutableIterable<People>) {
        peopleRepository?.deleteAll(entity)
    }

    override fun deleteAll() {
        peopleRepository?.deleteAll()
    }

    override fun <S : People?> saveAll(entity: MutableIterable<S>): MutableIterable<S> {
        return peopleRepository!!.saveAll(entity)
    }

    override fun count(): Long {
        return peopleRepository!!.count()
    }

    override fun findAllById(entity: MutableIterable<Long>): MutableIterable<People> {
        return peopleRepository!!.findAllById(entity)
    }

    override fun existsById(id: Long): Boolean {
        return peopleRepository!!.existsById(id)
    }

    override fun findById(id: Long): Optional<People> {
        return peopleRepository!!.findById(id)
    }

    override fun delete(entity: People) {
        return peopleRepository!!.delete(entity)
    }

}