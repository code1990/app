package easykotlin

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class SAMFunctionalInterfaceTest {
    @Test
    fun testSAM(){
        val runnable= Runnable { println("执行单元测试") }
        val thread= Thread(runnable)
        thread.start()
    }
}