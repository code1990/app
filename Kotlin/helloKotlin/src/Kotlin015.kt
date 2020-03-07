import kotlin.properties.Delegates
import kotlin.reflect.KProperty

//kotlin 委托
//委托模式是软件设计模式中的一项基本技巧。在委托模式中，有两个对象参与处理同一个请求，接受请求的对象将请求委托给另一个对象来处理。
//
//Kotlin 直接支持委托模式，更加优雅，简洁。Kotlin 通过关键字 by 实现委托。

//类委托
//类的委托即一个类中定义的方法实际是调用另一个类的对象的方法来实现的。

//创建接口
interface Base1 {
    fun print()
}

//实现此接口的被委托的类
class BaseImpl(val x: Int) : Base1 {
    override fun print() {
        print(x)
    }
}

//通过关键字by 建立委托
class Derived1(b: Base1) : Base1 by b

fun main(args: Array<String>) {
    val b = BaseImpl(10)
    Derived1(b).print()
    val e = Example()
    println(e.p)//访问该属性 调用getValue函数
    e.p = "test"//调用setValue函数
    println(e.p)
    println(lazyValue)   // 第一次执行，执行两次输出表达式
    println(lazyValue)   // 第二次执行，只输出返回值

    val user = User1()
    user.name = "第一次初始化"
    user.name = "第2次初始化"

    //构造函数接受一个映射参数
    val site = Site(
        mapOf(
            "name" to "qqq",
            "url" to "www"
        )
    )
    //读取映射值
    println(site.name)
    println(site.url)

    //
    var map: MutableMap<String, Any?> = mutableMapOf(
        "name" to "教程",
        "url" to "www.com"
    )
    val site1 = Site1(map)
    println(site1.name)
    println(site1.url)
    println("-----")
    map.put("name", "google")
    map.put("url", "google1")
    println(site1.name)
    println(site1.url)

    //
    val foo = Foo1()
    foo.notNullBar = "bar"
    println(foo.notNullBar)

}

//属性委托
//属性委托指的是一个类的某个属性值不是在类中直接进行定义，而是将其托付给一个代理类，从而实现对该类的属性统一管理。
//定义一个呗委托的类
class Example {
    var p: String by Delegate1()
}

//委托的类
class Delegate1 {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, 这里委托了 ${property.name} 属性"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$thisRef 的 ${property.name} 属性赋值为 $value")
    }
}

//标准委托
//Kotlin 的标准库中已经内置了很多工厂方法来实现属性的委托。
//
//延迟属性 Lazy
//lazy() 是一个函数, 接受一个 Lambda 表达式作为参数, 返回一个 Lazy <T> 实例的函数，
// 返回的实例可以作为实现延迟属性的委托： 第一次调用 get() 会执行已传递给 lazy() 的 lamda 表达式并记录结果，
// 后续调用 get() 只是返回记录的结果。

val lazyValue: String by lazy {
    println("computed!")// 第一次调用输出，第二次调用不执行
    "hello"
}

//可观察属性 Observable
//observable 可以用于实现观察者模式。
//
//Delegates.observable() 函数接受两个参数: 第一个是初始化值, 第二个是属性值变化事件的响应器(handler)。
//
//在属性赋值后会执行事件的响应器(handler)，它有三个参数：被赋值的属性、旧值和新值：
class User1 {
    var name: String by Delegates.observable("初始化") { property, oldValue, newValue ->
        println("$oldValue->$newValue")
    }
}

//可以使用映射实例自身作为委托来实现委托属性。
//把属性储存在映射中
class Site(val map: Map<String, Any?>) {
    val name: String by map
    val url: String by map
}

//如果使用 var 属性，需要把 Map 换成 MutableMap：
class Site1(val map: MutableMap<String, Any?>) {
    val name: String by map
    val url: String by map
}

//Not Null
//notNull 适用于那些无法在初始化阶段就确定属性值的场合。
class Foo1 {
    var notNullBar: String by Delegates.notNull<String>()
}

//局部委托属性
//你可以将局部变量声明为委托属性。 例如，你可以使一个局部变量惰性初始化：
fun example(computeFoo: () -> Foo) {
    val mFoo by lazy(computeFoo)
    //memoizedFoo 变量只会在第一次访问时计算。 如果 someCondition 失败，那么该变量根本不会计算。
    /*if (someCondition && memoizedFoo.isValid()) {
        memoizedFoo.doSomething()
    }
    *
    * */
}
//属性委托要求
//对于只读属性(也就是说val属性), 它的委托必须提供一个名为getValue()的函数。该函数接受以下参数：
//翻译规则
//在每个委托属性的实现的背后，Kotlin 编译器都会生成辅助属性并委托给它

//提供委托
//通过定义 provideDelegate 操作符，可以扩展创建属性实现所委托对象的逻辑

//provideDelegate 的参数与 getValue 相同：
