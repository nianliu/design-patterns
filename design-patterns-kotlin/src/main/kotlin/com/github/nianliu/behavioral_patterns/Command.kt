package com.github.nianliu.behavioral_patterns

import org.junit.jupiter.api.Test

class Operator {
    fun buy(symbol: String) {
        println("Buying $symbol")
    }

    fun sell(symbol: String) {
        println("Selling $symbol")
    }
}

interface Order {
    fun execute()
}

class BuyStock(private val symbol: String, private val operator: Operator) : Order {
    override fun execute() {
        operator.buy(symbol)
    }
}

class SellStock(private val symbol: String, private val operator: Operator) : Order {
    override fun execute() {
        operator.sell(symbol)
    }
}

class Broker {
    private var orders = mutableListOf<Order>()

    fun takOrder(order: Order) {
        orders.add(order)
    }

    fun placeOrders() {
        orders.forEach { it.execute() }
    }
}

class Command {
    @Test
    fun demo() {
        val broker = Broker()
        val operator = Operator()

        broker.takOrder(BuyStock("TSLA", operator))
        broker.takOrder(BuyStock("NFLX", operator))
        broker.takOrder(SellStock("GILD", operator))

        broker.placeOrders()
    }
}