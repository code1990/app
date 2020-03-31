package helloworld
//接着定义一个引用了代理类的野禽基类，
// 通过关键字by表示该接口将由入参中的代理类//实现
class WildFowl(name: String, sex: Int = 1, behavior: Behavior) : Bird(name, sex), Behavior by behavior {
}