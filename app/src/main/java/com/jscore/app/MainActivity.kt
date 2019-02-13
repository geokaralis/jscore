package com.jscore.app

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import jscore.JSContext


class MainActivity : AppCompatActivity() {

    private val context = JSContext()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Example of a call to a native method
        sample_text.text = context.evaluateScript("var num = 5; return num;")
    }
}
