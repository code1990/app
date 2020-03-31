package helloworld

//Kotlin恰恰相反，它默认每个类都不能被继承，
//如果要让某个类成为基类，就需把该类开放出来，也就是添加关键字open作为修饰符
////Kotlin的类默认是不能继承的（即final类型），如果需要继承某类，该父类就应当声明为
//open类型
open class Bird(var name: String, val sex: Int = 0) {
    //变量、方法、类默认都是public所以一般都把public省略掉了
    var sexName: String

    init {
        sexName = getSexName(sex)
    }

    ////私有的方法既不能被外部访问，也不能被子类继承，因此open与private不能共存
    open protected fun getSexName(sex: Int): String {
        return if (sex == MALE) "male" else "female"
    }

    companion object BirdStatic {
        val MALE = 0
        val FEMALE = 1
        val UNKNOWN = -1
        fun judegeSex(sexName: String): Int {
            var sex: Int = when (sexName) {
                "male" -> MALE
                "female" -> FEMALE
                else -> UNKNOWN
            }
            return sex
        }
    }
}