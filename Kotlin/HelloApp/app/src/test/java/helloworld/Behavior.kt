package helloworld

interface Behavior {
    //Kotlin与Java—样不允许多重继承，即不能同时继承两个及两个以上类
    //所以仍然需要接口 interface来间接实现多重继承的功能
    //接口不能带构造函数
    //接口内部的方法默认就是抽象的，所以不加abstract也可以，当然open也可以不加
    open abstract fun fly():String
    //比如下面这个swim方法就没加关键字abstract，也无须在此处实现方法
    //Kotlin接口内部允许实现方法
    fun swim():String
    //接口内部的所有方法都默认是open类型
    fun run():String {
        return "run quickly"
    }
    //Kotlin的接口允许声明抽象属性，实现该接口的类必须重载该属性
    //与接口内部方法一样，抽象属性前面的open和abstract也可省略掉
    var skilledSports:String
}