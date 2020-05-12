package com.github.nianliu.creational_patterns

interface Table
interface Chair
interface FurnitureFactory {
    fun makeTable(): Table
    fun makeChair(): Chair
}

class KitchenTable : Table
class KitchenChair : Chair
class KitchenFurnitureFactory : FurnitureFactory {
    override fun makeTable() = KitchenTable()
    override fun makeChair() = KitchenChair()
}

class OfficeTable : Table
class OfficeChair : Chair
class OfficeFurnitureFactory : FurnitureFactory {
    override fun makeTable() = OfficeTable()
    override fun makeChair() = OfficeChair()
}

class AbstractFactory {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val factory1 = KitchenFurnitureFactory()
            val factory2 = OfficeFurnitureFactory()

            val tables = arrayOf(factory1.makeTable(), factory2.makeTable())
            val chairs = arrayOf(factory1.makeChair(), factory2.makeChair())

            tables.forEach { println(it) }
            chairs.forEach { println(it) }
        }
    }

}