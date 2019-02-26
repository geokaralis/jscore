package jscore.android

class JSContext {

    external fun evaluate(script: String): String

    companion object {
        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("jscore-lib")
        }
    }
}