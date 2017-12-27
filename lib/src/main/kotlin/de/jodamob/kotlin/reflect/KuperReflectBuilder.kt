package de.jodamob.kotlin.reflect

import de.jodamob.reflect.SuperReflect
import kotlin.reflect.KProperty1

class KuperReflectBuilder<T>(internal val instance: T, internal val argument: String)

fun <T> on(instance: T) = instance

infix fun <T>T.set(argument: String) = KuperReflectBuilder(this, argument)

infix fun <U,V> U.set(argument: () -> KProperty1<U, V>) = KuperReflectBuilder(this, argument.invoke().name)

infix fun <U,V> U.set(prop: KProperty1<U, V>) = KuperReflectBuilder(this, prop.name)

infix fun <T>KuperReflectBuilder<T>.to(value: Any?) = SuperReflect.on(instance).set(argument, value)