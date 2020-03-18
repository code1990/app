// 第14章　使用 Kotlin DSL 438
// 嵌套DSL 风格的代码来替代 XML 式风格 的视图文件
//DSL（Domain-Specific Language，领域特定语言）指的是专注于特定问题领域的计算机语言（领域专用语言）
//DSL 提供了思考特定领域问题的模型语言，这使得我们可以更加简单高效地来解决问题。
// 14.1　什么是DSL 439
//封装完OkHttp之后，看看如何来编写get请求
//http {
//
//    url = "http://www.163.com/"
//
//    method = "get"
//
//    onSuccess {
//
//            string -> L.i(string)
//
//    }
//
//    onFail {
//
//            e -> L.i(e.message)
//
//    }
//
//}

// 14.2　Kotlin的DSL特性支持 441
//kotlinx.html是可在 Web 应用程序中用于构建 HTML 的 DSL。 它可以作为传统模板系统
// 14.3　使用kotlinx.html DSL写前端代码 442
// 14.4　实现一个极简的HTTP DSL 447
