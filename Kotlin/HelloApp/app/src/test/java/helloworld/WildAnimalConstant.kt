package helloworld

class WildAnimalConstant(var name: String, val sex: Int = MALE) {
    var sexName: String

    init {
        sexName = if (sex == 0) "male" else "female"
    }

    fun getDesc(tag: String): String {
        return "$tag" + sexName
    }

    //在类加载时就运行伴生对象的代码块
    //关键字companion表示伴随，object表示对象，WildAnimal表示伴生对象的名称
    companion object WildAnimal {
        //静态常量的值是不可变的，所以要使用关键字val修饰
        val MALE = 0
        val FEMALE = 1
        val UNKNOWN = -1
        fun judgeSex(sexName: String): Int {
            var sex: Int = when (sexName) {
                "male" -> MALE
                "female" -> FEMALE
                else -> -UNKNOWN
            }
            return sex
        }
    }
}