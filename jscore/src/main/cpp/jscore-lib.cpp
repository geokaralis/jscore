//
// Created by George on 15/01/2019.
//

#include <jni.h>
#include <string>

#include "libplatform/libplatform.h"
#include "v8.h"

std::unique_ptr<v8::Platform> platform;
v8::Isolate *isolate;
v8::Persistent<v8::Context> persistentContext;


extern "C" JNIEXPORT void JNICALL
Java_jscore_android_JSContext_initV8(
        JNIEnv *env,
        jobject /* this */) {

    // Initialize V8.
    v8::V8::InitializeICU();
    platform = v8::platform::NewDefaultPlatform();
    v8::V8::InitializePlatform(&(*platform.get()));
    v8::V8::Initialize();
//
//    // Create a new Isolate and make it the current one.
//    v8::Isolate::CreateParams create_params;
//    create_params.array_buffer_allocator = v8::ArrayBuffer::Allocator::NewDefaultAllocator();
//    isolate = v8::Isolate::New(create_params);
//
//    v8::Isolate::Scope isolate_scope(isolate);
//    // Create a stack-allocated handle scope.
//    v8::HandleScope handle_scope(isolate);
//
//    // Create a new context.
//    v8::Local<v8::Context> context = v8::Context::New(isolate);
//
//    // attach the context to the persistent context, to avoid V8 GC-ing it
//    persistentContext.Reset(isolate, context);
}
//
//extern "C" JNIEXPORT jstring JNICALL
//Java_jscore_android_JSContext_evaluateScript(
//        JNIEnv *env,
//        jobject /* this */,
//        jstring string) {
//    std::string script = env->GetStringUTFChars(string, nullptr);
//    return env->NewStringUTF(script.c_str());
//    std::string hello = "Hello v8 from C++!\n";
//
//    v8::Isolate::Scope isolate_scope(isolate);
//    v8::HandleScope handle_scope(isolate);
//
//    // Enter the context for compiling and running the hello world script.
//    v8::Local<v8::Context> context = v8::Local<v8::Context>::New(isolate, persistentContext);
//    v8::Context::Scope context_scope(context);
//
//    // Create a string containing the JavaScript source code.
//    v8::Local<v8::String> source = v8::String::NewFromUtf8(
//            isolate, "'Hello' + ', from Javascript!'", v8::NewStringType::kNormal).ToLocalChecked();
//
//    // Compile the source code.
//    v8::Local<v8::Script> script =
//            v8::Script::Compile(context, source).ToLocalChecked();
//
//    // Run the script to get the result.
//    v8::Local<v8::Value> result = script->Run(context).ToLocalChecked();
//
//    // Convert the result to an UTF8 string and print it.]
//    v8::String::Utf8Value utf8(isolate, result);
//    printf("%s\n", *utf8);
//    hello += *utf8;
//
//    return env->NewStringUTF(hello.c_str());
//}
