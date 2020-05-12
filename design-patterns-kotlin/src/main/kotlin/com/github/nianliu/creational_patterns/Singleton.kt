package com.github.nianliu.creational_patterns

class DatabaseClient private constructor() {

    companion object {

        private var instance: DatabaseClient? = null

        fun getInstance(): DatabaseClient {
            if (instance == null) instance = DatabaseClient()
            return instance!!
        }
    }
}

class Singleton {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val db = DatabaseClient.getInstance()
            println(db)
        }
    }
}
