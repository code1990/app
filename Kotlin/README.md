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

