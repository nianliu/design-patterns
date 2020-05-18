package com.github.nianliu.structural_patterns

import org.junit.jupiter.api.Test

interface Noodle {
    fun make()
}

class BasicNoodle : Noodle {
    override fun make() {
        println("Making basic noodle")
    }
}

abstract class BaseDecorator(private val noodle: Noodle) : Noodle {
    override fun make() {
        noodle.make()
    }
}

class MeatDecorator(noodle: Noodle) : BaseDecorator(noodle) {
    override fun make() {
        super.make()
        println("adding meat balls...")
    }
}

class VegeDecorator(noodle: Noodle) : BaseDecorator(noodle) {
    override fun make() {
        super.make()
        println("adding vegetables...")
    }
}

class Decorator {
    @Test
    fun demo() {
        val noodleWithMeat = MeatDecorator(BasicNoodle()).make()
        val noodleWithVege = VegeDecorator(BasicNoodle()).make()
        val noodleWithMeatAndVege = VegeDecorator(MeatDecorator(BasicNoodle())).make()
    }
}