import java.io.File
import java.nio.charset.Charset

// 第15章　Kotlin 文件IO操作与多线程 455
// 15.1　Kotlin IO基本操作 455
//Kotlin的IO操作都在kotlin.io包下。
// Kotlin的原则就是Java已经有的，好用的就直接使用，
// 没有的或 者不好用的，就在原有类的基础上进行封装扩展
// 15.1.1　终端IO操作 455
//Kotlin 的封装终端IO 的类在 stdlib/src/kotlin/io/Console.kt 源文件中。
/*
这里的 println 函数Kotlin实现如下
@kotlin.internal.InlineOnly
public inline fun println(message: Any?) {
    System.out.println(message)
}
*/
//Kotlin为java.io.File提供了大量好用的扩展函数
// 15.1.2　读文件 456
//使用readText()方法，它直接返回整个文件内容。
fun getFileCount(fileName: String): String {
    val f = File(fileName)
    return f.readText(Charset.forName("UTF-8"))
}

//readLines函数，获得文件每行的内容
fun getFileLines(fileName: String): List<String> {
    return File(fileName).readLines(Charset.forName("UTF-8"))
}

//直接操作文件的字节数组，可以使用readBytes()
fun test(fileName: String) {
    val bytes: ByteArray = File(fileName).readBytes()
    println(bytes.joinToString(separator = " "))
}

// 15.1.3　写文件 457
//覆盖写文件
fun writeFile(text: String, destFile: String) {
    val f = File(destFile)
    if (!f.exists()) {
        f.createNewFile()
    }
    f.writeText(text, Charset.defaultCharset())
}

//末尾追加写文件
fun appendFile(text: String, destFile: String) {
    val f = File(destFile)
    if (!f.exists()) {
        f.createNewFile()
    }
    f.appendText(text, Charset.defaultCharset())
}
// 15.1.4　遍历文件树 458
// 15.1.5　网络IO操作 459
// 15.1.6　kotlin.io标准库 460
// 15.1.7　执行Shell命令行 461
// 15.2　正则表达式 463
// 15.2.1　构造Regex表达式 463
// 15.2.2　Regex类中的函数 463
// 15.2.3　使用Java正则表达式类 465
// 15.3　Kotlin的多线程 466
// 15.3.1　创建线程 466
// 15.3.2　同步方法和块 467
// 15.3.3　可变字段 468
