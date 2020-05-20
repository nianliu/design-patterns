package com.github.nianliu.structural_patterns

import org.junit.jupiter.api.Test


class Tree(val x: Int, val y: Int, val treeType: TreeType) {
    fun draw() {
        treeType.draw(x, y)
    }
}

class TreeType(val name: String, val color: String, val description: String) {
    fun draw(x: Int, y: Int) {
        println("Drawing $name tree at ($x, $y)")
    }
}

class TreeTypeCache {
    companion object {
        private val cache = mutableMapOf<String, TreeType>()

        fun get(name: String, color: String, description: String): TreeType {
            return cache.getOrPut(name) { TreeType(name, color, description) }
        }
    }
}

class Forest {
    private val trees = mutableListOf<Tree>()

    fun plantTree(x: Int, y: Int, name: String, color: String, description: String): Forest {
        val treeType = TreeTypeCache.get(name, color, description)
        trees.add(Tree(x, y, treeType))
        return this
    }

    fun draw() {
        trees.forEach { it.draw() }
    }
}


class Flyweight {
    @Test
    fun demo() {
        Forest()
            .plantTree(1, 1, "White Oak", "white", "a long-lived tree")
            .plantTree(1, 2, "White Oak", "white", "a long-lived tree")
            .plantTree(2, 1, "Black Ash", "black", "a big tree")
            .plantTree(2, 2, "Black Ash", "black", "a big tree")
            .plantTree(3, 1, "Coconut Tree", "green", "a tall tree")
            .plantTree(3, 2, "Coconut Tree", "green", "a tall tree")
            .plantTree(4, 1, "Cherry Tree", "pink", "a beautiful tree")
            .plantTree(4, 2, "Cherry Tree", "pink", "a beautiful tree")
            .draw()
    }
}