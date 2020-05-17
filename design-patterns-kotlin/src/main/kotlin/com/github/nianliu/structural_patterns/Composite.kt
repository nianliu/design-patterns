package com.github.nianliu.structural_patterns

import org.junit.jupiter.api.Test


interface Worker {
    fun work()
}

class PartTimeWorker(var name: String) : Worker {
    override fun work() {
        println("$name is doing part time work.")
    }
}

class FullTimeWorker(var name: String) : Worker {
    override fun work() {
        println("$name is doing full time work.")
    }

}

class WorkerGroup(private val name: String) : Worker {
    private var workers = mutableListOf<Worker>()

    fun add(worker: Worker): WorkerGroup {
        workers.add(worker)
        return this
    }

    override fun work() {
        println("$name is coordinating all its workers to work hard!")
        workers.forEach { it.work() }
    }

}

class Composite {
    @Test
    fun demo() {
        WorkerGroup("Worker Empire")
            .add(PartTimeWorker("Lisa"))
            .add(
                WorkerGroup("Full Time Group")
                    .add(FullTimeWorker("Billie"))
                    .add(FullTimeWorker("Nian"))
            )
            .add(
                WorkerGroup("Mixed Group")
                    .add(FullTimeWorker("Ammy"))
                    .add(PartTimeWorker("Pieter"))
            )
            .work()
    }
}