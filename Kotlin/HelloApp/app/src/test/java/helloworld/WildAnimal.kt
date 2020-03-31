package helloworld

class WildAnimal(var name:String,val sex:Int=0) {
    var sexName:String
    init {
        sexName = if(sex==0)"male" else "female"
    }
    fun getDesc(tag:String):String{
        return "$tag"+sexName
    }
}
