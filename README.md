# JSCore
<p align="center">
  <img src="/docs/jscore_icon_256.png" width="128" alt="JSCore Logo"/>
</p>
JSCore is an android library for running javascript inside java. It's main purpose is for code sharing between web and mobile. In it's core it uses google's v8 javascript runtime library. One main characteristic of JSCore is the concept of javascript bindings within java/kotlin, making the js library feel more like a native one.

## Usage
```kotlin
class Underscore(private val src: String): JSObject() {

    /**
     * Checks if a value is present in a list
     *
     * @param list   ArrayList holding integer values
     * @param index  Value to check in the list
     *
     * @return       true if the value is present in the list, otherwise false
     */
    fun contains(list: ArrayList<Int>, index: Int): Boolean {
        return JSObject().bind(src).function("contains", arrayListOf(list, index))
    }
}
```
```kotlin
val list: ArrayList<Int> = ArrayList()
list.add(1)
list.add(2)
list.add(3)

val underscore = Underscore(src)
val contains = underscore.contains(list, 3) // true
```
JSCore also evaluates scripts as per the usual way.
```java
JSContext ctx = new JSContext(); // Javascript VM context

String greeting = (String) ctx.evaluate(""
  + "var message = 'hello world!'"
  + "message.toUpperCase();");
  
Log.d("Greeting", greeting); // HELLO WORLD!
```

## v8

v8 is used as JSCore's javascript runtime environment.

## Kotlin
JSCore is written entirely in Kotlin.

## Contributing

JSCore is still at the early alpha stages of architecting and c++ support through ndk. If you 'd like to contribute to this project feel free to pull request and provide ideas through issues.

## License
   Copyright (c) 2019, George Karalis.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
