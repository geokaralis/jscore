# JSCore

![JSCore Logo](/docs/jscore_icon_256.png)

JSCore is an android library for running javascript inside java. It's main purpose is for code sharing between web and mobile. In it's core it uses google's v8 javascript runtime library. One main characteristic of JSCore is the concept of javascript bindings within java/kotlin, making the js library feel more like a native one.
```java
public Class UnderscoreJs extends JSObject {
  // default constructor
  UnderscoreJs() { }
  
  public int min(ArrayList<Integer> list) {
    // returns the value of the product of _.min 
    // function from underscore.js, as an integer
    return JsObject().bind().method("min", list);
  }
}
```
```java
ArrayList<Integer> numbers = new ArrayList<Integer>();
numbers.add(27);
numbers.add(9);
numbers.add(18);
numbers.add(6);

UnderscoreJs _ = new UnderscoreJs();

int min = _.min(numbers); // 6
```
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
val contains = underscore.contains(list, 3)
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

JsCore is still at the early alpha stages of architecting and c++ support through ndk. If you 'd like to contribute to this project feel free to pull request and provide ideas through issues.
