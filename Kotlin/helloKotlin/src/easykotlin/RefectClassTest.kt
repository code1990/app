package easykotlin

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class RefectClassTest {
    @Test
    fun testGetterSetter() {
        val product = Product()
        val pClz = product::class.java
        println(pClz.canonicalName)
        pClz.declaredFields.forEach { print(it) }
        pClz.declaredMethods.forEach {
            print(it.name)
            it.parameters.forEach {
                println(it)
            }
        }
    }

}