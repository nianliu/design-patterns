package com.github.nianliu.behavioral_patterns

import org.junit.jupiter.api.Test

class PowerSupplier {
    fun turnOn() {
        println("Turn on power supplier")
    }

    fun turnOff() {
        println("Turn off power supplier")
    }
}

class Button {
    lateinit var mediator: Mediator

    fun press() {
        mediator.press()
    }
}

class Fan {
    lateinit var mediator: Mediator
    var isOn = false

    fun start() {
        mediator.start()
        isOn = true
    }

    fun stop() {
        mediator.stop()
        isOn = false
    }
}

class Mediator(private val powerSupplier: PowerSupplier, private val button: Button, private val fan: Fan) {

    init {
        button.mediator = this
        fan.mediator = this
    }

    fun press() {
        if (fan.isOn) {
            fan.stop()
        } else {
            fan.start()
        }
    }

    fun start() {
        powerSupplier.turnOn()
    }

    fun stop() {
        powerSupplier.turnOff()
    }
}

class MediatorDemo {
    @Test
    fun demo() {
        val button = Button()
        val powerSupplier = PowerSupplier()
        val fan = Fan()
        val mediator = Mediator(powerSupplier, button, fan)

        assert(!fan.isOn)
        button.press()
        assert(fan.isOn)
        button.press()
        assert(!fan.isOn)
    }
}