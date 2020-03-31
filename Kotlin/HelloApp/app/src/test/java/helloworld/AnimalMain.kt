package helloworld

class AnimalMain constructor(name:String){
    init {
        println("$name")
    }
    //⑴二级构造函数没有函数名称，只用关键字constructor表示这是一个构造函数。
    //(2)二级构造函数需要调用主构造函数◦
    constructor(name: String,sex:Int):this(name){
        var sexName:String = if(sex==0) "male" else "female"
        println(sexName)
    }
}