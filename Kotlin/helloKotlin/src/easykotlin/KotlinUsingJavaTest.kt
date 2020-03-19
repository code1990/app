package easykotlin

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
//Kotlin的集合类API很多就是直接使用的Java的API来实现的
class KotlinUsingJavaTest {

    @Test
    fun testArrayList(){
        val source = listOf<Int>(1,2,3,4,5)
        //使用java的arraylist
        val list = ArrayList<Int>()
        for (item in source){
            list.add(item)
        }
        for(i in 0..source.size-1){
            list[i]=source[i]
        }
    }

}