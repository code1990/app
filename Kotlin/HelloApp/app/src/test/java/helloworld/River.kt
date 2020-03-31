package helloworld
//在类名后面添加"<T>"，表示这是一个模板类
class River<T>(var name:String,var length:T) {
    fun getInfo():String{
        var unit:String=when(length){
            is String ->"meter"
            is Number->"m"
            else ->""
        }
        return "${name}的长度是$length$unit"
    }
}