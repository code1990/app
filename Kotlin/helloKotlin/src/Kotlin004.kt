//Kotlin 条件控制
//IF 表达式
//一个 if 语句包含一个布尔表达式和一条或多条语句。


fun main(args: Array<String>) {
    val a = 1
    val b = 1
    var max: Int = 0
    //传统用法
    if (a < b) max = b
    print(max)
    //使用else
    if (a > b) {
        max = a
    } else {
        max = b
    }
    print(max)
    // 作为表达式
    val max2 = if (a > b) a else b
    println(max2)
    //也可以把 IF 表达式的结果赋值给一个变量。
    val max3 = if (a > b) {
        print("choose a")
        a
    } else {
        print("choose b")
        b
    }
    print(max3)
    val c = if (a > b) a else b
    print(c)

    var x = 0
    if (x > 0) {
        print("x 大于0")
    } else if (x == 0) {
        print("x==0")
    } else {
        print("x<0")
    }
    print("c is $c")
    print("x is $x")

    //使用区间
    //使用 in 运算符来检测某个数字是否在指定区间内，区间格式为 x..y
    val xx = 5
    val yy = 9
    if (x in 1..8) {
        print("x 在区间范围内")
    }
    //when 类似其他语言的 switch 操作符。其最简单的形式如下：
    when (x) {
        1 -> print("x==1")
        2 -> print("x==2")
        //在 when 中，else 同 switch 的 default。
        else -> {
            print("x is 1,not is 2")
        }
    }

    //如果很多分支需要用相同的方式处理，则可以把多个分支条件放在一起，用逗号分隔：
    when (x) {
        0, 1 -> print("x==0 or x==1")
        else -> print("otherwise")
    }

    //我们也可以检测一个值在（in）或者不在（!in）一个区间或者集合中：
    when (x) {
        in 1..10 -> print("x is in the range")
        !in 10..20 -> print("x is in the range")
        else -> print("none of the above")
    }

    //when 也可以用来取代 if-else if链。
    when {
        x % 2 == 0 -> print("x is odd")
        x % 2 != 0 -> print("x is even")
        else -> print("x is funny")
    }

    val items = setOf("apple", "banana", "kiwi")
    when {
        "orange" in items -> println("juicy")
        "apple" in items -> println("apple if fine too")
    }
}

//另一种可能性是检测一个值是（is）或者不是（!is）一个特定类型的值。
fun hasPrefix(x: Any) = when (x) {
    is String -> x.startsWith("prefix")
    else -> false
}