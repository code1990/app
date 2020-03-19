package easykotlin

import java.lang.Exception

class CheckKotlinException {
    @Throws(Exception::class)
    fun funWithException(){
        throw Exception("111")
    }
}