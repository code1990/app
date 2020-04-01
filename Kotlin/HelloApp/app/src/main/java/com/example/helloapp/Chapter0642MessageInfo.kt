package com.example.helloapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
/*
修改文件build.gradle
* //@Parcelize标记需要设置 experimental = true
androidExtensions {
experimental = true
}
* */
//@Parcelize注解表示自动实现Parcelable接口的相关方法
@Parcelize
data class Chapter0642MessageInfo(val content:String,val send_time:String) : Parcelable {

}