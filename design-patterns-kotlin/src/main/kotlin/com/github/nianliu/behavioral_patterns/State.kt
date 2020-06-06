package com.github.nianliu.behavioral_patterns

import org.junit.jupiter.api.Test

class Parcel {
    var state: ParcelState = ReadyForDistributionState(this)

    fun nextState() {
        state.nextState()
    }

    fun printStatus() {
        state.printStatus()
    }
}

abstract class ParcelState(val parcel: Parcel) {
    abstract fun nextState()
    abstract fun printStatus()
}

class ReadyForDistributionState(parcel: Parcel) : ParcelState(parcel) {
    override fun nextState() {
        parcel.state = DeliveringState(parcel)
    }

    override fun printStatus() {
        println("Parcel is ready for distribution.")
    }
}

class DeliveringState(parcel: Parcel) : ParcelState(parcel) {
    override fun nextState() {
        parcel.state = DeliveredState(parcel)
    }

    override fun printStatus() {
        println("Parcel is in delivery.")
    }
}


class DeliveredState(parcel: Parcel) : ParcelState(parcel) {
    override fun nextState() {
        println("Already in final state.")
    }

    override fun printStatus() {
        println("Parcel has been delivered.")
    }
}


class State {
    @Test
    fun demo() {
        val parcel = Parcel()
        parcel.nextState()
        parcel.printStatus()
        parcel.nextState()
        parcel.printStatus()
        parcel.nextState()
        parcel.printStatus()
    }
}