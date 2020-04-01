package com.example.helloapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_act_first.*

class Chapter0642ParcelableFirstActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parcelable_first)
        btn_act_request.setOnClickListener {
            val request = Chapter0642MessageInfo(et_request.text.toString(),Chapter0641DateUtil.nowTime)
            //startActivity<Chapter0642ParcelableSecondActivity>("message" to request)
        }
    }
}