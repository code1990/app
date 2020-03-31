package helloworld
//子类的构造函数，原来的输入参数不用加var和val，新增的输入参数必须加var或者val
//因为抽象类不能直接使用，所以构造函数不必给默认参数赋值
abstract class Chicken(name: String, sex: Int, var voice: String) : Bird(name, sex) {
    val numberArray:Array<String> = arrayOf("1","2")
    //抽象方法必须在子类进行重写，所以可以省略关键字open，因为abstract方法默认就是open类型
    abstract fun callOut(times:Int):String
}