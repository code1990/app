package com.easykotlin.easykotlin.entity

import javax.persistence.*
import java.util.*

@Entity
class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = -1
    @Version
    var version: Long = 0
    var title: String = ""
    var content: String = ""
    var author: String = ""
    var gmtCreated: Date = Date()
    var gmtModified: Date = Date()
    var isDeleted: Int = 0//1yes 0 no
    var deletedDate: Date = Date()

    override fun toString(): String {
        return "Blog(id=$id, version=$version, title='$title', content='$content', author='$author', gmtCreated=$gmtCreated, gmtModified=$gmtModified, isDeleted=$isDeleted, deletedDate=$deletedDate)"
    }
}