package helloworld

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class Chapter06Test {
    @Test
    fun test61() {
        //Android中的视图分为两大类，一类是布局，另一类是控件。
        //布局本质上是个容器，内部还可以放其他视图（包括子布局和子控件）；
        //而控件是个单一的实体，已经是最后一级，下面不能再挂其他视图。
        //6.1使用按钮控件
        //Button是Android常用的控件之一
        //6.1.1按钮Button
        //接下来依次介绍按钮事件的三种Kotlin编码方式：匿名函数、内部类、接口实现。
        //Kotlin中的类型转换是通过关键字as实现的
        //
        //对于包含较多行代码的事件处理，往往给它单独定义一个内部类，这样该事件
        //的处理代码被完全封装在内部类之中，能够有效增强代码的可读性。
        //
        //接口实现
        //方式便应运而生，该方式让页面的Activity类实现事件监听器的接口，并重写监听器的接
        //口方法，使得这些接口方法就像是Activity类的成员方法一样，并且可以毫无障碍地访问
        //该Activity类的所有成员属性和成员方法。

        //ButtonClickActivity
        //6.1.2复选框CheckBox
        //CompoundButton类是抽象的复合按钮，因为是抽象类，所以并不能直接使用。
        //实际开发中用的是它的几个派生类，主要有复选框CheckBox、单选按钮RadioButton以及开
        //关按钮Switch，这些派生类均可使用CompoundButton的属性和方法。
        //Android处理复合按钮的勾选状态有两个Java方法：
        //setChecked和isChecked复选框CheckBox是复合按钮的一个简单实现
        //6.1.3单选按钮RadioButton
        //单选组RadioGroup实质上是一个布局，同一组的RadioButton都要放在同一个RadioGroup节点之下。
        //RadioGroup拥有orientation属性，可指定下级控件的排列方向，
        //该属性为horizontal时，单选按钮就在水平方向上排列；
        //该属性为vertical时，单选按钮就在垂直方向上排列◦
        //并且RadioGroup下面除了 RadioButton外，也可以挂载其他子控件，如TextView、ImageView等，
        //这样看来，它就是一个特殊的线性布局，只不过多了一个管理单选按钮的功能。
    }

    @Test
    fun test62() {
        //6.2使用页面布局
        //包括线性布局LinearLayout、相对布局RelativeLayout、
        //框架布局FrameLayout等，以及后起之秀约束布局ConstraintLayout。
        //6.2.1线性布局LinearLayout
        //线性布局主要有以下两种属性设置方法。
        //(1) setOrientation:设置内部视图的排列方向。LinearLayout.HORIZONTAL表示水平布
        //局，LinearLayout.VERTICAL表示垂直布局。
        //⑵setGravity:设置内部视图的对齐方式
        //由于线性布局的视图排列方式比较固定，既不能重叠显示也不能灵活布局，因此复杂一
        //些的界面往往用到相对布局RelativeLayout。相对布局内部的视图位置不依赖于排列规
        //则，而依赖于指定的参照物，这个参照物可以是与该视图平级的视图，也可以是该视图
        //的上级视图
        //6.2.2相对布局RelativeLayout
        //6.2.3约束布局ConstraintLayout
        //约束布局的出现正是为了解决这些问题，它兼顾灵活性和高效率，可
        //以看作是相对布局的升级版，在很大程度上改善了 Android的用户体验。
    }

    @Test
    fun test63() {
        //6.3使用图文控件
        //文本编辑框。编辑框与文本视图、图像视图一同组成Android三种常用的图文控件
        //6.3.1文本视图TextView
        //6.3.2图像视图ImageView
        //图像视图是另一种常用的基本控件，在基本的图文控件之中，TeXView用于显示文本内
        //容，而ImageView用于显示图像信息。
        //6.3.3文本编辑框EditText
        //文本编辑框EditText，用户可在编辑框里面输入包括文字、数字、标点在内的文本信息。
    }

    @Test
    fun test64() {
        //6.4Activity活动跳转
        //活动Activity是Android最常用的组件，一般来说，一个Activity就代表一个页面，所以活
        //动的用法就围绕着页面的运行过程而展开，包括活动的生命周期、活动是如何启动的、
        //活动页面之间是如何传递信息的
        //6.4.1传送配对字段数据
        //⑴Kotlin的完整写法是“this@类名”
        //(2)获取某个类的class对象Kotlin的写法是“类名::class.java”
        //6.4.2传送序列化数据
        //Activity之间传递的参数类型除了整型、浮点型、字符串等基本数据类型外，还允许传递
        //序列化结构，如Parcelable对象。
        //6.4.3跳转时指定启动模式
        //Anko库额外提供了intentFor方法，用于简单生成Intent对象，其书写格式类似于
        //startActivity方法
        //Android有两种方式用来设置Activity的启动模式，其一是修改AndroidManifest.xml，在指
        //定的activity节点添加属性launchMode，表示本活动以该启动模式来运行；其二是在代码
        //中给Intent对象调用setFlags方法，从而表明接下来打开的页面运用该启动标志。
        //6.4.4处理返回数据
    }

    @Test
    fun test65() {
        //6.5实战项目：电商App的登录页面
        //6.5.1需求描述
        //对于App而言，吸引用户注册并登录才是紧要之事，因为用户登录之后才有机会产生商品交易
        //6.5.2开始热身：提醒对话框AlertDialog
        //6.5.3控件设计
        //大致从上到下、从左到右分布着下列Android控件。
        //•单选按钮RadioButton:用来区分是密码登录还是验证码登录。
        //•文本视图TextView:输入框左侧要显示此处应该输入什么信息。
        //•编辑框EditText:用来输入手机号码和密码。
        //•复选框CheckBox:用于判断是否记住密码。
        //•按钮Button:除了“登录”按钮之外，还有“忘记密码”和“获取验证码”两个按钮。
        //•线性布局LinearLayout:指定手机号码的文本视图与手机号码的编辑框从左到右依次排列。
        //•相对布局RelativeLayout:忘记密码的按钮与密码输入框是叠加的，且“忘记密码”与上级视图右对齐。
        //•单选组RadioGroup:密码登录和验证码登录这两个单选按钮需要放在单选组布局之中。
        //6.5.4关键代码
    }
}
