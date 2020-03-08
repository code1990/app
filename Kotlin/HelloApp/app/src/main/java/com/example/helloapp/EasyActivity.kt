package com.example.helloapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_easy.*

/**
 * Created by Administrator on 2020/3/8.
 */
class EasyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_easy)

        tv_hello.text = "hello"
        btn_click.setOnClickListener {
            btn_click.text = "click"
        }
        btn_click_long.setOnLongClickListener {
            btn_click_long.text = "long click";
            true
        }
        btn_toast.setOnClickListener {
            btn_toast.text = "click"
        }
        btn_toast_long.setOnLongClickListener {
            btn_toast_long.text = "long click"
            true
        }

    }


}