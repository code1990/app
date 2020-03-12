package chapter03
//如果不在同一个package下面，我们就需要import对应的类和函数
//在同一个包命名空间下，可以直接调用，不需要import
//如果我们不定义package命令空间，则默认在根级目录,不需要import可以直接调用
//Kotlin会会默认导入一些基础包到每个 Kotlin 文件中：
//kotlin.*
//kotlin.annotation.*
//kotlin.collections.*
//kotlin.comparisons.* （自 1.1 起）
//kotlin.io.*
//kotlin.ranges.*
//kotlin.sequences.*
//kotlin.text.*
//根据目标平台还会导入额外的包：
//JVM:
//java.lang.*
//kotlin.jvm.*
//JS:
//kotlin.js.*
import easykotlin.chapter03.MotorBike
import easykotlin.chapter03.what
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class C0301Test {
    @Test
    fun testWhat(){
        what()
    }
    @Test
    fun testDriverMotorBike(){
        val bike =MotorBike()
        bike.drive()
    }
}