package helloworld

class WildAnimalCompanion (var name:String,val sex:Int=0) {
    var sexName:String
    init {
        sexName = if(sex==0)"male" else "female"
    }
    fun getDesc(tag:String):String{
        return "$tag"+sexName
    }
    //在类加载时就运行伴生对象的代码块
    //关键字companion表示伴随，object表示对象，WildAnimal表示伴生对象的名称
    companion object WildAnimal{
        fun judgeSex(sexName:String):Int{
            var sex:Int= when(sexName){
                "male"->0
                "female"->1
                else -> -1
            }
            return sex
        }
    }
}