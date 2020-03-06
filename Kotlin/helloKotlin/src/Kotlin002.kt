//Kotlin 基础语法

//包声明
//代码文件的开头一般为包的声明：package com.runoob.main
//Kotlin源文件可以放在任何文件目录
//如果没有指定包，默认为 default 包。
//默认导入
//有多个包会默认导入到每个 Kotlin 文件中：
//
//kotlin.*
//kotlin.annotation.*
//kotlin.collections.*
//kotlin.comparisons.*
//kotlin.io.*
//kotlin.ranges.*
//kotlin.sequences.*
//kotlin.text.*


//函数定义
//函数定义使用关键字 fun，参数格式为：参数 : 类型
fun sum(a: Int, b: Int): Int {//Int 类型的参数 返回值类int
    return a + b//
}

//表达式作为函数体，返回类型自动推断：
fun sum2(a: Int, b: Int) = a + b

//// public 方法则必须明确写出返回类型
public fun sum3(a: Int, b: Int): Int = a + b

//无返回值的函数(类似Java中的void)：
fun printSum(a: Int, b: Int): Unit {
    print(a + b)
}

//// 如果是返回 Unit类型，则可以省略(对于public方法也是这样)：
public fun printSum2(a: Int, b: Int) {
    print(a + b)
}

//可变长参数函数 用 vararg 关键字进行标识：
fun vars(vararg v: Int) {
    for (vt in v) {
        print(vt)
    }
}


//测试
fun main(args: Array<String>) {
    //lambda表达式使用实例：
    val sumLamda: (Int, Int) -> Int = { x, y -> x + y }
    print(sumLamda(1, 2))
    vars(1, 2, 3, 4, 5)
    //定义常量与变量
    //可变变量定义：var 关键字
    //不可变变量定义：val 关键字，只能赋值一次的变量(类似Java中final修饰的变量)
    val a: Int = 1
    val b = 1//系统自动推断类型
    val c: Int//如果不在声明时初始化则必须提供变量类型
    c = 2//明确赋值

    var x = 5//系统自动推断类型
    x += 1//变量可以修改

    //注释
// 这是一个单行注释
// Kotlin 中的块注释允许嵌套
/* 这是一个多行的
   块注释。 */

//    字符串模板
    var a1 = 1
    // 模板中的简单名称：
    val s1 = "a is $a1"
    //模板中的任意表达式
    val a2 = 2
    val s2 = "${s1.replace("is", "was")},but now is $a2"
    print(s1)
    print(s2)
//    NULL检查机制
//Kotlin的空安全设计对于声明可为空的参数，在使用时要进行空判断处理，有两种处理方式，
// 字段后加!!像Java一样抛出空异常
// 字段后加?可不做处理返回值为 null或
// 配合?:做空判断处理
//    //类型后面加?表示可为空
    var age: String? = "23"
    //抛出空指针异常
    val ages = age!!.toInt()
    //不做任何处理返回null
    val ages1 = age?.toInt()
    //age为空返回-1
    val ages2 = age?.toInt() ?: -1

    val xx = 1
    val yy = 2
    //直接使用 `x * y` 会导致错误, 因为它们可能为 null
    if (xx != null && yy != null) {
        // 在进行过 null 值检查之后, x 和 y 的类型会被自动转换为非 null 变量
        print(xx * yy)
    }
//区间表达式由具有操作符形式 .. 的 rangeTo 函数辅以 in 和 !in 形成。
    for (i in 1..4) print(i)//输出“1234”
    for (i in 4..1) print(i)//什么都不输出
    var ii: Int = 0
    if (ii in 1..10) { // 等同于 1 <= i && i <= 10
        println(ii)
    }
    // 使用 step 指定步长
    for (i in 1..4 step 2) print(i)
    //使用 downTo
    for (i in 4 downTo 1 step 2) print(i)//输出42
    //util函数排除结束元素
    for(i in 1 until 10){ // i in [1, 10) 排除了 10
        print(i)
    }

}

//类型检测及自动类型转换
//我们可以使用 is 运算符检测一个表达式是否某类型的一个实例(类似于Java中的instanceof关键字)。
fun getStringLength(obj: Any): Int? {
    if (obj is String) {
        // 做过类型判断以后，obj会被系统自动转换为String类型
        return obj.length
    }
    //obj仍然是Any类型的引用
    return null
}

fun getStringLength2(obj: Any): Int? {
    //与Java中instanceof不同，使用!is
    if (obj !is String) {
        return null
    }
    // 在这个分支中, `obj` 的类型会被自动转换为 `String`
    return obj.length
}

fun getStringLength3(obj: Any): Int? {
    // 在&&的左侧 obj的类型会被自动转换为String
    if (obj is String && obj.length > 0) {
        return obj.length
    }
    return null
}