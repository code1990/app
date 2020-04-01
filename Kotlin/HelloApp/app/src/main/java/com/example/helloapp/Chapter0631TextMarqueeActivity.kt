package com.example.helloapp

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.Gravity
import kotlinx.android.synthetic.main.activity_text_marquee.*

class Chapter0631TextMarqueeActivity : AppCompatActivity() {
    private var bPause = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_marquee)
        tv_marquee.textSize = 17f
        tv_marquee.setTextColor(Color.BLACK)
        tv_marquee.setBackgroundColor(Color.WHITE)
        tv_marquee.gravity = Gravity.LEFT or Gravity.CENTER //左对齐且垂直居中
        tv_marquee.ellipsize = TextUtils.TruncateAt.MARQUEE //从右向左滚动的跑马灯
        tv_marquee.setSingleLine(true) //跑马灯效果务必设置SingleLine
        tv_marquee.setOnClickListener {
            bPause = !bPause
            tv_marquee.isFocusable= if(bPause) false else true
            tv_marquee.isFocusableInTouchMode=if(bPause) false else true
            if(!bPause){
                tv_marquee.requestFocus()//强制获得焦点，让跑马灯滚起来
            }
        }


    }
}