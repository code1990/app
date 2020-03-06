import java.lang.IllegalArgumentException

//Kotlin 基本数据类型
//Kotlin 的基本数值类型包括 Byte、Short、Int、Long、Float、Double 等。
// 不同于 Java 的是，字符不属于数值类型，是一个独立的数据类型
//字面常量
//下面是所有类型的字面常量
//Kotlin 同时也支持传统符号表示的浮点数值：
fun main(args: Array<String>) {
    //字面常量
    val oneMillion = 1_000_000
    val creditCardNumber = 1234_5678_9012_3456L
    val socialSecurityNumber = 999_99_9999L
    val hexBytes = 0xFF_EC_DE_5E
    val bytes = 0b11010010_01101001_10010100_10010010
    print(oneMillion)
    print(creditCardNumber)
    print(socialSecurityNumber)
    print(hexBytes)
    print(bytes)
    //比较两个数字
    //Kotlin 中没有基础数据类型，只有封装的数字类型，
    // 你每定义的一个变量，其实 Kotlin 帮你封装了一个对象，这样可以保证不会出现空指针
    //在 Kotlin 中，三个等号 === 表示比较对象地址，两个 == 表示比较两个值大小。
    val a: Int = 1000
    print(a === a)//对象的地址相等
    val boxedA: Int? = a
    val anotherBoxedA: Int = a
    //虽然经过了装箱，但是值是相等的，都是10000
    println(boxedA === anotherBoxedA) //  false，值相等，对象地址不一样
    println(boxedA == anotherBoxedA) // true，值相等

    //类型转换
    //由于不同的表示方式，较小类型并不是较大类型的子类型，较小的类型不能隐式转换为较大的类型
    val b: Byte = 1//OK, 字面值是静态检测的
    val i: Int = b.toInt()//
    /*
    * toByte(): Byte
    toShort(): Short
    toInt(): Int
    toLong(): Long
    toFloat(): Float
    toDouble(): Double
    toChar(): Char
    * */
//有些情况下也是可以使用自动类型转化的，前提是可以根据上下文环境推断出正确的数据类型而且数学操作符会做相应的重载
    val ll = 1L + 3
    //位操作符
    //对于Int和Long类型，还有一系列的位操作符可以使用，分别是：
    //
    //shl(bits) – 左移位 (Java’s <<)
    //shr(bits) – 右移位 (Java’s >>)
    //ushr(bits) – 无符号右移位 (Java’s >>>)
    //and(bits) – 与
    //or(bits) – 或
    //xor(bits) – 异或
    //inv() – 反向

    //字符
    //Kotlin 中的 Char 不能直接和数字操作，Char 必需是单引号 ' 包含起来的。比如普通字符 '0'，'a'。

//    布尔
//布尔用 Boolean 类型表示，它有两个值：true 和 false。

    //数组
    //数组用类 Array 实现，并且还有一个 size 属性及 get 和 set 方法，由于使用 [] 重载了 get 和 set 方法
    //数组的创建两种方式：一种是使用函数arrayOf()；另外一种是使用工厂函数。
    val array = arrayOf(1, 2, 3)
    val array2 = Array(3, { i -> { i * 2 } })
    //读取数组内容
    //[] 运算符代表调用成员函数 get() 和 set()
    //Kotlin 中数组是不型变的（invariant）。
    //除了类Array，还有ByteArray, ShortArray, IntArray，用来表示各个类型的数组，省去了装箱操作，因此效率更高，其用法同Array一样：
    print(array[0])
    print(array2[1])
    val x: IntArray = intArrayOf(1, 2, 3)
    x[0] = x[1] + x[2]
    print(x.toString())
    //字符串
    //和 Java 一样，String 是不可变的。方括号 [] 语法可以很方便的获取字符串中的某个字符，也可以通过 for 循环来遍历：
    for (c in "hello") {
        print(c)
    }
    //Kotlin 支持三个引号 """ 扩起来的字符串，支持多行字符串，比如：
    val text = """
    多行字符串
    多行字符串
    """
    println(text)   // 输出有一些前置空格
    //String 可以通过 trimMargin() 方法来删除多余的空白。
    println(text.trimMargin())
    //字符串模板
    //字符串可以包含模板表达式 ，即一些小段代码，会求值并把结果合并到字符串中。
    // 模板表达式以美元符（$）开头，由一个简单的名字构成:
    val i1 = 10
    val s = "i1= $i1"
    print(s)
    //用花括号扩起来的任意表达式
    val ss = "hellokotlin"
    val str = "$ss.length is ${ss.length}"
    print(str)
    val price = """
    ${'$'}9.99
    """
    println(price)  // 求值结果为 $9.99

}

//显式把字符转换为 Int 数字：
fun decimalDigitValue(c: Char): Int {
    if (c !in '0'..'9') {
        throw IllegalArgumentException("out of range")
    }
    return c.toInt()
}