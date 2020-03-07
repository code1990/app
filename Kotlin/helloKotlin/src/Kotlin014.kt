import Site14.name

//Kotlin 对象表达式和对象声明
//Kotlin 用对象表达式和对象声明来实现创建一个对某个类做了轻微改动的类的对象，且不需要去声明一个新的子类。

//通过对象表达式实现一个匿名内部类的对象用于方法的参数中：
/*
* window.addMouseListener(object : MouseAdapter() {
    override fun mouseClicked(e: MouseEvent) {
        // ...
    }
    override fun mouseEntered(e: MouseEvent) {
        // ...
    }
})
* */
//对象可以继承于某个基类，或者实现其他接口:
open class A14(x: Int) {
    public open val y: Int = x
}

interface B14 {}

val ab: A14 = object : A14(1), B14 {
    override val y: Int = 15
}

fun main(args: Array<String>) {
    //如果超类型有一个构造函数，则必须传递参数给它。多个超类型和接口可以用逗号分隔。
    //通过对象表达式可以越过类的定义直接得到一个对象：
    val site = object {
        var name: String = "test"
        var url: String = "www.xx.com"
    }
    println(site.name)
    println(site.url)

    val s1 = Site14
    val s2 = Site14
    s1.url = "www.xx.com"
    println(s1.url)
    println(s2.url)

    var site3 = Site15
    //site.DeskTop.url // 错误，不能通过外部类的实例访问到该对象
    Site15.DeskTop.url // 正确

    val instance = MyClassInfo.create()//访问到对象的内部元素
    //我们可以省略掉该对象的对象名，然后使用 Companion 替代需要声明的对象名：
    val xx = MyClassInfo1.Companion

}

//匿名对象可以用作只在本地和私有作用域中声明的类型
class C14 {
    //私有函数 所以返回类型是匿名函数对象类型
    private fun foo() = object {
        val x: String = "x"
    }

    //共有函数 所以返回值是any
    fun publicFoo() = object {
        val x: String = "x"
    }

    fun bar() {
        val x1 = foo().x//没问题
//        val x2=publicFoo().x//未能解析的引用“x”
    }
}

//对象声明
//Kotlin 使用 object 关键字来声明一个对象。
//Kotlin 中我们可以方便的通过对象声明来获得一个单例。
object Site14 {
    var url: String = ""
    val name: String = "xxx"
}

//与对象表达式不同，当对象声明在另一个类的内部时，这个对象并不能通过外部类的实例访问到该对象，而只能通过类名来访问，同样该对象也不能直接访问到外部类的方法和变量。
object Site15 {
    var url: String = ""

    object DeskTop {
        var url = "xxx"
        fun showName() {
            //println("desk legs $name")//// 错误，不能访问到外部类的方法和变量
        }
    }
}

//伴生对象
//类内部的对象声明可以用 companion 关键字标记，这样它就与外部类关联在一起，我们就可以直接通过外部类访问到对象的内部元素。
class MyClassInfo {
    companion object Factory {
        fun create(): MyClassInfo = MyClassInfo()
    }
}

class MyClassInfo1 {
    companion object {

    }
}

interface Factory<T> {
    fun create(): T
}

//一个类里面只能声明一个内部关联对象，即关键字 companion 只能使用一次。
class MyClass2 {
    companion object : Factory<MyClass2> {
        override fun create(): MyClass2 = MyClass2()
    }
}

//对象表达式和对象声明之间的语义差异
//对象表达式和对象声明之间有一个重要的语义差别：
//
//对象表达式是在使用他们的地方立即执行的
//
//对象声明是在第一次被访问到时延迟初始化的
//
//伴生对象的初始化是在相应的类被加载（解析）时，与 Java 静态初始化器的语义相匹配