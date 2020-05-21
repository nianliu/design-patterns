package com.github.nianliu.structural_patterns

import com.github.javafaker.Faker
import org.junit.jupiter.api.Test


data class Pokemon(val id: Int, val name: String, val location: String)

interface PokemonDao {
    fun getPokemon(id: Int): Pokemon
}

class PokemonDaoImpl : PokemonDao {
    override fun getPokemon(id: Int): Pokemon {
        // getting pokemon from database, here faking it
        val fake = Faker().pokemon()
        return Pokemon(id, fake.name(), fake.location())
    }
}

class PokemonDaoCacheProxy(private val pokemonDaoImpl: PokemonDao) : PokemonDao {

    private var cache = mutableMapOf<Int, Pokemon>()

    override fun getPokemon(id: Int): Pokemon {
        return cache.getOrPut(id) { pokemonDaoImpl.getPokemon(id) }
    }
}


class Proxy {
    @Test
    fun demo() {
        val pokemonDao = PokemonDaoCacheProxy(PokemonDaoImpl())
        println(pokemonDao.getPokemon(1))
        println(pokemonDao.getPokemon(1))
    }
}