package jscore.android

import android.util.Log
import kotlin.text.StringBuilder

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
        //Log.d(tag, "Evaluating " + ctx?.evaluateScript(src))

        return this
    }

    @Suppress("UNCHECKED_CAST")
    fun <T> function(name: String, params: ArrayList<out Any>) : T {
        val method = "var a = function $name"

        val paramsBuilder = StringBuilder()
        var methodParams: String? = null
        var param: String?
        val size: Int? = params.size

        params.forEachIndexed { index, el ->
            param = "$el"
            if (el is String) param = "'$el'"
            if (el is ArrayList<*>) {
                param = param?.replace("[,| ]".toRegex(), "")

                param = param!!.replace("([a-zA-Z._^%\$#!~@,-]+)".toRegex(), "'\$1',")

                param = param!!.replace("(\\d(?=\\d{1}))".toRegex(), "\$1, ")
            }

            param = "$param, "

            if (index == size!! - 1)
            {
                param = param!!.replace(
                    "[,| ]".toRegex(),
                    ""
                )
            }

            methodParams = paramsBuilder.append(param).toString()
        }

        Log.d(tag, "$method($methodParams)")

        val list: ArrayList<*> = params[0] as ArrayList<*>
        val index = params[1]

        val bool: Boolean? = list.contains(index)

        return bool as T
    }
}