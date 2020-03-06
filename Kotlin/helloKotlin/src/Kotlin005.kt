//Kotlin 循环控制
//for 循环可以对任何提供迭代器（iterator）的对象进行遍历
//for (item in collection) print(item)
//循环体可以是一个代码块:
//for (item: Int in ints) {}
//如果你想要通过索引遍历一个数组或者一个 list，你可以这么做：
//for (i in array.indices) {}
//或者你可以用库函数 withIndex：
//for ((index, value) in array.withIndex()) {}
fun main(args: Array<String>) {
    val items = listOf<String>("apple", "banana", "kiwi")
    for (item in items) {
        println(item)
    }
    for (index in items.indices) {
        println("item at $index is ${items[index]}")
    }
    for ((index, value) in items.withIndex()) {
        println(index)
        println(value)
    }
    //while 与 do...while 循环
    //do…while 循环至少会执行一次。
    var x = 5
    while (x > 0) {
        print(x--)
    }
    var y = 5
    do {
        print(y--)
    } while (y > 0)
    //返回和跳转
    //Kotlin 有三种结构化跳转表达式：
    //
    //return。默认从最直接包围它的函数或者匿名函数返回。
    //break。终止最直接包围它的循环。
    //continue。继续下一次最直接包围它的循环。
    for (i in 1..10) {
        if (i == 3) continue
        print(i)
        if (i > 5) break
    }
    // 标签的格式为标识符后跟 @ 符号，例如：abc@、fooBar@都是有效的标签
    // 要为一个表达式加标签，我们只要在其前加标签即可。
    //我们可以用标签限制 break 或者continue：
    loop@ for (i in 1..100){
        for (j in 1..100){
            if(i==j && j ==10) break@loop
        }
    }
    //Kotlin 有函数字面量、局部函数和对象表达式。
    // 因此 Kotlin 的函数可以被嵌套。 标签限制的 return 允许我们从外层函数返回
    //通常情况下使用隐式标签更方便。 该标签与接受该 lambda 的函数同名

}
