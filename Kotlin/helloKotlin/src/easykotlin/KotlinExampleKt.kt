package easykotlin

fun f1() {
    println("f1")
}

fun f2() {
    println("f2")
}

//val p: String = "PPP"
//Kotlin中的扩展函数
fun String.swap(index1: Int, index2: Int): String {
    val strArray = this.toCharArray()
    val tmp = strArray[index1]
    strArray[index1] = strArray[index2]
    strArray[index2] = tmp

    var result = ""
    strArray.forEach { result += it }
    return result
}

fun main(args: Array<String>) {
    println("abc".swap(0,2))
}
