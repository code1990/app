package easykotlin

class OverridesFunWithDefaultParams {
    fun f1(a:Int,b:String="B"){

    }
    @JvmOverloads
    fun f2(a:Int,b:String="B"){

    }
}