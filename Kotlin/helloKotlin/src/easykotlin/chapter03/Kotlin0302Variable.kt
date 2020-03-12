package easykotlin.chapter03

//只要可能，尽量在Kotlin中首选使用 val 不变值
class C0302Variable {
    fun declareVar() {
        var a = 2
        a = 1
        println(a)
        println(a::class)
        println(a::class.java)

        var x = 5//自动推断类型
        x += 1
        println("x=$x")
    }

    fun declareVal() {
        val b = "a"
        println(b)
        println(b::class)
        println(b::class.java)

        val c: Int = 1//立即赋值
        val d = 2//自动推荐类型
        val e: Int//Kotlin的变量分为 var (可变的) 和 val (不可变的)。
        e = 0//明确赋值
        println("c = $c, d = $d, e = $e")
    }
}