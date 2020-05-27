package com.github.nianliu.behavioral_patterns

import org.junit.jupiter.api.Test

interface Observer {
    fun update(message: String)
}

interface Subject {
    fun subscribe(observer: Observer)
    fun unsubscribe(observer: Observer)
    fun notifyObservers()
}

class Person(private val name: String) : Observer {
    override fun update(message: String) {
        println("$name received an update: \"$message\"")
    }
}

class StockUpdate : Subject {
    private val observers = mutableListOf<Observer>()
    var message: String? = null
        set(value) {
            field = value
            notifyObservers()
        }

    override fun subscribe(observer: Observer) {
        observers.add(observer)
    }

    override fun unsubscribe(observer: Observer) {
        observers.remove(observer)
    }

    override fun notifyObservers() {
        observers.forEach { it.update(message!!) }
    }
}

class ObserverDemo {
    @Test
    fun demo() {
        val foo = Person("Foo")
        val bar = Person("Bar")
        val stockUpdate = StockUpdate()

        stockUpdate.message = "SNAP falls 1%"

        stockUpdate.subscribe(foo)
        stockUpdate.subscribe(bar)
        stockUpdate.message = "AAPL rallies 3%"

        stockUpdate.unsubscribe(foo)
        stockUpdate.message = "SPY plunges 5%"
    }
}