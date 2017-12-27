package de.jodamob.kotlin.testrunner.tests

import de.jodamob.kotlin.reflect.on
import de.jodamob.kotlin.reflect.set
import de.jodamob.kotlin.reflect.to
import org.amshove.kluent.`should equal to`
import org.junit.Test


class KuperReflectBuilderTest {

    class SomeClass {
        val variable = "nothing"
    }

    @Test
    fun `should use string with on syntax`() {
        val tested = SomeClass()

        on(tested) set "variable" to "something"

        tested.variable `should equal to` "something"
    }

    @Test
    fun `should use string`() {
        val tested = SomeClass().apply {
            set("variable") to "something"
        }
        tested.variable `should equal to` "something"
    }

    @Test
    fun `should use variable`() {
        val tested = SomeClass().apply {
            set(SomeClass::variable) to "something"
        }
        tested.variable `should equal to` "something"
    }

    @Test
    fun `should use variable via lambda`() {
        val tested = SomeClass().apply {
            set({SomeClass::variable}) to "something"
        }

        tested.variable `should equal to` "something"
    }
}
