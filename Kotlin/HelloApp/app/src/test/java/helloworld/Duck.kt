package helloworld
//注意父类Bird已经在构造函数声明了属性，故而子类Duck无须重复声明属性
//也就是说，子类的构造函数在输入参数前面不需要再加val和var
class Duck(name:String="duck",sex:Int=Bird.MALE): Bird(name, sex) {
}