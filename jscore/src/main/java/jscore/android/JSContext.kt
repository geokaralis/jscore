package jscore.android

import android.content.res.AssetManager

class JSContext {

    external fun evaluate(script: String): String
    external fun loadSnapshot(assetManager: AssetManager)
    external fun initV8()
    external fun stringFromV8(result: String): String

    companion object {
        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("jscore-lib")
        }
    }
}