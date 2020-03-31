package helloworld

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class Chapter05Test {
    @Test
    fun test51() {
        //5.1类的构造
        //5.1.1类的简单定义
        //Kotlin对类的写法与Java之间有以下几点区别:
        //(1)Kotlin省略了关键字public，缘于它默认就是开放的。
        //(2)Kotlin用冒号“:”代替extends，也就是通过冒号表示继承关系。
        //(3)Kotlin进行继承时，父类后面多了括号“()”。
        //所以声明对象时可以不用指定它的类型
        var animal = Animal()
        //5.1.2类的构造函数
        //Kotlin引入了主构造函数与二级构造函数的概念
        //跟在类名后面的参数是主构造函数的入参，
        //同时init方法是主构造函数的内部代码。
        //至于二级构造函数，则可以在类内部直接书写完整的函数表达式。
        var animal2 = AnimalMain("a")
        var animal3 = AnimalMain("a", 1)
        //Kotlin设定了主构造函数不是必需的，
        //可以把几个构造函数都放在类内部定义，从而都变成二级构造函数
        var animal4 = AnimalSeparate("a", 1)
        //5.1.3带默认参数的构造函数
        //类的构造函数同样也能添加默认参数。
        var animal5 = AnimalDefault("a")
        //若想让Java也能识别构造函数的默认参数，得往该类的构造函数添加注解“@JvmOverloads”，
        //告知编译器这个类是给Java重载用的
        //Java代码不允许直接支持默认参数
        //若想让Java代码识别默认参数，则需给该类的构造函数添加注解
//        @JvmOverloads
//        AnimalDefault animal5 = new AnimalDefault("a");
//        //Java代码必须调用参数完整的构造函数
//        AnimalDefault animal5 = new AnimalDefault("a", 1);
    }

    @Test
    fun test52() {
        //5.2类的成员
        //5.2.1成员属性
        var animal = WildAnimal("a")
        println(animal.toString())
        //5.2.2成员方法
        animal.getDesc("动物园")
        //5.2.3伴生对象
        //Kotlin引入了伴生对象的概念，可以把它理解为“影子
        println(WildAnimalCompanion.WildAnimal.judgeSex("male"))
        //简化写法 类似于静态方法
        println(WildAnimalCompanion.judgeSex("male"))
        //5.2.4静态属性
        println(WildAnimalConstant.MALE)
    }

    @Test
    fun test53() {
        //5.3类的继承
        //5.3.1开放性修饰符
        //Kotlin恰恰相反，它默认每个类都不能被继承，
        //如果要让某个类成为基类，就需把该类开放出来，也就是添加关键字open作为修饰符
        //public:默认是public类型
        //internal：对本模块内部开放，指APP自身
        //protected:对自身+子类开放
        //private:对自身开放
        //open不控制某个对象的访问权限
        //open与private二者不兼容
        var bird = Bird("bird")
        //5.3.2普通类继承
        var duck = Duck(sex = 0)
        var ostrich = Ostrich(sex = 1)
        //Kotlin也存在与Java类似的抽象类，抽象类之所以存在，
        //是因为其内部拥有被关键字abstract修饰的抽象方法。抽象方法没有具体的函数体，故而
        //外部无法直接声明抽象类的实例；只有在子类继承时重写抽象方法，方可使用该子类正
        //常声明对象实例。
        //5.3.3抽象类
        Cock().callOut(0)
        Hen().callOut(0)
        //5.3.4接口
        //继承列表中只允许出现一个类。
        //只能通过接口定义几个抽象方法，然后在实现该接口的具体类中重写这几个方法
        //(1)接口不能定义构造函数
        //(2)接口的内部方法通常要被实现它的类进行重写，所以这些方法默认为抽象类型。
        //(3)Kotlin允许在接口内部实现某个方法
        //Java的extends和implement这两个关键字在Kotlin中都被冒号取代了
        Goose().fly()
        Goose().swim()
        Goose().run()
        //5.3.5接口代理
        //即一个类先声明继承自某个接口，但并不直接实现该接口的方法，
        //而是把已经实现该接口的代理类作为参数传给前面的类，
        //相当于告诉前面的类：“该接口的方法我已经代替你实现了，你直接拿去用便是”
        //把代理类作为输入参数来创建实例
        WildFowl("老鹰", 1, BehaviorFly())
        WildFowl("企鹅", 1, BehaviorSwim())
        WildFowl("鸵鸟", 1, BehaviorRun())
        //(1) Kotlin的类默认不可被继承，若需继承，则要添加open声明
        //⑵Kotlin增加了修饰符internal，表示只对本模块开放。
        //(3)关键字extends,implement在Kotlin中都被冒号所取代。
        //(4)Kotlin允许在接口内部实现某个方法，而Java接口的内部方法只能是抽象方法。
        //(5)Kotlin引入了接口代理（类代理)的概念
    }

    @Test
    fun test54() {
        //5.4几种特殊类
        //5.4.1嵌套类
        //嵌套类，即A类嵌套在B类之中
        ////使用嵌套类时，只能引用外部类的类名，不能调用外部类的构造函数
        //相当于把这个嵌套类作为外部类的静态对象使用
        println(Tree.Flower("桃花"))
        //5.4.2内部类
        //把inner加在嵌套类的class前面，嵌套类华丽地转变为了内部类
        //内部类比起嵌套类的好处是能够访问外部类的成员
        ////使用内部类时，必须调用外部类的构造函数，否则编译器会报错
        val peach = Tree("桃树").Fruit("桃子");
        println(peach.getName())
        //5.4.3枚举类
        //将关键字enum作为class的修饰符，使之名正言顺地成为一种类	枚举类
        //通过构造函数能够给枚举值赋予更加丰富的含义
        //ordinal属性用于获取该枚举值的序号，name属性用于获取该枚举值的名称
        println(SeasonType.SPRING.name)
        println(SeasonType.SUMMER.name)
        println(SeasonType.AUTUMN.name)
        println(SeasonType.WINTER.name)
        println(SeasonType.SPRING.ordinal)
        println(SeasonType.SUMMER.ordinal)
        println(SeasonType.AUTUMN.ordinal)
        println(SeasonType.WINTER.ordinal)
        println(SeasonName.SPRING.name)
        println(SeasonName.SUMMER.name)
        println(SeasonName.AUTUMN.name)
        println(SeasonName.WINTER.name)
        println(SeasonName.SPRING.ordinal)
        println(SeasonName.SUMMER.ordinal)
        println(SeasonName.AUTUMN.ordinal)
        println(SeasonName.WINTER.ordinal)
        //5.4.4密封类
        //密封类就像是一种更加严格的枚举类，它内部有且仅有自身的实例对象，
        //所以是一个有限的自身实例集合。
        //定义密封类的时候，需要在该类的class前面加上关键字sealed作为标记
        var count = 1
        var season = when (count) {
            0 -> SeasonSealed.Spring("春天")
            1 -> SeasonSealed.Summer("夏天")
            2 -> SeasonSealed.Autumn("秋天")
            else -> SeasonSealed.Winter("冬天")
        }
        //密封类是一种严格的枚举类，它的值是一个有限的集合
        //密封类确保条件分支覆盖了所有的枚举类型，因此不再需要else分支
        var text = when (season) {
            is SeasonSealed.Spring -> season.name
            is SeasonSealed.Summer -> season.name
            is SeasonSealed.Autumn -> season.name
            is SeasonSealed.Winter -> season.name
        }
        //5.4.5数据类
        //数据类在class前面增加关键字“data”，并声明拥有完整输入参数的构造函数，
        //即可无缝实现以下功能：
        //(1)自动声明与构造函数入参同名的属性字段。
        //(2)自动实现每个属性字段的get/set方法。
        //(3)自动提供equals方法，用于比较两个数据对象是否相等。
        //(4)自动提供copy方法，允许完整复制某个数据对象
        //(5)自动提供toString方法
        //====================
        //(1)数据类必须有主构造函数，且至少有一个输入参数
        //(2)主构造函数的输入参数前面必须添加关键字val或者var
        //(3)数据类有自己的一套行事规则，所以它只能是个独立的类，不能是其他类型的类

        var lotus = Plant("莲", "莲藕", "莲叶", "莲花", "莲蓬", "莲子")
        //数据类的copy方法不带参数，表示复制一模一样的对象
        var lotus2 = lotus.copy()
        println(lotus.toString())
        println(lotus.equals(lotus2))
        //5.4.6模板类
        //常见的容器类ArrayList、HashMap均是模板类
        var river = when (count) {
            //模板类（泛型类）声明对象时，要在模板类的类名后面加上"< 参数类型>〃
            0 -> River<Int>("小溪", 100)
            //如果编译器根据输入参数就能知哓参数类型，也可直接省略"< 参数类型〉"
            1 -> River("濕布", 99.9f)
            //当然保守起见，新手最好按规矩添加"< 参数类型>〃
            2 -> River<Double>("山涧", 50.5)
            //如果你已经是老手了，怎么方便怎么来，Kotlin的设计初衷就是偷懒
            else -> River("大河", "一千")
        }
        println(river.toString())
    }
}
