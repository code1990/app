package com.example.helloapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_act_second.*

class Chapter0642ParcelableSecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parcelable_second)
        //获得Parcelable格式的请求参数
        val request = intent.extras.getParcelable<Chapter0642MessageInfo>("message")
        tv_response.text = "${request.send_time}"
    }
}