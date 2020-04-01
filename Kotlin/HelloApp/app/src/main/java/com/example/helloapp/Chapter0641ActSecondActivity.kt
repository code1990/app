package com.example.helloapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_act_second.*

class Chapter0641ActSecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_second)
        //获得请求参数的包裹
        val bundle = intent.extras
        val request_time = bundle.getString("request_time")
        val request_content = bundle.getString("request_content")
        tv_response.text = "收到请求消息：\n请求时间为${request_time}\n请求内容为${request_content}"


    }
}