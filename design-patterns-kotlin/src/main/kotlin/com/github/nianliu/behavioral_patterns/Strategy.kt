package com.github.nianliu.behavioral_patterns

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

interface ArithmeticalOperation {
    fun operate(a: Int, b: Int): Int
}

class Plus : ArithmeticalOperation {
    override fun operate(a: Int, b: Int) = a + b
}

class Minus : ArithmeticalOperation {
    override fun operate(a: Int, b: Int) = a - b
}

class Calculator {
    var operation: ArithmeticalOperation? = null

    fun calculate(a: Int, b: Int): Int? {
        return operation?.operate(a, b)
    }
}

class Strategy {
    @Test
    fun demo() {
        val calculator = Calculator()
        calculator.operation = Plus()
        assertEquals(3, calculator.calculate(1, 2))

        calculator.operation = Minus()
        assertEquals(1, calculator.calculate(3, 2))
    }
}