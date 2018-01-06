[![Release](https://jitpack.io/v/dpreussler/android-tdd-utils.svg)](https://jitpack.io/#dpreussler/KuperReflect)
[![Build Status](https://travis-ci.org/dpreussler/KuperReflect.svg?branch=master)](https://travis-ci.org/dpreussler/KuperReflect)
[![Coverage Status](https://coveralls.io/repos/github/dpreussler/KuperReflect/badge.svg)](https://coveralls.io/github/dpreussler/KuperReflect)

# KuperReflect
Easy reflection with Kotlin


## in short
- set private and final variables
- syntax comparable to Kotlin Reflect (no dependency to it)
- infix notation available


## in detail
In Java world there is SuperReflect (a fork of jOOQ/jOOR) for fluent reflection.

Kotlin reflect offers a nice syntax itself but is limited in functionality compared.


KuperReflect combines both worlds: nice syntax including more variations and being able to set private or even final fields.


## examples:

### set non private on the property like Kotlin Reflect:

```kotlin
    val myClass = SomeClass()
    SomeClass::variable.set(tested, "something")
```


### set non private on the instance itself:

```kotlin
    SomeClass().set(SomeClass::variable).to("something")

    SomeClass().set(SomeClass::variable) to "something"

    SomeClass().apply {
        set(SomeClass::variable) to "something"
    }
```


### set private on the instance itself:

```kotlin
    SomeClass().set("variable").to("something")

    SomeClass().set("variable") to "something"

    SomeClass().apply {
        set("variable") to "something"
    }
```


### use infix all the way:

```kotlin
    on(myClass) set "variable" to "something"
        
    on(myClass) set SomeClass::variable to "something"

```


## Gradle

```groovy
...
repositories {
    maven {url "https://jitpack.io"}
}

testCompile 'com.github.dpreussler:KuperReflect:v0.1'

```


