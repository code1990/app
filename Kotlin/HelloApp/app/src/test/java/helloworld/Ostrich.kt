package helloworld

//子类也可以定义新的成员属性和成员方法，或者重写被声明为open的父类方法。
class Ostrich(name: String = "bird", sex: Int = Bird.MALE): Bird(name, sex) {
    //继承 protected 的方法，标准写法是“override protected”
    //override protected fun getSexName(sex:Int):String {
    //不过protected的方法继承过来默认就是protected，所以也可直接省略protected
    //override fun getSexName(sex:Int):String {
    //protected的方法继承之后允许将可见性升级为public，但不能降级为private
    override public fun getSexName(sex: Int): String {
        return if (sex == 0) "雄" else "雌"
    }
}