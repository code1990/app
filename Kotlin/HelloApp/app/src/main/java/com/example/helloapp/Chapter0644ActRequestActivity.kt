package com.example.helloapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_act_first.btn_act_request
import kotlinx.android.synthetic.main.activity_act_first.et_request
import kotlinx.android.synthetic.main.activity_act_request.*
import org.jetbrains.anko.startActivityForResult

class Chapter0644ActRequestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_request)
        btn_act_request.setOnClickListener {
            val info = Chapter0642MessageInfo(et_request.text.toString(), Chapter0641DateUtil.nowTime)
            //ForResult表示需要返回参数
            startActivityForResult<Chapter0644ActResponseActivity>(0, "message" to info)
        }
    }

    //从下个页面返回到本页面时回调onActivityResult方法
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (data != null) {
            //获得下一个页面的应答参数
            val response = data.extras.getParcelable<Chapter0642MessageInfo>("message")
            tv_request.text = "${response.send_time}"
        }
    }
}