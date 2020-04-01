package com.example.helloapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_alert_dialog.*
import org.jetbrains.anko.alert

class Chapter0652AlertDialogActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert_dialog)
        btn_alert.setOnClickListener {
            alert("are you sure") {
                positiveButton("yes") { tv_alert.text = "yes" }
                negativeButton("no") { tv_alert.text = "no" }
            }.show()
        }

    }
}