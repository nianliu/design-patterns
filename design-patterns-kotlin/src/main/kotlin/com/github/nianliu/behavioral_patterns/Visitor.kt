package com.github.nianliu.behavioral_patterns

import org.junit.jupiter.api.Test

interface Shape {
    fun id(): Int
    fun accept(v: Visitor): String
}

class Circle(private val id: Int) : Shape {
    override fun id() = id
    override fun accept(v: Visitor) = v.visit(this)
}

class Rectangle(private val id: Int) : Shape {
    override fun id() = id
    override fun accept(v: Visitor) = v.visit(this)
}

interface Visitor {
    fun visit(c: Circle): String
    fun visit(r: Rectangle): String
}

class XmlExportVisitor : Visitor {
    override fun visit(c: Circle) = "<Circle>${c.id()}</Circle>"
    override fun visit(r: Rectangle) = "<Rectangle>${r.id()}</Rectangle>"
}


class VisitorDemo {
    @Test
    fun demo() {
        val shapes = listOf(Circle(1), Rectangle(2), Circle(3))
        val visitor = XmlExportVisitor()

        println("<Shapes>${shapes.map { it.accept(visitor) }.joinToString("")}</Shapes>")
    }
}