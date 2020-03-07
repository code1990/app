import javax.naming.Context
import javax.swing.text.AttributeSet

//Kotlin 继承
//Kotlin 中所有类都继承该 Any 类，它是所有类的超类，对于没有超类型声明的类是默认超类：
//class Example // 从 Any 隐式继承
//Any 默认提供了三个函数：
//
//equals()
//
//hashCode()
//
//toString()
//注意：Any 不是 java.lang.Object。
//
//如果一个类要被继承，可以使用 open 关键字进行修饰。
open class BaseInfo(p: Int)//定义基类

class DerivedInfo(p: Int) : BaseInfo(p)//
//构造函数
//子类有主构造函数
//如果子类有主构造函数， 则基类必须在主构造函数中立即初始化。
open class PersonInfo(var name: String, var age: Int) {//基类

}

class Student(name: String, age: Int, var no: String, var score: Int) : PersonInfo(name, age) {

}

fun main(args: Array<String>) {
    //测试PersonInfo类
    var s = Student("test", 18, "11", 11)
    print("$s.name")
    print("$s.age")
    print("$s.no")
    print("${s.score}")
    /*测试StudentInfo123 */
    var s2 = StudentInfo123("Runoob", 18, "S12345", 89)
    /*StudentInfo111*/
    val s3 = Student111()
    s3.study()
    //C 继承自 a() 或 b(), C 不仅可以从 A 或则 B 中继承函数，而且 C 可以继承 A()、B() 中共有的函数
    val c = C()
    c.f()


}
//子类没有主构造函数
//如果子类没有主构造函数，则必须在每一个二级构造函数中用 super 关键字初始化基类，或者在代理另一个构造函数。初始化基类时，可以调用基类的不同构造方法。
/*
class StudentInfo2:PersonInfo{
    constructor(ctx:Context):super(ctx){

    }
    constructor(ctx: Context,attrs:AttributeSet):super(ctx,attrs){

    }
}*/
/**用户基类**/
open class PersonInfo123(name: String) {
    /**次级构造函数**/
    constructor(name: String, age: Int) : this(name) {
        //初始化
        println("基类次级构造函数")
    }
}

//子类继承Person 类
class StudentInfo123 : PersonInfo123 {
    /**次级构造函数**/
    constructor(name: String, age: Int, no: String, score: Int) : super(name, age) {
        println("-------继承类次级构造函数---------")
        println("学生名： ${name}")
        println("年龄： ${age}")
        println("学生号： ${no}")
        println("成绩： ${score}")
    }
}

//重写
//在基类中，使用fun声明函数时，此函数默认为final修饰，不能被子类重写。
// 如果允许子类重写该函数，那么就要手动添加 open 修饰它, 子类重写方法使用 override 关键词
/*用户基类*/
open class PersonInfo111 {
    open fun study() { // 允许子类重写
        println("ok")
    }
}

/*子类继承父类*/
class Student111 : PersonInfo111() {
    override fun study() {// 重写方法
        println("not ok")
    }
}

/*如果有多个相同的方法（继承或者实现自其他类，如A、B类），则必须要重写该方法，使用super范型去选择性地调用父类的实现。
*/
open class A {
    open fun f() {
        println("A")
    }

    fun a() {
        println("a")
    }
}

interface B {
    fun f() {
        print("B")
    }

    fun b() {
        println("b")
    }
}

class C() : A(), B {
    override fun f() {
        super<A>.f()//调用A.f()
        super<B>.f()//调用A.f()
    }
}

//属性重写
//属性重写使用 override 关键字，属性必须具有兼容类型，每一个声明的属性都可以通过初始化程序或者getter方法被重写：
open class Foo {
    open val x: Int = 0
}

class Bar1 : Foo() {
    override val x: Int
        get() = super.x
}

//你可以用一个var属性重写一个val属性，但是反过来不行
interface Foo123 {
    val count: Int
}

//你可以在主构造函数中使用 override 关键字作为属性声明的一部分:
class Bar123(override val count: Int) : Foo123

class Bar124 : Foo123 {
    override val count: Int = 0
}
//1、子类继承父类时，不能有跟父类同名的变量，除非父类中该变量为 private，或者父类中该变量为 open 并且子类用 override 关键字重写
//2、子类不一定要调用父类和接口中共同拥有的同名的方法
//子类重写父类属性，也就相当于必须重写该属性的 getter 和 setter 方法，而子类中的 val 不能有 setter 方法，所以无法“覆盖”父类中 var 的 setter 方法
//如果一个变量想要在定义的时候被初始化，则该变量必须拥有 backing field 字段，该变量的默认 getter 和 setter 方法中是有定义 field 字段的

