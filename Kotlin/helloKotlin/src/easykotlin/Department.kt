package easykotlin

class Department {
    var id: Long = -1L
    var name: String = "dept"
    var isOpen: Boolean = true
    var isBig: String = "Y"
    //Kotlin编译器在处理的时候，将不会给这个字段生成getters/setters方法
    @JvmField
    var NO = 0

    companion object {
        var innerId = "1"//私有的
        @JvmField
        var innerName = "12"//公开的

        fun getObject() = "1"
        @JvmStatic
        fun getObjectId() = "2"
    }

    fun getGrade(score: Int): String {
        var grade = when (score) {
            9, 10 -> "A"
            in 6..8 -> "B"
            4, 5 -> "C"
            in 1..3 -> "D"
            else -> "E"
        }
        return grade
    }
}