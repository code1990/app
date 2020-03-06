/*kotlin面向对象实例*/
class Greeter(val name: String) {
    fun greet() {
        println("hello $name")
    }
}

fun main(args: Array<String>) {
//    创建一个对象不需要使用new关键字
    Greeter("world").greet()
}