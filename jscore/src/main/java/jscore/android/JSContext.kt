package jscore.android

class JSContext : AutoCloseable {

    init {
        v8()
    }

    external fun evaluate(script: String): String
    private external fun v8()
    private external fun dispose()

    override fun close() {
        dispose()
    }

    companion object {
        fun create(): JSContext = JSContext()
        // Used to load the 'jscore-lib' library on application startup.
        init {
            System.loadLibrary("jscore-lib")
        }
    }
}