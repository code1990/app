package easykotlin.chapter03

fun main(args: Array<String>) {
    val rawString = """
        11111
    """.trimIndent()
    println(rawString)
    val tmp = "$rawString has ${rawString.length}"
    println(tmp)
}