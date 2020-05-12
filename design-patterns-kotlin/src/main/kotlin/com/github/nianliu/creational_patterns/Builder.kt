package com.github.nianliu.creational_patterns


class Person private constructor(val name: String, val age: Int) {

    class PersonBuilder {

        private var name: String? = null
        private var age: Int? = null

        fun name(v: String): PersonBuilder {
            this.name = v
            return this
        }

        fun age(v: Int): PersonBuilder {
            this.age = v
            return this
        }

        fun build() = Person(name!!, age!!)
    }
}

class Builder {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val person = Person.PersonBuilder()
                .name("nian")
                .age(18)
                .build()
            println("Person ${person.name} is ${person.age} years old")
        }
    }
}
