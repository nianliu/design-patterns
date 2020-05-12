package com.github.nianliu.creational_patterns

interface Game

data class SwitchGame(val name: String) : Game

data class PS4Game(val name: String) : Game

class GameFactory {

    fun makeGame(name: String, platform: String): Game {
        return when (platform.toLowerCase()) {
            "switch" -> SwitchGame(name)
            "ps4" -> PS4Game(name)
            else -> throw IllegalArgumentException("Unknown platform: $platform")
        }
    }

}

class FactoryMethod {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val gameFactory = GameFactory()
            val games = arrayOf(
                gameFactory.makeGame("Pokeman", "switch")
                , gameFactory.makeGame("Assassin's Creed", "ps4")
                , gameFactory.makeGame("FIFA 2020", "ps4")
            )

            games.forEach { println(it) }
        }
    }

}
