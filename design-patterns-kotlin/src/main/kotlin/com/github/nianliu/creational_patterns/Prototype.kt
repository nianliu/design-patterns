package com.github.nianliu.creational_patterns

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

abstract class Robot {

    var name: String? = null
    var id: Int? = null

    constructor()

    constructor(robot: Robot) {
        this.name = robot.name
        this.id = robot.id
    }

    abstract fun clone(): Robot

    override fun equals(other: Any?): Boolean {
        return other is Robot
                && other.name === this.name
                && other.id === this.id
    }
}

class AlphaRobot : Robot {

    var version = "alpha"
        private set

    constructor() : super()

    constructor(alphaRobot: AlphaRobot) : super(alphaRobot)

    override fun clone(): Robot {
        return AlphaRobot(this)
    }

    override fun equals(other: Any?): Boolean {
        return other is AlphaRobot && super.equals(other)
    }
}

class BetaRobot : Robot {

    var version = "beta"
        private set

    constructor() : super()

    constructor(betaRobot: BetaRobot) : super(betaRobot)

    override fun clone(): Robot {
        return BetaRobot(this)
    }

    override fun equals(other: Any?): Boolean {
        return other is BetaRobot && super.equals(other)
    }
}

class Prototype {

    @Test
    fun demo() {
        val alphaRobot = AlphaRobot()
            .apply { id = 1 }
            .apply { name = "Billie" }
        val alphaClone = alphaRobot.clone()

        val betaRobot = BetaRobot()
            .apply { id = 2 }
            .apply { name = "Alita" }
        val betaClone = betaRobot.clone()

        assertTrue(alphaRobot == alphaClone)
        assertFalse(alphaRobot === alphaClone)

        assertTrue(betaRobot == betaClone)
        assertFalse(betaRobot === betaClone)

        arrayOf(alphaRobot, alphaClone, betaRobot, betaClone)
            .forEach { assertTrue(it is Robot) }
    }
}

