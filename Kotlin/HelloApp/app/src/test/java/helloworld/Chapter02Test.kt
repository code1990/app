package helloworld

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class Chapter02Test {
    @Test
    fun test21() {
        //2.1基本数据类型
        //Kotlin的基本数据类型包括整型、长整型、浮点型、双精度、布尔型、字符型、字符串这几种常见类型
        //2.1.1基本类型的变量声明
        //变量名:变量类型=变量值
//        var 修饰过的可以再次赋值
        var a: Int = 10
//        可以把val看作是Java里的final关键字
        val b: Double = 2.0
        //2.1.2简单变量之间的转换
        //只能调用类型转换函数输出其他类型的变量
        println(a.toString())
        println(a.toShort())
        println(a.toLong())
        println(a.toFloat())
        println(a.toDouble())
        println(a.toChar())
        println(a.toByte())
        println(b.toInt())
    }

    @Test
    fun test22() {
        //2.2数组
        //2.2.1数组变量的声明
        //Java中声明数组 int[] int_array = new int[] {1, 2, 3};
        //Kotlin调用的是intArrayOf方法，并不使用new关键字
        var array_int = intArrayOf(1, 2, 3)
        println(array_int.size)
        val array_long = longArrayOf(1, 2, 3)
        val array_float = floatArrayOf(1.0F, 2.0F)
        val array_double = doubleArrayOf(1.0, 2.0)
        val array_bool = booleanArrayOf(false, true)
        val array_char = charArrayOf('a', 'b', 'c')
        //在Kotlin这里，并不存在名为StringArray的数组类型，因为String是一种特殊的基本数
        //据类型◦
        var array_string: Array<String> = arrayOf("are", "you", "ok")
        //其他类型的数组变量也能通
        //过“Array<数据类型>”的方式来声明
        var int_array: Array<Int> = arrayOf(1, 2, 3)
        var long_array: Array<Long> = arrayOf(1, 2, 3)
        var float_array: Array<Float> = arrayOf(1.0f, 2.0f)
        var bool_array: Array<Boolean> = arrayOf(true, false, false)
        var char_array: Array<Char> = arrayOf('a', 'b')
        //2.2.2数组元素的操作
        //(1)对于如何获取数组长度，Java使用.length，而Kotlin使用.size。
        //(2)对于如何获取指定位置的数组元素，Java通过方括号加下标来获取，
        //Kotlin也能通过方括号加下标来获取指定元素，不过Kotlin还拥有get和set两个方法
        var string_array2: Array<String> = arrayOf("are", "you", "ok")
        var i: Int = 0
        var str: String = ""
        while (i < string_array2.size) {
            str += string_array2[i] + ","
            i++
        }
        println(str)
        string_array2.set(3, "?")
        println(string_array2.get(2))
    }

    @Test
    fun test23() {
        //2.3字符串
        //2.3.1字符串与基本类型的转换
        //在Kotlin这边，转换类型相对简单，并且与基本数据类型之间的转换形式保持一致，即都是采取“to***〇”的形式
        println(1.toShort())
        //2.3.2字符串的常用方法
        //在Kotlin中，split方法返回的是String队列，即List<String>
        var str: String = "1,2,3"
        var list: List<String> = str.split(",")
        println(list.size)
        println(str.replace(",", "."))
        if (str.indexOf(".") > 0) {
            println(str.substring(0, 1))
            println(str[0].toString())
        }
        //Kotlin允许直接通过下标访问字符串指定位置的字符
        //2.3.3字符串模板及其拼接
        //直接在字符串中加入“$变量名”即可表示此处引用该变量的值
        println("$str 的长度为 ${str.length}")
    }

    @Test
    fun test24() {
        //2.4容器
        //2.4.1容器的基本操作
        //Kotlin号称全面兼容Java，于是Java的容器类仍可在Kotlin中正常使用，
        //包括大家熟悉的队列ArrayList、映射HashMap等◦
        //分别是集合Set、队列List、映射Map，然后每类容器又分作只读与可变两种类型
        //这些公共方法具体说明如下。
        //•isEmpty:判断该容器是否为空。
        //•isNotEmpty:判断该容器是否非空。
        //•clear:清空该容器。
        //•contains:判断该容器是否包含指定元素。
        //•iterator:获取该容器的迭代器。
        //•count:获取该容器包含的元素个数，也可通过size属性获得元素数量。
        //Kotlin允许在声明容器变量时就进行初始赋值
        ////只读集合Set、只读队列List、只读映射Map
        ////比如MutableSet表示可变集合，MutableList表示可变队列，MutableMap表示可变映射
        //2.4.2集合SetMutableSet
        //集合是一种最简单的容器，它具有以下特性：
        //(1)容器内部的元素不按顺序排列，因此无法按照下标进行访问。
        //(2)容器内部的元素存在唯一性，通过哈希值校验是否存在相同的元素，若存在，则将其覆盖。
        //Set是只读集合，初始化赋值后便不可更改
        //MutableSet的变更操作尚有以下限制：
        //(1)MutableSet的add方法仅仅往集合中添加元素，
        //(2)MutableSet没有修改元素值的方法，一个元素一旦被添加，就不可被修改。
        //(3)MutableSet的remove方法用于删除指定元素，但无法删除某个位置的元素
        val goodSet:Set<String> = setOf("1","2","3")
        for (item in goodSet){
            println(item)
        }
        //迭代器与指针的概念有点接近，它自身并非具体的元素，而是指向元素的存放地址
        val iterator = goodSet.iterator()
        while (iterator.hasNext()){
            println(iterator.next())
        }
        //实际开发基本用不到集合
        //2.4.3队列ListMutableList
        //凡是涉及增、删、改的，都必须由MutableList来完成：
        //(1)队列能够通过get方法获取指定位置的元素，也可以直接通过下标获得该位置的元
        //(2)MutableList的add方法每次都是把元素添加到队列末尾，也可指定添加的位置。
        //(3)MutableList的set方法允许替换或者修改指定位置的元素。
        //(4)MutableList的removeAt方法允许删除指定位置的元素。
        val goodList:List<String> = listOf("111","22222","3")
        //indices是队列的下标数组。如果队列大小为10,下标数组的取值就为0〜9
        for (i in goodList.indices){
            println(goodList[i])
        }
        //6) MutableList提供了sort系列方法用于给队列中的元素重新排序，其中sortBy方法表
        //示按照指定条件升序排列，sortByDescending方法表示按照指定条件降序排列
        var sortAsc = true
        if (sortAsc){
            ////sortBy表示升序排列，后面跟的是排序条件
            goodList.sortedBy { it.length }
        }else{
            //sortByDescending表示降序排列，后面跟的是排序条件
            goodList.sortedByDescending { it.length }
        }
        //2.4.4映射MapMutableMap
        //增、删操作必须由MutableMap来完成）：
        //⑴映射的containsKey方法判断是否存在指定键名的元素，containsValue方法判断是否
        //存在指定键值的元素。
        //⑵MutableMap的put方法不单单是添加元素，而是智能的数据存储。每次调用put方法
        //时，映射会先根据键名寻找同名元素，如果找不到就添加新元素，如果找得到就用新元
        //素替换旧元素。
        //(1)MutableMap的remove方法是通过键名来删除元素的。
        //调用mapOf和mutableMapOf方法初始化映射时，有两种方式可以表达单个键值对元素，
        //其一是采取“键名to键值”的形式，
        //其二是采取Pair配对方式，形如“Pair(键名，键值)。
        var goodsMap:Map<String,String> = mapOf("苹果" to "apple")
        var goodsMutMap:MutableMap<String,String> = mutableMapOf(Pair("苹果","apple"))
        for(item in  goodsMap){
            println(item.key+item.value)
        }
        val iterator2 = goodsMap.iterator()
        ////如果迭代器还存在下一个节点，就继续取出下一个节点的记录
        while (iterator2.hasNext()){
            println(iterator2.next())
        }
        ////forEach内部使用key指代每条记录的键，使用value指代每条记录的值
        goodsMap.forEach { key, value -> println(key+value) }
    }
}
