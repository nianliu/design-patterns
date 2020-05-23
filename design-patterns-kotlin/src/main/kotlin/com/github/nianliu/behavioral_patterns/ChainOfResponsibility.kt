package com.github.nianliu.behavioral_patterns

import com.github.javafaker.Faker
import org.junit.jupiter.api.Test
import kotlin.random.Random

abstract class MortgageControlTask {

    private var next: MortgageControlTask? = null

    abstract fun check(person: String): Boolean

    fun next(next: MortgageControlTask) = next.also { this.next = it }

    fun checkNext(person: String) = if (next == null) true else next!!.check(person)
}

class CheckResidency : MortgageControlTask() {
    override fun check(person: String): Boolean {
        return if (Random.nextBoolean()) {
            checkNext(person)
        } else {
            println("$person failed on not having a valid residency.")
            false
        }
    }
}

class CheckNoCriminalRecords : MortgageControlTask() {
    override fun check(person: String): Boolean {
        return if (Random.nextBoolean()) {
            checkNext(person)
        } else {
            println("$person failed on having criminal records.")
            false
        }
    }
}

class CheckSufficientSalary : MortgageControlTask() {
    override fun check(person: String): Boolean {
        return if (Random.nextBoolean()) {
            checkNext(person)
        } else {
            println("$person failed on insufficient salary.")
            false
        }
    }
}

class MortgageControlService {
    fun performCheck(person: String, taskChain: MortgageControlTask) {
        if (taskChain.check(person)) println("$person is eligible for the mortgage.")
    }
}

class ChainOfResponsibility {
    @Test
    fun demo() {
        val taskChain = CheckResidency().also {
            it.next(CheckNoCriminalRecords())
                .next(CheckSufficientSalary())
        }

        MortgageControlService().performCheck(Faker().name().fullName(), taskChain)
    }
}