//Kotlin 接口
//Kotlin 接口与 Java 8 类似，使用 interface 关键字定义接口，允许方法有默认实现：
interface MyInterface {
    fun bar()//未实现
    fun foo() {//已经实现
        //可以选择的方法体
        println("foo")
    }
}

//实现接口
//一个类或者对象可以实现一个或多个接口
class Child : MyInterface {
    override fun bar() {
        //方法体
        println("bar")
    }
}

fun main(args: Array<String>) {
    val c = Child()
    c.foo()
    c.bar()
    val m = MyImpl()
    println(m.name)
    val d = D1()
    d.foo()
    d.bar()
}

//接口中的属性
//接口中的属性只能是抽象的，不允许初始化值，接口不会保存属性值，实现接口时，必须重写属性
interface MyInterface1 {
    var name: String//name属性是抽象的

}

class MyImpl : MyInterface1 {
    override var name: String = "123"//重写属性
}

//函数重写
//实现多个接口时，可能会遇到同一方法继承多个实现的问题。例如:
interface A1 {
    fun foo() {
        println("A")//已经实现
    }

    fun bar()//未实现
}

interface B1 {
    fun foo() {
        println("B")//已经实现
    }

    fun bar() {
        println("bar")//已经实现
    }
}

class D1 : A1, B1 {
    //实现多个接口继承的所有方法，并指明 D 应该如何实现它们
    override fun foo() {
        super<A1>.foo()
        super<B1>.foo()
    }

    //必须要重写 bar() 并实现这个抽象方法
    override fun bar() {
        super<B1>.bar()
    }
}