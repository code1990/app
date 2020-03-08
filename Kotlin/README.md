# kotlin开发语言的学习

HelloApp项目bug

# Conflict with dependency 'com.android.support:support-annotations' in project ':app'

依赖冲突问题的处理

```csharp
apply plugin: 'com.android.application'
android {
  //省略
  configurations.all {
      resolutionStrategy.force 'com.android.support:support-annotations:26.1.0'
  }
}
```

本项目采取oppor9s真机调试 所以api选择23

顺利通过测试

-------------

|Anko是使用Kotlin语言编写的一个Android增强库，它用于简化Android开发时的Kotlin代码，使得开发者只用较少的Kotlin代码便能表达完整的编程含义，同时也让App代码变得更加简洁易懂。

Lambda表达式其实是一个匿名函数，匿名函数指的是：它是一个没有名字的函数，但函数体的内部代码是完整的。