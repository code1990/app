package easykotlin.chapter03
//在 *.kt 文件开头声明 package 命名空间
//声明了包 com.easy.kotlin , 里面定义了包级函数
//what() , 同时定义了一个类 Motorbike 。另外，目录与包的结构无需匹配：源代码可以在文件
//系统的任意位置。
fun what() {
    println("Hello,World")
}

class MotorBike {
    fun drive() {
        println("drive the bike")
    }
}

fun main(args: Array<String>) {
    println("hello,World")
}