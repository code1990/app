import org.junit.Test
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader
import java.net.URL
import java.nio.charset.Charset
import kotlin.concurrent.thread

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
//遍历文件树需要调用扩展方法walk()。 它会返回一个FileTreeWalk对象，它有一些方法用于设置遍历方向和深度
fun traverseFile(fileName: String) {
    val f = File(fileName)
    val fileTreeWalk = f.walk()
    fileTreeWalk.iterator().forEach {
        println(it.absolutePath)
    }
}

//我们还可以遍历当前文件下面所有子目录文件，存入一个 Iterator 中
fun getFileIterator(fileName: String): Iterator<File> {
    val f = File(fileName)
    val fileTreeWalk = f.walk()
    return fileTreeWalk.iterator()
}

//遍历当前文件下面所有子目录文件，还可以根据条件过滤，并把结果存入一个 Sequence 中
fun getFileSequenceBy(fileName: String, p: (File) -> Boolean): Sequence<File> {
    val f = File(fileName)
    return f.walk().filter(p)
}

// 15.1.5　网络IO操作 459
//Kotlin为java.net.URL增加了两个扩展方法，readBytes和readText。
// 我们可以方便的使用这两个方法 配合正则表达式实现网络爬虫的功能。
//根据 url 获取该 url 的响应 HTML函数
fun getUrlContent(url: String): String {
    return URL(url).readText(Charset.defaultCharset())
}

//根据 url 获取该 url 响应比特数组函数
fun getUrlBytes(url: String): ByteArray {
    return URL(url).readBytes()
}

//把 url 响应字节数组写入文件
fun writeUrlBytesTo(fileName: String, url: String) {
    val bytes = URL(url).readBytes()
    File(fileName).writeBytes(bytes)
}

// 15.1.6　kotlin.io标准库 460
//Kotlin 的 io 库主要是扩展 Java 的 io 库
//appendBytes追加字节数组到该文件中
//appendText追加文本到该文件中
//bufferedReader获取该文件的BufferedReader
//bufferedWriter获取该文件的BufferedWriter
//copyRecursively复制该文件或者递归复制该目录及其所有子文件到指定路径，如果指定路径下的文件不存在，会自动创建。
// 15.1.7　执行Shell命令行 461
//Kotlin 中的文件 IO，网络 IO 操作跟 Groovy一样简单
//我们来扩展 String 的 execute() 函数
fun String.execute(): Process {
    val runtime = Runtime.getRuntime()
    return runtime.exec(this)
}

//来给 Process 类扩展一个 text函数
fun Process.text(): String {
    var output = ""
    //输出shell执行的结果
    val inputStream = this.inputStream
    val isr = InputStreamReader(inputStream)
    val reader = BufferedReader(isr)
    var line: String? = ""
    while (line != null) {
        line = reader.readLine()
        output += line + "\n"
    }
    return output
}

// 15.2　正则表达式 463
//Kotlin 还提供了一个正则 表达式类 kotlin/text/regex/Regex.kt ，我们通过 Regex 的构造函数来创建一个正则表达式
//使用Regex构造函数
fun testRegex() {
    val r1 = Regex("[a-z]+")
    val r2 = Regex("[a-z]+", RegexOption.IGNORE_CASE)
    //使用 String 的 toRegex 扩展函数
    val r3 = "[A-Z]+".toRegex()
}

// 15.2.1　构造Regex表达式 463
// 15.2.2　Regex类中的函数 463
//matches(): Boolean输入字符串全部匹配
//containsMatchIn(): Boolean输入字符串至少有一个匹配
//matchEntire(): MatchResult?输入字符串全部匹配，返回一个匹配结果对象
//replace():把输入字符串中匹配的部分替换成replacement的内容
//replace():把输入字符串中匹配到的值，用函数transform映射之后的新值替换
//find():返回输入字符串中第一个匹配的值
//findAll():返回输入字符串中所有匹配的值Result的序列
//matches输入字符串全部匹配正则表达式返回 true , 否则返回 false
fun testMatches() {
    val r1 = Regex("[a-z]+")
    println(r1.matches("ABCzxc"))
    val r2 = Regex("[a-z]+", RegexOption.IGNORE_CASE)
    println(r2.matches("ABCzxc"))
    val r3 = "[A-Z]+".toRegex()
    println(r3.matches("GGMM"))
}

//containsMatchIn 输入字符串中至少有一个匹配就返回true，没有一个匹配就返回false
fun testContainsMatchIn() {
    val re = Regex("[0-9]+")
    println(re.containsMatchIn("012Abc"))
    println(re.containsMatchIn("Abc"))
}

//matchEntire//输入字符串全部匹配正则表达式返回 一个MatcherMatchResult对象，否则返回 null
fun testMatchEntire() {
    val re = Regex("[0-9]+")
    println(re.matchEntire("1234567890"))
    println(re.matchEntire("1234567890!"))
    //可空对象，所以这里我们使用了安全调用符号	?.
    println(re.matchEntire("1234567890")?.value)
}
//replace(input: CharSequence, replacement: String): String//把输入字符串中匹配的部分替换成replacement的内容
//replace(input: CharSequence, transform: (MatchResult) -> CharSequence): String把输入字符串中匹配到的值，用函数 transform映射之后的新值替换

fun testReplace() {
    val re = Regex("[0-9]+")
    println(re.replace("12345XYZ", "abcd"))
    println(re.replace("9XYZ8", { (it.value.toInt() * it.value.toInt()).toString() }))
}

//find//返回输入字符串中第一个匹配的MatcherMatchResult对象
fun testFind() {
    val re = Regex("[0-9]+")
    println(re.find("123XYZ987abcd7777"))
    println(re.find("123XYZ987abcd7777")?.value)

}

//findAll//返回输入字符串中所有匹配的值的MatchResult的序列
fun testFindAll() {

    val re = Regex("[0-9]+")
    println(re.findAll("123XYZ987abcd7777"))
    //我们可以通过 forEach 循环遍历所以匹配的值
    re.findAll("123XYZ987abcd7777").forEach { println(it.value) }

}

// 15.2.3　使用Java正则表达式类 465
fun testJavaRegex() {
    val re = Regex("[0-9]+")
    val p = re.toPattern()

    val m = p.matcher("888ABC999")
    while (m.find()) {

        val d = m.group()
        println(d)

    }

}

// 15.3　Kotlin的多线程 466
//Kotlin中没有synchronized关键字。 Kotlin中没有volatile关键字。 Kotlin的Any类似于Java的Object， 但是没有wait()，notify()和notifyAll() 方法。
//Kotlin通过封装 Java 中的线程类，简化了我们的编码。同时我们也可以使用一些特定 的注解， 直接使用 Java 中的同步关键字等。
// 15.3.1　创建线程 466
//使用Kotlin的对象表达式创建一个匿名类并覆盖run()方法
fun getThread() {
    object : Thread() {
        override fun run() {
            Thread.sleep(2000)
            println("${Thread.currentThread()}")
        }
    }.start()
}

//如何将一个Runnable传递给一个新创建的Thread实例
fun getThread2() {
    Thread({

        Thread.sleep(2000)

        println("B 使用 Lambda 表达式: ${Thread.currentThread()}")

    }).start()
}

//使用 Kotlin 封装的 thread 函数
fun getThread3() {
    val t = Thread({
        Thread.sleep(2000)
        println("B 使用 Lambda 表达式: ${Thread.currentThread()}")
    })
    t.isDaemon = false
    t.name = "CThread"
    t.priority = 3
    t.start()

    val t2 = thread(start = true, isDaemon = false, name = "DThread", priority = 3) {

        Thread.sleep(1000)

        println("D 使用 Kotlin 封装的函数 thread(): ${Thread.currentThread()}")

    }
}


// 15.3.2　同步方法和块 467
//synchronized不是Kotlin中的关键字，它替换为@Synchronized 注解
@Synchronized
fun appendFile2(text: String, destFile: String) {
    val f = File(destFile)
    if (!f.exists()) {
        f.createNewFile()
    }
    f.appendText(text, Charset.defaultCharset())
}

//对 于同步块，我们使用synchronized() 函数，它使用锁作为参数：
fun appendFileSync(text: String, destFile: String) {
    val f = File(destFile)
    if (!f.exists()) {
        f.createNewFile()
    }
//    synchronized(this) {
//        f.appendText(text, Charset.defaultCharset())
//    }
}

// 15.3.3　可变字段 468
//Kotlin没有 volatile 关键字，但是有@Volatile注解
@Volatile
private var running = false

fun start2() {
    running = true
    thread(start = true) {
        while (running) {
            println("${Thread.currentThread()}")
        }
    }
}
