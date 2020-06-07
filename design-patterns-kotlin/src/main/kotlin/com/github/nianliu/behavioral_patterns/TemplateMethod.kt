package com.github.nianliu.behavioral_patterns

import org.junit.jupiter.api.Test

abstract class Plan {
    fun execute() {
        step1()
        step2()
    }

    abstract fun step1()
    abstract fun step2()
}

open class CommonPlan : Plan() {
    override fun step1() {
        println("Generic step 1")
    }

    override fun step2() {
        println("Generic step 2")
    }

}

class SpecialPlan : CommonPlan() {
    override fun step1() {
        println("Special step 1")
    }
}

class TemplateMethod {
    @Test
    fun demo() {
        CommonPlan().execute()
        println("...")
        SpecialPlan().execute()
    }
}