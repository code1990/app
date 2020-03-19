package easykotlin

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MathToolsTest {
    @Test
    fun testInfo(){
        println(MathTools().`is`(1))
    }
}