package easykotlin.chapter03

import java.util.*

fun typeInference() {

    val str = "abc"
    println(str)
    println(str is String)
    println(str::class)
    println(str::class.java)
    // abc
// true
// class java.lang.String (Kotlin reflection is not available)
// class java.lang.String
    val d = Date()
    println(d)
    val bool = true
    println(bool)
    val array = arrayOf(1, 2, 3, 4)
    println(array)
    //整型变量Int不能赋值Long变量
    val x: Int = 10
    val y: Long = x.toLong()
    println(y)


}

//is 运算符检测一个表达式是否某类型的一个实例
fun getLength(obj: Any): Int? {
    var result = 0
    if (obj is String) {
        result = obj.length
    }
    return result
}