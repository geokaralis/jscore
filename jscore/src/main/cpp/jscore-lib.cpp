//
// Created by George on 15/01/2019.
//

#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_jscore_android_JSContext_evaluateScript(
        JNIEnv *env,
        jobject /* this */,
        jstring string) {
    std::string script = env->GetStringUTFChars(string, nullptr);
    return env->NewStringUTF(script.c_str());
}
