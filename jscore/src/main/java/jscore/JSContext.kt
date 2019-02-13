package jscore

class JSContext {

    external fun evaluateScript(script: String): String

    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("jscore-lib")
        }
    }
}