# jscore

JsCore is an android library for running javascript inside java. It's main purpose is for code sharing between web and mobile. In it's core it uses google's v8 javascript runtime library. One main characteristic of JsCore is the concept of javascript bindings within java/kotlin, making the js library feel more like a native one.
```java
public Class UnderscoreJs extends JsObject {
  // default constructor
  UnderscoreJs() { }
  
  public int min(ArrayList<Integer> list) {
    // returns the value of the product of _.min 
    // function from underscore.js, as an integer
    return JsObject().bind.method("_.min", list);
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
JsCore also evaluates scripts as per the usual way.
```java
JsContext ctx = new JsContext(); // Javascript VM context

String greeting = (String) ctx.evaluate(""
  + "var message = 'hello world!'"
  + "message.toUpperCase();");
  
Log.d("Greeting", greeting); // HELLO WORLD!
```

## v8

JsCore focuses mainly on developer ease of use, but that means that performance must not sacrifised as well. That's why v8 is used as a very fast and modern javascript run time environment. At build all the necessary prunings and optimizations take in effect to reduce v8's footprint as low as possible. The library is provided as a fat library containing all the build variants of v8 for different platforms, but with multiple apks techniques it can be reduced further down for each platform.

## Contributing

JsCore is still at the early alpha stages of architecting and c++ support through ndk. If you 'd like to contribute to this project feel free to pull request and provide ideas through issues.
