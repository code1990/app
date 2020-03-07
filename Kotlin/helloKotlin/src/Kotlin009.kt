//Kotlin 扩展
//Kotlin 可以对一个类的属性和方法进行扩展，且不需要继承或使用 Decorator 模式。
//
//扩展是一种静态行为，对被扩展的类代码本身不会造成任何影响。
class User(var name: String)

//拓展函数
fun User.print() {
    print("$name")
}

fun main(args: Array<String>) {
    var user = User("test")
    user.print()
    val l = mutableListOf<Int>(1, 2, 3)
    // 位置 0 和 2 的值做了互换
    l.swap(0, 2)// 'swap()' 函数内的 'this' 将指向 'l' 的值
    println(l.toString())

    printFoo(D2())

    var c3= C3()
    c3.foo()

    //拓展一个空对象
    var t = null
    println(t.toString())

    println("no:${MyClass.no}")
    MyClass.foo()

    //
    val c5=C5()
    val d5=D5()
    c5.caller(d5)

    //拓展函数
    C7().caller(D7())
    C8().caller(D7())
    C7().caller(D8())

    println("no:${MyClass.no}")
    println("field1:${MyClass12.myClassField1}")
    println("field2:${MyClass12.myClassField2}")
    MyClass12.foo()
    MyClass12.companionFun2()


}

//下面代码为 MutableList 添加一个swap 函数：
fun MutableList<Int>.swap(index1: Int, index2: Int) {
    val tmp = this[index1]//this对应列表
    this[index1] = this[index2]
    this[index2] = tmp

}

//扩展函数是静态解析的
//扩展函数是静态解析的，并不是接收者类型的虚拟成员
open class C2

class D2 : C2()

fun C2.foo() = "c"//拓展函数foo

fun D2.foo() = "d"//拓展函数foo

fun printFoo(c: C2) {
    println(c.foo())//类型是C类
}
//若扩展函数和成员函数一致，则使用该函数时，会优先使用成员函数。
class C3 {
    fun foo() {
        println("成员函数")
    }
}

fun C3.foo() {
    println("拓展函数")
}

//扩展一个空对象
//在扩展函数内， 可以通过 this 来判断接收者是否为 NULL,这样，即使接收者为 NULL,也可以调用扩展函数
fun Any?.toString():String{
    if (this==null)return "null"
    // 空检测之后，“this”会自动转换为非空类型，所以下面的 toString()
    // 解析为 Any 类的成员函数
    return toString()
}
//扩展属性
//除了函数，Kotlin 也支持属性对属性进行扩展:
//val <T> List<T>.lastIndex: Int
//扩展属性只能被声明为 val。


//伴生对象的扩展
//如果一个类定义有一个伴生对象 ，你也可以为伴生对象定义扩展函数和属性。
//
//伴生对象通过"类名."形式调用伴生对象，伴生对象声明的扩展函数，通过用类名限定符来调用
class MyClass{
    companion object {}//将被称为 "Companion"
}
fun MyClass.Companion.foo(){
    println("伴生对象的拓展函数")
}
val MyClass.Companion.no:Int
    get() = 10

//扩展的作用域
//通常扩展函数或属性定义在顶级包下:
//要使用所定义包之外的一个扩展, 通过import导入扩展的函数名进行使用:
//import foo.bar.goo // 导入所有名为 goo 的扩展
//import foo.bar.*   // 从 foo.bar 导入一切


//扩展声明为成员
//在一个类内部你可以为另一个类声明扩展。
//
//在这个扩展中，有个多个隐含的接受者，其中扩展方法定义所在类的实例称为分发接受者，而扩展方法的目标类型的实例称为扩展接受者。

class D5{
    fun bar(){
        println("D5 bar")
    }
}
class C5{
    fun baz(){
        println("C baz")
    }
    //在 C 类内，创建了 D 类的扩展。此时，C 被成为分发接受者，而 D 为扩展接受者。
    fun D5.foo(){
        bar()// 调用 D.bar
        baz()// 调用 C.baz
    }
    fun caller(d5: D5){
        d5.foo()//调用拓展函数
    }
}
//假如在调用某一个函数，而该函数在分发接受者和扩展接受者均存在，则以扩展接收者优先，要引用分发接收者的成员你可以使用限定的 this 语法。
class D6{
    fun bar(){
        println("D bar")
    }
}
class C6{
    fun bar(){
        println("C bar")// 与 D 类 的 bar 同名
    }
    fun D6.foo(){
        bar()         // 调用 D.bar()，扩展接收者优先
        this@C6.bar()  // 调用 C.bar()
    }
    fun caller(d6: D6){
        d6.foo()//调用拓展函数
    }
}
//以成员的形式定义的扩展函数, 可以声明为 open , 而且可以在子类中覆盖
open class D7{

}
class D8:D7(){

}
open class C7{
    open fun D7.foo(){
        println("D7.foo in c")
    }
    open fun D8.foo(){
        println("D8.foo in c")
    }
    fun caller(d7: D7){
        d7.foo()//调用拓展函数
    }
}
class C8:C7(){
    override fun D7.foo() {
        println("D7.foo in c1")
    }

    override fun D8.foo() {
        println("D8.foo in c1")
    }
}

//伴生对象内的成员相当于 Java 中的静态成员，其生命周期伴随类始终，在伴生对象内部可以定义变量和函数，这些变量和函数可以直接用类名引用。
//
//对于伴生对象扩展函数，有两种形式，一种是在类内扩展，一种是在类外扩展，这两种形式扩展后的函数互不影响
class MyClass12{
    companion object{
        val myClassField1:Int=1
        val myClassField2="this is myClassField2"
        fun companionFun1(){
            println("this is companion function")
            foo()
        }
        fun companionFun2(){
            println("this is 2st companion function")
        }
    }
    fun MyClass.Companion.foo(){
        println("半生对象的拓展函数内部")
    }
    fun test2(){
        MyClass.foo()
    }
    init {
        test2()
    }
}
val MyClass12.Companion.no:Int
    get() = 10
fun MyClass12.Companion.foo(){
    println("foo 伴随对象外部拓展函数")
}