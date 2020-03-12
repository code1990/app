## 第3章　Kotlin语言基础 
### 3.1　包 

可以在 *.kt 文件开头声明 package 命名空间

包 com.easy.kotlin , 里面定义了包级函数what() , 同时定义了一个类 Motorbike 。

另外，目录与包的结构无需匹配：源代码可以在文件系统的任意位置。

```
//如果不在同一个package下面，我们就需要import对应的类和函数//在同一个包命名空间下，可以直接调用，不需要import//如果我们不定义package命令空间，则默认在根级目录,不需要import可以直接调用//Kotlin会会默认导入一些基础包到每个 Kotlin 文件中：//kotlin.*//kotlin.annotation.*//kotlin.collections.*//kotlin.comparisons.* （自 1.1 起）//kotlin.io.*//kotlin.ranges.*//kotlin.sequences.*//kotlin.text.*//根据目标平台还会导入额外的包：//JVM://java.lang.*//kotlin.jvm.*//JS://kotlin.js.*
```

### 3.2　声明变量和值 

Kotlin的变量分为 var (可变的) 和 val (不可变的)。

只要可能，尽量在Kotlin中首选使用 val 不变值。

### 3.3　变量类型推断 

不需要说明你使用对象的类型，编译器可以直接推断出它的类型

#### 3.3.1　省去变量类型 

只需要依据要产生的变量类型填写var或val，其类型通常能够被推断出来。编译器能够检测到其类型，自动地完成类型转换

整型变量Int不能赋值Long变量

需要显式地调用对应的类型转换函数进行转换

#### 3.3.2　使用is运算符进行类型检测 

is 运算符检测一个表达式是否某类型的一个实例。

### 3.4　字符串与其模板表达式 

原始字符串(raw string)由三重引号（"""）分隔(这个跟python一样)。原始字符串可以包含换行符和任何其他字符。

字符串可以包含模板表达式。模板表达式以美元符号（$）开始。

### 3.5　流程控制语句 

流程控制语句是编程语言中的核心之一。可分为：
分支语句( if 、 when )
循环语句( for 、 while )和
跳转语句 ( return 、 break 、 continue 、 throw )等。

#### 3.5.1　if表达式 

if-else语句是控制程序流程的最基本的形式，其中else是可选的。
在 Kotlin 中，if 是一个表达式，即它会返回一个值(跟Scala一样)。

if 的分支可以是代码块，最后的表达式作为该块的值：

if作为代码块时，最后一行为其返回值。

在Kotlin中没有类似 true? 1: 0 这样的三元表达式。对应的写法是使用 if else 语句

如果 if 表达式只有一个分支， 或者分支的结果是 Unit , 它的值就是 Unit 。

if后的括号不能省略，括号里表达式的值须是布尔型

如果条件体内只有一条语句需要执行，那么if后面的大括号可以省略。良好的编程风格建议加上大括号。

对于给定的if，else语句是可选的，else if 语句也是可选的。
else和else if同时出现时，else必须出现在else if 之后。
如果有多条else if语句同时出现，那么如果有一条else if语句的表达式测试成功，那么会忽略掉
其他所有else if和else分支。
如果出现多个if,只有一个else的情形，else子句归属于最内层的if语句。

#### 3.5.2　when表达式 

when表达式类似于 switch-case 表达式。when会对所有的分支进行检查直到有一个条件满足。但
相比switch而言，when语句要更加的强大，灵活。

像 if 一样，when 的每一个分支也可以是一个代码块，它的值是块中最后的表达式的值。
如果其他分支都不满足条件会到 else 分支（类似default）。

如果我们有很多分支需要用相同的方式处理，则可以把多个分支条件放在一起，用逗号分隔：

#### 3.5.3　for循环 

Kotlin的for循环跟现代的程序设计语言基本相同。
for 循环可以对任何提供迭代器（iterator）的对象进行遍历

如果你想要通过索引遍历一个数组或者一个 list，

可以用库函数 withIndex

#### 3.5.4　while循环 

while 和 do .. while使用方式跟C、Java语言基本一致

#### 3.5.5　break和continue 

break 和 continue 都是用来控制循环结构的，主要是用来停止循环（中断跳转）。

break 用于完全结束一个循环，直接跳出循环体，然后执行循环后面的语句。

continue 是只终止本轮循环，但是还会继续下一轮循环。

#### 3.5.6　return 

使用return的编码风格更加容易阅读理解。

除了表达式的值，有返回值的函数都要求显式使用 return 来返回其值。

可以直接使用 = 符号来直接返回一个函数的值

函数体语句有没有大括号 {} 意思完全不同

sumf ， maxf 的返回值是函数类型：
在Kotlin中，调用无参函数也是要加上括号 () 的。
return 语句会从最近的函数或匿名函数中返回，但是在Lambda表达式中遇到return，
则直接返回最近的外层函数

#### 3.5.7　标签 

在 Kotlin 中任何表达式都可以用标签（label）来标记。 标签的格式为标识符后跟 @ 符号，例
如： abc@ 、 jarOfLove@ 都是有效的标签。我们可以用Label标签来控制 return 、 break 或
continue 的跳转（jump）行

为了代码可读性，我们可以用标签来显式地指出循环体的跳转地址

#### 3.5.8　throw表达式 

在 Kotlin 中 throw 是表达式，它的类型是特殊类型 Nothing。 该类型没有值。跟C、Java中的 void 意思一样。

用 Nothing 来标记无返回的函数

如果把一个throw表达式的值赋值给一个变量，需要显式声明类型为 Nothing

### 3.6　代码注释 

Kotlin 支持行注释及块注释。
// 这是一个行注释
/* 这是一个多行的
块注释。 */

Kotlin 的块注释可以嵌套

### 3.7　语法与标识符 

词法分析是将源程序读入的字符序列，按照一定的规则转换成词法单元（Token）序列的过程。词法单元是语言中具有独立意义的最小单元，包
括修饰符、关键字、常数、运算符、边界符等等。

#### 3.7.1　修饰符 

modifier
: classModifier
: accessModifier
: varianceAnnotation
: memberModifier
: parameterModifier
: typeParameterModifier
: functionModifier
: propertyModifier
;
classModifier 类修饰符
: "abstract" 抽象类
: "final" 不可被继承final类
: "enum" 枚举类
: "open" 可继承open类
: "annotation" 注解类
: "sealed" 密封类
: "data" 数据类
;
memberModifier
: "override" 重写函数
: "open" 可被重写
: "final" 不可被重写
: "abstract" 抽象函数
: "lateinit" 后期初始化
;
accessModifier 访问权限控制, 默认是public
: "private"
: "protected"
: "public"
: "internal" 整个模块内（模块(module)是指一起编译的一组 Kotlin 源代码文件: 例如，一个 Int
elliJ IDEA 模块，一个 Maven 工程, 或 Gradle 工程，通过 Ant 任务的一次调用编译的一组文件等）
可访问
;
varianceAnnotation 泛型可变性
: "in"
: "out"
;
parameterModifier
: "noinline"
: "crossinline"
: "vararg" 变长参数
;
typeParameterModifier
: "reified"
;
functionModifier
: "tailrec" 尾递归
: "operator"
: "infix"
: "inline"
: "external"
: suspendModifier
;
propertyModifier
: "const"
;
suspendModifier
: "suspend"
;

#### 3.7.2　关键字（保留字） 

**this 关键字**

this 关键字持有当前对象的引用。我们可以使用 this 来引用变量或者成员函数，也可以使
用 return this ，来返回某个类的引用。

在类的成员中，this 指向的是该类的当前对象。
在扩展函数或者带接收者的函数字面值中， this 表示在点左侧传递的 接收者参数。

如果 this 没有限定符，它指的是最内层的包含它的作用域。如果我们想要引用其他作用域中的
this，可以使用 this@label 标签。

**super 关键字**

super关键字持有指向其父类的引用。

#### 3.7.3　操作符和操作符的重载 

Kotlin 允许我们为自己的类型提供预定义的一组操作符的实现。这些操作符具有固定的符号表示
（如 + 或 * ）和固定的优先级

#### 3.7.4　操作符优先级 

优先级
标题符号
最高
后缀（Postfix ） ++ , -- , . , ?. , ?
前缀（Prefix） - , + , ++ , -- , ! , labelDefinition @
右手类型运算（Type RHS，
right-hand side class type
(RHS) ）
: , as , as?
乘除取余（Multiplicative） * , / , %
加减（Additive ） + , -
区间范围（Range） ..
Infix函数
例如，给 Int 定义扩展 infix fun Int.shl(x:
Int): Int {...} ,这样调用 1 shl 2 ，等同
于 1.shl(2)
Elvis操作符 ?:
命名检查符（Named
checks） in , !in , is , !is
比较大小（Comparison） < , > , <= , >=
相等性判断（Equality) == , \!==
与 （Conjunction） &&
或 （Disjunction） ll
最低
赋值（Assignment） = , += , -= , *= , /= , %=

重载操作符的函数需要用 operator 修饰符标记。中缀操作符的函数使用 infix 修饰符标记。

#### 3.7.5　一元操作符 

前缀操作符

+a a.unaryPlus()
-a a.unaryMinus()
!a a.not()

当编译器处理表达式 +a 时，它将执行以下步骤：
确定 a 的类型，令其为 T 。
为接收者 T 查找一个带有 operator 修饰符的无参函数 unaryPlus（） ，即成员函数或扩
展函数。
如果函数不存在或不明确，则导致编译错误。
如果函数存在且其返回类型为 R ，那就表达式 +a 具有类型 R 。

递增和递减

a++ a.inc() 返回值是 a
a-- a.dec() 返回值是 a
++a a.inc() 返回值是 a+1
--a a.dec() 返回值是 a-1

#### 3.7.6　二元操作符 
### 3.8　扩展函数和扩展属性 
#### 3.8.1　扩展函数 
#### 3.8.2　扩展属性 
### 3.9　空指针安全 
### 3.10　标准库API简介 
