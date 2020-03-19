package easykotlin

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.util.*

@RunWith(JUnit4::class)
class ProductTest {
    @Test
    public fun testGetterSetter(){
        val product = Product()
        product.name=""
        product.category=""
        product.gmtCreated= Date()
        product.gmtModified=Date()
        println(product.toString())
        Assert.assertTrue(product.name=="")

        val product2=Product()
        val name = product2.name
        println(name.substring(1))
    }

}