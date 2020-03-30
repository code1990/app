package helloworld

import java.text.SimpleDateFormat
import java.util.*

//关键字object用来声明单例对象，就像Java中开发者自己定义的Utils工具类
//其内部的属性等同于Java中的static静态属性，外部可直接获取属性值
object DateUtil {
    ////外部访问DateUtil.nowDateTime时，会自动调用nowDateTime附属的get方法得到它的值
    val nowDateTime: String
        get() {
            val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            return sdf.format(Date())
        }

    val nowDate: String
        get() {
            val sdf = SimpleDateFormat("yyyy-MM-dd")
            return sdf.format(Date())
        }

    val nowTime: String
        get() {
            val sdf = SimpleDateFormat("HH:mm:ss")
            return sdf.format(Date())
        }

    val nowTimeDetail: String
        get() {
            val sdf = SimpleDateFormat("HH:mm:ss.SSS")
            return sdf.format(Date())
        }

    //返回开发者指定格式的日期时间字符串
    fun getFormatTime(format: String = ""): String {
        val fmt: String = format
        val sdf = if (!fmt.isEmpty()) SimpleDateFormat(fmt) else SimpleDateFormat("yyyyMMddHHmmss")
        return sdf.format(Date())
    }
}