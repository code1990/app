package com.example.helloapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_image_scale.*
import android.widget.ImageView.ScaleType

class Chapter0632ImageScaleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_scale)
        iv_scale.setImageResource(R.drawable.apple1)
        btn_center.setOnClickListener { iv_scale.scaleType = ScaleType.CENTER }
        btn_fitCenter.setOnClickListener { iv_scale.scaleType = ScaleType.FIT_CENTER }
        btn_centerCrop.setOnClickListener { iv_scale.scaleType = ScaleType.CENTER_CROP }
        btn_centerInside.setOnClickListener { iv_scale.scaleType = ScaleType.CENTER_INSIDE }
        btn_fitXY.setOnClickListener { iv_scale.scaleType = ScaleType.FIT_XY }
        btn_fitStart.setOnClickListener { iv_scale.scaleType = ScaleType.FIT_START }
        btn_fitEnd.setOnClickListener { iv_scale.scaleType = ScaleType.FIT_END }


    }
}