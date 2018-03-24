package de.jodamob.kotlin.reflect

import org.amshove.kluent.`should equal to`
import org.junit.Test


class KuperReflectBuilderTest {

    class SomeClass {
        val variable = "nothing"
        val variable2 = 100
        private val variable3 = 101

        fun getVar3() = variable3
    }

    @Test
    fun `should set primitives`() {
        val tested = SomeClass()

        on(tested) set "variable2" to 200

        tested.variable2 `should equal to` 200
    }

    @Test
    fun `should use string with on syntax`() {
        val tested = SomeClass()

        on(tested) set "variable" to "something"

        tested.variable `should equal to` "something"
    }

    @Test
    fun `should use property with on syntax`() {
        val tested = SomeClass()

        on(tested) set SomeClass::variable to "something"

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

    @Test
    fun `should use string without infix`() {
        val tested = KuperReflectBuilderTest.SomeClass()
        tested.set(SomeClass::variable, "something")
        tested.variable `should equal to` "something"
    }

    @Test
    fun `should use string on property`() {
        val tested = KuperReflectBuilderTest.SomeClass()
        SomeClass::variable.set(tested, "something")
        tested.variable `should equal to` "something"
    }

    @Test
    fun `should set private string`() {
        val tested = SomeClass().apply {
            set("variable3") to 103
        }
        tested.getVar3() `should equal to` 103
    }

    @Test
    fun `should set private java string`() {
        val tested = de.jodamob.kotlin.reflect.SomeJavaClass().apply {
            set("variable1") to "changed"
        }
        tested.one `should equal to` "changed"
    }

    @Test
    fun `should set private java static string`() {
        SomeJavaClass::class.java.set("variable2").to("changed")
        SomeJavaClass.getTwo() `should equal to` "changed"
    }
}
