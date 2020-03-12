## 第2章　快速开始HelloWorld
### 2.1　命令行版HelloWorld 

Kotlin 命令行编译工具下载地址：https://github.com/JetBrains/kotlin/releases/tag/v1.1.2-2

配置path环境变量

kotlin -version

### 2.2　应用程序版HelloWorld

```
import java.util.Date
import java.text.SimpleDateFormat
fun main(args: Array<String>) {
println("Hello, world!")
println(SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date()))
}
```

### 2.3　Web RESTful HelloWorld 
### 2.4　Android版的HelloWorld 
### 2.5　JavaScript版HelloWorld 

```
fun helloWorld(){
println("Hello,World!")
}

//下面我们来新建一个index.html页面，使用我们生成的app.js。代码如下
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>KotlinJS</title>
</head>
<body>
<!-- 优先加载kotlin.js，再加载应用程序代码app.js-->
<script type="text/javascript" src="kotlin.js"></script>
<script type="text/javascript" src="jquery.js"></script>
<script type="text/javascript" src="js/app.js"></script>
74
<script>
var kotlinJS = app;
console.log(kotlinJS.com.easy.kotlin.helloWorld())
</script>
</body>
</html>
```



