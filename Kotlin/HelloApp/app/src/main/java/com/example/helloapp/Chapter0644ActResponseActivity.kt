package com.example.helloapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_act_response.*

class Chapter0644ActResponseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_response)
        btn_act_response.setOnClickListener {
            val response = Chapter0642MessageInfo(et_response.text.toString()
                    , Chapter0641DateUtil.nowTime)
            val intent = Intent()
            intent.putExtra("message", response)
            //调用setResult方法表示携带应答参数返回到上一个页面
            setResult(Activity.RESULT_OK, intent)
            finish()


        }
        val request = intent.extras.getParcelable<Chapter0642MessageInfo>("message")
        tv_response.text = "请求时间为${request.send_time}\n请求内容为${request.content}"
    }
}