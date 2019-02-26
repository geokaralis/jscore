package jscore.android

class JSContext {

    fun evaluated(src: String): Boolean {
        return false
    }

    external fun initV8()
    external fun evaluateScript(script: String): String

    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("jscore-lib")
        }
    }
}