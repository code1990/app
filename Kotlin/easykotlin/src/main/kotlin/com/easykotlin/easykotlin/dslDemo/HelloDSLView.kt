package com.easykotlin.easykotlin.dslDemo

import org.springframework.stereotype.Service

@Service
class HelloDSLView {
    fun html():String{
        return "createHtml().html()"
//        return createHtml().html()
    }
}