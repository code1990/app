import java.awt.im.InputSubset
import javax.security.auth.Subject

//Kotlin 类和对象
//类定义
//Kotlin 类可以包含：构造函数和初始化代码块、函数、属性、内部类、对象声明。
//
//Kotlin 中使用关键字 class 声明类，后面紧跟类名：
class Test {

}

//可以定义一个空类
class Empty

//在类中定义成员函数
class TestInfo() {
    fun foo() {
        println("Foo")//成员函数
    }

    //类的属性
    //属性定义
    //类的属性可以用关键字 var 声明为可变的，否则使用只读关键字 val 声明为不可变。
    var name: String = "jim"
    var url: String = "www.xx.com"
    val city: String = "Peking"

}

fun main(args: Array<String>) {
    //// Kotlin 中没有 new 关键字
    //像使用普通函数那样使用构造函数创建类实例
    val site = TestInfo()
    //要使用一个属性，只要用名称引用它即可
    println(site.name)
    println(site.url)
//getter 和 setter 都是可选
//
//如果属性类型可以从初始化语句或者类的成员函数中推断出来，那就可以省去类型，val不允许设置setter函数，因为它是只读的。
    var initialized = 1    // 类型为 Int, 默认实现了 getter 和 setter
    val simple: Int?       // 类型为 Int ，默认实现 getter ，但必须在构造函数中初始化
    val inferredType = 1   // 类型为 Int 类型,默认实现 getter

    //测试person类
    var person: Person3 = Person3()
    person.lastName = "wang"
    println("lastName:${person.lastName}")
    person.no = 9
    println("lastName:${person.no}")
    person.no = 20
    println("lastName:${person.no}")
    //测试runoob类


}

//Koltin 中的类可以有一个 主构造器，以及一个或多个次构造器，主构造器是类头部的一部分，位于类名称之后:
class Person1 constructor(firstName: String) {}

//如果主构造器没有任何注解，也没有任何可见度修饰符，那么constructor关键字可以省略。
class Person2(firstName: String) {}

class Person3 {
    var lastName: String = "zhang"
        get() = field.toUpperCase() // 将变量赋值后转换为大写
        set

    var no: Int = 100
        //Kotlin 中类不能有字段。
        // 提供了 Backing Fields(后端变量) 机制,
        // 备用字段使用field关键字声明,
        // field 关键词只能用于属性的访问器，如以上实例：
        get() = field// 后端变量
        set(value) {
            if (value < 10) {
                field = value
            } else {
                field = -1
            }
        }

    var height: Float = 145.4f
}

//非空属性必须在定义的时候初始化,kotlin提供了一种可以延迟初始化的方案,使用 lateinit 关键字描述属性：
/*
public class MyTest{
    lateinit var subject: Subject:TestSubject

    @Setup fun setUp(){
        subject= Test
    }

    @Test fun test(){
        subject.method()
    }
}*/
//主构造器
//主构造器中不能包含任何代码，初始化代码可以放在初始化代码段中，初始化代码段使用 init 关键字作为前缀。
class Person5 constructor(firstName: String) {
    init {
        println("firstNme is $firstName")
    }
}

//可以通过主构造器来定义属性并初始化属性值（可以是var或val）：
class Person6(val firstName: String, val lastName: String) {}

//如果构造器有注解，或者有可见度修饰符，这时constructor关键字是必须的，注解和修饰符要放在它之前。
class Runoob constructor(name: String) {
    //
    val url: String = "www.xxx.com"
    val country: String = "cn"
    val siteName = name

    init {
        println("初始化网站名称$name")
    }

    fun printTest() {
        println("我是类的函数")
    }
}

//次构造函数
//类也可以有二级构造函数，需要加前缀 constructor:
class Person7(val name:String) {
    //如果类有主构造函数，每个次构造函数都要，或直接或间接通过另一个次构造函数代理主构造函数。
    // 在同一个类中代理另一个构造函数使用 this 关键字
    constructor(name: String,age:Int):this(name) {
        println("二级构造函数")
    }
}
//如果一个非抽象类没有声明构造函数(主构造函数或次构造函数)，它会产生一个没有参数的构造函数。构造函数是 public 。如果你不想你的类有公共的构造函数，你就得声明一个空的主构造函数：
