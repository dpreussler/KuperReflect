package de.jodamob.kotlin.reflect

import de.jodamob.reflect.SuperReflect
import kotlin.reflect.KProperty1

fun <T> on(instance: T) = instance

infix fun <T>T.set(argument: String) = Pair(this, argument)

infix fun <U,V> U.set(argument: () -> KProperty1<U, V>) = Pair(this, argument.invoke().name)

infix fun <U,V> U.set(prop: KProperty1<U, V>) = Pair(this, prop.name)

fun <U,V, W> U.set(prop: KProperty1<U, V>, value: W) = Pair(this, prop.name).to(value)

fun <U,V, W> KProperty1<U, V>.set(instance: U, value: W) = Pair(instance, this.name).to(value)

infix fun <T>Pair<T, String>.to(value: Any?) {
    if (first is Class<*>) {
        SuperReflect.on(first as Class<*>).set(second, value)
    } else {
        SuperReflect.on(first).set(second, value)
    }
}