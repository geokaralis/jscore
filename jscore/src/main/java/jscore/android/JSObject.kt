package jscore.android

import android.util.Log

open class JSObject {
    private val tag : String = "JSObject"
    private var ctx : JSContext? = null

    init {
        Log.d(tag, "Initializing context virtual machine...")
        this.ctx = JSContext()
    }


    /**
     * Setup bindings for evaluating specific code inside the .js script.
     * This method parses the .js file or a String containing the script
     * and loads it into the temporary short lived context of JSObject.
     */
    fun bind(src: String): JSObject {
        if (ctx?.evaluated(src)!!) {
            return this
        }
        ctx?.evaluateScript(src)
        Log.d(tag, "Evaluating " + ctx?.evaluateScript(src))

        return this
    }

    fun <T> function(name: String, params: ArrayList<out Any>) : T {
        val script: String = "function contains() { };"

        ctx!!.evaluateScript(script)

//
//
//        params.forEach {
//            Log.d(tag, it.toString())
//        }

        var list: ArrayList<Int> = params[0] as ArrayList<Int>
        var index = params[1]


//        for (item: Int in list) {
//            Log.d(tag, item.toString())
//        }

//        Log.d(tag, list.toString() + index)

        val bool: Boolean? = list.contains(index)

        return bool as T
    }
}