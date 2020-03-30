package helloworld

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.text.SimpleDateFormat
import java.util.*

@RunWith(JUnit4::class)
class Chapter04Test {
    @Test
    fun test41() {
        //4.1函数的基本用法
        //4.1.1与Java声明方式的区别
        //override fun onCreate(savedInstanceState: Bundle?) {
        //(1) Kotlin使用小写的“override”在同一行表达重载操作。
        //⑵ Kotlin默认函数就是公开的，所以省略了关键字“public”。
        //⑶Kotlin不存在关键字“void”，若无返回参数，则不用特别说明。
        //(4)Kotlin新增了关键字“fun”，表示这里是函数定义
        //(5)Kotlin声明输入参数的格式为“变量名称:变量类型”。
        //(6)Kotlin引入了空安全机制，如果某个变量允许为空，就需要在变量类型后面加个问号“?” ◦
        //4.1.2输入参数的格式
        getDinnerEmpty()
        getDinnerInput(1, 2F)
        getDinnerCanNull(1, null, 2F)
        //4.1.3输出参数的格式
        //Kotlin中，返回参数类型却在右括号后面指定
        //把函数作为一个特殊的变量
        //Kotlin函数也会默认返回一个Unit类型的对象

    }

    ////没有输入参数，也没有输出参数
    fun getDinnerEmpty() {
        var str: String = "nothing"
    }

    ////只有输入参数
    fun getDinnerInput(egg: Int, shell: Float) {
        var resut: String = ""
    }

    //输入参数存在空值
    fun getDinnerCanNull(egg: Int, water: String?, shell: Float) {
        if (water == null) "no water"
    }

    //Unit类型表示没有返回参数，也可直接省略Unit声明
    fun getDinnerUnit(): Unit {
        print("Unit")
    }

    //只有输出参数
    fun getDinnerOutput(): String {
        var dinner: String = "dinner"
        return dinner
    }

    @Test
    fun test42() {
        //4.2输入参数的变化
        println(getInvent("1", "2", "3", "4"))
        //4.2.1默认参数
        println(getInventDefault())
        //4.2.2命名参数
        //指定某个参数的名称及其数值，具体格式形如“参数名=参数值
        println(getInventDefault(second = "二"))
        //4.2.3可变参数
        println(getInventVararg("2", "6"))
    }

    fun getInvent(first: String, second: String, third: String, four: String): String {
        return "${first},${second},${third},${four}"
    }

    //Kotlin引入了默认参数的概念，允许在定义函数时直接指定输入参数的默认值。
    fun getInventDefault(first: String = "1", second: String = "2", third: String = "3", four: String = "4"): String {
        return "${first},${second},${third},${four}"
    }

    //可变参数值
    //加上vararg前缀，告诉编译器后面的数组个数是变化的
    fun getInventVararg(vararg otherArray: String?): String {
        var str: String = ""
        for (item in otherArray) {
            str += item + ","
        }
        return str
    }

    @Test
    fun test43() {
        //4.3几种特殊函数
        //泛型函数是全局函数定义在类外面
        //内联函数是定义在类内部，为了拓展类内部的泛型方法
        //4.3.1泛型函数
        println(appendString<String>("a", "b", "c"))
        println(appendString<Int>(1, 3, 5))
        //4.3.2内联函数
        //普通类是不允许定义泛型函数的
        //即将“<T>”改为“<reifiedT:Number>”，在fun前面添加关键字inline，表示该函数属于内联函数。
        //内联函数在编译的时候会在调用处把该函数的内部代码直接复制一份
        var int_array: Array<Int> = arrayOf(1, 2, 3)
        var float_array: Array<Float> = arrayOf(1.0f, 2.0f, 3.0f)
        setArrayStr<Int>(int_array)
        setArrayStr<Float>(float_array)
        //4.3.3简化函数
        //可将函数当作一种特殊的变量，既然变量通过等号赋值，那么函数也允许使用等号对输出参数赋值
        println(factorial(2))
        println(factorial2(2))
        //4.3.4尾递归函数
        //4.3.5高阶函数
        //把A函数作为B函数的输入参数，就像普通变量一样参与B函数的表达式计算
        var string_array: Array<String> = arrayOf("How", "do", "you")
        println(maxCustom<String>(string_array, { a, b -> a > b }))
    }

    //定义泛型函数时，得在函数名称前面添加“<T>”
    fun <T> appendString(vararg otherInfo: T?): String {
        var str: String = ""
        for (item in otherInfo) {
            str = "$str${item.toString()}"
        }
        return str
    }

    ////该函数既不接收Array<Int>，也不接收Array<Double>
    fun setArrayNumber(array: Array<Number>) {
        for (item in array) {
            println(item)
        }
    }

    ////只有内联函数才可以被具体化
    inline fun <reified T : Number> setArrayStr(array: Array<T>) {
        for (item in array) {
            println(item)
        }
    }

    fun factorial(n: Int): Int {
        if (n <= 1) {
            return n
        } else {
            return n * factorial(n - 1)
        }
    }

    fun factorial2(n: Int): Int = if (n <= 1) n else n * factorial2(n - 1)
    ////如果函数尾部递归调用自身，那么可加上关键字tailrec表示这是一个尾递归函数
    ////此时编译器会自动优化递归，即用循环方式代替递归，从而避免栈溢出的情况
    ////比如下面这个求余弦不动点的函数就是尾递归函数
    tailrec fun findFixPoint(x: Double = 1.0): Double = if (x == Math.cos(x)) x else findFixPoint(Math.cos(x))

    ////允许将函数表达式作为输入参数传进来，就形成了高阶函数
    fun <T> maxCustom(array: Array<T>, greater: (T, T) -> Boolean): T? {
        var max: T? = null
        for (item in array) {
            if (max == null || greater(item, max)) {
                max = item

            }
        }
        return max
    }

    fun greater(a: String, b: String): Boolean {
        var result: Boolean = a.length > b.length
        return result
    }

    @Test
    fun test44() {
        //4.4增强系统函数
        //Kotlin推出了扩展函数的概念，扩展函数允许开发者给系统类补写新的方法，而无须另外编写额外的工具类。
        //4.4.1扩展函数
        val array_int: Array<Int> = arrayOf(1, 2, 3)
        val array_double: Array<Double> = arrayOf(1.0, 2.0, 3.0)
        array_int.swap(1, 2)
        array_double.swap(1, 2)
        //4.4.2扩展高阶函数
        //4.4.3日期时间函数
        //4.4.4单例对象
    }

    //在swap函数名称前面加上前缀“Array<Int>.”，表示该函数扩展自系统类Array<Int>
    //扩展函数结合泛型函数能够更好地扩展函数功能
    fun <T> Array<T>.swap(pos1: Int, pos2: Int) {
        val tmp = this[pos1]//this 表示数组自身
        this[pos1] = this[pos2]
        this[pos2] = tmp
    }
    ////为Array<T>拓展高阶函数
    //fun <T> Array<T>.maxCustomize(greater:(T,T->Boolean)):T?{
    //	var max:T?=null
    //	for(item in this){
    //		if(max==null || greater(item,max)){
    //			max=item
    //		}
    //	}
    //	return max
    //}

    ////方法名称前面的Date.表示该方法扩展自Date类
    fun Date.getNowDateTime(): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        return sdf.format(this)
    }

    ////只返回日期字符串
    fun Date.getNowDate(): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd")
        return sdf.format(this)
    }

    //只返回时间字符串
    fun Date.getNowTime(): String {
        val sdf = SimpleDateFormat("HH:mm:ss")
        return sdf.format(this)
    }

    //返回详细的时间字符串，精确到毫秒
    fun Date.getNowTimeDetail(): String {
        val sdf = SimpleDateFormat("HH:mm:ss.SSS")
        return sdf.format(this)
    }

    //返回开发者指定格式的日期时间字符串
    fun Date.getFormatTime(format: String = ""): String {
        var ft: String = format
        val sdf = if (!ft.isEmpty()) SimpleDateFormat(ft) else SimpleDateFormat("yyyyMMddHHmmss")
        return sdf.format(this)
    }

}
