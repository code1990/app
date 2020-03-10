第11章 使用Kotlin集成SpringBoot开发Web服务端

11.1 Spring Boot简介

11.2 统架构技术栈

编程语言Java，Kotlin
数据库MySQL , mysql-jdbc-driver, Spring data JPA,
J2EE框架Spring Boot, Spring MVC
视图模板引擎Freemarker
前端组件库jquery，bootstrap, flat UI , Mditor , DataTables
工程构建工具Gradle

11.3 环境准备
11.3.1 创建工程

CREATE SCHEMA `blog` DEFAULT CHARACTER SET utf8 ;

11.3.2 Gradle配置文件说明

11.4 数据库层配置

11.4.1 配置数据源

11.5 Endpoint监控接口

http://127.0.0.1:8000/application/beans

management.security.enabled=false

11.6 数据库实体类

11.7 数据访问层代码

需要实现接口 CrudRepository<T, ID> 即可获得一个拥有基本CRUD操作的接口实现

11.7.1 原生SQL查询
其中，@Query注解里面的value的值就是我们要写的 JP QL语句。另外，JPA的EntityManager API
还提供了创建 Query 实例以执行原生 SQL 语句的createNativeQuery方法。
默认是非原生的JP QL查询模式。如果我们想指定原生SQL查询，只需要设置 nativeQuery=true 即可。

11.7.2 模糊查询like写法

在JP QL中, 这样写like %?1%

11.7.3 参数占位符
其中，查询语句中的 ?1 是函数参数的占位符，1代表的是参数的位置。
11.7.4 JP QL中的SpEL
另外我们使用JPA的标准查询（Criteria Query）：
SELECT a FROM #{#entityName} a where a.content like %:content%
其中的 #{#entityName} 是SpEL（Spring表达式语言），用来代替本来实体的名称，而Spring data
jpa会自动根据Article实体上对应的默认的 @Entity class Article ，或者指定 @Entity(name =
"Article") class Article 自动将实体名称填入 JP QL语句中

11.7.5 注解参数
我们使用 @Param("content") 来指定参数名绑定，然后在JP QL语句中这样引用：
:content

11.8 控制器层

@Autowired val articleRepository: ArticleRepository? = null

11.9 启动初始化CommandLineRunner

在SpringBoot应用启动的时候初始化几条数据到数据库里。Spring Boot 为我们提供了一个方法，通过实现接口 CommandLineRunner 来实现

11.10 应用启动类
我们在main函数中调用SpringApplication类的静态run方法，我们的SpringBootApplication主类代码

11.10.1 启动运行

11.11 Model数据绑定
我们写一个返回ModelAndView对象控制器类

11.12 模板引擎视图页面

11.13 运行测试

11.14 引入前端组件
我们使用基于Bootstrap的前端UI库Flat UI。http://www.bootcss.com/p/flat-ui/

11.15 实现写文章模块

11.15.1 加上导航栏

11.15.2 抽取公共模板文件

11.15.3 写文章的控制器层接口

11.15.4 前端 ajax 请求

11.15.5 文章详情页

11.16 添加Markdown支持
使用前端js组件Mditor来支持Markdown的编辑。

11.16.1 引入静态资源

11.16.2 初始化Mditor

使用了代码高亮插件highlight.js

11.16.3 文章详情显示Markdown渲染

11.17 文章列表分页搜索
为了方便检索我们的博客文章，我们再来给文章列表页面添加分页、搜索、排序等功能。我们使用
前端组件DataTables来实现。

11.17.1 引入静态资源文件

11.17.2 给表格加上id

11.17.3 调用DataTable函数

11.18 Spring 5.0对Kotlin的支持

Spring 对 Java 8 的新支持：函数式 Web 编程、bean 注册 API ， 这同样可以在 Kotlin 中使用。

11.18.1 一种注册 Bean 的新方法

例如用 Java 代码我们会这样写：
GenericApplicationContext context = new GenericApplicationContext();
context.registerBean(Foo.class);
context.registerBean(Bar.class, () -> new
Bar(context.getBean(Foo.class))
);
而使用 Kotlin 我们可以将代码写成这样:
val context = GenericApplicationContext {
registerBean<foo>()
registerBean { Bar(it.getBean<foo>()) }
}

11.18.2 Spring Web 函数式 API
Spring 5.0 中的 RouterFunctionDsl 可以让我们使用干净且优雅的 Kotlin 代码来使用崭新的 Spring
Web 函数式 API

```kotlin
fun route(request: ServerRequest) = RouterFunctionDsl {
accept(TEXT_HTML).apply {
(GET("/user/") or GET("/users/")) { findAllView() }
GET("/user/{login}") { findViewById() }
}
accept(APPLICATION_JSON).apply {
(GET("/api/user/") or GET("/api/users/")) { findAll() }
POST("/api/user/") { create() }
POST("/api/user/{login}") { findOne() }
}
} (request)
```

11.18.3 Reactor Kotlin 扩展
Reactor 是 Spring 5.0 中提供的响应式框架。而 reactor-kotlin 项目则是对 Reactor 中使用Kotlin 的支持。目前该项目正在早期阶段。

11.18.4 基于 Kotlin脚本的 Gradle 构建配置

11.18.5 基于模板的 Kotlin 脚本
从 4.3 版本开始，Spring 提供了一个 ScriptTemplateView，用于利用支持 JSR-223 的脚本引擎来渲
染模板。 Kotlin 1.1-M04 提供了这样的支持，并支持渲染基于 Kotlin 的模板