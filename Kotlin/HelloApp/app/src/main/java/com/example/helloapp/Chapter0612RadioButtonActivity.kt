package com.example.helloapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_radio_button.*

class Chapter0612RadioButtonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio_button)
        rg_sex.setOnCheckedChangeListener { group, checkedId ->
            tv_sex.text = when (checkedId) {
                R.id.rb_male -> "boy"
                R.id.rb_female -> "girl"
                else -> ""
            }
        }

    }

}