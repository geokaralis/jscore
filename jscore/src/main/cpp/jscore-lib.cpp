//
// Created by George on 15/01/2019.
//

#include <jni.h>
#include <string>

#include "libplatform/libplatform.h"
#include "v8.h"

extern "C" JNIEXPORT jstring JNICALL
Java_jscore_android_JSContext_evaluate(
        JNIEnv *env,
        jobject /* this */,
        jstring string) {

    std::string test_script = env->GetStringUTFChars(string, nullptr);

    std::string hello = "Hello v8 from C++!\n";

    std::unique_ptr<v8::Platform> platform = v8::platform::NewDefaultPlatform();
    v8::V8::InitializePlatform(platform.get());
    v8::V8::Initialize();

    v8::Isolate::CreateParams create_params;
    create_params.array_buffer_allocator =
            v8::ArrayBuffer::Allocator::NewDefaultAllocator();

    v8::Isolate* isolate = v8::Isolate::New(create_params);
    {
        v8::Isolate::Scope isolate_scope(isolate);
        // Create a stack-allocated handle scope.
        v8::HandleScope handle_scope(isolate);
        // Create a new context.
        v8::Local<v8::Context> context = v8::Context::New(isolate);
        // Enter the context for compiling and running the hello world script.
        v8::Context::Scope context_scope(context);
        {
            // Create a string containing the JavaScript source code.
            v8::Local<v8::String> source =
                    v8::String::NewFromUtf8(isolate, "'Hello' + ', World!'",
                                            v8::NewStringType::kNormal)
                            .ToLocalChecked();
            // Compile the source code.
            v8::Local<v8::Script> script =
                    v8::Script::Compile(context, source).ToLocalChecked();
            // Run the script to get the result.
            v8::Local<v8::Value> result = script->Run(context).ToLocalChecked();
            // Convert the result to an UTF8 string and print it.
            v8::String::Utf8Value utf8(isolate, result);
            printf("%s\n", *utf8);

            hello += *utf8;
        }
    }

    isolate->Dispose();
    v8::V8::Dispose();
    v8::V8::ShutdownPlatform();
    delete create_params.array_buffer_allocator;

    return env->NewStringUTF(hello.c_str());
}
