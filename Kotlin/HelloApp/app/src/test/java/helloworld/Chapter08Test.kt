package helloworld

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class Chapter08Test {
    @Test
    fun test81() {
        //8.1使用共享参数SharedPreferences
        //8.1.1共享参数读写模板Preference
        //8.1.2属性代理等黑科技
        //8.1.3实现记住密码功能
    }

    @Test
    fun test82() {
        //8.2使用数据库SQLite
        //8.2.1数据库帮助器SQLiteOpenHelper
        //8.2.2更安全的ManagedSQLiteOpenHelper
        //8.2.3优化记住密码功能
    }

    @Test
    fun test83() {
        //8.3文件IO操作
        //8.3.1文件保存空间
        //8.3.2读写文本文件
        //8.3.3读写图片文件
        //8.3.4遍历文件目录
    }

    @Test
    fun test84() {
        //8.4Application全局变量
        //8.4.1Application单例化
        //8.4.2利用Application实现全局变量
    }

    @Test
    fun test85() {
        //8.5实战项目：电商App的购物车
        //8.5.1需求描述
        //8.5.2开始热身：选项菜单OptionsMenu
        //8.5.3控件设计
        //8.5.4关键代码
    }
}
