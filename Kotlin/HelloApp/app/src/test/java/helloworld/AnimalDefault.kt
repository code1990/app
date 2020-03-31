package helloworld
//类的主构造函数使用了默认参数
////加上@JvmOverloads的目的是让Java代码也能识别默认参数
////因为添加了注解标记，所以必须补上关键字constructor
class AnimalDefault @JvmOverloads constructor(name:String,sex:Int=0) {
    init {
        println(name+sex)
    }
}