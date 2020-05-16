package com.github.nianliu.structural_patterns

import org.junit.jupiter.api.Test

/**
 * Decouple an abstraction (Remote) from its implementation (Device) so that the two can vary independently.
 */
interface Device {
    fun getVolume(): Int
    fun setVolume(value: Int)
}

interface Remote {
    fun volumeUp()
    fun volumeDown()
}

class TV : Device {

    private var volume = 30

    override fun getVolume() = volume

    override fun setVolume(value: Int) {
        volume = value
    }
}

class Radio : Device {

    private var volume = 20

    override fun getVolume() = volume

    override fun setVolume(value: Int) {
        volume = value
    }
}

open class BasicRemote(private val device: Device) : Remote {

    override fun volumeUp() {
        device.setVolume(device.getVolume() + 5)
    }

    override fun volumeDown() {
        device.setVolume(device.getVolume() - 5)
    }
}

class AdvancedRemote(private val device: Device) : BasicRemote(device) {

    fun mute() {
        device.setVolume(0)
    }
}

class Bridge {
    @Test
    fun demo() {
        val basicRadioRemote = BasicRemote(Radio())
        val basicTVRemote = BasicRemote(TV())
        val advancedRadioRemote = AdvancedRemote(Radio())
        val advancedTVRemote = AdvancedRemote(TV())
    }
}

