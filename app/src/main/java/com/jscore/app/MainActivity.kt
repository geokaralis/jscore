package com.jscore.app

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import jscore.android.JSContext
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

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

        JSContext.create().use { ctx ->
            ctx.evaluate(src)
            val result = ctx.evaluate(""
                    + "var func = function(greeting){ return greeting + ': ' + this.name };"
                    + "func = _.bind(func, {name: 'moe'}, 'hi');"
                    + "func();")

            Log.d("MainActivity", result)
            sample_text.text = result
        }
    }
}
