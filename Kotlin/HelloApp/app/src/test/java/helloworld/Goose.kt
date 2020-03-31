package helloworld

class Goose(name:String="e",sex:Int=1):Bird(name, sex),Behavior {
    override fun fly(): String {
        return "fly"
    }

    override fun swim(): String {
        return "swim"
    }
////因为接口已经实现了 run方法，所以此处可以不用实现该方法，当然你要实现它也行
    override fun run(): String {
    ////super用来调用父类的属性或方法，由于Kotlin的接口允许实现方法，因此super
    //所指的对象也可以是interface
        return super.run()
    }
    //重载了来自接口的抽象属性
    override var skilledSports: String="swim"
}