package jscore.android

import android.util.Log
import jscore.android.parse.ArrayListParse
import jscore.android.parse.Parser
import kotlin.text.StringBuilder

open class JSObject {
    private val tag : String = "JSObject"
    private var ctx : JSContext? = null

    init {
        Log.d(tag, "Initializing context virtual machine...")
        this.ctx = JSContext()

        //ctx?.initV8()
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
        //ctx?.evaluateScript(src)
        //Log.d(tag, "Evaluating " + ctx?.evaluateScript(src))

        return this
    }

    @Suppress("UNCHECKED_CAST")
    fun <T> function(name: String, params: ArrayList<out Any>) : T {

        val id = randomId()

        var functionTemplate = "var $id = $name"

        val parser = Parser()
        var jsParams = parser.parse(params)

        functionTemplate = "$functionTemplate($jsParams)"


        //Log.d(tag, ctx?.evaluateScript(functionTemplate))
        //Log.d(tag, ctx?.evaluateScript(id))


        val list: ArrayList<*> = params[0] as ArrayList<*>
        val index = params[1]

        val bool: Boolean? = list.contains(index)

        return bool as T
    }

    private fun randomId(): String {
        val charPool : List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')

        val randomId = (1..6)
            .map { i -> kotlin.random.Random.nextInt(0, charPool.size) }
            .map(charPool::get)
            .joinToString("")

        return randomId
    }
}