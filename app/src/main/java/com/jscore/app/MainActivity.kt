package com.jscore.app

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import jscore.android.JSContext
import jscore.android.JSObject


class MainActivity : AppCompatActivity() {

    private val ctx = JSContext()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val list: ArrayList<Int> = ArrayList()
//        list.add(1)
//        list.add(2)
//        list.add(3)
//
        val fileName = "underscore-min.js"
        val src = application.assets.open(fileName).bufferedReader().use{
            it.readText()
        }
//
//        val underscore = Underscore(src)
//        val contains = underscore.contains(list,3)
//
//        Log.d("Main", contains.toString())
//
//        // Example of a call to a native method
//        sample_text.text = context.evaluateScript("var num = 5; return num;")

        Log.d("MainActivity", ctx.evaluate(src))
    }
}
