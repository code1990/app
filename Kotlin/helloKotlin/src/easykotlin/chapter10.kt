// 第10章　Kotlin与Java互操作 330
// 10.1　在Kotlin中调用Java 330
//Kotlin 在设计之初就考虑了与 Java 的互操作性。
//下面是一个Kotlin调用Java中的Okhttp库的代码
//Java 代码中也可以很顺利地调用 Kotlin 代码
// 10.1.1　调用Okhttp库示例 331
// 10.1.2　使用Java的集合类 332
// 10.1.3　调用Java中的Getter和Setter 333
// 10.1.4　调用Java中返回void的方法 334
//如果一个 Java 方法返回 void，那么从 Kotlin 调用时中返回	Unit
// 10.1.5　调用来自Java中的null 335
//Java 声明的类型在 Kotlin 中会被特别对待并称为平台类型（platform types ）。对这种类型的空检 查会放宽，因此它们的安全保证与在 Java 中相同。
//平台类型不能在程序中显式表述
//映射只发生在编译期间，运行时表示保持不变
//Kotlin 的泛型与 Java 有点不同。当将 Java 类型导入 Kotlin 时，我们会执行一些转换：
//
//	Kotlin 的泛型			Java 的泛型	说明
//	Foo<out Bar!>!				Foo<? extends Bar>		Java 的通配符转换成类型投影
//	Foo<? super Bar>			Foo<in Bar!>!		同上
//	List<*>!			List		Java的原始类型转换成星投影
// 10.1.6　使用Java的泛型 336
// 10.1.7　数组的互操作 337
// 10.1.8　可变参数的互操作 337
//Java 类有时声明一个具有可变数量参数（varargs）的方法来使用索引
// 10.1.9　检查Java中的异常 337
//在 Kotlin 中，所有异常都是非受检的（Non-Checked Exceptions），这意味着编译器不会强迫你捕 获其中的任何一个。而在Java中会要求我们捕获异常
//当我们调用一个声明受检异常的 Java 方法时，Kotlin 不会强 迫你做任何事情：
//但是，我们在运行的时候，还是会抛异常
// 10.1.10　调用Java的Object方法
//当 Java 类型导入到 Kotlin 中时，类型 java.lang.Object 的所有引用都成了 Any 。 Any 只声明 了 toString() 、 hashCode() 和 equals() 函数。怎样才能用到 java.lang.Object 的其他成
//wait()/notify()
//如果我们真的需要调用它们的话，可以将其转换为	java.lang.Object 来使用：
//(foo as java.lang.Object).wait()
//getClass()

// val fooClass = foo::class.java val fooClass = foo.javaClass
//clone()
//
//要覆盖	clone() ，需要继承	kotlin.Cloneable 要谨慎地改写clone方法
//class Example : Cloneable {
// override fun clone(): Any { …… }
//}
//finalize()
//
//要覆盖	finalize() ，我们只需要声明它即可，不用再写 override关键字
//protected fun finalize() {
//
//}
// 10.1.11　访问Java静态成员 340
//Java 类的静态成员会形成该类的“伴生对象”。我们可以直接显式访问其成员。
//一个带静态方法的Java类
//我们在Kotlin代码可以直接这样调用:
//val userJson = JSONUtils.toJsonString(user)
//如果是反过来调用，Java调用Kotlin中的object对象类中的函数，需要使用object//的	对象名.INSTANCE	来调用函数。

// 10.1.12　使用Java的反射 340
//我们可以使用
// instance::class.java 、
// ClassName::class.java 或者
// instance.javaClass
// 通过 java.lang.Class 来进入 Java 的反射类 java.lang.Class ， 之后我们就可以使用Java中的反射的
//功能特性了。
// 10.1.13　SAM转换 341
//我们在Kotlin中，要某个函数做某件事时，会传一个函数参数给它。
//这些接口只有单个抽象方法（single abstract method），在Java中 被称为SAM类型。
//例如：Runnable接口：在 Java 8中我们也通常称之为函数式接口。
//，SAM 转换只适用于接口，而不适用于抽象类，
//还要注意，此功能只适用于 Java 互操作
// 10.2　在Java中调用Kotlin 342
//一些 Kotlin 关键字在 Java 中是有效标识符：in、 object、 is等等。
///我们可以通过反引号（`）字符转义它来调用该方 法。
// 10.2.1　访问Kotlin属性 342
//Kotlin 属性会编译成以下 Java 元素：
//
//一个 getter 方法，名称通过加前缀	get	算出；
//
//一个 setter 方法，名称通过加前缀	set	算出（只适用于	var	属性）；
//
//  一个与属性名称相同的私有字段。

//如果Kotlin的属性名以	is	开头，则使用不同的名称映射规则：
//
//getter 的名称直接使用属性名称
//
//setter 的名称是通过将	is	替换为	set	获得。
//
//例如，对于属性	isOpen ，其 getter 会称做	isOpen() ，而其 setter 会称做	setOpen() 。

// 10.2.2　调用Kotlin的包级函数 344
//如果确实有特殊场景需要自定义Kotlin包级函 数对应的生成Java类的名字，我们可以使用 @JvmName 注解修改生成的 Java 类的类名
//我们使用 @JvmField 注解对Kotlin中的属性字段标注，表示这是一个实例字段（Instance Fields），Kotlin编译器在处理的时候，将不会给这个字段生成getters/setters方法。
// 10.2.3　调用Kotlin中的实例字段 347
// 10.2.4　调用Kotlin中的静态字段 348
// 10.2.5　调用Kotlin中的静态方法 349
//Kotlin中在命名对象或伴生对象中声明的 属性
//在Java访问的 innerID 时候，是通过Companion来访问：//Department.Companion.getInnerID()
//使用 @JvmField 注解的字段 innerName ，Kotlin编译器会把它的访问权限设置是public的， //Department.innerName
//伴生对象中定义的函数标注为 @JvmStatic ，这样编译器既会在 相应对象的类中生成静态方法，也会在对象自身中生成实例方法。

// 10.2.6　Kotlin与Java的可见性 350
//internal==public
// 10.2.7　生成默认参数函数的重载 352
//如果我们希望Java像Kotlin中一样可以调用多个重载，可以使用 @JvmOverloads 注解。
//@JvmOverloads 注解的作用，编译器会处理这个注解所标注的函数，并为之生成额外的重 载函数给Java调用。
// 10.2.8　显式声明Kotlin中的异常 353
//Kotlin 没有受检异常 在Java中调用，编译器是不会检查这个异常的 在运行时，这个异常还是会抛出来
//如果我们想要在 Java 中调用它并捕捉这个异//常，我们可以给Kotlin中的函数加上注解 @Throws(Exception::class)
// 10.2.9　关键字冲突的互操作 355
// 10.2.10　Nothing类型 355
//在Kotlin中 Nothing 类型是一个特殊的类型，它在 Java 中没有的对应的类型。在使用 Nothing 参 数的地方会生成一个原始类型。
// 10.3　类型映射 356
// 10.4　Kotlin与Java的简单实例对比 357
//打印日志
//Kotlin中的println函数是一个内联函数，它其实就是通过封装 java.lang.System 类
//System.out.println("Java");  println("Kotlin")
//常量与变量
//final String name = "KotlinVSJava"; val name = "KotlinVSJava"
//null声明
//String otherName; otherName = null;
//var otherName : String? otherName = null
//空判断
//if (text != null) {}  val length = text?.length
//字符串拼接
//String message = "My name is: " + firstName + " " + lastName;
//val message = "My name is: $firstName $lastName"
//换行
//String text = "First Line\n" +
//val text = """
//|First Line
//|Third Line
//""".trimMargin()
//三元表达式
//String text = x > 5 ? "x > 5" : "x <= 5";
//val text = if (x > 5) "x > 5"
//
//else "x <= 5"
//操作符
//final int andResult = a & b; final int orResult = a | b; final int xorResult = a ^ b; final int rightShift = a >> 2; final int leftShift = a << 2;
//val andResult = a and b val orResult = a or b val xorResult = a xor b val rightShift = a shr 2 val leftShift = a shl 2
//类型判断和转换（显式）
//if (object instanceof Car) {
//Car car = (Car) object;
//if (object is Car) {
//var car = object as Car
//类型判断和转换 (隐式)
//if (object instanceof Car) { Car car = (Car) object;
//
//}
//if (object is Car) {
//
//var car = object // Kotlin智能转换
//
//}
//Range区间
//if (score >= 0 && score <= 300) { }
//if (score in 0..300) { }
//更灵活的case语句
// when
//for循环
//for (i in 1..10) { }
//
//for (i in 1 until 10) { }
//
//for (i in 10 downTo 0) { }
//
//for (i in 1..10 step 2) { }
//
//for (i in 10 downTo 1 step 2) { }
//
//for (item in collection) { }
//
//for ((key, value) in map) { }
//更方便的集合操作
// 第三部分　综合实战
