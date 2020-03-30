package helloworld

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.lang.Exception
import java.util.*

@RunWith(JUnit4::class)
class Chapter03Test {
    @Test
    fun test31() {
        //3.1条件分支
        //3.1.1简单分支
        //if...else
        var is_odd: Boolean = true
        if (is_odd) {
            println("it is true")
        } else {
            println("it is false")
        }
        //简化版
        var str: String = if (is_odd) "it is true" else " it is false"
        println(str)
        //3.1.2多路分支
        //即用when/else来处理多路分支的条件判断
        var count: Int = 1
        var info: String = ""
        when (count) {
            0 -> info = "it is zero"
            1 -> info = "it is one"
            else -> info = "it is NAN"
        }
        println(info)
        //分支处理时允许引入变量判断
        var odd: Int = 0
        var even: Int = 1
        when (count) {
            odd -> print("it is ${odd}")
            even -> print("it is ${even}")
            else -> print("it is NAN")
        }
        //使用“in开始值..结束值”指定区间范围
        when (count) {
            1, 3, 5, 7, 9 -> print("even")
            in 13..19 -> print("in")
            !in 6..10 -> print("not in")
            else -> print("nan")
        }
        //3.1.3类型判断
        //在Kotlin中，关键字instanceof被is所取代
        //在分支判断时采取“is变量类型->”这种形式
        var countType: Number;
        count = (count + 1) % 3
        countType = when (count) {
            0 -> count.toLong()
            1 -> count.toDouble()
            else -> count.toFloat()
        }
        when (countType) {
            is Long -> println("is long")
            is Double -> println("is Double")
            else -> print("other")
        }
    }

    @Test
    fun test32() {
        //3.2循环处理
        //3.2.1遍历循环
        //采纳了 for和while关键字，只是在具体用法上有所微调
        val poemArray: Array<String> = arrayOf("a", "b", "c")
        for (item in poemArray) {
            println(item)
        }
        ////indices表示数组变量对应的下标数组
        for (i in poemArray.indices) {
            println(poemArray[i])
        }
        //3.2.2条件循环
        //代价是多了几个诸如until、step、//downTo这样的关键字
        ////左闭右开区间，合法值包括11，但不包括66
        for (i in 11 until 66) {
            println(i)
        }
        //每次默认递增1，这里改为每次递增4
        for (i in 23..89 step 4) {
            println(i)
        }
        //// for循环默认递增，这里使用downTo表示递减
        for (i in 50 downTo 7) {
            println(i)
        }
        //Kotlin的while循环与Java的处理是一致的
        var i: Int = 0
        while (i < poemArray.size) {
            println(poemArray[i])
            i++
        }
        //既然while语句保留了下来，do/while语句继续保留
        var a: Int = 0
        do {
            println(poemArray[a])
            a++
        } while (a < poemArray.size)
        //3.2.3跳出多重循环
        //(1)忽略此行，即使用关键字continue继续下一个循环。
        //关键字break跳出循环。
        val poemArray2: Array<String?> = arrayOf("a", "b", null, "12", "33")
        var poem: String = ""
        var pos: Int = 0
        var count: Int = 0
        while (pos <= poemArray2.size) {
            var info = poemArray2[i]
            if (info.isNullOrBlank()) {
                continue
            } else {
                poem += poemArray2[pos] + ","
                if (count == 3) {
                    break
                }
            }
            pos++
            count++
        }

        //@标记
        var j: Int = 0
        var is_found = false
        outside@ while (j < poemArray.size) {
            var k: Int = 0
            var item = poemArray[i]
            if (k == item.length) {
                //跳出多重循环的支持（通过“break@标记位”实现
                break@outside
            }
            j++
        }
    }

    @Test
    fun test33() {
        //3.3空安全
        //3.3.1字符串的有效性判断
        //下面列出Kotlin校验字符串空值的几个方法。
        //•isNullOrEmpty:为空指针或者字串长度为0时返回true，非空串与可空串均可调用。
        //•isNullOrBlank:为空指针、字串长度为0或者全为空格时返回true，非空串与可空串均可调用。
        //•isEmpty:字串长度为0时返回true，只有非空串可调用。
        //•isBlank:字串长度为0或者全为空格时返回true，只有非空串可调用。
        //•isNotEmpty:字串长度大于0时返回true，只有非空串可调用。
        //•isNotBlank:字串长度大于0且不是全空格串时返回true，只有非空串可调用。
        //3.3.2声明可空变量
        val strA: String = "非空"
        var strB: String? = null
        val strC: String? = "可空串"
        //3.3.3校验空值的运算符
        var length: Int = strA.length
        println(length)
        //因为strB可能为空，会扔出空指针异常
        length = if (strB != null) strB.length else -1
        ////即使strC有值，也必须做非空判断，谁叫它号称可空呢
        println(length)
        length = if (strC != null) strC.length else -1
        println(length)
        ////?.表示变量为空时直接返回null，所以返回值的变量必须被声明为可空类型
        var length_null: Int?
        ////?.表示变量为空时直接返回null，所以返回值的变量必须被声明为可空类型
        //“strB?.length”其实等价于“length_null = if (strB!=null) strB.length else null”
        length_null = strB?.length
        println(length_null)
        //?: Java的三元运算符“变量名=条件语句?取值A:取值B”的缩写
        ////?:表示为空时就返回右边的值
        length_null = strB?.length ?: -1
        //把双感叹号加在变量名称后面表示强行把该变量从可空类型转为非空类型
        strB = "排雷完毕"
        length = strB!!.length
        println(length)
        //只有在确保为非空时，才能使用！！
        try {
            length = strB!!.length
            println(length)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        //(1)变量名:变量类型？表示该变量可以为空。
        //(2)变量.?方法  表示一旦变量为空就返回null。
        //(3)"?:"，表示一旦变量为空，就返回该运算符右边的表达式。
        //(4)"!!"，通知编译器不做非空校验。如果运行时发现变量为空，就扔出异常。

    }

    @Test
    fun test34() {
        //3.4等式判断
        //3.4.1结构相等 即模样相等，通俗地说就是一模一样
        //字符串变量之间也能使用双等号“==”来判断
        //Java中实现了equals函数的类，其变量均可在Kotlin中通过运算符“==”和“!=”进行等式判断
        val helloHe: String = "你好"
        val helloShe: String = "你好"
        println(helloHe == helloShe)
        //3.4.2引用相等
        //结构相等的运算符是双等号“==”，
        //那么引用相等的运算符便是二个等号“===”
        //(1)对于基本数据类型，包括整型、浮点型、布尔型、字符串，结构相等和引用相等没有区别。
        //(2)同一个类声明的不同变量，只要有一个属性不相等，则其既是结构不等，也是引用不等。
        //(3)同一个类声明的不同变量，若equals方法校验的每个属性都相等，则其结构相等，但引用不等
        val date1: Date = Date()
        val date2: Any = date1.clone()
        println(date1 == date2)
        //date2从datel克隆而来，所以二者的值是完全一样的，区别仅仅是存储的地址不同
        println(date1 === date2)
        //3.4.3is和in
        //变量是否为某种类型 运算符is和!is
        val one:Long =1L
        println(one is Long)
        //运算符in和!in校验数组中是否存在某个元素
        val oneArray:IntArray = intArrayOf(1,2,3,4,5)
        println(1 in oneArray)
    }
}
