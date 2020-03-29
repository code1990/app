package helloworld

import java.text.SimpleDateFormat
import java.util.*

fun main(args: Array<String>) {
    println("Hello,world")
    println(SimpleDateFormat("yyyy-MM-dd").format(Date()))
}